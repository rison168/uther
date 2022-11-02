package com.rison.uther.table.interceptor;

import com.alibaba.fastjson.TypeReference;
import com.rison.uther.table.pojo.query.TableQueryBean;
import com.rison.uther.table.service.fiters.UserInfomationHolder;
import com.tencent.tbds.metadata.datasource.pojo.DatabaseQueryBean;
import com.tencent.tbds.metadata.table.entity.meta.MetaDatabaseInfo;
import com.tencent.tbds.metadata.table.entity.meta.MetaTableBaseInfo;
import com.tencent.tbds.metadata.table.repository.basedata.DatabaseInfoDao;
import com.tencent.tbds.metadata.table.repository.basedata.TableBaseInfoDao;
import com.tencent.tbds.rpc.meta.TableQueryInfo;
import com.tencent.tbds.utils.core.logger.AuditLoggerInfo;
import com.tencent.tbds.utils.core.logger.LoggerUtils;
import com.tencent.tbds.utils.core.logger.ParametersServletRequestWrapper;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.rison.uther.table.interceptor
 * @NAME: AuditLoggerInterceptor
 * @USER: Rison
 * @DATE: 2022/11/2 10:21
 * @PROJECT_NAME: uther
 **/
public class AuditLoggerInterceptor implements HandlerInterceptor {
    private static Logger LOG = LoggerFactory.getLogger(AuditLoggerInterceptor.class);

    private Map<String, List<AuditLoggerInfo>> auditLoggerInfoMap;

    private TableBaseInfoDao tableBaseInfoDao;

    private DatabaseInfoDao databaseInfoDao;

    public AuditLoggerInterceptor(Map<String, List<AuditLoggerInfo>> auditLoggerInfoMap, TableBaseInfoDao tableBaseInfoDao, DatabaseInfoDao databaseInfoDao) {
        this.auditLoggerInfoMap = auditLoggerInfoMap;
        this.tableBaseInfoDao = tableBaseInfoDao;
        this.databaseInfoDao = databaseInfoDao;

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        try {
            String method = request.getMethod();
            final String uri = request.getRequestURI();
            final AuditLoggerInfo loggerInfoByUri = LoggerUtils.getLoggerInfoByUri(
                    uri,
                    method,
                    this.auditLoggerInfoMap

            );
            if (loggerInfoByUri == null){
                return true;
            }
            LOG.debug("begin to pre handle of audit logger by uri={}, method={}", uri, method);
            ParametersServletRequestWrapper requestWrapper = new ParametersServletRequestWrapper(request);
            String body = requestWrapper.getBody();
            switch (loggerInfoByUri.getCategory()){
                case meta_table:
                    setTableInfo(uri, method, body, loggerInfoByUri);
                    break;
                case meta_db:  
                    setDatabaseInfo(uri, method, body, loggerInfoByUri);
                    break;
            }
            loggerInfoByUri.setRemoteIp(requestWrapper.getRemoteHost());
            loggerInfoByUri.setUserId(UserInfomationHolder.getCurrentUserId());
            loggerInfoByUri.setUsername(UserInfomationHolder.getCurrentUserName());
            final com.tencent.tbds.actionlog.ActionLog actionLog = LoggerUtils.actionLog4j(loggerInfoByUri);
            LOG.debug("finish to get action log by uri={}, actionLog={}");

        } catch (Exception e) {
            LOG.error("audit logger pre handler error by uri=" + request.getRequestURI(), e);
        }
        return true;
    }

    private void setDatabaseInfo(String uri, String method, String body, AuditLoggerInfo loggerInfoByUri) {
        try{
            if (uri.endsWith("/create") || uri.endsWith("/execute/sql") || uri.endsWith("/chown")) {
                TableQueryBean queryBean = (TableQueryBean)JSON.parseObject(body, new TypeReference<TableQueryBean>() {

                },  new com.alibaba.fastjson.parser.Feature[0]);
                loggerInfoByUri.setProjectId(queryBean.getProjectId());
                loggerInfoByUri.setClusterId(queryBean.getClusterId());
            } else if (uri.endsWith("/update") || uri.endsWith("/delete")) {
                TableQueryBean queryBean = (TableQueryBean)JSON.parseObject(body, new TypeReference<TableQueryBean>() {

                },  new com.alibaba.fastjson.parser.Feature[0]);
                MetaTableBaseInfo baseInfo = this.tableBaseInfoDao.findByObjectId(queryBean.getObjectId());
                loggerInfoByUri
                        .setProjectId(baseInfo.getProjectId());
                loggerInfoByUri
                        .setClusterId(baseInfo.getClusterId());
            }
        }catch (Exception e){
            LOG.error("pre handler set table info error by uri = " + uri + ",method=" + method, e );
        }
    }

    private void setTableInfo(String uri, String method, String body, AuditLoggerInfo loggerInfoByUri) {
        try {
            if (uri.endsWith("/create") || uri.endsWith("/chown")) {
                DatabaseQueryBean queryBean = (DatabaseQueryBean)JSON.parseObject(body, new TypeReference<DatabaseQueryBean>() {

                },  new com.alibaba.fastjson.parser.Feature[0]);
                loggerInfoByUri.setProjectId(queryBean.getProjectId());
                loggerInfoByUri.setClusterId(queryBean.getClusterId());
            } else if (uri.endsWith("/delete")) {
                DatabaseQueryBean queryBean = (DatabaseQueryBean)JSON.parseObject(body, new TypeReference<DatabaseQueryBean>() {

                },  new com.alibaba.fastjson.parser.Feature[0]);
                MetaDatabaseInfo baseInfo = this.databaseInfoDao.findByObjectId(queryBean.getObjectId());
                loggerInfoByUri.setProjectId(baseInfo.getProjectId());
                loggerInfoByUri.setClusterId(baseInfo.getClusterId());
            }
        } catch (Exception e) {
            LOG.error("pre handler set database info error by uri=" + uri + ",method=" + method, e);
        }
    }

}

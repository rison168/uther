package com.rison.uther.table.exception;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @PACKAGE_NAME: com.rison.uther.table.exception
 * @NAME: ExceptionIllustrate
 * @USER: Rison
 * @DATE: 2022/11/2 9:45
 * @PROJECT_NAME: uther
 **/
public class ExceptionIllustrate {
    private static Logger LOG = LoggerFactory.getLogger(ExceptionIllustrate.class);

    public static String MetaDbException = "查询库表异常，请到系统运维中查看组件MetaDB是否正常";

    public static String HiveHdfsException = "操作失败，请查看HIVE或者HDFS是否运行正常";

    public static String RangerException = "权限打通失败，请到系统运维中查看组件Ranger是否正常";

    public static String DeleteTbaseDBException = "删除tbase数据库异常";

    public static String DeleteTbaseTABLEException = "删除tbase表异常";

    public static String columnDuplicate = "同名列已存在，请重新命名";

    public static String TableNotExistException = "表不存在";

    public static String FailedDeletePhysicalTableException = "删除物理表失败";

    public static String UnSupportedTypeDuplicate = "不支持的类型";

    public static String TableIsExistException = "表已存在";

    public static String CreateTableLocationException = "创建表失败，请检查路径";

    public static String CreateTableException = "创建表失败";

    public static String UnableToGetTableInfo = "获取表信息错误";

    public static String UnableToGetColumnsInfo = "获取表信息错误";

    public static String TableAlreadyAttribute = "表已有归属";

    public static String UpdateAuthorization = "权限修改失败";

    public static String ProjectOwnerParamError = "项目所有者信息不正确，请检查的用户所有者信息";

    public static String GetTableErrorByObjectId = "根据ObjectId获取表失败";

    public static String CurrentUserEmpty = "当前用户为空";

    public static String ObjectIdIsEmpty = "ObjectId不能为空";

    public static String GetUserInfoError = "获取当前登录用户信息失败";

    public static String CurrentUserNoPrivilege = "当前用户没有权限";

    public static String NeedAdminPrivilege = "只允许管理员进行操作";

    public static String AuthorityTypeParamError = "参数异常：角色为空";

    public static String OwnerParamError = "参数异常：责任人为空";

    public static String ProjectIdentParamError = "参数异常: 项目标识为空";

    public static String ProjectIDParamError = "参数异常: 项目id为空";

    public static String ProjectNameParamError = "参数异常: 项目名为空";

    public static String DBNameParamError = "参数异常：所属数据库为空";

    public static String MaxCNName = "中文名最大长度为: ";

    public static String MaxENName = "英文名最大长度为: ";

    public static String MaxBussisDesc = "业务描述最大长度为: ";

    public static String MaxTecnDesc = "技术描述过长";

    public static String InputFormatEmpty = "自定义文件格式，inputFormat是空";

    public static String OutFormatEmpty = "自定义文件格式，outFormat是空";

    public static String ExternalTablePartitions = "外表不支持创建分区";

    public static String NeedPartition = "必须先有分区，再有子分区";

    public static String PartitionFieldNotEmpty = "确认分区字段和分区类型不为空，且分区类型属于[list,range,hash]\"";

    public static String SubPartitionFieldNotEmpty = "确认子分区字段和分区类型不为空，且分区类型属于[list,range,hash]";

    public static String FieldIsEmpty = "参数异常：字段信息为空";

    public static String FieldTypeIsEmpty = "参数异常：字段类型为空";

    public static String CharSizeIsEmpty = "char类型size不能为空";

    public static String VarcharSizeIsEmpty = "varchar类型size不能为空";

    public static String SameFieldName = "字段存在重名，请正确填写字段信息";

    public static String FieldInfoIsEmpty = "参数异常：列信息为空";

    public static String PartitionLessOne = "参数异常：分区数量小于1";

    public static String ReplicationFactor = "参数异常：复制因子必须在0和3之间";

    public static String FormatError = " ：需数字小字母开头，是小字母，数字，下划线组合， 且不能全为数字或者下划线";

    public static String HbaseFormatError = "：需数字字母开头，是字母，数字，下划线组合， 且不能全为数字或者下划线";

    public static String ExceedLengthLimit = "超过长度限制";

    public static String ContainSpecialChara = "不能包含特殊字符：'单引号，\"双引号, \\等";

    public static String ContaionKeyword = "不能包含关键字，例如：create, update等";

    public static String DsIdError = "数据源Id获取失败";

    public static String GetDataError = "获取数据失败";

    public static String ConditonsEmpty = "条件不能为空";

    public static String PageParam = "分页参数不能为空";

    public static String GetDamMetaError = "河图信息获取错误";

    public static String GetGuidError = "guid获取失败";

    public static String GetTagsError = "表标签获取失败";

    public static String SearchTagsInfoError = "查询标签失败";

    public static String GetPartitionDataError = "获取分区数据失败，分区数据为空";

    public static String GetTablesFromExternalServerError = "无法从该外部源获取表数据";

    public static String GetDbListFromExternalServerError = "无法从该外部源获取库数据";

    public static String GetEmptyUnifiedMetadataError = "从河图获取数据为空";

    public static String DBNameNotExists = "所属数据库不存在";

    public String getExceptionDesc(String exceptionMessage) {
        String result = null;
        if (exceptionMessage.contains("exception.JDBCConnectionException: could not prepare statement") || exceptionMessage
                .contains("JDBCConnectionException: could not extract ResultSet"))
            result = MetaDbException;
        if (exceptionMessage.contains("JDBCConnectionException: Could not open connection"))
            result = MetaDbException;
        if (exceptionMessage.contains(".DDLTask. Duplicate column name"))
            result = columnDuplicate;
        if (exceptionMessage.contains("Could not roll back JPA transaction; nested exception is javax.persistence.PersistenceException"))
            result = MetaDbException;
        if (exceptionMessage.contains("Cannot find class"))
            result = "请确保自定义文件格式所填写的inputFormat, outputFormat类可被正确加载";
        if (exceptionMessage.contains("Cannot validate serde"))
            result = "serde信息不合法，请填写正确已存在的serde信息！";
        if (tableExist(exceptionMessage))
            result = "表已存在！";
        if (exceptionMessage.contains("SQLException: Could not establish connection to jdbc") || exceptionMessage
                .contains("SQLException: Could not open client transport with JDBC Uri"))
            result = "无法建立连接，请检查HIVE或HDFS是否运行正常";
        if (exceptionMessage.contains("Column can't not be empty"))
            result = "列不能为空！";
        if (exceptionMessage.contains("SemanticException No valid privileges"))
            result = "创建该表的权限错误，请检查用户权限";
        if (exceptionMessage.contains("Could not get JDBC Connection; nested exception is java.sql.SQLException: Could not open client"))
            result = "无法获取JDBC连接，请检查HIVE、LDAP、MetaDB、HDFS是否运行正常";
        if (exceptionMessage.contains("Could not get JDBC Connection; nested exception is java.sql.SQLException: org.apache.hive.jdbc.ZooKeeper"))
            result = "无法获取JDBC连接，请检查HIVE、Zookeeper是否运行正常";
        if (StringUtils.isBlank(result))
            if (exceptionMessage.length() > 200) {
                result = exceptionMessage.substring(0, 200);
            } else {
                result = exceptionMessage;
            }
        return result;
    }

    private boolean tableExist(String errorMsg) {
        String regx = "Table .+ already exists";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(errorMsg);
        return matcher.find();
    }
}

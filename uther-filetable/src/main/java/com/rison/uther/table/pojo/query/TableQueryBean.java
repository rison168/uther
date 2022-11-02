package com.rison.uther.table.pojo.query;

import com.rison.uther.table.pojo.custom.CustomItemInfo;
import com.tencent.tbds.metadata.security.UserLoginInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

/**
 * @PACKAGE_NAME: com.rison.uther.table.pojo.query
 * @NAME: TableQueryBean
 * @USER: Rison
 * @DATE: 2022/11/2 16:10
 * @PROJECT_NAME: uther
 **/
@ApiModel("表的公共属性")
public class TableQueryBean extends UserLoginInfo {
    @ApiModelProperty("表ObjectId")
    private String objectId;

    @ApiModelProperty("表名称")
    private String tableName;

    @ApiModelProperty("库表底层描述")
    private String tableDesc;

    @ApiModelProperty("业务描述")
    private String businessDesc;

    @ApiModelProperty("表类型")
    private String tableType;

    @ApiModelProperty("数据库名称")
    private String dbName;

    @ApiModelProperty("项目ID")
    private String projectId;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("项目标识")
    private String projectIdent;

    @ApiModelProperty("所属人ID")
    private String ownerId;

    @ApiModelProperty("所属人")
    private String owner;

    @ApiModelProperty("表中文名称")
    private String tableNameOfCN;

    @ApiModelProperty("表英文名称")
    private String tableNameOfEN;

    @ApiModelProperty("表自定义字段")
    private List<CustomItemInfo> customItemInfoList;

    @ApiModelProperty("DW表类型：维表、事实表")
    private String dwTableType;

    @ApiModelProperty("集群ID")
    private String clusterId;

    @ApiModelProperty("集群ID")
    private String clusterIdentification;

    @ApiModelProperty("是否是视图")
    private Boolean isView;

    @ApiModelProperty("生命周期")
    private long lifeTime;

    @ApiModelProperty("商业模式")
    private String businessModule;

    @ApiModelProperty("guid")
    private String guid;

    @ApiModelProperty("类型名")
    private String typeName;

    private String clusterName;

    @ApiModelProperty("项目是否在hive、hbase上创建物理表，默认创建物理表")
    private boolean enableAllocateResource = true;

    private String externalDsId;

    private String tableCategory = "MANAGED";

    private String location;

    private boolean force;

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableDesc() {
        return this.tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public String getBusinessDesc() {
        return this.businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
    }

    public String getTableType() {
        return this.tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getDbName() {
        return this.dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdent() {
        return this.projectIdent;
    }

    public void setProjectIdent(String projectIdent) {
        this.projectIdent = projectIdent;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTableNameOfCN() {
        return this.tableNameOfCN;
    }

    public void setTableNameOfCN(String tableNameOfCN) {
        this.tableNameOfCN = tableNameOfCN;
    }

    public String getTableNameOfEN() {
        return this.tableNameOfEN;
    }

    public void setTableNameOfEN(String tableNameOfEN) {
        this.tableNameOfEN = tableNameOfEN;
    }

    public List<CustomItemInfo> getCustomItemInfoList() {
        return this.customItemInfoList;
    }

    public void setCustomItemInfoList(List<CustomItemInfo> customItemInfoList) {
        this.customItemInfoList = customItemInfoList;
    }

    public String getDwTableType() {
        return this.dwTableType;
    }

    public void setDwTableType(String dwTableType) {
        this.dwTableType = dwTableType;
    }

    public String getClusterId() {
        return this.clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getTableCategory() {
        return this.tableCategory;
    }

    public void setTableCategory(String tableCategory) {
        this.tableCategory = tableCategory;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean isView() {
        return this.isView;
    }

    public void setView(boolean view) {
        this.isView = Boolean.valueOf(view);
    }

    public void setIsView(boolean view) {
        setView(view);
    }

    public long getLifeTime() {
        return this.lifeTime;
    }

    public void setLifeTime(long lifeTime) {
        this.lifeTime = lifeTime;
    }

    public String getBusinessModule() {
        return this.businessModule;
    }

    public void setBusinessModule(String businessModule) {
        this.businessModule = businessModule;
    }

    public String getClusterIdentification() {
        return this.clusterIdentification;
    }

    public void setClusterIdentification(String clusterIdentification) {
        this.clusterIdentification = clusterIdentification;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isForce() {
        return this.force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public String getExternalDsId() {
        return this.externalDsId;
    }

    public void setExternalDsId(String externalDsId) {
        this.externalDsId = externalDsId;
    }

    public boolean isEnableAllocateResource() {
        return this.enableAllocateResource;
    }

    public void setEnableAllocateResource(boolean enableAllocateResource) {
        this.enableAllocateResource = enableAllocateResource;
    }

    @Override
    public String toString() {
        return "TableQueryBean{objectId='" + this.objectId + '\'' + ", tableName='" + this.tableName + '\'' + ", tableDesc='" + this.tableDesc + '\'' + ", businessDesc='" + this.businessDesc + '\'' + ", tableType='" + this.tableType + '\'' + ", dbName='" + this.dbName + '\'' + ", projectId='" + this.projectId + '\'' + ", projectName='" + this.projectName + '\'' + ", projectIdent='" + this.projectIdent + '\'' + ", ownerId='" + this.ownerId + '\'' + ", owner='" + this.owner + '\'' + ", tableNameOfCN='" + this.tableNameOfCN + '\'' + ", tableNameOfEN='" + this.tableNameOfEN + '\'' + ", customItemInfoList=" + this.customItemInfoList + ", dwTableType='" + this.dwTableType + '\'' + ", clusterId='" + this.clusterId + '\'' + ", clusterIdentification='" + this.clusterIdentification + '\'' + ", guid='" + this.guid + '\'' + ", isView='" + this.isView + '\'' + ", typeName='" + this.typeName + '\'' + ", enableAllocateResource='" + this.enableAllocateResource + '\'' + '}';
    }

    public String getClusterName() {
        return this.clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }
}

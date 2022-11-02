package com.rison.uther.table.pojo.custom;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.rison.uther.table.common.FiledMode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@ApiModel("表的自定义字段项")
@Entity
@Table(name = "custom_item")
public class CustomItem {
    public static final Integer STATUS_ENABLE = Integer.valueOf(1);

    public static final Integer STATUS_DISABLE = Integer.valueOf(0);

    @Id
    @Column(length = 36)
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @ApiModelProperty("字段名称")
    @Column(unique = true)
    private String name;

    @ApiModelProperty("中文名")
    private String nameOfCN;

    @ApiModelProperty("描述")
    private String des;

    @ApiModelProperty("hive/hbase/kafka")
    private String type;

    @ApiModelProperty("状态")
    private Integer status = STATUS_ENABLE;

    @ApiModelProperty("单选/多选/str")
    private FiledMode filedMode;

    @ApiModelProperty("字段限制类型")
    private String filedType;

    @ApiModelProperty("获取对应取值的url")
    private String url;

    @ApiModelProperty("该字段对应的可选值")
    private String fieldValues;

    @ApiModelProperty("创建时间")
    @CreationTimestamp
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @CreationTimestamp
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfCN() {
        return this.nameOfCN;
    }

    public void setNameOfCN(String nameOfCN) {
        this.nameOfCN = nameOfCN;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public FiledMode getFiledMode() {
        return this.filedMode;
    }

    public void setFiledMode(FiledMode filedMode) {
        this.filedMode = filedMode;
    }

    public String getFiledType() {
        return this.filedType;
    }

    public void setFiledType(String filedType) {
        this.filedType = filedType;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFieldValues() {
        return this.fieldValues;
    }

    public void setFieldValues(String fieldValues) {
        this.fieldValues = fieldValues;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

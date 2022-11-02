package com.rison.uther.table.pojo.custom;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;

import javax.jdo.annotations.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @PACKAGE_NAME: com.rison.uther.table.pojo.custom
 * @NAME: CustomDetail
 * @USER: Rison
 * @DATE: 2022/11/2 16:22
 * @PROJECT_NAME: uther
 **/
@Entity
@Table(name = "custom_detail")
public class CustomDetail {
    @Id
    @Column(length = 36)
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String tableObjectId;

    private String itemId;

    private String contentId;

    private String contentName;

    @CreationTimestamp
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @CreationTimestamp
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableObjectId() {
        return this.tableObjectId;
    }

    public void setTableObjectId(String tableObjectId) {
        this.tableObjectId = tableObjectId;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getContentId() {
        return this.contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentName() {
        return this.contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
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

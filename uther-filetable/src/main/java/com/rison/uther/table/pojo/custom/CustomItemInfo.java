package com.rison.uther.table.pojo.custom;

import java.util.List;

/**
 * @PACKAGE_NAME: com.rison.uther.table.pojo.custom
 * @NAME: CustomItemInfo
 * @USER: Rison
 * @DATE: 2022/11/2 16:21
 * @PROJECT_NAME: uther
 **/
public class CustomItemInfo {
    private CustomItem customItem;

    private List<CustomDetail> customDetailList;

    public CustomItem getCustomItem() {
        return this.customItem;
    }

    public void setCustomItem(CustomItem customItem) {
        this.customItem = customItem;
    }

    public List<CustomDetail> getCustomDetailList() {
        return this.customDetailList;
    }

    public void setCustomDetailList(List<CustomDetail> customDetailList) {
        this.customDetailList = customDetailList;
    }
}

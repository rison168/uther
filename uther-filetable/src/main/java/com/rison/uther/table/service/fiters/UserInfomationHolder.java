package com.rison.uther.table.service.fiters;

import com.tencent.tbds.metadata.security.UserLoginInfo;

/**
 * @PACKAGE_NAME: com.rison.uther.table.service.fiters
 * @NAME: UserInfomationHolder
 * @USER: Rison
 * @DATE: 2022/11/2 15:25
 * @PROJECT_NAME: uther
 **/
public class UserInfomationHolder {
    private static final ThreadLocal<UserLoginInfo> threadLocal = new ThreadLocal<>();

    public static UserLoginInfo getUserInformation() {
        final UserLoginInfo userLoginInfo = threadLocal.get();
        return (userLoginInfo != null) ? userLoginInfo : new UserLoginInfo();
    }

    public static String getCurrentUserId() {
        UserLoginInfo loginInfo = getUserInformation();
        String userId = null;
        if (loginInfo != null) {
            userId = loginInfo.getUserId();
        }
        return userId;
    }

    public static String getCurrentUserName() {
        UserLoginInfo loginInfo = getUserInformation();
        String userName = null;
        if (loginInfo != null) {
            userName = loginInfo.getUserName();
        }
        return userName;
    }


    public static void setUserInformation(UserLoginInfo userInformation) {
        threadLocal.set(userInformation);
    }

    public static void clear() {
        threadLocal.set(null);
    }
}

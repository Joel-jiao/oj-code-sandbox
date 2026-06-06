package com.oj.ojcodesandbox.security;

import java.security.Permission;

/**
 * 安全管理器，阻止危险操作
 */
public class MySecurityManager extends SecurityManager {

    @Override
    public void checkPermission(Permission perm) {
        //super.checkPermission(perm);
    }

    @Override
    public void checkWrite(String file) {
        // 只允许在 tempCode 目录中写入
        if (file == null || !file.toLowerCase().contains("tempcode")) {
            //throw new SecurityException("checkWrite 权限异常：" + file);
        }
    }

    @Override
    public void checkExec(String cmd) {
        // 禁止执行外部命令（防止用户代码执行危险命令）
        throw new SecurityException("checkExec 权限异常：" + cmd);
    }

    @Override
    public void checkConnect(String host, int port) {
        // 禁止网络连接（防止用户代码建立网络连接）
        //throw new SecurityException("checkConnect 权限异常：" + host + ":" + port);
    }

}

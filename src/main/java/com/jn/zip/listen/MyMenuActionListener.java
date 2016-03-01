package com.jn.zip.listen;

import com.jn.zip.ZipManageApp;
import com.swing.menu.MenuUtil2;
import com.swing.messagebox.GUIUtil23;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * 设置新的密码
 *
 * @author huangwei
 */
public class MyMenuActionListener implements ActionListener {
    private ZipManageApp manualApp;

    public MyMenuActionListener(ZipManageApp manualApp) {
        super();
        this.manualApp = manualApp;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals(MenuUtil2.ACTION_HELP)) {
            System.out.println(MenuUtil2.ACTION_HELP);
            GUIUtil23.infoDialog("联系邮箱:huangwei@yunmasoft.com");
        } else if (command.equals(MenuUtil2.ACTION_STR_EXIT)) {// 退出应用程序
            manualApp.dispose();
            System.exit(0);
        }
    }
}

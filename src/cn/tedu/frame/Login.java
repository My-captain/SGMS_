package cn.tedu.frame;

import cn.tedu.dao.DBUtil;
import cn.tedu.po.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton loginButton = null;
    JButton registerButton = null;

    JPanel titleJP = null;
    JPanel userInfoJP = null;
    JPanel buttonJP = null;

    JLabel userLabel = null;
    JLabel passwordLabel = null;
    JLabel title = null;

    JTextField user = null;
    JPasswordField passwd = null;

	public Login() {
        titleJP = new JPanel();
//	    titleJP.setBounds(0, 0, 800, 200);
        userInfoJP = new JPanel();
//	    userInfoJP.setBounds(0, 200, 800, 350);
        userInfoJP.setLayout(new GridLayout(2, 2));
        buttonJP = new JPanel();
//	    buttonJP.setLayout(new GridLayout(1, 2));
//	    buttonJP.setBounds(0, 550, 800, 50);

        loginButton = new JButton("登录");
        registerButton = new JButton("注册");

        userLabel = new JLabel("用户名", JLabel.CENTER);
        passwordLabel = new JLabel("密码", JLabel.CENTER);

        title = new JLabel("员工管理系统", JLabel.CENTER);
        title.setFont(new Font("楷体", Font.BOLD, 28));

        user = new JTextField(10);
        passwd = new JPasswordField(10);

        titleJP.add(title);
        userInfoJP.add(userLabel);
        userInfoJP.add(user);
        userInfoJP.add(passwordLabel);
        userInfoJP.add(passwd);
        buttonJP.add(loginButton);
        buttonJP.add(registerButton);

        this.setLayout(new GridLayout(3, 1));
        this.setSize(360, 200);
        this.setVisible(true);
        this.add(titleJP);
        this.add(userInfoJP);
        this.add(buttonJP);

        /*
         * 注册按钮监听事件
         * */
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "登录") {
            if (user.getText() != "" && passwd.getPassword() != null) {
                userLogin(user.getText(), String.valueOf(passwd.getPassword()));
            } else {
                JOptionPane.showMessageDialog(null, "请填写账户名和密码", "登录失败", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // ======================================================================================================================
            if (user.getText() != "" && passwd.getPassword() != null) {
                // ==============================================================================================================================
                userRegister();
            } else {
                JOptionPane.showMessageDialog(null, "请填写账户名和密码", "注册失败", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void userLogin(String username, String passwd) {
        DBUtil.getConn();
        User user = DBUtil.SelectByUsername(username);
        if (user == null) {
            System.out.println("查无此人");
        } else {
            if (user.getPassword() == passwd) {
                System.out.println("登录成功");
            } else {
                System.out.println("密码错了啊傻逼");
            }
        }
    }

    public void userRegister() {
        DBUtil.getConn();
        User user = DBUtil.SelectByUsername(username);
        if (user == null) {
            System.out.println("查无此人");
        } else {
            if (user.getPassword() == passwd) {
                System.out.println("登录成功");
            } else {
                System.out.println("密码错了啊傻逼");
            }
        }
    }

    public static void main(String args[]) {
	    Login login = new Login();
    }
}

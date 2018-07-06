package cn.tedu.frame;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import cn.nj.db.DBUtil;
import cn.nj.db.User;

public class Login extends JFrame implements ActionListener{
	private JPanel jp = new JPanel();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	private JLabel tit = new JLabel("智能商品管理系统");

	private JLabel username = new JLabel("用户名:",JLabel.CENTER);
	private JLabel password = new JLabel("密码:",JLabel.CENTER);
	private JTextField user = new JTextField(10);
	private JPasswordField passwd = new JPasswordField(10);
	private JButton login = new JButton("登录");
	private JButton register = new JButton("注册");
	Font ft = new Font("楷体",Font.BOLD,20);
	Font fl = new Font("黑体",Font.BOLD,15);

	Login() {
		tit.setFont(ft);
		jp2.add(tit);
		
		username.setFont(fl);
		password.setFont(fl);
		jp1.add(username);
		jp1.add(user);
		jp1.add(password);
		jp1.add(passwd);
		
		login.setFont(fl);
		register.setFont(fl);
		jp3.add(login);
		login.addActionListener(this);
		jp3.add(register);
		register.addActionListener(this);
		
		jp.add(jp2);
		jp.add(jp1);
		jp.add(jp3);
		
		jp1.setLayout(new GridLayout(2, 2));
		jp.setLayout(new GridLayout(3, 1));
		
		this.add(jp);
		this.setTitle("SMGS V1.0");
		this.setSize(360, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "登录") {
        if (user.getText() != "" && passwd.getPassword() != null) {
            userLogin(user.getText(), String.valueOf(passwd.getPassword()));
        } else {
            JOptionPane.showMessageDialog(null, "请填写账户名和密码", "登录", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        // ======================================================================================================================
        if (user.getText() != "" && passwd.getPassword() != null) {
            // ==============================================================================================================================
            userRegister(user.getText(), String.valueOf(passwd.getPassword()));
        } else {
            JOptionPane.showMessageDialog(null, "请填写账户名和密码", "注册", JOptionPane.WARNING_MESSAGE);
        }
    }
}

public void userLogin(String username, String passwd) {
    DBUtil.getConn();
    User user = DBUtil.SelectByUsername(username);
    if (user == null) {
        JOptionPane.showMessageDialog(null, "查无此人", "登录", JOptionPane.WARNING_MESSAGE);
    } else {
        if (user.getPassword() == passwd) {
            JOptionPane.showMessageDialog(null, "登录成功", "登录", JOptionPane.WARNING_MESSAGE);
            new Index();
        } else {
            JOptionPane.showMessageDialog(null, "密码错误", "登录", JOptionPane.WARNING_MESSAGE);
        }
    }
}

public void userRegister(String username, String passwd) {
    DBUtil.getConn();
    User user = DBUtil.SelectByUsername(username);
    if (user != null) {
        JOptionPane.showMessageDialog(null, "此人已存在", "登录", JOptionPane.WARNING_MESSAGE);
    } else {
        User userRegister = new User();
        userRegister.setUsername(username);
        userRegister.setPassword(passwd);
        if (DBUtil.insertUser(user)) {
            JOptionPane.showMessageDialog(null, "注册成功", "注册", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "注册失败", "注册", JOptionPane.WARNING_MESSAGE);
        }
    }
}
}
package cn.nj.show;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Show extends JFrame {
JFrame jf;
JButton jbt1;
public Show() {
	// TODO Auto-generated constructor stub
	jf=new JFrame();
	jbt1=new JButton("查询");
	
	this.setTitle("测试主窗体");
	this.setSize(1000, 768);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
}
public static void main(String[] args) {
		Show newwin=new Show();
}
}

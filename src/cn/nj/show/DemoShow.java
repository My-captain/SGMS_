package cn.nj.show;

import javax.swing.JFrame;

public class DemoShow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1196326221577707121L;

	public static void main(String[] args) {
			JFrame jf=new JFrame();
			jf.setTitle("第一个程序窗体！");
			jf.setSize(300,300);
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
			jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}

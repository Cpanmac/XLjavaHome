package com.xl.gui;

/*
 练习-列出指定目录内容

 */
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

class MyWindowDemo {
	private Frame f; // 可以直接继承Frame,就可以直接调用里面的方法了
	private TextField tf; // 文本框
	private Button but; // 按钮
	private TextArea ta; // 是显示文本的多行区域

	MyWindowDemo() {
		init();
	}

	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500); // 出现该Frame距离屏幕左边的距离，距离上边的距离。文本横坐标长度，纵坐标长度
		f.setLayout(new FlowLayout()); // 设置布局管理，流布局，默认是边界布局，如果不指认东南西北就全填充

		// tf = new TextField(30);
		// 觉得上面短了
		tf = new TextField(60); // 文本长度

		but = new Button("转到"); // 按钮的名称
		// ta = new TextArea(15,40); //文本区域
		ta = new TextArea(25, 70);
		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();// 事件

		f.setVisible(true); // 显示出来
	}

	private void myEvent() {
		f.addWindowListener(new WindowAdapter() // 点击关闭触发的事件
		{
			public void windowClosing(WindowEvent e) // 设置关闭事件
			{
				System.exit(0);
			}
		});
		// 确定事件源是文本框
		but.addActionListener(new ActionListener() // 点击转到按钮触发的事件
		{
			// 获取文本区域
			public void actionPerformed(ActionEvent e) {
				// 输入目录
				String dirPath = tf.getText();
				File dir = new File(dirPath); // 封装成对象
				if (dir.exists() && dir.isDirectory()) // 如果是目录并且存在
				{
					ta.setText(""); // 把以前的清空
					String[] names = dir.list();
					for (String name : names) {
						// ta.setText(name+"\r\n"); //输出，但是这样会覆盖！
						ta.append(name + "\r\n"); // 追加文本
					}
				}

				/*
				 * //演示 String text = tf.getText(); tf.setText(""); //将上面清空。
				 * //设置文本区域的内容 ta.setText(text); //将字符串在文本区域中显示 //
				 * System.out.print(text);
				 */
			}
		});

	}

	public static void main(String[] args) {
		new MyWindowDemo();
	}
}

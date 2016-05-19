package com.xl.基础加强;

public class Eclipse基本使用 {
    /*
     * 高版本的java可以运行低版本的javac编译的程序 低版本的java不能运行高版本的javac编译的程序
     */
    public static void main(String[] args) {
        // 配置try..finally模板
        // 1.window-->preference-->java-->editor-->template
        int x;
        try {
            x = 1;
        } finally {
        }
        // compiler，选择编译版本
        // 高版本的java可以运行低版本的javac编译的程序
        // 低版本的java不能运行高版本的javac编译的程序
        // 每一个小窗口叫视图。 透视图就是右上角的，显示很多小窗口
        // 断电调试：
        // F5:step into
        // F6:step over 跳过
        // F7:step return
        // drop to frame:跳到当前方法的第一行
        // resume:跳到下一个断电（如果没有下一个，则运行完整程序
        // DebugF8下一步
    /*断点要注意的问题
     * 1.断电调试完成后，要在breakpoints视图清除所有断电
	 * 2.断点调式完成后，一定要记得停止运行jvm
	 */
        x++;
        System.out.println(x);
        // 增加库add Library相当好多jar包，user Library然后增加很多jar包

		/*快捷键
		 * 更改大小写Ctrl+Shift+X(或Y)
		 * 查看类的继承关系Ctrl+T
		 * Ctrl+Shift+T可以直接查看类
		 * CTRL+SHIFT+L查看所有快捷键
		 */
    }
}


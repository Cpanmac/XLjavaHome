package com.xl.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by �� on 7/25 0025.
 */
class SwingDemo extends JApplet {
    public void init() {
        Container contentPane = getContentPane();
         /*ԭ��
    Icon icon = new ImageIcon("swing.gif","An animated GIF of Duke on a swing");
    JLabel label = new JLabel("Swing!",icon,SwingConstants.CENTER);
    */
        //�޸ĺ�
        JLabel label = new JLabel("Swing!", new ImageIcon(getImage(getCodeBase(), "swing.gif"), "An animated GIF of Duke on a swing"), SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);
    }
}

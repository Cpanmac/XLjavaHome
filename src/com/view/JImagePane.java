package com.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class JImagePane extends JPanel {
    /**
     * 背景图片
     */
    private Image image = null;
    /**
     * 是否自适应
     */
    private boolean autoResize = false;

    /**
     * 构造方法
     */
    public JImagePane() {
        this(null, false);
    }

    /**
     * 构造方法
     *
     * @param autoResize - 图形是否根据面大大小自适应
     */
    public JImagePane(boolean autoResize) {
        this(null, autoResize);
    }

    /**
     * 构造方法
     *
     * @param image - 图片
     */
    public JImagePane(Image image) {
        this(image, false);
    }

    /**
     * 构造方法
     *
     * @param image      - 图片
     * @param autoResize - 是否自适应
     */
    public JImagePane(Image image, boolean autoResize) {
        super();
        this.autoResize = autoResize;
        this.image = image;
        repaint();
    }

    // --------------以下为测试用例，可以将图片改为你自己的图片进行测试-------------
    private static void initGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        try {
            frame.setContentPane(new JImagePane(ImageIO.read(ClassLoader.getSystemResource("images/suzhou.jpg")), true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(new JButton("123"));
        frame.add(new JButton("456"));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initGUI();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            if (autoResize) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            } else {
                g.drawImage(image, 0, 0, null);
            }
        }
    }

    /**
     * 返回背景图片
     *
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     * 设置背景图片
     *
     * @param image - 背景图片
     */
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    /**
     * 返回图片是否自适应
     *
     * @return
     */
    public boolean isAutoResize() {
        return autoResize;
    }

    /**
     * 设置图片是否自适应
     *
     * @param autoResize
     */
    public void setAutoResize(boolean autoResize) {
        this.autoResize = autoResize;
        repaint();
    }
    // -------------------------测试用例结束-------------------------
}

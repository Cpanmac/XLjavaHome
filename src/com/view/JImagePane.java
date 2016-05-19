package com.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class JImagePane extends JPanel {
    /**
     * ����ͼƬ
     */
    private Image image = null;
    /**
     * �Ƿ�����Ӧ
     */
    private boolean autoResize = false;

    /**
     * ���췽��
     */
    public JImagePane() {
        this(null, false);
    }

    /**
     * ���췽��
     *
     * @param autoResize - ͼ���Ƿ��������С����Ӧ
     */
    public JImagePane(boolean autoResize) {
        this(null, autoResize);
    }

    /**
     * ���췽��
     *
     * @param image - ͼƬ
     */
    public JImagePane(Image image) {
        this(image, false);
    }

    /**
     * ���췽��
     *
     * @param image      - ͼƬ
     * @param autoResize - �Ƿ�����Ӧ
     */
    public JImagePane(Image image, boolean autoResize) {
        super();
        this.autoResize = autoResize;
        this.image = image;
        repaint();
    }

    // --------------����Ϊ�������������Խ�ͼƬ��Ϊ���Լ���ͼƬ���в���-------------
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
     * ���ر���ͼƬ
     *
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     * ���ñ���ͼƬ
     *
     * @param image - ����ͼƬ
     */
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    /**
     * ����ͼƬ�Ƿ�����Ӧ
     *
     * @return
     */
    public boolean isAutoResize() {
        return autoResize;
    }

    /**
     * ����ͼƬ�Ƿ�����Ӧ
     *
     * @param autoResize
     */
    public void setAutoResize(boolean autoResize) {
        this.autoResize = autoResize;
        repaint();
    }
    // -------------------------������������-------------------------
}

package com.xl.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Snake extends JFrame {
    /** */
    private static final long serialVersionUID = 1L;
    MyPaint mp = null;

    public Snake() {
        mp = new MyPaint();
        Thread t1 = new Thread(mp);// ����mp�߳�
        t1.start();
        this.add(mp);// �������
        this.addKeyListener(mp);// ���ذ�������
        this.setSize(300, 320);// ���ڴ�С
        this.setLocationRelativeTo(null); // ����
        this.setTitle("̰����V1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ����ر�ʱ���رճ���
        this.setVisible(true);// �ɼ�
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Snake she = new Snake();
    }
}

class MyPaint extends JPanel implements KeyListener, Runnable {
    /** */
    private static final long serialVersionUID = 1L;
    yidong yd = new yidong();

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, 300, 260);
        g.setColor(Color.yellow);
        g.fillOval(yd.swx, yd.swy, 20, 20);
        g.setColor(Color.red);
        g.fillOval(yd.x[0], yd.y[0], 20, 20);// ��ͷ��ʾ
        g.setColor(Color.blue);
        for (int i = 1; i < yd.sum - 1; i++) {// ��������ʾ
            g.fillOval(yd.x[i], yd.y[i], 20, 20);
        }
        g.drawString("��ǰ����: " + yd.fenshu, 190, 275);
        g.drawString("�ٶȵȼ�: " + yd.lv, 10, 275);
        g.setColor(Color.ORANGE);
        if (yd.kaishi == 0) { // ����Ϸ����ʱ��ʾ
            g.setFont(new Font("����", 1, 20));
            g.drawString("Game over", 90, 100);
            g.setFont(new Font("����", 1, 15));
            g.drawString("��Z��  ������Ϸ��", 80, 120);
        }
    }

    public void keyPressed(KeyEvent e) {
        if (yd.kaishi == 1) {// ����Ϸ����ʱ �ɿ���
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                if (yd.fx != 2) {
                    yd.fx = 8;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                if (yd.fx != 8) {
                    yd.fx = 2;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                if (yd.fx != 6) {
                    yd.fx = 4;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                if (yd.fx != 4) {
                    yd.fx = 6;
                }
            }
        } else {// ����Ϸ����ʱ ��Z �ָ���Ϸ
            if (e.getKeyCode() == KeyEvent.VK_Z) {
                yd.sum = 4;
                yd.x[0] = 100;
                yd.y[0] = 100;
                yd.x[1] = 80;
                yd.y[1] = 100;
                yd.x[2] = 60;
                yd.y[2] = 100;
                yd.yanchi = 200;
                yd.kaishi = 1;
                yd.fx = 6;
                yd.nfx = 6;
                yd.sp = 20;
            }
        }
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }

    public void run() { // ˢ������߳�
        Thread t2 = new Thread(yd);
        t2.start();
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}

class yidong implements Runnable { // ���ƶ��߳�
    /**
     * �ߵ���󳤶�
     */
    int maxsum = 128;
    /**
     * �ߵĳ�ʼ����
     */
    int sum = 3, x[] = new int[maxsum], y[] = new int[maxsum];
    /**
     * 1:��ʼ;0:����
     */
    int kaishi = 1; // sum�������ߵ��ܹ�������sum-1
    /**
     * ���� fx��4=�� 6=�� 8=�� 2=�� ���ࣺ���ƶ�
     */
    int fx = 1;
    int nfx, sp = 20, i = 0;
    /**
     * �ӳ�
     */
    int yanchi = 200;
    /**
     * ����
     */
    int fenshu;
    /**
     * ʳ�������
     */
    int swx = 0, swy = 0;
    /**
     * ʳ��
     */
    int shiwu = 0;
    String lv = "1";
    Random sj = new Random();

    @Override
    public void run() {
        x[0] = 100;
        y[0] = 100;// ��ʼ��������
        while (true) {
            try {
                Thread.sleep(yanchi);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (shiwu == 0) {// �������ʳ��
                swx = (sj.nextInt(10) + 1) * 20;// ���0-20
                swy = (sj.nextInt(10) + 1) * 20;
                shiwu = 1;
            }
            if (kaishi == 1) {
                // ����ǿ�ʼ,���߳���ʳ�����Ϊʳ�ﳤ�ȼ�ȥ��ʼ����
                fenshu = sum * 100 - 400;
            }
            // ��������
            for (int i = sum - 1; i > 0; i--) {// ��������ˢ��
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            if (fx == 6 && nfx != 4) {// �����ж�
                x[0] += sp;// �ƶ�
                nfx = 6;
            } else if (fx == 4 && nfx != 6) {
                x[0] -= sp;
                nfx = 4;
            } else if (fx == 2 && nfx != 8) {
                y[0] += sp;
                nfx = 2;
            } else if (fx == 8 && nfx != 2) {
                y[0] -= sp;
                nfx = 8;
            } else {
                if (nfx == 6) {
                    x[0] += sp;
                }
                if (nfx == 4) {
                    x[0] -= sp;
                }
                if (nfx == 2) {
                    y[0] += sp;
                }
                if (nfx == 8) {
                    y[0] -= sp;
                }
            }
            if (x[0] > 270) {
                x[0] -= sp;
            }
            if (x[0] < 0) {
                x[0] += sp;
            }
            if (y[0] > 255) {
                y[0] -= sp;
            }
            if (y[0] < 0) {
                y[0] += sp;
            }
            if (x[0] > swx - 5 && x[0] < swx + 5 && y[0] > swy - 5 && y[0] < swy + 5) {
                sum++;// ���ӳ���
                shiwu = 0;
                if (sum == 10) {
                    yanchi = 180;
                    lv = "2";
                }// ����
                if (sum == 20) {
                    yanchi = 160;
                    lv = "3";
                }
                if (sum == 30) {
                    yanchi = 150;
                    lv = "4";
                }
                if (sum == 40) {
                    yanchi = 140;
                    lv = "5";
                }
                if (sum == 50) {
                    yanchi = 130;
                    lv = "max";
                }
            }
            for (int i = sum - 1; i > 0; i--) {// �ж����Ƿ�Ե��Լ�
                if (x[0] > x[i] - 5 && x[0] < x[i] + 5 && y[0] > y[i] - 5 && y[0] < y[i] + 5) {
                    sp = 0;
                    yanchi = 500;
                    kaishi = 0;
                }
            }
        }
    }
}

package com.xuan.xutils.bt.tracker;

/**
 * �ܵ���һ��������,Ŀǰ�������ٳ�RT��ԭ��
 * <p>
 * Created by xuan on 17/7/29.
 */
public abstract class Tracker {
    /**
     * �ڴ�����ʱ,����������ʱ��,��Ҫ��־���,���Ƿŵ���������
     */
    private static final Long DEFAULT_LOG_INTERVAL = 500L;
    /**
     * �Ƿ�����¼,���Ƿŵ���������
     */
    private static final boolean TRACE = true;
    //private static final Logger log = LoggerFactory.getLogger(Tracker.class);
    /**
     * ÿ���̶߳���һ��ThreadLocalMap, ��һ��ThreadLocalʵ������һ��keyֵ
     */
    private static ThreadLocal<TKPointLine> traceLine = new ThreadLocal<>();

    /**
     * ��㿪ʼ,name�淶,��������,[����-������-�����ڲ��߼����]
     *
     * @param name
     */
    public static void start(String name) {
        if (!TRACE) {
            return;
        }
        if (null == name || name.length() == 0) {
            return;
        }
        //����һ����·,����ʼ����һ����־��
        TKPointLine tkPointLine = new TKPointLine();
        tkPointLine.addPoint(TKPoint.buildStart(name));
        traceLine.set(tkPointLine);
    }

    /**
     * ���,name�淶,��������,[����-������-�����ڲ��߼����]
     *
     * @param name
     * @param remark
     */
    public static void on(String name, String remark) {
        if (!TRACE) {
            return;
        }
        if (null == name || name.length() == 0) {
            return;
        }
        TKPointLine tkPointLine = getTraceLine();
        if (null == tkPointLine) {
            return;
        }
        int size = tkPointLine.getPointList().size();
        if (0 == size) {
            tkPointLine.addPoint(TKPoint.buildStart(name));
        } else {
            TKPoint on = TKPoint.buildOn(tkPointLine.getPointList().get(size - 1), name);
            //���ñ�ע���Ը��õķ�����־
            if (null == remark || remark.length() == 0) {
                on.setRemark(remark);
            }
            tkPointLine.addPoint(on);
        }
    }

    /**
     * ������,name�淶,��������,[����-������-�����ڲ��߼����]
     *
     * @param name
     */
    public static void end(String name) {
        if (!TRACE) {
            return;
        }
        Tracker.on(name, null);
        TKPointLine tkPointLine = getTraceLine();
        if (null == tkPointLine) {
            return;
        }
        int size = tkPointLine.getPointList().size();
        if (size < 3) {
            //���ֻ��������,˵��ֻ�п�ʼ�ͽ���,��ֹ��Ľӿ���Ⱦ��־,�����Ȳ���¼,ֻ��¼����on��
            return;
        }
        //��ӡ������ʱ
        Long interval = tkPointLine.getPointList().get(size - 1).getTimestamp().longValue() - tkPointLine.getPointList().get(0).getTimestamp().longValue();
        if (interval - DEFAULT_LOG_INTERVAL > 0) {
            Tracker.on("�ܺ�ʱ��", String.valueOf(interval));//���һ����,��¼�ܺ�ʱ
            //�������������־,�����ϱ�����־ƽ̨
            //log.warn("Tracker OPS:" + JSON.toJSONString(tkPointLine.getPointList()));
            System.out.println("Tracker OPS: " + tkPointLine.getPointList().toString());
        }
        //����
        clear();
    }

    private static TKPointLine getTraceLine() {
        Object obj = traceLine.get();
        if (null == obj) {
            return null;
        }
        return (TKPointLine) obj;
    }

    /**
     * �̱߳����е���־����
     */
    public static void clear() {
        Object obj = traceLine.get();
        if (null != obj) {
            traceLine.remove();
        }
    }

    public static void main(String args[]) {
        try {
            /**
             * �ڵ��ÿ�ʼǰstart
             */
            Tracker.start("[Tracker-main-start]");
            /**
             * �м��κεط������Լ�¼��־���
             */
            Tracker.on("[Tracker-main-1]", "1");
            Thread.sleep(100);
            Tracker.on("[Tracker-main-2]", "2");
            Thread.sleep(450);
            Tracker.on("[Tracker-main-3]", "3");
            /**
             * �ȵ��ý�����end,�������ݷ�������
             */
            Tracker.end("[Tracker-main-end]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

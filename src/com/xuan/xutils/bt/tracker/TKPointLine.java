package com.xuan.xutils.bt.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * ��־���,������·
 * <p>
 * Created by xuan on 17/7/29.
 */
public class TKPointLine {
    /**
     * �ӿ�ʼ��������¼�Ĵ����־
     */
    private List<TKPoint> pointList = new ArrayList<>();

    public List<TKPoint> getPointList() {
        return pointList;
    }

    public void setPointList(List<TKPoint> pointList) {
        this.pointList = pointList;
    }

    /**
     * ���һ����־��
     *
     * @param tkPoint
     */
    public void addPoint(TKPoint tkPoint) {
        this.pointList.add(tkPoint);
    }
}

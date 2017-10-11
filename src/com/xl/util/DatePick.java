package com.xl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ��ȡʱ�䷽��
 *
 * @author wzj
 * @date 2014-2-25
 */
public class DatePick {
    private final static String WEEK_START = "wkstart";
    private final static String WEEK_END = "wkend";
    private final static String MONTH_START = "mostart";
    private final static String MONTH_END = "moend";

    public static String getWeekStart() {
        return WEEK_START;
    }

    public static String getWeekEnd() {
        return WEEK_END;
    }

    public static String getMonthStart() {
        return MONTH_START;
    }

    public static String getMonthEnd() {
        return MONTH_END;
    }

    /**
     * ������date����תΪstring����
     *
     * @param date
     * @return
     */
    private String convertDateToString(Date date) {
        String res = "";
        if (date != null) {
            Date currentTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            res = sdf.format(currentTime);
        }
        return res;
    }

    /**
     * ���ݵ�ǰʱ���ȡ���ܵ�ʱ�����䣬����һ��ʼ���ս���
     *
     * @param date
     * @return
     * @throws Exception
     */
    public String weekInterval(Date date, String meth) {
        return this.weekInterval(this.convertDateToString(date), meth);
    }

    /**
     * ���ݵ�ǰʱ���ȡ���ܵ�ʱ�����䣬����һ��ʼ���ս���
     *
     * @param date
     * @param meth
     * @return
     * @throws ParseException
     */
    public String weekInterval(String date, String meth) {
        String res = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (null != date && !"".equals(date)) {
            try {
                Date d = sdf.parse(date);
                cal.setTime(d);
                /* ����������������һ�ܣ���Ϊ�����������Ϊÿ�ܵ�һ�� */
                if (Calendar.SUNDAY == cal.get(Calendar.DAY_OF_WEEK)) {
                    cal.add(Calendar.WEEK_OF_YEAR, -1);
                }
                if (WEEK_START.equals(meth)) {
                    /* ��ȡ����һ������ */
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    res = sdf.format(cal.getTime());
                } else if (WEEK_END.equals(meth)) {
                    /* ������������ϸ��������յ����ڣ���Ϊ�����Ǳ߰����յ��ɵ�һ�� */
                    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                    /* ����һ�����ڣ����������й������ı����յ����� */
                    cal.add(Calendar.WEEK_OF_YEAR, 1);
                    res = sdf.format(cal.getTime());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * ���ݵ�ǰʱ���ȡ���µ�ʱ�����䣬��ÿ�µĵ�һ����һ��ʼ�������һ�������ܵ����ս���
     *
     * @param date
     * @param meth
     * @return
     */
    public String monthInterval(Date date, String meth) {
        return this.monthInterval(this.convertDateToString(date), meth);
    }

    /**
     * ���ݵ�ǰʱ���ȡ���µ�ʱ�����䣬��ÿ�µĵ�һ����һ��ʼ�������һ�������ܵ����ս���
     *
     * @param date
     * @param meth
     * @return
     */
    public String monthInterval(String date, String meth) {
        String res = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
        if (null != date && !"".equals(date)) {
            try {
                Date d = sdf.parse(date);
                cal.setTime(d);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                int i = 1;
                while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                    cal.set(Calendar.DAY_OF_MONTH, i++);
                }
                if (MONTH_START.equals(meth)) {
                    res = sdf_date.format(cal.getTime());
                } else if (MONTH_END.equals(meth)) {
                    /* set �������һ�� */
                    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    /* ����������һ�����������ʾ���½�����������ڱ��µ����һ��������Ļ����ϼ�һ�� */
                    if (cal.get(Calendar.WEEK_OF_MONTH) != 6) {
                        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                        /* ����һ�����ڣ����������й������ı����յ����� */
                        cal.add(Calendar.WEEK_OF_YEAR, 1);
                    }
                    res = sdf_date.format(cal.getTime());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * �������¼��㵱���м��ܣ���ÿ�µĵ�һ����һ��ʼ�������һ�������ܵ����ս���
     *
     * @param date
     * @return
     */
    public long countWeeksInMonth(Date date) {
        return countWeeksInMonth(this.convertDateToString(date));
    }

    /**
     * �������¼��㵱���м��ܣ���ÿ�µĵ�һ����һ��ʼ�������һ�������ܵ����ս���
     *
     * @param date
     * @return
     */
    public long countWeeksInMonth(String date) {
        long res = 0;
        String sbegin = this.monthInterval(date, MONTH_START);
        String send = this.monthInterval(date, MONTH_END);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (sbegin != null && !"".equals(sbegin) && send != null && !"".equals(send)) {
            try {
                Date dbegin = sdf.parse(sbegin);
                Date dend = sdf.parse(send);
                long cdays = dend.getTime() - dbegin.getTime();
                res = cdays / 1000 / 60 / 60 / 24;
                res = (res + 1) / 7;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * �������º��ܴβ�ѯ���ܵ����ջ�ֹ������,��ÿ�µĵ�һ����һ��ʼ�������һ�������ܵ����ս���
     *
     * @param date
     * @param week
     * @param meth
     * @return
     */
    public String getWeekDate(Date date, int weekNo, String meth) {
        return getWeekDate(this.convertDateToString(date), weekNo, meth);
    }

    /**
     * �������º��ܴβ�ѯ���ܵ����ջ�ֹ������,��ÿ�µĵ�һ����һ��ʼ�������һ�������ܵ����ս���
     *
     * @param date
     * @param week
     * @param meth
     * @return
     */
    public String getWeekDate(String date, int weekNo, String meth) {
        String res = "";
        String sbegin = this.monthInterval(date, MONTH_START);
        long weeks = this.countWeeksInMonth(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        if (weekNo > 0 && weekNo <= weeks && sbegin != null && !"".equals(sbegin)) {
            try {
                Date d = sdf.parse(sbegin);
                cal.setTime(d);
                cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 7 * (weekNo - 1));
                if (WEEK_START.equals(meth)) {
                    res = sdf.format(cal.getTime());
                } else if (WEEK_END.equals(meth)) {
                    cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 6);
                    res = sdf.format(cal.getTime());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * �жϸ��������ܴκ͵�ǰ����ʱ����ܴβ�ֵ�Ƿ�������Χ��
     *
     * @param date
     * @param week
     * @param scope
     */
    public boolean weekInScopeFromNow(Date date, int week, int scope) {
        return this.weekInScopeFromNow(this.convertDateToString(date), week, scope);
    }

    /**
     * �жϸ��������ܴκ͵�ǰ����ʱ����ܴβ�ֵ�Ƿ�������Χ��
     *
     * @param date
     * @param week
     * @param scope
     */
    public boolean weekInScopeFromNow(String date, int weekNo, int scope) {
        boolean res = false;
        String sta = weekInterval(new Date(), WEEK_START);
        String end = getWeekDate(date, weekNo, WEEK_START);
        if (sta != null && !"".equals(sta) && end != null && !"".equals(end)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date staD = sdf.parse(sta);
                Date endD = sdf.parse(end);
                long jump = scope * (-7);
                long cdays = staD.getTime() - endD.getTime();
                cdays = cdays / 1000 / 60 / 60 / 24;
                if ((0 <= cdays && cdays <= jump) || (jump <= cdays && cdays <= 0)) {
                    res = true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * ����������ں͵�ǰ��������������߼��ȣ��������ֵΪLong.MIN_VALUE���ʾ�������
     *
     * @param date
     * @param type ��ֵΪmonth��ʾ���·ݲ�ֵ��Ϊquarter��ʾ�󼾶Ȳ�ֵ
     * @return
     */
    public long countMonthesToNow(String date, String type) {
        long res = Long.MIN_VALUE;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar cal = Calendar.getInstance();
        if (date != null && !"".equals(date)) {
            try {
                Date dorg = sdf.parse(date);
                int orgY = 0, nowY = 0;
                int orgM = 0, nowM = 0;
                cal.setTime(dorg);
                orgY = cal.get(Calendar.YEAR);
                orgM = cal.get(Calendar.MONTH);
                cal.setTime(new Date());
                nowY = cal.get(Calendar.YEAR);
                nowM = cal.get(Calendar.MONTH);
                if ("month".equals(type)) {
                    res = (orgY - nowY) * 12 + orgM - nowM;
                } else if ("quarter".equals(type)) {
                    /* ����Calendar.MONTH�н�һ�µķ���ֵ��Ϊ0������������·�ֵ������1�ٴ��� */
                    res = (orgY - nowY) * 4 + (orgM + 1) / 4 - (nowM + 1) / 4;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * �жϸ������º͵�ǰ�������µ��·ݲ�ֵ�Ƿ�������Χ��
     *
     * @param date
     * @param scope ������ʾ��ǰʱ��֮�󣬸�����ʾ��ǰʱ��֮ǰ
     * @return
     */
    public boolean monthInScopeFromNow(Date date, int scope) {
        return this.monthInScopeFromNow(this.convertDateToString(date), scope);
    }

    /**
     * �жϸ������º͵�ǰ�������µ��·ݲ�ֵ�Ƿ�������Χ��
     *
     * @param date
     * @param scope ������ʾ��ǰʱ��֮�󣬸�����ʾ��ǰʱ��֮ǰ
     * @return
     */
    public boolean monthInScopeFromNow(String date, int scope) {
        boolean res = false;
        long scmonth = this.countMonthesToNow(date, "month");
        if (scmonth > Long.MIN_VALUE) {
            if ((scope <= scmonth && scmonth <= 0) || (0 <= scmonth && scmonth <= scope)) {
                res = true;
            }
        }
        return res;
    }

    /**
     * �жϸ����������ڼ��Ⱥ͵�ǰ�������ȵļ��Ȳ�ֵ�Ƿ�������Χ��
     *
     * @param date
     * @param scope ������ʾ��ǰʱ��֮�󣬸�����ʾ��ǰʱ��֮ǰ
     * @return
     */
    public boolean quarterInScopeFromNow(Date date, int scope) {
        return this.monthInScopeFromNow(this.convertDateToString(date), scope);
    }

    /**
     * �жϸ����������ڼ��Ⱥ͵�ǰ�������ȵļ��Ȳ�ֵ�Ƿ�������Χ��
     *
     * @param date
     * @param scope ������ʾ��ǰ����֮�󣬸�����ʾ��ǰ����֮ǰ
     * @return
     */
    public boolean quarterInScopeFromNow(String date, int scope) {
        boolean res = false;
        long scmonth = this.countMonthesToNow(date, "quarter");
        if (scmonth > Long.MIN_VALUE) {
            if ((scope <= scmonth && scmonth <= 0) || (0 <= scmonth && scmonth <= scope)) {
                res = true;
            }
        }
        return res;
    }

    /**
     * �жϸ����ꡢ���Ⱥ͵�ǰ�������ȵļ��Ȳ�ֵ�Ƿ�������Χ��
     *
     * @param year    ��
     * @param quarter ���� 1-4
     * @param scope
     * @return
     */
    public boolean quarterInScopeFromNow(Date year, int quarter, int scope) {
        return this.quarterInScopeFromNow(this.convertDateToString(year), quarter, scope);
    }

    /**
     * �жϸ����ꡢ���Ⱥ͵�ǰ�������ȵļ��Ȳ�ֵ�Ƿ�������Χ��
     *
     * @param year    ��
     * @param quarter ���� 1-4
     * @param scope
     * @return
     */
    public boolean quarterInScopeFromNow(String year, int quarter, int scope) {
        boolean res = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        if (year != null && !"".equals(year) && 0 < quarter && quarter < 5) {
            String mo = "";
            switch (quarter) {
                case 1:
                    mo = "-01";
                    break;
                case 2:
                    mo = "-04";
                    break;
                case 3:
                    mo = "-07";
                    break;
                case 4:
                    mo = "-10";
                    break;
            }
            try {
                Date d = sdf.parse(year);
                year = sdf.format(d) + mo;
                year = year.replaceAll(" ", "");
                res = this.quarterInScopeFromNow(year, scope);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}

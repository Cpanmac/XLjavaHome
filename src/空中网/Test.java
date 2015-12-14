package ������;

/**
 * ��һ�⣺���еĳ������ģ�������16����־���󣬲�����Ҫ����16����ܴ�ӡ����Щ��־�����ڳ���������4���߳�ȥ����parseLog()��������ͷ��ӡ��16����־����
 * ����ֻ��Ҫ����4�뼴�ɴ�ӡ����Щ��־����ԭʼ�������£�
 * 
 * @Description
 * 
 * @author ����
 * 
 * @date 2015-3-18
 */
public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		/*
		 * ģ�⴦��16����־������Ĵ��������16����־���󣬵�ǰ������Ҫ����16����ܴ�ӡ����Щ��־��
		 * �޸ĳ�����룬���ĸ��߳�����16��������4���Ӵ��ꡣ
		 */
		for (int i = 0; i < 16; i++) { // ���д��벻�ܸĶ�
			final String log = "" + (i + 1);// ���д��벻�ܸĶ�
			{
				if(i%4==0){
					Thread.sleep(1000);
				}
				new Thread(new MyThread(log)).start();
				
//				 Test.parseLog(log);
			}
		}
	}
	
	// parseLog�����ڲ��Ĵ��벻�ܸĶ�
	public static void parseLog(String log) {
		System.out.println(log + ":" + (System.currentTimeMillis() / 1000));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread implements Runnable {
	private String log;
	
	public MyThread() {
	}
	
	public MyThread(String log) {
		this.log = log;
	}
	
	@Override
	public void run() {
		Test.parseLog(log);
	}
	
	public String getLog() {
		return log;
	}
	
	public void setLog(String log) {
		this.log = log;
	}
}

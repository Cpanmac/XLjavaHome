package com.xl.����;


class Worker {
}

class Student {
}

class Tool {
}

/*
 * ����ǰ���� class Tool { private Object obj; publlic void setWoker(Object obj) {
 * this.object=object; } public Object getObject() { return object; } }
 */
// ������
class Utils<QQ> // �ɶԷ�ָ������ʲô���͵Ķ���
{
	private QQ q;

	public void setObject(QQ q) {
		this.q = q;
	}

	public QQ getObject() {
		return q;
	}
}

class GenericDemo3 {
	public static void main(String[] args) {
		/*
		 * Tool t = new Tool(); t.setWorker(new Worker()); t.getWorker();
		 */
	}

	Utils<Worker> u = new Utils<Worker>();
	// u.setObject(new Worker());
	Worker w = u.getObject();

}
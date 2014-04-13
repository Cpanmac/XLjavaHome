package com.xl.泛型;


class Worker {
}

class Student {
}

class Tool {
}

/*
 * 泛型前做法 class Tool { private Object obj; publlic void setWoker(Object obj) {
 * this.object=object; } public Object getObject() { return object; } }
 */
// 泛型类
class Utils<QQ> // 由对方指定操作什么类型的对象
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
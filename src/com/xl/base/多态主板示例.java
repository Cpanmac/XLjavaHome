package com.xl.base;

/*
����
��������ʵ����
�������л������塣
*/

interface PCI
{
	public void open();
	public void close();
}

class MainBoard
{
	public void run()
	{
		System.out.println("mainboard run");
	}
	public void usePCI(PCI p)
	{
		if(p!=null)
		{
			p.open();
			p.close();
		}
	}

}

class NetCard
{
	public void open()
	{
		System.out.println("open");
	}
	public void close()
	{
		System.out.println("close");
	}
}

class DuoTaiDemo5 
{
	public static void main(String[] args)
	{
		MainBoard mb=new MainBoard();
		mb.run();
		mb.usePCI(null);
	}
}

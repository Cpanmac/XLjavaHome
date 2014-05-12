package com.xl.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.xl.util.FileTool;

/**
 * @Decription һ��ǰ��
 * 
 *             ��������ҵ����Ϣϵͳ�У�������һֱռ�Ƚ���Ҫ�����ã����Ľ�����һ������PDF�����Java���--iText��
 *             ͨ���ڷ�������ʹ��Jsp��JavaBean����PDF����
 *             ���ͻ��˲��ó���������ʾ�����صõ����ɵı��������ͺܺõĽ����B/Sϵͳ�ı��������⡣
 * 
 *             ��������iText���
 * 
 *             ����iText�������Ŀ���Դ���վ��sourceforgeһ����Ŀ������������PDF�ĵ���һ��java��⡣
 *             ͨ��iText������������PDF��rtf���ĵ������ҿ��Խ�XML��Html�ļ�ת��ΪPDF�ļ���
 * 
 *             ����iText�İ�װ�ǳ����㣬��http://www.lowagie.com/iText/download.html -
 *             download ��վ������iText.jar�ļ���ֻ��Ҫ��ϵͳ��CLASSPATH�м���iText.jar��·����
 *             �ڳ����оͿ���ʹ��iText����ˡ�
 * 
 * 
 * @date 2014��3��25��
 * 
 * @author ����
 * 
 */
public class PdfDemo {
	/** �ļ� */
	File file;

	@Before
	public void init() throws UnsupportedEncodingException {
		file = new File(FileTool.getCurrentPath(this), "pdf.pdf");
	}

	@Test
	public void write() throws FileNotFoundException, DocumentException {
		// �ٽ���com.lowagie.text.Document�����ʵ����
		Document document = new Document(PageSize.A4);
		// �ڽ���һ����д��(Writer)��document���������ͨ����д��(Writer)���Խ��ĵ�д�뵽�����С�
		PdfWriter.getInstance(document, new FileOutputStream(file));
		// �۴��ĵ���
		document.open();
		// �����ĵ���������ݡ�
		document.addTitle("���Ǳ���");
		document.add(new Paragraph("�ҵĵ�һ��Pdf", new Font()));
		// �ݹر��ĵ���
		document.close();
	}

	@Test
	public void ������() throws FileNotFoundException, DocumentException {
		Rectangle r = new Rectangle(144, 720); //����ָ������
		Document document = new Document(r);
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.addTitle("���Ǳ���");
		document.add(new Paragraph("�ҵĵ�һ��Pdf", new Font()));
		document.close();
	}
	

}

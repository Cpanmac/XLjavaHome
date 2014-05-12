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
 * @Decription 一、前言
 * 
 *             　　在企业的信息系统中，报表处理一直占比较重要的作用，本文将介绍一种生成PDF报表的Java组件--iText。
 *             通过在服务器端使用Jsp或JavaBean生成PDF报表
 *             ，客户端采用超级连接显示或下载得到生成的报表，这样就很好的解决了B/S系统的报表处理问题。
 * 
 *             　　二、iText简介
 * 
 *             　　iText是著名的开放源码的站点sourceforge一个项目，是用于生成PDF文档的一个java类库。
 *             通过iText不仅可以生成PDF或rtf的文档，而且可以将XML、Html文件转化为PDF文件。
 * 
 *             　　iText的安装非常方便，在http://www.lowagie.com/iText/download.html -
 *             download 网站上下载iText.jar文件后，只需要在系统的CLASSPATH中加入iText.jar的路径，
 *             在程序中就可以使用iText类库了。
 * 
 * 
 * @date 2014年3月25日
 * 
 * @author 徐立
 * 
 */
public class PdfDemo {
	/** 文件 */
	File file;

	@Before
	public void init() throws UnsupportedEncodingException {
		file = new File(FileTool.getCurrentPath(this), "pdf.pdf");
	}

	@Test
	public void write() throws FileNotFoundException, DocumentException {
		// ①建立com.lowagie.text.Document对象的实例。
		Document document = new Document(PageSize.A4);
		// ②建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		PdfWriter.getInstance(document, new FileOutputStream(file));
		// ③打开文档。
		document.open();
		// ④向文档中添加内容。
		document.addTitle("这是标题");
		document.add(new Paragraph("我的第一个Pdf", new Font()));
		// ⑤关闭文档。
		document.close();
	}

	@Test
	public void 构造器() throws FileNotFoundException, DocumentException {
		Rectangle r = new Rectangle(144, 720); //创建指定画布
		Document document = new Document(r);
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.addTitle("这是标题");
		document.add(new Paragraph("我的第一个Pdf", new Font()));
		document.close();
	}
	

}

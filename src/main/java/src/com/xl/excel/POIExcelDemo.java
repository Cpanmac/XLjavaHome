package com.xl.excel;

import com.xl.util.FileTool;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.poi工具类
 * User: 徐立
 * Date: 2017-10-20
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
public class POIExcelDemo {
    @Test
    public void excelTest() throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("第一个工作簿");
        HSSFRow row = sheet1.createRow((short) 0);
        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue(1);
        row.createCell((short) 1).setCellValue(1.2);
        row.createCell((short) 2).setCellValue("这是String");
        row.createCell((short) 3).setCellValue(true);
        row.createCell((short) 4).setCellValue(new Date());
        HSSFSheet sheet2 = wb.createSheet("第二个工作簿");
        File file = FileTool.createResourceFile("workbook.xls");
        FileOutputStream fileOut = new FileOutputStream(file);
        wb.write(fileOut);
        fileOut.close();
        FileTool.open(file);
    }
}

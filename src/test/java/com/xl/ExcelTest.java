package com.xl;

import com.github.sd4324530.fastexcel.FastExcel;
import com.xl.entity.MyTest;
import com.xl.util.FileTool;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 徐立
 * Date: 2017-10-17
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 */
public class ExcelTest {
    private static final Logger LOG = LoggerFactory.getLogger(ExcelTest.class);
    InputStream is = FileTool.getResourceInputStream("data.xlsx");

    @Test
    public void excelTest() throws IOException, InvalidFormatException {
        FastExcel fastExcel = new FastExcel(is);
        fastExcel.setSheetName("活动信息数据");
        List<MyTest> tests = fastExcel.parse(MyTest.class);
        if (null != tests && !tests.isEmpty()) {
            for (MyTest myTest : tests) {
                LOG.debug("记录:{}", myTest.toString());
            }
            FastExcel create = new FastExcel(FileTool.getResourceFile("excel.xls").getAbsolutePath());
            create.setSheetName("活动信息数据");
            boolean result = create.createExcel(tests);
            LOG.debug("结果:{}", result);
            create.close();
        } else {
            LOG.debug("没有结果");
        }
        fastExcel.close();
    }
}

package fastexcel;

import com.github.sd4324530.fastexcel.FastExcel;
import com.xl.util.FileTool;
import fastexcel.entity.MyTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ����
 * Date: 2017-10-17
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 */
public class ExcelTest {
    private static final Logger LOG = LoggerFactory.getLogger(ExcelTest.class);
    InputStream is = FileTool.getResourceInputStream("data.xlsx");

    @Test
    public void test() throws IOException, InvalidFormatException {
        FastExcel fastExcel = new FastExcel(is);
        fastExcel.setSheetName("���Ϣ����");
        List<MyTest> tests = fastExcel.parse(MyTest.class);
        if (null != tests && !tests.isEmpty()) {
            for (MyTest myTest : tests) {
                LOG.debug("��¼:{}", myTest.toString());
            }
            FastExcel create = new FastExcel(FileTool.getResourceFile("excel.xls").getAbsolutePath());
            create.setSheetName("���Ϣ����");
            boolean result = create.createExcel(tests);
            LOG.debug("���:{}", result);
            create.close();
        } else {
            LOG.debug("û�н��");
        }
        fastExcel.close();
    }
}

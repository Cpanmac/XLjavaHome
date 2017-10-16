package fastexcel;

import com.github.sd4324530.fastexcel.FastExcel;
import fastexcel.entity.MyTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author peiyu
 */
public class ExcelTest {
    private static final Logger LOG = LoggerFactory.getLogger(ExcelTest.class);

    @Test
    public void test() {
        try {
            createExcel();
        } catch (IOException e) {
            LOG.error("�쳣", e);
        } catch (InvalidFormatException e) {
            LOG.error("�쳣", e);
        }
    }

    private void createExcel() throws IOException, InvalidFormatException {
        FastExcel fastExcel = new FastExcel("E:/data.xlsx");
        fastExcel.setSheetName("���Ϣ����");
        List<MyTest> tests = fastExcel.parse(MyTest.class);
        if (null != tests && !tests.isEmpty()) {
            for (MyTest myTest : tests) {
                LOG.debug("��¼:{}", myTest.toString());
            }
            FastExcel create = new FastExcel("E:/data2.xlsx");
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

package fastexcel.entity;

import com.github.sd4324530.fastexcel.annotation.MapperCell;

/**
 * @author peiyu
 */
public class MyTest {
    @MapperCell(cellName = "����", order = 0)
    private String name;
    @MapperCell(cellName = "��ϵ�绰", order = 1)
    private String phone;
    @MapperCell(cellName = "��ַ", order = 2)
    private String address;
    @MapperCell(cellName = "һ������ID", order = 3)
    private int type;
    @MapperCell(cellName = "����", order = 4)
    private double lat;

    @Override
    public String toString() {
        return "MyTest{" + "name='" + name + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + ", type=" + type + ", lat=" + lat + '}';
    }
}

package com.xl.json;

import com.xl.entity.User;
import com.xl.util.FileTool;
import com.xl.util.Print;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 徐立
 * @Decription
 * @date 2014年4月13日
 */
public class JsonTest {
    @Test
    public void testnetSfJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", 1);
        jsonObject.put("a", 2);
        Print.info(jsonObject);
    }

    /**
     * 这个需要下列5个jar包才可以
     * commons-beanutils-1.8.3.jar
     * commons-collections.jar
     * commons-lang.jar
     * commons-logging.jar
     * ezmorph-1.0.6.jar
     * json-lib-2.3-jdk15.jar
     */
    @Test
    public void test1() {
        User user = new User();
        user.setName("phl");
        user.setAge(25);
        User user2 = new User();
        user2.setName("luckybird");
        user2.setAge(26);
        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user2);
        JSONObject json = JSONObject.fromObject(user);
        Print.info(json);
        Print.info(json.toString());
        JSON json2 = JSONSerializer.toJSON(list);
        Print.info(json2.toString());
        json2 = JSONSerializer.toJSON(new User());
        Print.info(json2.toString());
    }

    /**
     * @throws IOException
     */
    @Test
    public void jsonTest() throws IOException {
        File file = FileTool.getResourceFile("json/contact.json");
        InputStreamReader fr = new InputStreamReader(new FileInputStream(file), com.xl.encode.Encode.UTF);
        char[] ch = new char[1];
        StringBuffer sb = new StringBuffer();
        while ((fr.read(ch)) != -1) {
            sb.append(ch);
 }
     JSONObject json = JSONObject.fromObject(sb.toString());
        Print.print(sb);
        Print.info(json);
        // JSONObject response = dataJson.getJSONObject("response");
        // JSONArray data = response.getJSONArray("data");
        // JSONObject info = data.getJSONObject(0);
        // String province = info.getString("province");
        // String city = info.getString("city");
        // String district = info.getString("district");
        // String address = info.getString("address");
        // Print.print(province + city + district + address);
    }

    @Test
    public void nullTest() {
        //没有报错返回空
        Print.info(JSONObject.fromObject(null));
    }
}

package com.xl.json;

import com.xl.entity.User;
import com.xl.util.FileTool;
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
public class JsonDemo {
    @Test
    public void testnetSfJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", 1);
        jsonObject.put("a", 2);
        System.out.println(jsonObject);
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
        System.out.println(json);
        System.out.println(json.toString());
        // ********************************************************
        JSON json2 = JSONSerializer.toJSON(list);
        System.out.println(json2.toString());
        //
        json2 = JSONSerializer.toJSON(new User());
        System.out.println(json2.toString());
    }

    /**
     * FIXME 忘记在哪儿了
     * 只需要gjson.jar
     *
     * @throws IOException
     */
    @Test
    public void googleJson() throws IOException {
        // GJson g = new GJson();
        // String s = g.toString();
        // System.out.println(s);
        String path = FileTool.getCurrentPath(this);
        File file = new File(path + "/contact.json");
        System.out.println(file.exists());
        InputStreamReader fr = new InputStreamReader(new FileInputStream(file), "utf-8");
        char[] ch = new char[1];
        StringBuffer sb = new StringBuffer();
        while ((fr.read(ch)) != -1) {
            sb.append(ch);
        }
        System.out.println(sb);
        JSONObject json = JSONObject.fromObject(sb.toString());
        //		System.out.println(sb);
        System.out.println(json);
        // JSONObject response = dataJson.getJSONObject("response");
        // JSONArray data = response.getJSONArray("data");
        // JSONObject info = data.getJSONObject(0);
        // String province = info.getString("province");
        // String city = info.getString("city");
        // String district = info.getString("district");
        // String address = info.getString("address");
        // System.out.println(province + city + district + address);
    }
}

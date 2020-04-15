package com.canxue.day.file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Author Lishuntao
 * @Date 2019/10/24
 */
public class FileTest {


    @Test
    public void formatterTest() {
        // 使用 format进行格式化输出
        System.out.printf("this is a String: %s , this is a number: %.2f", "test", 4.56f);
        System.out.format("this is a String: %s , this is a number: %.2f", "test", 4.56f);

        // %[argument_index$][flags][width]conversion
        System.out.println();
        double d1 = 34.34;
        double d2 = 34.3445;
        System.out.printf("d1: %2$6.2f  , and d2 : %1$09.6f", d1, d2);  // 使用第一个参数总共9位,保留6位小数, 空余位使用0进行填充
    }

    public static final List<String> OutTaskTypes = new ArrayList<String>() {
        {
            add("wajTask");
            add("ismsTask");
            add("drmsTask");
        }
    };

    @Test
    public void messageFormatTest() {

        MessageFormat messageFormat = new MessageFormat("this is message: {0} , this is a number {1,number,##.##}");
        Object[] array = new Object[]{
                "测试", 425.67333
        };
        String format = messageFormat.format(array);
        MessageFormat.format("this is a number {0}", "test");
        System.out.println(format);
    }

    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);
        formatter.format("this is a String: %s , this is a number: %10.2f", "test", 4.56f);
    }

    Pattern pattern = Pattern.compile("\\w+");

    @Test
    public void patternTest() {

        String s = "{\n" +
                "\t\t\"domain\":\"cc10.com\",\n" +
                "\t\"domainType\":\"1\",\n" +
                "\t\"paraList\":[{\"ipv4List\":[\"1.1.1.1\"],\"areaId\":[\"0\"],\"ipv6List\":[\"::\"],\"orgId\":\"0\"}],\n" +
                "\t\t\"timeStamp\":\"2019-10-30T14:44:46Z\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        String domain = (String) jsonObject.get("domain");
        System.out.println(domain);
        JSONArray jsonArray = jsonObject.getJSONArray("paraList");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject next = (JSONObject) iterator.next();
            JSONArray ipv4List = next.getJSONArray("ipv4List");
            Iterator<Object> iterator1 = ipv4List.iterator();
            while (iterator1.hasNext()){
                String next1 = (String) iterator1.next();
                System.out.println(next);
            }
            System.out.println();

        }

        System.out.println(jsonArray);

    }


}

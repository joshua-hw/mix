package test.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * JAVA对象转JSON
 *
 * @see http://www.jianshu.com/p/b0f6d20ed804
 */
public class JacksonDemo {
    public static void main(String[] args) throws ParseException, IOException {
        User user = new User();
        user.setName("小民");
        user.setEmail("xiaomin@sina.com");
        user.setAge(20);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1996-10-01"));

        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();

        //User类转JSON
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        //Java集合转JSON
        List<User> users = new ArrayList<User>();
        users.add(user);
        String jsonlist = mapper.writeValueAsString(users);
        System.out.println(jsonlist);


        String jsonString = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";
        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        User objUser = mapper.readValue(jsonString, User.class);
        System.out.println(objUser.getName());
        System.out.println(objUser.getAge());
    }
}

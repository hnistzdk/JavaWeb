package JavaBean;

import java.sql.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zdk
 * @Date 2021/3/2 19:31
 */
public class Person {
    private String username;
    private String password;
    private String sex;
    private String question;
    private String answer;
    private String email;
    public static final int PAGE_SIZE=2;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public static Connection getConnection(){
        Connection con=null;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/servlettest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String user="root";
        String password="root";
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url, user, password);
            if(con!=null) {
                System.out.println("数据库连接成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public List<Person> find(int page){
        Connection con=getConnection();
        List<Person> list=new ArrayList<>();
        String sql="select * from servletuserregister order by username desc limit ?,?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, (page-1)*Person.PAGE_SIZE);
            ps.setInt(2, Person.PAGE_SIZE);
            ResultSet resultSet=ps.executeQuery();
            while(resultSet.next()){
                Person person=new Person();
                person.setUsername(resultSet.getString("username"));
                person.setPassword(resultSet.getString("password"));
                person.setSex(resultSet.getString("sex"));
                person.setQuestion(resultSet.getString("question"));
                person.setAnswer(resultSet.getString("answer"));
                person.setEmail(resultSet.getString("email"));
                list.add(person);
            }
            con.close();
            ps.close();
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public int findCount(){
        int count = 0;
        Connection con=getConnection();
        String sql="select count(*) from servletuserregister";
        try {
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                count=resultSet.getInt(1);
            }
            con.close();
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}

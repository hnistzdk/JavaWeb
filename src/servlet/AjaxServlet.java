package servlet;

import JavaBean.Hero;
import com.mysql.cj.xdevapi.JsonParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author zdk
 * @Date 2021/3/6 10:54
 */
@WebServlet(name = "AjaxServlet",urlPatterns = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hero> heros=new ArrayList<>();
        for(int i=0;i<10;i++){
            Hero hero=new Hero();
            hero.setName("name"+i);
            hero.setHp(i*10);
            hero.setMp(i);
            heros.add(hero);
        }
        String result=JSONSerializer.toJSON(heros).toString();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(result);
    }

    public static void main(String[] args) {
        List<Hero> heros=new ArrayList<>();
        for(int i=0;i<10;i++){
            Hero hero=new Hero();
            hero.setName("name"+i);
            hero.setHp(i*10);
            hero.setMp(i);
            heros.add(hero);
        }
        String result= JSONSerializer.toJSON(heros).toString();
        System.out.println(result);
    }
}

package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author zdk
 * @Date 2021/3/7 18:26
 */
@WebServlet(name = "ZoneServlet",urlPatterns = "/ZoneServlet")
public class ZoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        System.out.println(action);
        if("getProvince".equals(action)){
            this.getProvince(req, resp);
        }else if("getCity".equals(action)){
            this.getCity(req, resp);
        }
        PrintWriter writer=resp.getWriter();
        writer.println("hello servlet");
    }
    public void getProvince(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        response.setCharacterEncoding("GBK");
        String result="";
        Map<String,String[]> map=new HashMap<>();
        map.put("湖南省", new String[]{"长沙市", "岳阳市", "常德市"});
        map.put("湖北省", new String[]{"武汉市","仙桃市","宜昌市"});
        Set<String> set=map.keySet();
        Iterator it=set.iterator();
        while(it.hasNext()){
            result=result+it.next()+",";
        }
        result=result.substring(0,result.length()-1);
        System.out.println(result);
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    public void getCity(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        response.setCharacterEncoding("GBK");
        String result="";
        String selProvince=request.getParameter("parProvince");
        selProvince=new String(selProvince.getBytes("ISO-8859-1"),"GBK");
        Map<String,String[]> map=new HashMap<>();
        map.put("湖南省", new String[]{"长沙市", "岳阳市", "常德市"});
        map.put("湖北省", new String[]{"武汉市","仙桃市","宜昌市"});
        String[] arrCity=map.get(selProvince);
        for(int i=0;i<arrCity.length;i++){
            result=result+arrCity[i]+",";
        }
        result=result.substring(0,result.length()-1);
        System.out.println(result);
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}

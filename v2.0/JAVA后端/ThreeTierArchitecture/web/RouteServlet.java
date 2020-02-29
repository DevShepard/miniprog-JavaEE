package ThreeTierArchitecture.web;

import ThreeTierArchitecture.entity.Route;
import ThreeTierArchitecture.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "RouteServlet" ,urlPatterns = "/test2")
public class RouteServlet extends HttpServlet {
    private RouteService rs = new RouteService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        /*传入变量*/
        String test_text = request.getParameter("username");

        if(rs.findAllRoutes(test_text)==1){
            Writer out = response.getWriter();
            out.write("数据载入成功！");
            out.flush();
        }else {
            System.out.println("fail");
        }
        //System.out.println(list);

    }
}

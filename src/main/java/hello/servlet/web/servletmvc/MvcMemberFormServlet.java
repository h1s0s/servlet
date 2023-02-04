package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName  : hello.servlet.web.servletmvc
 * fileName     : MvcMemberFormServlet
 * author       : sshan
 * date         : 2023-02-04
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-02-04          sshan            최초생성
 */

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath="/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
        //다른 서블릿이나 jsp로 이동할 수 있는 메서드. 서버 내부에서 다시 호출이 발생함
        //리다이렉트 하는게 아니라 서버에서 호출이 일어남. 그래서 새로고침 현상이 나타나지 않음.
    }
}
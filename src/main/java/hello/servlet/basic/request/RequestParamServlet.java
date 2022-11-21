package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName  : hello.servlet.basic.request
 * fileName     : RequestParamServlet
 * author       : sshan
 * date         : 2022-11-21
 * description  : 파라미터 전송기능
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2022-11-21          sshan            최초생성
 */
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        System.out.println("[전체 파라미터 조회] - end");

        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();
        System.out.println("[단일 파라미터 조회] - end");

        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        String[] usernames = request.getParameterValues("username");//같은이름의 파라미터가 여러개일때
        for (String name : usernames) {
            System.out.println("username=" + name);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] - end");

        response.getWriter().write("ok");
    }
}

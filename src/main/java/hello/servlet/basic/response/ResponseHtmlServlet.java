package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * packageName  : hello.servlet.basic.response
 * fileName     : ResponseHtmlServlet
 * author       : sshan
 * date         : 2022-12-11
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2022-12-11          sshan            최초생성
 */
@WebServlet(name = "responseHtmlServlet", urlPatterns= "/response-html")
public class ResponseHtmlServlet extends HttpServlet {

    /*
     * HTTP요청을 HTML로 응답하기
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //컨텐츠 타입 : text/html; charset=utf-8
        //컨텐츠 타입 : text/html; charset=utf-8
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //body
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("    <body>");
        writer.println("        <div>안녕?</div>");
        writer.println("    </body>");
        writer.println("</html>");
    }
}

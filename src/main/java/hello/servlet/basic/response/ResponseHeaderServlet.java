package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * packageName  : hello.servlet.basic.response
 * fileName     : ResponseHeaderServlet
 * author       : sshan
 * date         : 2022-11-26
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2022-11-26          sshan            최초생성
 */
@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK); //HTTP 응답코드를 넣어줄 수 있음. 코드별로 상수가 있어 상수를 쓰는게 좋다.
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        //[response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//이 값이 헤더에 있으면 캐쉬를 무효화 함
        response.setHeader("Pragma", "no-cache");//이 값이 헤더에 있으면 캐쉬를 무효화 함
        response.setHeader("my-header", "hello");//헤더에 임의의 값을 넣을 수 있음
        //이렇게 값을 넣어주지 않았는데 기본적으로 Header에 박혀있는 데이터들은, 톰캣이 알아서 넣어줬기 때문임

        //[Header 편의 메서드]
        //        content(response);
        //cookie(response);
        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.println("안녕하세요.");
    }

    /*
     * 응답 - 컨텐츠 메서드
     */
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");//setHeader("키","값") 말고 set키("값")의 형식으로도 넣을 수 있음
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성) - 바디 글자 길이값
    }

    /*
     * 응답 - 쿠키 메서드
     */
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    /*
     * 응답 - 리다이렉트 메서드
     */
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");

        response.sendRedirect("/basic/hello-form.html");
    }
}

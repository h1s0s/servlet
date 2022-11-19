package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName  : hello.servlet.basic
 * fileName     : HelloServlet
 * author       : sshan
 * date         : 2022-11-19
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2022-11-19          sshan            최초생성
 */

@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    //인텔리제이 - 컨트롤+O : 부모 메서드 첨부 가능
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // url을 친다 -> 웹브라우저가 http 요청을 만든다 -> 서버에 던진다
        // 서버에 요청이 오면 WAS가 리퀘스트,리스폰스 객체를 만들어 브라우저에 응답한다.
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //HttpServletRequest 는 안에 보면 인터페이스로 되잇음
        //톰캣이나 언더토등등 여러가지 WAS 서버가 많은데 인터페이스로 표준스펙을 정의해놓고 쓰는거임

        //요청다루기
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //응답다루기
        //리스폰스헤더
        response.setContentType("text/plain");//단순문자형식
        response.setCharacterEncoding("utf-8");//인코딩형식

        //리스폰스바디
        response.getWriter().write("hello " + username); //getWriter은 리스폰스 바디에 쓰는거임
        //리퀘스트헤더는 웹브라우저가 보내는 정보임
        //사용자가 지정하지 않은 것중 header에 콘텐츠렝쓰, 데이트, 킵얼라이브같은 정보는 톰캣이 자동으로 붙여서 보내는 것

        //서블릿이란 웹브라우저프로그래밍 기술로
        //요청응답 흐름을 메소드 호출만으로 체계적으로 다루게 해주는 기술

        //서블릿컨테이너는 @WebServlet 애노테이션 밑에 service메소드를 자동으로 실행함.
    }
}

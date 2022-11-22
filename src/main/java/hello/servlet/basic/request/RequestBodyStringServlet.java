package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * packageName  : hello.servlet.basic.request
 * fileName     : RequestBodyStringServlet
 * author       : sshan
 * date         : 2022-11-22
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2022-11-22          sshan            최초생성
 */

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HTTP 요청 데이터 - API 메세지 바디 - 단순 텍스트
        ServletInputStream inputStream = request.getInputStream(); //컨트롤 + 알트 + V => 변수 자동생성
        //getInputStream()은 메세지 바디의 내용을 byte 코드로 얻을수 있음
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//변환해주는 UTIL

        System.out.println("messageBody = " + messageBody);
        //바디의 내용이 그냥 text로 찍힘

        response.getWriter().write("ok");
    }
}

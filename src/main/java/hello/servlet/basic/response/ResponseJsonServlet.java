package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName  : hello.servlet.basic.response
 * fileName     : ResponseJsonServlet
 * author       : sshan
 * date         : 2022-12-11
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2022-12-11          sshan            최초생성
 */
@WebServlet(name = "responseJsonServlet", urlPatterns= "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    /*
     * HTTP 요청을 JSON으로 응답하기
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type : application/json
        response.setContentType("application/json"); //json은 encoding이 자동으로 utf-8로 적용됨
//        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        //{"username":"kim", "age":20}
//        String result = objectMapper.writerValueAsString(helloData);
//        return helloData;

    }
}

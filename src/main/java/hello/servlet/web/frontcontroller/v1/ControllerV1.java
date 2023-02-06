package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    //인터페이스로 정의하고 이 인터페이스를 구현한 컨트롤러를 여러개 만들어도, 호환 문제가 없어 유리함.
}

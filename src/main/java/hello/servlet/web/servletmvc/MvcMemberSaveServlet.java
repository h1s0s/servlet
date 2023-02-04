package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName  : hello.servlet.web.servletmvc
 * fileName     : MvcMemberSaveServlet
 * author       : sshan
 * date         : 2023-02-04
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-02-04          sshan            최초생성
 */
@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        System.out.println("member = " + member);
        memberRepository.save(member);

        //Model에 데이터를 보관한다.
        request.setAttribute("member", member);

        //JSP 포워드
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);


        /* MVC 컨트롤러 단점
        * 1. 포워드 중복
        * 2. 뷰패스 중복 prefix, suffix
        * 3. HttpServletRequest, Response를 사용하지 않을때도 있음
        * 4. 공통처리가 어렵다
        * 정리하자면 공통처리가 어렵다 -> 이 문제를 해결하려면 컨트롤러 호출 전에 공통 기능을 처리해야 함.
        * 프론트 컨트롤러 패턴을 도입하면 이 문제를 깔끔하게 해결할 수 있다(입구를 하나로)
        * 스프링 MVC 핵심도 이 프론트 컨트롤러에 있다.*/
    }
}

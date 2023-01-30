package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * packageName  : hello.servlet.web.servlet
 * fileName     : MemberListServlet
 * author       : sshan
 * date         : 2023-01-30
 * description  :
 * ========================================================
 * DATE            AUTHOR              NOTE
 * --------------------------------------------------------
 * 2023-01-30          sshan            최초생성
 */
@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        /* 회원정보 전체를 List로 꺼내옴 */
        List<Member> members = memberRepository.findAll();

        PrintWriter w = response.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write(" <meta charset=\"UTF-8\">");
        w.write(" <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write(" <thead>");
        w.write(" <th>id</th>");
        w.write(" <th>username</th>");
        w.write(" <th>age</th>");
        w.write(" </thead>");
        w.write(" <tbody>");
        /*
         w.write(" <tr>");
         w.write(" <td>1</td>");
         w.write(" <td>userA</td>");
         w.write(" <td>10</td>");
         w.write(" </tr>");
        */
        for (Member member : members) {
            w.write(" <tr>");
            w.write(" <td>" + member.getId() + "</td>");
            w.write(" <td>" + member.getUsername() + "</td>");
            w.write(" <td>" + member.getAge() + "</td>");
            w.write(" </tr>");
        }
        w.write(" </tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");
    }
    /*
        동적인 페이지를 만들기 위해선 HTML에 JAVA를 사용해야 하는데,
        현재 강의에서는 자바 코드에 HTML 코드를 넣어, 회원정보 저장, 조회 페이지를 구현했는데 많이 복잡한 걸 알 수 있음.
        이 배경때문에 템플릿엔진(html 코드에 중간중간 java코드를 넣는 방식. 대표적인 템플릿 엔진으로는 jsp, 타임리프)을 사용하게 되었다.
        JSP는 성능과 기능면에서 다른 템플릿 엔진과의 경쟁에서 밀리며, 점점 사장되어가는 추세이다.
        타임리프가 스프링과 잘 통합됨.
    */
}
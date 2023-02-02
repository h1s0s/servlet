<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // request, response 사용 가능, JSP에서 자바코드를 사용할려면 이 태그를 쓰면 됨.
  MemberRepository memberRepository = MemberRepository.getInstance();
  System.out.println("save.jsp");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));
  Member member = new Member(username, age);
  System.out.println("member = " + member);
  memberRepository.save(member);
%>
<%--
  JSP는 아래 HTML 태그를 writer 클래스를 이용해서 찍는 거임.
  JSP는 서버 내부에서 서블릿으로 변환됨.
  JSP는 자바 코드를 그대로 다 사용할 수 있음.
  하지만 JSP와 자바 코드를 한 파일안에서 사용하는 방식은 문제점이 많다.
  그래서 등장한 방식이 MVC 패턴이다.
--%>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
성공
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>구구단 보기</title>
	<style>
		a { text-decoration: none;  }
	</style>
</head>
<body>
	<h3>구구단 보기</h3>
	${gugu }
	<%-- <%
		int dan = 2;
		for(int i=1; i<=9; i++) {
			  out.print(String.format("%d * %d = %d<br>",dan,i,dan*i));  
			 /* out.print(dan + " * " + i + " = " + dan*i+"<br>");  */
		}
	%> --%>
	<p>
<a href="gugu/2">2</a>
<a href="/3">3</a>
<a href="/4">4</a>
<a href="/5">5</a>
<a href="/6">6</a>
<a href="/7">7</a>
<a href="/8">8</a>
<a href="/9">9</a>
</body>
</html>
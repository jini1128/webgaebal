<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>
${param.no}<--요렇게 그냥 받아올수있음 jstl사용 없이
<form action="delboard">
<table border="1">
<tr>
<input type="hidden" name="no" value="${param.no}">
<td>비번</td><td><input type="text" name="pw"></td>
<td colspan="2"><input type="submit" value="삭제완료"></td>
</tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>
${param.no}<--�䷸�� �׳� �޾ƿü����� jstl��� ����
<form action="delboard">
<table border="1">
<tr>
<input type="hidden" name="no" value="${param.no}">
<td>���</td><td><input type="text" name="pw"></td>
<td colspan="2"><input type="submit" value="�����Ϸ�"></td>
</tr>
</table>
</form>
</body>
</html>
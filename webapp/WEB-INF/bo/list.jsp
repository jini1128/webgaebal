<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="addboard" method="post">
<table border="1">
<tr>
<td>�̸�</td><td><input type="text" name="name"></td>
<td>���</td><td><input type="text" name="pw"></td>
<td>����</td><td><textarea name="content" rows="10" cols="100"></textarea></td>
<td colspan="2"><input type="submit" value="����"></td>
</tr>
</table>
</form>
<img src="/assets/images/sign.png" style="width: 120px;height: 120px">
<c:set var="count" value="${fn:length(list)}" />
<c:forEach items="${list }" var="vo" varStatus="status" >
   <table  border="1">
          <tr>
             <td>[${count - status.index}]</td>
             <td>${vo.name }</td>
             <td>${vo.date }</td>
             <td><a href="delboardpg?no=${vo.no}">����</a></td><!-- ������������ �̵��Ҷ� �� ���� ��ȣ�� ���� �Ѱ��� -->
          </tr>
    </table>
</c:forEach>

</body>
</html>
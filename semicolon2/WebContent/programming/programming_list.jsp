<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개발</title>
<link rel="stylesheet" href="css/sub.css">
</head>
<body>
	<jsp:include page="../include/top.jsp" />
	<div align="center">
		<table id="list">
		<tr>
			<th>회사명</th>
			<th>지역</th>
			<th>연봉(만)</th>
			<th>사원수</th>
			<th>혜택</th>
			<th>고용형태</th>
			<th>근무시간</th>
			<th>상세보기</th>
		</tr>

		<c:set var="list" value="${List }" />
		<c:if test="${!empty list }">
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.getName() }</td>
					<td>${dto.getNa() }</td>
					<td>${dto.getMoney() }</td>
					<td>${dto.getPeople() }명</td>
					<td>${dto.getBenefits() }</td>
					<td>${dto.getType() }</td>
					<td>${dto.getTime() }</td>
					<td>
						<input class="btn" type="button" value="상세보기" onclick="location.href='programming_content.do?no=${dto.getNo() }'">
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<br>
		<%-- 검색 관련 요청 태그 --%>
		<form method="post" action="<%=request.getContextPath() %>/search_p.do">
			<input id="sspace" type="text" name="find_name">
			<input id="sbtn" type="submit" value="검색">
		</form>
	</div>
</body>
</html>
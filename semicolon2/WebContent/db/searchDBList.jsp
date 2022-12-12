<%@page import="com.model.DBDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<DBDTO> search = (List<DBDTO>)request.getAttribute("searchList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB</title>
<link rel="stylesheet" href="css/sub.css">
</head>
<body>
	<jsp:include page="../include/top.jsp" />
	<div align="center">
		<table id="list">
			<tr>
				<th>회사명</th>
				<th>지역</th>
				<th>연봉</th>
				<th>사원수</th>
				<th>혜택</th>
				<th>고용형태</th>
				<th>근무시간</th>
			</tr>
			<%
				if(search.size() != 0){
					for(int i=0; i<search.size(); i++){
					DBDTO dto = search.get(i);
			%>
					<tr>
						<td><%=dto.getName() %></td>
						<td><%=dto.getNa() %></td>
						<td><%=dto.getMoney() %></td>
						<td><%=dto.getPeople() %>명</td>
						<td><%=dto.getBenefits() %></td>
						<td><%=dto.getType() %></td>
						<td><%=dto.getTime() %></td>
					</tr>			
				<%	}
				} else { %>
					<tr>
						<td colspan="10" align="center">
							<h3>검색된 게시물이 없습니다</h3>
						</td>
					</tr>
			<% 	} %>
			<tr>
				<td colspan="10" align="center">
					<input id="allbtn" type="button" value="전체 게시물" onclick="location.href='db_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
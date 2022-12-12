<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB</title>
<link rel="stylesheet" href="css/detail.css">
</head>
<body>
	<jsp:include page="../include/top.jsp" />
	<c:set var="dto" value="${Cont }"/>
	<div id="main">
		<div id="sub_div_area1">
			<div class="sub_div">
				<span class="title">회사명</span> <input style="margin-left: 21.2%"
					class="input_box" value="${dto.getName() }" readonly>
			</div>
		</div>
		<div id="sub_div_area1">
			<div class="sub_div">
				<span class="title">지역</span> <input style="margin-left: 22.6%"
					class="input_box" value="${dto.getNa() }" readonly>
			</div>
		</div>
		<div id="sub_div_area1">
			<div class="sub_div">
				<span class="title">연봉</span> <input style="margin-left: 22.6%"
					class="input_box" value="${dto.getMoney() }" readonly>
			</div>
		</div>
		<div id="sub_div_area1">
			<div class="sub_div">
				<span class="title">사원수</span> <input style="margin-left: 21.1%"
					class="input_box" value="${dto.getPeople() }명" readonly>
			</div>
		</div>
		<div id="sub_div_area1">
			<div class="sub_div">
				<span class="title">혜택</span> <input style="margin-left: 22.6%"
					class="input_box" value="${dto.getBenefits() }" readonly>
			</div>
		</div>
		<div id="sub_div_area1">
			<div class="sub_div">
				<span class="title">고용형태</span> <input style="margin-left: 19.6%"
					class="input_box" value="${dto.getType() }" readonly>
			</div>
		</div>
		<div id="sub_div_area1">
			<div class="sub_div">
				<span class="title">근무시간</span> <input style="margin-left: 19.6%"
					class="input_box" value="${dto.getTime() }" readonly>
			</div>
		</div>
		
		<div id="sub_div_area1">
			<div class="sub_div">
				<span class="title">지도</span>
			</div>
		</div>
		<div id ="map" style="width:500px;height:400px;margin-left: 26%"></div>
            <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3c606cd5ddc4cf8ca544b6cc2bd762c2"></script>
			   <script>
			      var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			          mapOption = {
			              center: new kakao.maps.LatLng(${dto.getLatitude() }, ${dto.getLongitude() }), // 지도의 중심좌표
			              level: 3, // 지도의 확대 레벨
			              mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
			          }; 
			
			      // 지도를 생성한다 
			      var map = new kakao.maps.Map(mapContainer, mapOption); 
			
			      // 지도 타입 변경 컨트롤을 생성한다
			      var mapTypeControl = new kakao.maps.MapTypeControl();
			
			      // 지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
			      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);   
			
			      // 지도에 확대 축소 컨트롤을 생성한다
			      var zoomControl = new kakao.maps.ZoomControl();
			
			      // 지도의 우측에 확대 축소 컨트롤을 추가한다
			      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
			
			      // 지도에 마커를 생성하고 표시한다
			      var marker = new kakao.maps.Marker({
			          position: new kakao.maps.LatLng(${dto.getLatitude() }, ${dto.getLongitude() }), // 마커의 좌표
			          map: map // 마커를 표시할 지도 객체
			      });
			
			      // 마커 위에 표시할 인포윈도우를 생성한다
			      var infowindow = new kakao.maps.InfoWindow({
			          content : '<div style="padding:5px;">${dto.getName() }</div>' // 인포윈도우에 표시할 내용
			      });
			
			      // 인포윈도우를 지도에 표시한다
			      infowindow.open(map, marker);
			
			   </script>
		

		<div id="sub_div_area7">
			<div class="sub_div_btn">
				<input type="button" id="btn" value="목록으로"
					onclick="location.href='db_list.do'">
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="include/top.jsp" />
<div align="center" style="margin-top: 1%">
	<h1>게시판</h1>
<div align="left" class="accordion accordion-flush" id="accordionFlushExample" style="width: 80%; margin-top: 2%;">
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingOne">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
        남서울대학교 드론공간정보공학과 자율동아리 세미콜론입니다!
      </button>
    </h2>
    <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">
        안녕하세요 저희는 남서울대학교 드론공간정보공학과 자율동아리 세미콜론<br>
      	19102237 이수연<br>
		18102128 김경령<br>
		18102208 주지호<br>
		18102209 진현규<br>
		20102174 박준수<br>
		21102128 안정현입니다
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingTwo">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
        [공지]공간정보융합산업기사 신설 2023년 하반기 시행
      </button>
    </h2>
    <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
      <div class="accordion-body">
      	<strong>제4회</strong><br>
      	<필기시험><br>
      	원서접수(휴일제외) : 8.7 ~ 8.10<br>
      	시험 시행 : 9.2 ~ 9.17<br>
      	합격(예정)자 발표 : 9.22<br>
     	응시자격 서류제출(필기 합격자 결정) : 9.4 ~ 10.6<br><br>
     	<실기시험><br>
      	원서접수(휴일제외) : 10.10 ~ 10.13<br>
      	시험 시행 : 11.4 ~11.17<br>
      	합격자 발표 : 1차 : 11.29 / 2차 : 12.13<br>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="flush-headingThree">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
        [공지]2023년 공간정보 국제표준 총회, 전주서 열린다
      </button>
    </h2>
    <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
    	<div class="accordion-body">
      		공간정보 분야 국제표준화기구(ISO/TC 211)의 내년 총회가 전주에서 열린다.<br>
			국토교통부는 지난 5일부터 9일까지 스웨덴 스톡홀롬에서 열린 제55차 공간정보 분야 국제표준 총회에서 대한민국 전주시가 제56차 총회 개최지로 결정됐다고 11일 밝혔다.<br>
			공간정보 국제표준 총회는 지구상의 사물이나 현상을 공간정보로 수집·처리·분석하는 방법 및 서비스 등에 대한 기술을 공유하고, 이런 기술의 국제표준을 제·개정하는 기구다.<br>
			내년에 열릴 총회에는 70개 회원국 공간정보 분야 전문가와 학술인 등이 참여하는 공간정보 표준화 회의, 표준화 사예 발표 세미나, 표준 전략 자문 및 의장단 회의 등이 열릴 예정이다.
     	</div>  
	</div>
  </div>
</div>
</div>
</body>
</html>
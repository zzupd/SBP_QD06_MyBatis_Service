<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap" class="listWrap">
		<header id="header" class="dFlex">
			<h1>지원 정보 리스트</h1>
			<div id="headerBtnArea">
				<button type="button" id="insFormBtn">입력</button>
			</div>
		</header>
		
		<main id="main">
			<div id="headerRow" class="listCol dFlex">
				<span>번호</span>
				<span>이름</span>
				<span>연락처</span>
				<span>분야</span>
				<span>지원동기</span>
				<span>등록일</span>
			</div>
			
			<c:forEach var="list" items="${mtdList}">
			<div class="dataRow listCol dFlex">
				<span>${list.num }</span>
				<span>${list.userName }</span>
				<span>${list.userPhone }</span>
				<span>${list.applyPart }</span>
				<span class="wordWrap">${list.applyMotive }</span>
				<span>
				<fmt:formatDate value="${list.applyTM }" type="date" />
				</span>
			</div>
			</c:forEach>
			
		</main>
		
	</div>
	<!-- div#wrap -->
	<script src="/script/jquery-3.7.1.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    








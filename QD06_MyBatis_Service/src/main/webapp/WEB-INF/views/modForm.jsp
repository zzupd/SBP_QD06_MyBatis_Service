<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap" class="applyWrap">
		<h1>개발자 지원서 수정(SVC)</h1>
		<hr>
		
		<form action="/modProc" id="applyForm">
			<fieldset>
				<legend>개인정보</legend>
				<label>
					<span>이름</span>
					${applyDto.userName }
				</label>
				<label>
					<span>연락처</span>
					<input type="text" name="userPhone" 
					value="${applyDto.userPhone }" required>
				</label>
			</fieldset>		
						
			<fieldset id="applyFieldset">
				<legend>지원 분야</legend>
				<label>
					<input type="radio" name="applyPart" 
					value="Java" <c:if test="${applyDto.applyPart=='Java'}">checked</c:if>>
					<span>Java</span>
				</label>
				<label>
					<input type="radio" name="applyPart" 
					value="Android" <c:if test="${applyDto.applyPart=='Android'}">checked</c:if>>
					<span>Android</span>
				</label>
				<label>
					<input type="radio" name="applyPart"
					value="React" <c:if test="${applyDto.applyPart=='React'}">checked</c:if>>
					<span>React</span>
				</label>
			</fieldset>	
			
			<fieldset id="motiveFieldset">
				<legend>지원 동기</legend>
				<textarea name="applyMotive" placeholder="지원 동기 기재란">${applyDto.applyMotive}</textarea>
			</fieldset>	
			<div id="btnArea">
				<input type="hidden" name="numParam" value="${applyDto.num }">
				<button>수정하기</button>
				<button type="reset">다시 쓰기</button>
				<button type="button" id="goListBtn">리스트</button>
			</div>
		</form>
		
	</div>
	<!-- div#wrap -->
	<script src="/script/jquery-3.7.1.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    








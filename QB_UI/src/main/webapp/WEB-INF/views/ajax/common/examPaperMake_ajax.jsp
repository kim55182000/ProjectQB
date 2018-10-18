<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
</head>
<body>
	<c:forEach items="${question }" var="question">
		<div class="questions">
			<div
				class="questionDiv col-lg-11 questionDiv_${question.question_num }">
				<div class="col-lg-1 qnumdiv">
					<input type="checkbox" value="${question.question_num }"
						name="checkbox[]" />
					<!-- value에 문제고유번호 들어간다 -->
				</div>
				<div class="col-lg-3">
					${question.md_category_name}<br> ${question.sm_category_name }<br>
					난이도: ${question.level_name}<br> 정답:
					${question.question_answer }<br>
					정답률:${question.question_correct_ratio}%<br> 출제자:
					${question.member_id }<br>
				</div>
				<div class="col-lg-8">
					<b>${question.question_name }</b><br> <br>
					<div class="questionImgDiv">
						<c:if test="${question.question_img  ne null }">
							<img
								src="${pageContext.request.contextPath}/img/${question.question_img }"
								alt="questionImg" class="questionImg" />
							<!-- 문제에 이미지가 있다면 questionImgDiv 밑에 추가 -->
						</c:if>
					</div>
					<br>
					<div>
						<c:forEach items="${question_choice}" var="question_choice">
							<c:if
								test="${question_choice.question_num eq question.question_num}">
								<p>${question_choice.question_choice_num}.${question_choice.question_choice_content}</p>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-12">
			<hr>
		</div>
	</c:forEach>
</body>
</html>
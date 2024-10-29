<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board list</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center mb-4">${board.title}</h2>

		<!-- board 정보를 한 줄로 정렬 -->
		<div class="d-flex justify-content-between mb-4 border-bottom pb-3">
			<span><strong>식당:</strong> ${board.restaurant}</span> <span><strong>작성자:</strong>
				${board.writer}</span> <span><strong>작성일:</strong> ${board.regDate}</span>
			<span><strong>조회수:</strong> ${board.viewCnt}</span>
		</div>
		        <!-- 리뷰 카드들 -->
        <div class="reviews-section">
            <c:forEach items="${reviews}" var="review">
                <div class="card mb-3" style="width: 100%;"> <!-- 한 줄 길이로 설정 -->
                   <div class="card-body d-flex align-items-center">
                        <h6 class="card-title mb-0 me-3">${review.foodName}</h6>
                        <h6 class="card-subtitle text-muted flex-grow-1">${review.foodComent}</h6>
                        
                        <span class="card-text ms-3"><strong>Rating:</strong> ${review.foodRating}</span>
                        <div class="ms-3">
                            <a href="/review/update/${review.reviewId}" class="btn btn-primary me-2">수정</a> 
                            <a href="/review/delete/${review.reviewId}" class="btn btn-danger">삭제</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
	    <!-- 게시글 수정 및 삭제 버튼 -->
		<div class="text-center mt-4">
            <a href="/update/${board.boardId}" class="btn btn-secondary me-2">게시글 수정</a> 
            <a href="/delete/${board.boardId}" class="btn btn-danger">게시글 삭제</a>
        </div>
	</div>
</body>
</html>
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
	<h2>리뷰 목록</h2>
<div class="container mt-5">
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <c:forEach items="${boards}" var="board">
            <div class="col">
                  <!-- 카드 전체를 링크로 감싸기 -->
                <a href="/detail/${board.boardId}" class="text-decoration-none text-dark">
                <div class="card h-100"> <!-- h-100으로 카드 높이 균일하게 유지 -->
                    <div class="card-body">
                        <!-- 제목과 조회수 배지 -->
                        <div class="d-flex justify-content-between align-items-center mb-2">
                            <h5 class="card-title mb-0">${board.title}</h5>
                            <span class="badge bg-primary">${board.viewCnt} 조회</span>
                        </div>
                        
                        <h6 class="card-subtitle mb-2 text-muted">${board.restaurant}</h6>
                        <p class="card-text">${board.coment}</p>

                        <!-- 별점과 작성일을 덜 눈에 띄게 표시 -->
                        <div class="d-flex justify-content-between align-items-center">
                            <span class="text-secondary small flex-grow-0">⭐ ${board.reviewRating}</span>
                            <span class="text-muted small flex-grow-0">${board.regDate}</span>
                       		<!-- 버튼들 -->
							<%-- <a href="/detail/${board.boardId}" class="btn btn-primary mt-3">자세히 보기</a> --%>                        
							<form action="/search" method="post" class="flex-grow-0">
					    		<button class="btn btn-secondary btn-sm" type="submit" name="wrieter">${board.writer}</button>
							</form>
                        </div>
                    </div>
                </div>
                    </a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
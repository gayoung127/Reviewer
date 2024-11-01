<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Board</title>
</head>
<body>
    <%@ include file="/WEB-INF/views/includes/header.jsp"%>
    <h2>게시글 수정</h2>
    <form action="/update" method="post">
        <!-- 수정할 게시글의 ID -->
        <input type="hidden" name="boardId" value="${board.boardId}">
        
        <label for="title">제목</label>
        <input type="text" name="title" id="title" value="${board.title}" max="40" required>
        
        <label for="writer">작성자</label>
        <input type="text" name="writer" id="writer" value="${board.writer}" readonly>
        
        <label for="restaurant">식당</label>
        <input type="text" name="restaurant" id="restaurant" value="${board.restaurant}" max="45" required>
        
        <label for="coment">한줄평</label>
        <textarea name="coment" id="coment" minlength="10" maxlength="255" required>${board.coment}</textarea>
        
        <!-- 리뷰 목록 -->
        <div id="reviewContainer">
            <c:forEach var="review" items="${reviews}" varStatus="status">
                <div class="review-form-group">
                    <label>Menu ${status.index + 1}</label>
                    <input type="text" name="reviews[${status.index}].foodName"
                        value="${review.foodName}" placeholder="음식 이름" maxlength="25" required>
                    <input type="text" name="reviews[${status.index}].foodComent"
                        value="${review.foodComent}" placeholder="음식은 어땠나요?" maxlength="40" required>
                    <input type="range" name="reviews[${status.index}].foodRating"
                        value="${review.foodRating}" min="0" max="5" required>
                    <button type="button" onclick="removeReview(this)">삭제</button>
                </div>
            </c:forEach>
        </div>

        <!-- 리뷰 추가 버튼 -->
        <button type="button" onclick="addReview()">리뷰 추가</button>
        <button type="submit">수정</button>
    </form>

    <script>
        let reviewIndex = document.querySelectorAll('#reviewContainer .review-form-group').length; // 초기 인덱스 설정

        function addReview() {
            const reviewContainer = document.getElementById("reviewContainer");
            console.log(`Current reviewIndex: ${reviewIndex}`);

            // 새로운 리뷰 입력 필드 생성
            const newReview = document.createElement("div");
            newReview.classList.add("review-form-group", "mt-3");
            newReview.innerHTML = 
                '<label>Menu ' + (reviewIndex + 1) + '</label>' +
                '<input type="text" name="reviews[' + reviewIndex + '].foodName" placeholder="음식 이름" maxlength="25" required>' +
                '<input type="text" name="reviews[' + reviewIndex + '].foodComent" placeholder="음식은 어땠나요?" maxlength="40" required>' +
                '<input type="range" name="reviews[' + reviewIndex + '].foodRating" min="0" max="5" required>' +
                '<button type="button" onclick="removeReview(this)">삭제</button>';

            reviewContainer.appendChild(newReview); // 새로운 리뷰 추가
            reviewIndex++; // 인덱스 증가
        }

        function removeReview(button) {
            const reviewContainer = document.getElementById("reviewContainer");
            reviewContainer.removeChild(button.parentNode); // 리뷰 항목 삭제
            updateMenuNumbers(); // 삭제 후 메뉴 번호 재계산
        }

        function updateMenuNumbers() {
            const reviews = document.querySelectorAll('#reviewContainer .review-form-group');
            reviews.forEach(function(review, index) {
                review.querySelector('label').innerText = 'Menu ' + (index + 1);
                review.querySelector('input[name$="foodName"]').name = 'reviews[' + index + '].foodName';
                review.querySelector('input[name$="foodComent"]').name = 'reviews[' + index + '].foodComent';
                review.querySelector('input[type="range"]').name = 'reviews[' + index + '].foodRating';
            });

            reviewIndex = reviews.length; // 인덱스 갱신
        }
    </script>
</body>
</html>

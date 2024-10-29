<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regist Form</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	<h2>등록</h2>
	<form action="regist" method="post">
		<input type="text" name="title" max="40" required>
		<input type="text" name="writer" value="${sessionScope.loginUserName}" readonly>
		<input type="text" name="restaurant" max="45" required>
		<textarea name="coment" minlength="10" maxlength="255" placeholder="한줄평을 남겨주세요." required></textarea>
		  <!-- 리뷰 입력 필드들 -->
        <div id="reviewContainer">
            <div class="review-form-group">
                <label>Menu 1</label>
                <input type="text" name="reviews[0].foodName" placeholder="음식 이름" maxlength="25" required>
                <input type="text" name="reviews[0].foodComent" placeholder="음식은 어땠나요?" maxlength="40" required>
                <input type="range" name="reviews[0].foodRating" min="0" max="5" required>
                <button type="button" onclick="removeReview(this)">삭제</button>
            </div>
        </div>

        <!-- 리뷰 추가 버튼 -->
        <button type="button" onclick="addReview()">리뷰 추가</button>
        <button type="submit">등록</button>
    </form>

    <script>
        let reviewIndex = 1;

        function addReview() {
            const reviewContainer = document.getElementById("reviewContainer");

            // 새로운 리뷰 입력 필드 생성
            const newReview = document.createElement("div");
            newReview.classList.add("review-form-group", "mt-3");
            newReview.innerHTML = `
                <label>Menu ${reviewIndex + 1}</label>
                <input type="text" name="reviews[${reviewIndex}].foodName" placeholder="음식 이름" maxlength="25" required>
                <input type="text" name="reviews[${reviewIndex}].foodComent" placeholder="음식은 어땠나요?" maxlength="40" required>
                <input type="range" name="reviews[${reviewIndex}].foodRating" min="0" max="5" required>
                <button type="button" onclick="removeReview(this)">삭제</button>
            `;

            reviewContainer.appendChild(newReview); // 새로운 리뷰 추가
            reviewIndex++; // 인덱스 증가
            updateMenuNumbers(); // 메뉴 번호 업데이트
        }

        function removeReview(button) {
            const reviewContainer = document.getElementById("reviewContainer");
            reviewContainer.removeChild(button.parentNode); // 리뷰 항목 삭제
            updateMenuNumbers(); // 삭제 후 메뉴 번호 재계산
        }

        function updateMenuNumbers() {
            const reviews = document.querySelectorAll('#reviewContainer .review-form-group');
            reviews.forEach((review, index) => {
                review.querySelector('label').innerText = `Menu ${index + 1}`;
                review.querySelector('input[name$="foodName"]').name = `reviews[${index}].foodName`;
                review.querySelector('input[name$="foodComent"]').name = `reviews[${index}].foodComent`;
                review.querySelector('input[type="range"]').name = `reviews[${index}].foodRating`;
            });
            reviewIndex = reviews.length; // 인덱스 갱신
        }
    </script>
</body>
</html>
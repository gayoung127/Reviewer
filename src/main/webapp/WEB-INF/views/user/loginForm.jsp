<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<style>
    /* 폼이 화면 중앙에 위치하도록 설정 */
    .login-container {
        max-width: 400px; /* 폼의 너비 지정 */
        margin-top: 100px; /* 상단 여백 */
    }
    /* 버튼이 동일한 너비를 차지하도록 설정 */
    .equal-width-button {
        flex: 1;
    }
    /* 버튼 간 간격 설정 */
    .button-gap {
        gap: 10px;
    }
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	<div class="container d-flex justify-content-center align-items-center login-container">
	 <!-- form을 직사각형 모양의 card로 만들기 -->
        <div class="card p-4" style="width: 100%; max-width: 400px;">
            <h3 class="text-center mb-4">Login</h3>
            <c:if test="${not empty requestScope.message}">
				<span class="alert alert-info text-center" role="alert">${requestScope.message}</span>
			</c:if>
			<form class="mb-3" action="login" method="post">
				<div class="form-floating mb-3">
					<input class="form-control form-control-lg" type="text" name="id" id="floatingInput" placeholder="ID">
					<label for="floatingInput">ID</label>
				</div>
				<div class="form-floating mb-3">
					<input class="form-control form-control-lg" type="password" name="pass" id="floatingInput" placeholder="PASSWORD">
					<label for="floatingInput">Password</label>
				</div>
  		  	    <div class="d-flex button-gap">
					<button class="btn btn-primary equal-width-button">Login</button>
					<a class="btn btn-secondary equal-width-button" href="/user/signup" role="button">Sign	Up</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
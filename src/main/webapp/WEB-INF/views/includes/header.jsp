<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../includes/bootstrap.jsp"%>
<title>header</title>
<style>
body {
	padding-top: 56px; /* 헤더 높이만큼 여백 추가 */
}
</style>
</head>
<body>
	<div class="container text-center">
		<nav class="navbar fixed-top" style="background-color: #e3f2fd;">
			<div class="container-fluid">
				<a class="navbar-brand" href="/">Home</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
					aria-controls="offcanvasDarkNavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="offcanvas offcanvas-end" tabindex="-1"
					id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
					<div class="offcanvas-header">
						<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Reviewer</h5>
						<button type="button" class="btn-close btn-close-white"
							data-bs-dismiss="offcanvas" aria-label="Close"></button>
					</div>
					<div class="offcanvas-body">
						<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
							<li calss="nav-item"><a class="nav-link active" href="/list">List</a></li>
							<li calss="nav-item"><a class="nav-link active" href="/user/userpage">My Page</a></li>
							<li calss="nav-item"><a class="nav-link active" href="/list">List</a></li>
							<li calss="nav-item"><a class="nav-link active" href="/list">List</a></li>
							<c:if test="${empty sessionScope.loginUser}">
								<li class="nav-item"><a class="nav-link active" href="/user/login">Log In</a></li>
							</c:if>
							<c:if test="${not empty sessionScope.loginUser}">							
								<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="/user/userpage" role="button" data-bs-toggle="dropdown" aria-expanded="false"> My Page </a>
								<ul class="dropdown-menu dropdown-menu">
									<li><a class="dropdown-item" href="/user/userpage">My Page</a></li>
									<li><a class="dropdown-item" href="/user/userReviews">My Reviews</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" href="/user/logout">Log Out</a></li>
								</ul>
								</li>
							</c:if>
						</ul>
						<form class="d-flex mt-3" role="search">
							<input class="form-control me-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-success" type="submit">Search</button>
						</form>
					</div>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>
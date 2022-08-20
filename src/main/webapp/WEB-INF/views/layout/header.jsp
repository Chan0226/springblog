<%@ page language="java" contentType="text/html; charset=UTF-16"
         pageEncoding="UTF-16"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/blog">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <c:choose>
            <%-- 세션이 되있다면 화면에 출력 --%>
            <c:when test="${empty sessionScope.principal}">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/blog/user/loginForm">로그인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/blog/user/joinForm">회원가입</a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/blog/board/writeForm">글쓰기</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/blog/user/userForm">회원정보</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/blog/user/logout">로그아웃</a>
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>
        </div>
    </div>
</nav>
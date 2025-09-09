<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Script Part -->
<script src="${pageContext.request.contextPath}/resources/static/js/login/admLogin.js"></script>

<!-- Draw view [S] -->
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-5">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header"><h3 class="text-center font-weight-light my-4">URDOGZONE ADMIN</h3></div>
                <div class="card-body">
                    <form>
                        <div class="form-floating mb-3">
                            <input class="form-control" type="text" name="adminId" id="adminId" />
                            <label for="inputEmail">아이디</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input class="form-control" type="password" name="adminPw" id="adminPw" />
                            <label for="inputPassword">비밀번호</label>
                        </div>
                        <div class="form-check mb-3">
                            <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                            <label class="form-check-label" for="inputRememberPassword">Remember Password</label>
                        </div>
                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                            <a class="small" href="#">Forgot Password?</a>
                            <a class="btn btn-primary" id="adLoginBtn">Login</a>
                        </div>
                    </form>
                </div>
               <div class="card-footer text-center py-3">
                    <div class="small"><a href="#">Need an account? Sign up!</a></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Draw view [E] -->
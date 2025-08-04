<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="text-center">
	<ul class="pagination pagination-sm">

	<%-- 첫 페이지로 이동 
	<c:if test="${paging.curPage ne 1 }">
		<c:choose>
			<c:when test="${not empty param.param}">
				<li><a href="${paging.uri}?param=${param.param}">&larr; 처음</a></li>	
			</c:when>
			<c:otherwise>
				<li><a href="${paging.uri}">&larr; 처음</a></li>	
			</c:otherwise>
		</c:choose>
	</c:if> --%>
	
	<%-- 이전 페이징 리스트로 이동 
	<c:choose>
	<c:when test="${paging.startPage ne 1 }">
		<li><a href="${paging.uri}?curPage=${paging.startPage - paging.pageCount }">&laquo;</a></li>
	</c:when>
	<c:when test="${paging.startPage eq 1 }">
		<li class="disabled"><a>&laquo;</a></li>
	</c:when>
	</c:choose> --%>
	
	<%-- 이전 페이지로 가기 --%>
	<c:if test="${paging.curPage > 1 }">
	<c:choose>
		<c:when test="${not empty param.param}">
			<li><a href="${paging.uri}?curPage=${paging.curPage - 1 }&param=${param.param}">&lt;</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${paging.uri}?curPage=${paging.curPage - 1 }">&lt;</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	
	
	
	<%-- 페이징 리스트 --%>
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
	<c:if test="${paging.curPage eq i }">
	<c:choose>
		<c:when test="${not empty param.param}">
			<li class="active"><a href="${paging.uri}?curPage=${i }&param=${param.param}">${i }</a></li>
		</c:when>
		<c:otherwise>
			<li class="active"><a href="${paging.uri}?curPage=${i }">${i }</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	<c:if test="${paging.curPage ne i }">
		<c:choose>
			<c:when test="${not empty param.param}">
				<li><a href="${paging.uri}?curPage=${i }&param=${param.param}">${i }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${paging.uri}?curPage=${i }">${i }</a></li>
			</c:otherwise>
		</c:choose>
	</c:if>
	</c:forEach>

	
	
	<%-- 다음 페이지로 가기 --%>
	<c:if test="${paging.curPage < paging.totalPage }">
		<c:choose>
			<c:when test="${not empty param.param}">
				<li><a href="${paging.uri}?curPage=${paging.curPage + 1 }&param=${param.param}">&gt;</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${paging.uri}?curPage=${paging.curPage + 1 }">&gt;</a></li>
			</c:otherwise>
		</c:choose>
	</c:if>
	
	<%-- 다음 페이징 리스트로 이동
	<c:choose>
	<c:when test="${paging.endPage ne paging.totalPage }">
		<li><a href="${paging.uri}?curPage=${paging.startPage + paging.pageCount }">&raquo;</a></li>
	</c:when>
	<c:when test="${paging.endPage eq paging.totalPage }">
		<li class="disabled"><a>&raquo;</a></li>
	</c:when>
	</c:choose>  --%>

	<%-- 끝 페이지로 이동 
	<c:if test="${paging.curPage ne paging.totalPage }">
		<li><a href="${paging.uri}?curPage=${paging.totalPage }">끝 &rarr;</a></li>	
	</c:if> --%>
	
	</ul>
</div>

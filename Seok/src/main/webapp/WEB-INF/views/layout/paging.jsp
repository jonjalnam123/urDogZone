<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="text-center">
	<ul class="pagination pagination-sm">
	
	<c:set var="searchQuery"
       value="&param=${searchDTO.param}&param1=${searchDTO.param1}" />
       
	<c:choose>
		<c:when test="${empty searchDTO.param || searchDTO.param eq null || searchDTO.param eq ''}">
			<!-- 이전 페이지 --> 
			<c:if test="${paging.curPage > 1 }">
			    <li><a href="${paging.uri}?curPage=${paging.curPage - 1}">&lt;</a></li>
			</c:if>
			
			<!-- 페이징 리스트 -->
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i">
			    <c:choose>
			        <c:when test="${paging.curPage eq i}">
			            <li class="active"><a href="${paging.uri}?curPage=${i}">${i}</a></li>
			        </c:when>
			        <c:otherwise>
			            <li><a href="${paging.uri}?curPage=${i}">${i}</a></li>
			        </c:otherwise>
			    </c:choose>
			</c:forEach>
			
			<!-- 다음 페이지 -->
			<c:if test="${paging.curPage < paging.totalPage }">
			    <li><a href="${paging.uri}?curPage=${paging.curPage + 1}">&gt;</a></li>
			</c:if>
		</c:when>
		<c:otherwise>
			<!-- 이전 페이지 -->
			<c:if test="${paging.curPage > 1 }">
			    <li><a href="${paging.uri}?curPage=${paging.curPage - 1}${searchQuery}">&lt;</a></li>
			</c:if>
			
			<!-- 페이징 리스트 -->
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i">
			    <c:choose>
			        <c:when test="${paging.curPage eq i}">
			            <li class="active"><a href="${paging.uri}?curPage=${i}${searchQuery}">${i}</a></li>
			        </c:when>
			        <c:otherwise>
			            <li><a href="${paging.uri}?curPage=${i}${searchQuery}">${i}</a></li>
			        </c:otherwise>
			    </c:choose>
			</c:forEach>
			
			<!-- 다음 페이지 -->
			<c:if test="${paging.curPage < paging.totalPage }">
			    <li><a href="${paging.uri}?curPage=${paging.curPage + 1}${searchQuery}">&gt;</a></li>
			</c:if>
		</c:otherwise>
	</c:choose>
	
	</ul>
</div>

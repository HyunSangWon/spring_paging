<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="cPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="${cPath}/resources/img/favicon.ico">
<meta charset="UTF-8">
<title>페이징 처리</title>
</head>
<script type="text/javascript">
	function page(pageNum){
		 location.href = "/"+pageNum;
	}
</script>
<body>
<h3>상원 게시판</h3>
 <table>
 	<colgroup>
		<col width="15%">
		<col width="70%">
		<col width="15%">
	</colgroup>
  <!--페이지 리스트  -->
   <tbody>
   		<tr>
   			<td>NO</td>
   			<td>제목</td>
   			<td>등록일</td>
   		</tr>
   		<c:choose>
   			<c:when test="${fn:length(list)>0}">
   				<c:forEach items="${list}" var="row">
			   		 <tr>
			   			<td>${row.board_no}</td>
			   			<td>${row.board_title}</td>
			   			<td>${row.board_date}</td>
			   		</tr>
   				</c:forEach>
   			</c:when>
   			<c:otherwise>
   				<td colspan="3">작성된 게시물이  없습니다.</td>
   			</c:otherwise>
   		</c:choose>
   </tbody>
   </table>
   <!-- 페이지 번호  -->
   <div>
     <table>
     	<tbody>
	     	<tr>
	     		<c:if test="${pageHandler.prev}">
	   				<td><a href="javascript:page(${pageHandler.getStartPage()-1});"><img src="${cPath}/resources/img/prev_btn.png" alt="이전으로"></a></td>
	   			</c:if>
	   				<c:forEach begin="${pageHandler.getStartPage()}" end="${pageHandler.getEndPage()}" var="idx" >
						<td><a href="javascript:page(${idx});"><span id="page${idx}">${idx}</span></a></td>
					</c:forEach>
				<c:if test="${pageHandler.next}">
	   				<td><a href="javascript:page(${pageHandler.getEndPage()+1});"><img src="${cPath}/resources/img/next_btn.png" alt="다음으로"></a></td>
	   			</c:if>
	   		</tr>
     	</tbody>
     </table>
   </div>
</body>
</html>
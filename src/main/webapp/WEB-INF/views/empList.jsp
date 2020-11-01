<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	System.out.println(request.getContextPath());
%>
<title>Employee</title>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-3.5.1/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<!-- title -->
		<div class="row">
			<div class="col-md-12">
				<h1>员工信息</h1>
			</div>
		</div>
		<!-- operation -->
		<div class="row">
			<div class="col-md-2 col-md-offset-10">
				<button class="btn btn-primary text-uppercase">new</button>
				<button class="btn btn-warning text-uppercase">delete</button>
			</div>
		</div>
		<!-- database -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped">
					<tr>
						<th>#</th>
						<th>员工姓名</th>
						<th>性别</th>
						<th>邮箱地址</th>
						<th>隶属部门</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							<th>${emp.empId }</th>
							<th>${emp.empName }</th>
							<th>${emp.gender?"Male":"Female" }</th>
							<th>${emp.email }</th>
							<th>${emp.department.deptName }</th>
							<th>
								<button class="btn btn-primary text-uppercase btn-sm">
								<span class="glyphicon glyphicon-edit" ></span> edit</button>
								<button class="btn btn-warning text-uppercase btn-sm">
								<span class="glyphicon glyphicon-remove" ></span> delete</button>
							</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- pagedetail -->
		<div class="row">
			<div class=col-md-6>
				<h4>当前第${pageInfo.pageNum }页, 共${pageInfo.pages }页 </h4>
			</div>
			<div class=col-md-6>
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				  	<li><a href="${APP_PATH }/detail?pageNum=1">首页</a></li>
				  	
				  	<!-- 判断是否有上一页 -->
				  	<c:if test="${pageInfo.hasPreviousPage }">
				  		<li>
				      		<a href="${APP_PATH }/detail?pageNum=${pageInfo.pageNum - 1}" aria-label="Previous">
				        		<span aria-hidden="true">&laquo;</span>
				      		</a>
				    	</li>
				  	</c:if>
				    
				    <!-- 判断是否当前页设置选中样式 -->
			    	<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
			    		<c:if test="${page_Num == pageInfo.pageNum }">
			    			<li class="active"><a href="#">${page_Num }</a></li>
			    		</c:if>
			    		<c:if test="${page_Num != pageInfo.pageNum }">
			    			<li><a href="${APP_PATH }/detail?pageNum=${page_Num}">${page_Num }</a></li>
			    		</c:if>
			    	</c:forEach>
			    	
			    	<!-- 判断是否有下一页 -->
			    	<c:if test="${pageInfo.hasNextPage }">
			    		<li>
					      <a href="${APP_PATH }/detail?pageNum=${pageInfo.pageNum + 1}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
			    	</c:if>
				    
				    <li><a href="${APP_PATH }/detail?pageNum=${pageInfo.pages}">末页</a></li>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>
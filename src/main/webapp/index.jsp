<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
System.out.println(request.getContextPath());
%>
<title>shouye</title>
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-3.5.1/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<script type="text/javascript" src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${APP_PATH }/static/js/employeejs.js"></script>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="addempmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增员工</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="empName" class="col-sm-2 control-label">员工姓名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="empName" name="empName" placeholder="your name">
								<span id="helpBlock2" class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="empEmail" class="col-sm-2 control-label">邮箱地址</label>
							<div class="col-sm-5">
								<input type="email" class="form-control" id="empEmail" name="email" placeholder="your email">
								<span id="helpBlock2" class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="empEmail" class="col-sm-2 control-label">性 别</label>
							<div class="col-sm-5">
								<label class="checkbox-inline"> <input type="radio" name="gender" id="empgender1" value="M"> 男</label>
								<label class="checkbox-inline"> <input type="radio" name="gender" id="empgender2" value="F"> 女</label>
							</div>
						</div>
						<div class="form-group">
							<label for="empEmail" class="col-sm-2 control-label">隶属部门</label>
							<div class="col-sm-5">
								<select class="form-control" id="empdid" name="dId">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="empsavebtn">Submit</button>
				</div>
			</div>
		</div>
	</div>
	
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
				<button class="btn btn-primary text-uppercase" id="addempbtn">new</button>
				<button class="btn btn-warning text-uppercase">delete</button>
			</div>
		</div>
		<!-- database -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped" id="emp_tb">
					<thead>
						<tr>
							<th>#</th>
							<th>员工姓名</th>
							<th>性别</th>
							<th>邮箱地址</th>
							<th>隶属部门</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<!-- ajax动态添加数据	 -->
					</tbody>
				</table>
			</div>
		</div>
		<!-- pagedetail -->
		<div class="row">
			<div class=col-md-6 id="page_detail"></div>
			<div class=col-md-6 id="page_num"></div>
		</div>
	</div>
	
</body>

</html>
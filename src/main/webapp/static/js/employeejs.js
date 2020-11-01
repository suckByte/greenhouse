/**
 * 
 */
$(function() {
	forward_page(1);
});

$(function() {
	$("#addempbtn").click(function() {
		$("#addempmodal").modal({
			backdrop: 'static'
		});
		forward_dept();
	});
});

function forward_dept() {
	$.ajax({
		url: "/greenhouse/getDeptName",
		type: "GET",
		success: function(result) {
			//填充新增员工模态框部门名称
			build_empadd_modal(result);
		}
	});
}

function build_empadd_modal(result) {
	$("#empdid").empty();
	var depts = result.extend.dpList;
	$.each(depts, function(index, item) {
		var opt = $("<option></option>").append(item.deptName).attr("value", item.deptId);
		opt.appendTo($("#addempmodal select"));
	});
}

function forward_page(pageNum) {
	$.ajax({
		url: "/greenhouse/detail",
		data: "pageNum=" + pageNum,
		type: "GET",
		success: function(result) {
			//解析显示员工数据
			build_emps_table(result);
			//解析显示分页信息
			build_page_detail(result);
			//解析显示分页页码
			build_page_num(result);
		}
	});
}

function build_emps_table(result) {
	$("#emp_tb tbody").empty();
	var emps = result.extend.pageInfo.list;
	$.each(emps, function(index, item) {
		var empId = $("<th></th>").append(item.empId);
		var empName = $("<th></th>").append(item.empName);
		var gender = $("<th></th>").append(item.gender == "M" ? "男" : "女");
		var email = $("<th></th>").append(item.email);
		var deptName = $("<th></th>").append(item.department.deptName);
		var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm text-uppercase").append("<span></span>").addClass("glyphicon glyphicon-edit").append("edit");
		var deleteBtn = $("<button></button>").addClass("btn btn-warning btn-sm text-uppercase").append("<span></span>").addClass("glyphicon glyphicon-trash").append("delete");
		var allBtn = $("<th></th>").append(editBtn).append(" ").append(deleteBtn);
		$("<tr></tr>").append(empId).append(empName).append(gender).append(email).append(deptName).append(allBtn).appendTo($("#emp_tb tbody"));
	});
}

function build_page_detail(result) {
	$("#page_detail").empty();
	var pageDetail = result.extend.pageInfo;
	$("<h4></h4>").append(pageDetail.pages + "/" + pageDetail.pageNum + "  " + pageDetail.total + "条记录").appendTo("#page_detail");
}

function build_page_num(result) {
	$("#page_num").empty();
	var nav = $("<nav></nav>").attr("aria-label", "Page navigation");
	var ul = $("<ul></ul>").addClass("pagination");

	var firstPage = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
	var prePage = $("<li></li>").append($("<a></a>").append($("<span></span>").append("&laquo;").attr("aria-hidden", "true")).attr("href", "#"));

	ul.append(firstPage).append(prePage);
	if (result.extend.pageInfo.hasPreviousPage == false) {
		firstPage.addClass("disabled");
		prePage.addClass("disabled");
	} else {
		firstPage.click(function() {
			forward_page(1);
		});
		prePage.click(function() {
			forward_page(result.extend.pageInfo.pageNum - 1);
		});
	}

	$.each(result.extend.pageInfo.navigatepageNums, function(index, num) {
		var li = $("<li></li>").append($("<a></a>").append(num).attr("href", "#"));
		if (result.extend.pageInfo.pageNum == num) {
			li.addClass("active");
		}
		li.click(function() {
			forward_page(num);
		});
		li.appendTo(ul);
	});
	
	var lastPage = $("<li></li>").append($("<a></a>").append($("<span></span>").append("&raquo;").attr("aria-hidden", "true")).attr("href", "#"));
	var endPage = $("<li></li>").append($("<a></a>").append("尾页").attr("href", "#"));

	ul.append(lastPage).append(endPage);
	if (result.extend.pageInfo.hasNextPage == false) {
		lastPage.addClass("disabled");
		endPage.addClass("disabled");
	} else {
		endPage.click(function() {
			forward_page(result.extend.pageInfo.pages);
		});
		lastPage.click(function() {
			forward_page(result.extend.pageInfo.pageNum + 1);
		});
	}

	nav.append(ul).appendTo("#page_num");
}

$(function() {
	$("#empsavebtn").click(function() {
		//将模态框中表单数据提交给服务器保存
		//正则表达式校验输入框的信息格式
		validate_addForm();
		//ajax发送请求保存数据
		console.log($("#addempmodal form").serialize());
		/*$.ajax({
			url: "/greenhouse/emp",
			type: "POST",
			data: $("#addempmodal form").serialize(),
			success: function(result) {
				//提交完成后关闭模态框
				$("#addempmodal").modal("hide");
			}
		})*/
	});
})

function validate_addForm() {
	
	var regName = /(^[a-zA-Z0-9_-]{6,16})|(^[\u2E80-\u9FFF]{2,6})$/;
	var regEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	
	var empName = $("#empName").val();
	var empEmail = $("#empEmail").val();
	
	if(!regName.test(empName)) {
		show_validate_msg("#empName", "error", "输入6-16位任意字符或中文");
		return false;
	} else {
		show_validate_msg("#empName", "success", "");
	}
	
	if(!regEmail.test(empEmail)) {
		show_validate_msg("#empEmail", "error", "输入正确的邮箱格式");
		return false;
	} else {
		show_validate_msg("#empEmail", "success", "");
	}
	
	return true;
}

function show_validate_msg(ele, status, msg) {
	$(ele).parent().removeClass("has-success has-error");
	$(ele).next("span").text("");
	if("success" == status) {
		$(ele).parent().addClass("has-success");
		$(ele).next("span").text("");
	} else if("error" == status) {
		$(ele).parent().addClass("has-error");
		$(ele).next("span").text(msg);
	}
}



















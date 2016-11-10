<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<body class="menubar-hoverable header-fixed menubar-first full-content "
	style="font: 12px/1.5 arial;">
	<header>
		<link type="text/css" rel="stylesheet" href="../css/page/article.css">
	</header>
	<script type="text/javascript">
	$(function(){
		$("#add").click(function(){
			$.ajax({
	 			url:'/type/selectType',
	 			type:'post',
	 			dataType:'json',
	 			success:function(data){
	 				var html;
	 				$.each(data.data.data, function(i,type){
	 					html+="<option value="+type.id+">"+type.name+"</option>";
	 				});
	 				$("#select1").html(html);
	 			    $("#myModalLabel").text("新增");
	 		        $('#myModal').modal();
	 			}
	 		});
	     
	    });
	})
	</script>
	<%@ include file="/pages/common/menu.jsp"%>
	<div id="base">
		<div id="content">
			<div class="widget widget-table">
				<section class="has-actions style-default-bright">
					<div class="main-content">
						<div class="widget widget-table">
							<div class="widget-header">
								<h3>
									<i class="fa fa-table"></i> 文章详情
								</h3>
							</div>
							<div class="widget-content">
								<div class="row">
									<div id="search">
										<label> Search: <input type="text"
											aria-controls="DataTables_Table_0">
										</label>
										<button class="example8 btn btn-primary" id="add">新增</button>
									</div>
								</div>
								<table
									class="table table-sorting table-striped table-hover datatable"
									cellpadding="0" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>序号</th>
											<th>标题</th>
											<th>内容</th>
											<th>类型</th>
											<th>标签</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.data}" var="ar" varStatus="xh">
											<tr>
												<td>${xh.count}</td>
												<td>${ar.title}</td>
												<td>${ar.context}</td>
												<td>${ar.type.name}</td>
												<td>${ar.label}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="dataTables_paginate paging_bootstrap">
									<ul class="pagination">
										<li class="prev disabled"><a href="#">←</a></li>
										<li class="active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li class="next"><a href="#">→</a></li>
									</ul>
								</div>
							</div>
						</div>

						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">×</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">新增</h4>
									</div>
									<div class="modal-body">
										<form class="form" id="formCompose" action="/article/saveOrUpdate" method="post">
											<div class="form-group floating-label">
												<input type="text" class="form-control" id="to1" name="article.title"> 
													<label for="to1">标题</label>
													<a class="link-default pull-right" href="#emailOptions" data-toggle="collapse">More</a>
											</div>
											<div id="emailOptions" class="collapse">
												<div class="form-group floating-label">
													<input type="text" class="form-control" id="cc1"
														name="article.label"> <label for="cc1">关键字</label>
												</div>
												<div class="form-group">
													<select id="select1" name="article.type.id"
														class="form-control dirty">
													</select> <label for="select1">类型</label>
												</div>
											</div>
											<div class="form-group">
												<textarea id="simple-summernote" name="article.context"
													class="form-control control-6-rows" spellcheck="false"></textarea>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">
													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
												</button>
												<button type="submit" class="btn btn-primary">保存</button>
											</div>
										</form>
									</div>
							</div>
						</div>
				</section>
			</div>
		</div>
</body>
</html>

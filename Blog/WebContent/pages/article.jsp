<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<body class="menubar-hoverable header-fixed menubar-first full-content ">
	<%@ include file="/pages/common/menu.jsp"%>
	<div id="base">
		<div id="content">
			<div class="widget widget-table">
				<section class="has-actions style-default-bright">
					<div class="main-content">
						<!-- JQUERY DATA TABLE -->
						<div class="widget widget-table">
							<div class="widget-header">
								<h3>
									<i class="fa fa-table"></i> 文章详情
								</h3>
							</div>
							<div class="widget-content">
								<div class="row">
									<div id="DataTables_Table_0_length" class="dataTables_length">
									</div>
									<div class="col-md-5">
										<div class="dataTables_filter" id="DataTables_Table_0_filter">
											<label>Search: <input type="text"
												aria-controls="DataTables_Table_0"></label>
										</div>
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
										<c:forEach items="${page.data}" var="entity" varStatus="xh">
											<tr>
												<td>${xh.count}</td>
												<td>$(entity.title}</td>
												<td>$(entity.context}</td>
												<td>$(entity.type.name}</td>
												<td>$(entity.label}</td>
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
						<%-- <div class="section-body">
							<div class="row">
								<div class="col-sm-8 col-md-9 col-lg-10">
									<h3 class="text-bold text-primary">好记性不如烂笔头</h3>
									<form class="form" id="formCompose"
										action="/article/saveOrUpdate" method="post">
										<div class="form-group floating-label">
											<input type="text" class="form-control" id="to1"
												name="article.title"> <label for="to1">标题</label> <a
												class="link-default pull-right" href="#emailOptions"
												data-toggle="collapse">More</a>
										</div>
										<div id="emailOptions" class="collapse">
											<div class="form-group floating-label">
												<input type="text" class="form-control" id="cc1"
													name="article.label"> <label for="cc1">关键字</label>
											</div>
											<div class="form-group">
												<select id="select1" name="article.type.id"
													class="form-control dirty">
													<c:forEach items="${page.data}" var="entity">
														<option value="${entity.id}">${entity.name}</option>
													</c:forEach>
												</select> <label for="select1">类型</label>
											</div>
										</div>
										<div class="form-group">
											<textarea id="simple-summernote" name="article.context"
												class="form-control control-6-rows" spellcheck="false"></textarea>
										</div>
										<div style="text-align: right">
											<button type="submit" class="btn ink-reaction btn-primary">提
												交</button>
										</div>
									</form>
								</div>
							</div>
						</div> --%>
				</section>
			</div>
		</div>
</body>
</html>

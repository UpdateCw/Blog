<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/pages/common/taglibs.jsp"%>
<body class="menubar-hoverable header-fixed menubar-first full-content " style="font:12px/1.5 arial;">
	<%@ include file="/pages/common/menu.jsp"%>
	<div id="base">
		<div id="content">
			<div class="widget widget-table">
				<section class="has-actions style-default-bright">
						<div class="section-body">
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
						</div>
				</section>
			</div>
		</div>
</body>
</html>

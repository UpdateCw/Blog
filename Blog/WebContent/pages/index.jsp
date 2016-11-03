<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Update Admin</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="keywords" content="your,keywords">
		<meta name="description" content="Short explanation about this website">
	    <link href='http://fonts.useso.com/css?family=Roboto:300italic,400italic,300,400,500,700,900' rel='stylesheet' type='text/css'/>
		<link type="text/css" rel="stylesheet" href="../css/theme-default/bootstrap.css?1422792965" />
		<link type="text/css" rel="stylesheet" href="../css/theme-default/materialadmin.css?1425466319" />
		<link type="text/css" rel="stylesheet" href="../css/theme-default/font-awesome.min.css?1422529194" />
		<link type="text/css" rel="stylesheet" href="../css/theme-default/material-design-iconic-font.min.css?1421434286" />
		<link type="text/css" rel="stylesheet" href="../css/theme-default/libs/summernote/summernote.css?1425218701" />
		<link type="text/css" rel="stylesheet" href="../css/style.css">
		<script src="../js/libs/jquery/jquery-1.11.2.min.js"></script>
		<script src="../js/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
		<script src="../js/libs/bootstrap/bootstrap.min.js"></script>
		<script src="../js/libs/spin.../js/spin.min.js"></script>
		<script src="../js/libs/autosize/jquery.autosize.min.js"></script>
		<script src="../js/libs/nanoscroller/jquery.nanoscroller.min.js"></script>
		<script src="../js/libs/ckeditor/ckeditor.js"></script>
		<script src="../js/libs/ckeditor/adapters/jquery.js"></script>
		<script src="../js/libs/summernote/summernote.min.js"></script>
		<script src="../js/core/source/App.js"></script>
		<script src="../js/core/source/AppNavigation.js"></script>
		<script src="../js/core/source/AppOffcanvas.js"></script>
		<script src="../js/core/source/AppCard.js"></script>
		<script src="../js/core/source/AppForm.js"></script>
		<script src="../js/core/source/AppNavSearch.js"></script>
		<script src="../js/core/source/AppVendor.js"></script>
		<script src="../js/core/demo/Demo.js"></script>
		<script src="../js/core/demo/DemoFormEditors.js"></script>
	</head>
	<body class="menubar-hoverable header-fixed menubar-first full-content ">
		<header id="header" >
			<div class="headerbar">
				<div class="headerbar-left">
					<ul class="header-nav header-nav-options">
						<li class="header-nav-brand" >
							<div class="brand-holder">
								<a href="../../html/dashboards/dashboard.html">
									<span class="text-lg text-bold text-primary">Update</span>
								</a>
							</div>
						</li>
						<li>
							<a class="btn btn-icon-toggle menubar-toggle" data-toggle="menubar" href="javascript:void(0);">
								<i class="fa fa-bars"></i>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</header>
			<div id="menubar" class="menubar-inverse ">
				<div class="menubar-fixed-panel">
					<div>
						<a class="btn btn-icon-toggle btn-default menubar-toggle" data-toggle="menubar" href="javascript:void(0);">
							<i class="fa fa-bars"></i>
						</a>
					</div>
					<div class="expanded">
						<a href="javaScript:">
							<span class="text-lg text-bold text-primary ">ChenWu</span>
						</a>
					</div>
				</div>
				<div class="menubar-scroll-panel">
					<ul id="main-menu" class="gui-controls">
						<li>
							<a href="javaScript:" >
								<div class="gui-icon"><i class="md md-home"></i></div>
								<span class="title">首页</span>
							</a>
						</li>
					</ul>
					<div class="menubar-foot-panel">
						<small class="no-linebreak hidden-folded">
							<span class="opacity-75">Copyright &copy; 2016</span> <strong>Update</strong>
						</small>
					</div>
				</div>
			</div>
		<div id="base">
			<div id="content">
				<section class="has-actions style-default-bright">
					<div class="section-body">
						<div class="row">
							<div class="col-sm-8 col-md-9 col-lg-10">
								<h3 class="text-bold text-primary">好记性不如烂笔头</h3>
								<form class="form" id="formCompose" action="/Blog/article/upload">
									<div class="form-group floating-label">
										<input type="email" class="form-control" id="to1" name="title" >
										<label for="to1">标题</label>
										<a class="link-default pull-right" href="#emailOptions" data-toggle="collapse">More</a>
									</div>
									<div id="emailOptions" class="collapse">
										<div class="form-group floating-label">
											<input type="text" class="form-control" id="cc1" name="label" >
											<label for="cc1">关键字</label>
										</div>
										<div class="form-group">
											<select id="select1" name="type" class="form-control dirty">
													<option>Java</option>
													<option>Hadoop</option>
													<option>多线线程</option>
													<option>并发</option>
											</select>
											<label for="select1">类型</label>
										</div>
									</div>
									<div class="form-group">
										<textarea id="simple-summernote" name="message" class="form-control control-6-rows" spellcheck="false"></textarea>
									</div>
									<div style="text-align:right">
										<button type="submit" class="btn ink-reaction btn-primary">提 交</button>
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

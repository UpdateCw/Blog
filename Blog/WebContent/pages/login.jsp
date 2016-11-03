<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Update - Login</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="keywords" content="your,keywords">
		<meta name="description" content="Short explanation about this website">
		<link href='http://fonts.useso.com/css?family=Roboto:300italic,400italic,300,400,500,700,900' rel='stylesheet' type='text/css'/>
		<link type="text/css" rel="stylesheet" href="../css/theme-default/bootstrap.css?1422792965" />
		<link type="text/css" rel="stylesheet" href="../css/theme-default/materialadmin.css?1425466319" />
		<link type="text/css" rel="stylesheet" href="../css/theme-default/font-awesome.min.css?1422529194" />
		<link type="text/css" rel="stylesheet" href="../css/theme-default/material-design-iconic-font.min.css?1421434286" />
	</head>
	<body >
		<section class="section-account">
			<div class="img-backdrop" style="background-image: url('../../assets/img/img16.jpg')"></div>
			<div class="spacer" style="margin-left:30%;width:50%;font-weight:bold;font-family:'楷体';padding:120px;">
					<h2>带着责任做事</h2>
					<h3 style="text-indent:120px">带着稳重的心态处事</h3>
			 </div>
			<div class="card contain-sm style-transparent">
				<div class="card-body">
					<div class="row">
						<div class="col-sm-7">
							<br/>
							<span class="text-lg text-bold text-primary">Update 登录</span>
							<br/><br/>
							<form class="form floating-label" action="/user/login" accept-charset="utf-8" method="post" autocomplete="off">
								<div class="form-group">
									<input type="text" class="form-control" id="username" name="admin.username">
									<label for="username">Username</label>
								</div>
								<div class="form-group">
									<input type="password" class="form-control" id="password" name="admin.password">
									<label for="password">Password</label>
								</div>
								<br/>
								<div class="row">
									<div class="col-xs-6 text-left">
										<div class="checkbox checkbox-inline checkbox-styled">
											<label>
												<input type="checkbox"> <span>Remember me</span>
											</label>
										</div>
									</div>
									<div class="col-xs-6 text-right">
										<button class="btn btn-primary btn-raised" type="submit">Login</button>
									</div>
								</div>
							</form>
						</div>
					</div>
		 </section>
	</body>
</html>

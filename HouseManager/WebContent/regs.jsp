<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>青鸟租房 - 用户注册</TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
		<LINK rel=stylesheet type=text/css href="css/style.css">
		<META name=GENERATOR content="MSHTML 8.00.7601.17514">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#fm').submit(function(){
				var name = $('#name').val();
				var pass = $('#pass').val();
				var pass2=$('#repassword').val();
				if(name==''||pass==''){
					alert('用户名或密码不能为空！');
					return false;
				}
				if(pass.equals(pass2)){
					alert('两次密码输入不一致！');
					return false;
				}
				return true;
			});
			
			$('#name').blur(function(){ 
				  var name = $('#name').val();
				  $.post("isExists",{userName:name},function(result){
					  alert("aaa"+result);
					  if(result==1){
						  alert("用户名可以使用");
						  reg();
					  }else{
						  alert("用户名已存在");
						  return false;
					  }
				  });
			});
			function reg(){
				$("#reg").click(function(){
					var param=$("input:text,input:password").serialize();
					  alert("5555"+param);
					  $.post("register",param,function(result){
						  alert(result);
						  if(result==1){
							  alert("注册成功");
							  window.location="login.jsp";
						  }else{
							  alert("注册失败");
						  }
					  });
				});
			}
		});
	
	</script>
	</HEAD>
	<BODY>
		<DIV id=header class=wrap>
			<DIV id=logo>
				<IMG src="images/logo.gif">
			</DIV>
		</DIV>
		<DIV id=regLogin class=wrap>
			<DIV class=dialog>
				<DL class=clearfix>
					<DT>
						新用户注册
					</DT>
					<DD class=past>
						填写个人信息
					</DD>
				</DL>
				<DIV class=box>
					<FORM id='fm' action='#' method="post">
						<DIV class=infos>
							<TABLE class=field>
								<TBODY>
									<TR>
										<TD class=field>
											用 户 名：
										</TD>
										<TD>
											<INPUT class=text id='name' type=text name=userName>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											密 码：
										</TD>
										<TD>
											<INPUT class=text type=password id='pass' name=passWord>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											确认密码：
										</TD>
										<TD>
											<INPUT class=text type=password name=repassword id='repassword'>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											电 话：
										</TD>
										<TD>
											<INPUT class=text type=text name=phone>
										</TD>
									</TR>
								<!-- 	<TR>
										<TD class=field>
											用户姓名：
										</TD>
										<TD>
											<INPUT class=text type=text name=username>
										</TD>
									</TR> -->
								</TBODY>
							</TABLE>
							<DIV class=buttons>
								<INPUT value=立即注册 type="button" id="reg">
							</DIV>
						</DIV>
					</FORM>
				</DIV>
			</DIV>
		</DIV>
		<DIV id=footer class=wrap>
			<DL>
				<DT>
					青鸟租房 © 2010 北大青鸟 京ICP证1000001号
				</DT>
				<DD>
					关于我们 · 联系方式 · 意见反馈 · 帮助中心
				</DD>
			</DL>
		</DIV>
	</BODY>
</HTML>

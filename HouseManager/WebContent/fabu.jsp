<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>青鸟租房 -发布房屋信息</TITLE>
		<META content="text/html; charset=utf-8" http-equiv=Content-Type>
		<LINK rel=stylesheet type=text/css href="css/style.css">
		<META name=GENERATOR content="MSHTML 8.00.7601.17514">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
		$(function(){
			$("#dis").change(function(){
		 		var did=$(this).val();
		 		$.getJSON("getStreet",{did:did},function(json){
					showSte(json);
				});
		 	});
			function showSte(json){
  					var html = "<option value='0' selected='selected'>--请选择--</option>";
  					for(var i=0;i<json.length;i++){
  						//el表达式要加""
  						if(json[i].sid=="0"){
  							html+="<option value='"+json[i].sid+"' selected='selected'>"+json[i].sname+"</option>"
  						}else{
  							html+="<option value='"+json[i].sid+"' >"+json[i].sname+"</option>"
  						}					
  					}					
  					$('#street').html(html); 				
  			}		
					
			//类型区域回显
			$("option[class='tp'][value=6]").prop('selected',true);
			$("option[class='ds'][value=1]").prop('selected',true);


			$('#add_action').submit(function(){				
				if($('#add_title').val()==''){
					alert('标题不能为空！');
					return false;
				}
				if($('#add_floorage').val()==''){
					alert('面积不能为空！');
					return false;
				}
				if($('#add_price').val()==''){
					alert('价格不能为空！');
					return false;
				}
				if(isNaN($('#add_price').val()) || isNaN($('#add_floorage').val())){
					alert('价格或面积一定要是数字！');
					return false;
				}
				if($('#add_price').val()<=0 || $('#add_floorage').val()<=0){
					alert('价格或面积一定要大于0！');
					return false;
				}
				if($('#type').val()==0 || $('#street').val()==0){
					alert('请选择好类型和街道！');
					return false;
				}
				var reg = /^\d{4}-\d{2}-\d{2}$/;
				if(!reg.test($('#add_date').val())){
					alert('日期格式必须是yyyy-MM-dd！');
					return false;
				}
				return true;
			});
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
						新房屋信息发布
					</DT>
					<DD class=past>
						填写房屋信息
					</DD>
				</DL>
				<DIV class=box>
					<FORM id='add_action' method='post' action='addHouse.action'>
						<DIV class=infos>
							<TABLE class=field>
								<TBODY>
									<TR>
										<TD class=field>
											标 题：
										</TD>
										<TD>
											<INPUT type=hidden name="uid" value="${user.uid }">
											<INPUT type=text name="userName" value="${user.userName}">
											<INPUT id='add_title' class=text type=text name=topic>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											户 型：
										</TD>
										<TD>
										<select name="htid" id="type">
												<option value="0" selected=selected>
												--请选择--
												</option>
													<c:forEach items="${getType}" var="t">
													<option class='tp' value="${t.htid }">
														${t.htName }
													</option>
												</c:forEach>	
											</select>   
										</TD>
									</TR>
									<TR>
										<TD class=field>
											面 积：
										</TD>
										<TD>
											<INPUT id='add_floorage' class=text type=text
												name=area >
										</TD>
									</TR>
									<TR>
										<TD class=field>
											价 格：
										</TD>
										<TD>
											<INPUT id='add_price' class=text type=text name=price>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											房产证日期：
										</TD>
										<TD>
											<INPUT id='add_date' class=text type=text name=htime>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											位 置：
										</TD>
										<TD>
											区：
									<select name="did" id="dis">
									<option value="0" selected='selected'>
											--请选择--
										</option>		
									<c:forEach items="${getDname}" var="d">
											<option class='ds' value="${d.did }">
												${d.dname }
											</option>
									</c:forEach>
									</select>   
									街道:
									<select name="sid" id="street">
										<option value="0" selected="selected" id="street" >
											--请选择--
										</option>
									</select>   
										</TD>
									</TR>
									<TR>
										<TD class=field>
											联系方式：
										</TD>
										<TD>
											<INPUT id=add_action_contact class=text type=text
												name=phone>
										</TD>
									</TR>
									<TR>
										<TD class=field>
											详细信息：
										</TD>
										<TD>
											<TEXTAREA name=contents></TEXTAREA>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<DIV class=buttons>
								<INPUT  value='立即发布' type='submit'>
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

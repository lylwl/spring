<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'house.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK rel=stylesheet type=text/css href="css/style.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

		<script type="text/javascript">

		function ch(){
								
			$.post('findStreetServlet',{did:$('#dis').val()},function(data){
				var html = "<option value='0'>--请选择--</option>";
				for(var i=0;i<data.length;i++){
					//el表达式要加""
					if(data[i].sid=="0"){
						html+="<option value='"+data[i].sid+"' selected='selected'>"+data[i].sname+"</option>"
					}else{
						html+="<option value='"+data[i].sid+"'>"+data[i].sname+"</option>"
					}					
				}					
				
				$('#street').html(html);
			},'json');
		} 
		
		$(function(){
			 //区街级联
			//$('#dis').change(ch);		
			//面积价格回显
			$("#floorage>[value=0]").attr('selected','selected');
			$("#price>[value=0]").prop('selected',true);
			//类型区域回显
			$("option[class='tp'][value=0]").prop('selected',true);
			$("option[class='ds'][value=0]").prop('selected',true);
			//街道回显
			//ch();
			//删除
			$('.del').live("click",function(){
				var f = window.confirm('确定要删除吗？');
				if(f){
					var hmid=$(this).attr('hmid');
					$.post("del?hmid="+hmid,function(result){
						alert(result);
						if(result==1){
							alert("删除成功！");
							window.location="getHouse";
						}else{
							alert("删除失败！");
						}
					});
				}
			});

		 	$("#dis").change(function(){
		 		var did=$(this).val();
		 		$.getJSON("getStreet",{did:did},function(json){
					showSte(json);
				});
		 	});
			function showSte(json){
  					var html = "<option value='0'>--请选择--</option>";
  					for(var i=0;i<json.length;i++){
  						//el表达式要加""
  						if(json[i].sid=="0"){
  							html+="<option value='"+json[i].sid+"' selected='selected'>"+json[i].sname+"</option>"
  						}else{
  							html+="<option value='"+json[i].sid+"'>"+json[i].sname+"</option>"
  						}					
  					}					
  					$('#street').html(html); 				
  			}
		});
	
	</script>

	</head>

	<body>
		<DIV id=header class=wrap>
			<DIV id=logo>
				<IMG src="images/logo.gif"/>
				<span style="font:normal bold 16px 宋体;">欢迎：${user.userName }</span>
				<a style='padding-left:30px' href='usersServlet?opr=logout'>注销</a>
			</DIV>			
		</DIV>
		<form action="selWhere" method="post">
		<DIV id=navbar class="wrap"><br/>
					标题:
					<input type="text" name="topic" value="" />  
					<input type="hidden" name="user.userName" value="${user.userName }" />  
					面积:
					<select name="floorage" id="floorage">
						<option value="0">
							--请选择--
						</option>
						<option value="1-200">
							1-200
						</option>
						<option value="200-1800">
							200-1800
						</option>
						<option value="1800-180000">
							1800-180000
						</option>
					</select>   
					价格:
					<select name="moneny" id="price">
						<option value="0" selected=selected>
							--请选择--
						</option>
						<option value="1-600">
							1-600
						</option>
						<option value="600-1200">
							600-1200
						</option>
						<option value="1200-2000">
							1200-2000
						</option>
						<option value="2000-80000">
							2000-80000
						</option>
					</select>   
					类型:
					<select name="htid">
						<option value="0" selected=selected>
							--请选择--
						</option>
							<c:forEach items="${getType}" var="t">
							<option class='tp' value="${t.htid }">
								${t.htName }
							</option>
						</c:forEach>		
						
					</select>   
					区县:
					<select name="dis.did" id="dis">
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
						<option value="0" selected="selected" id="street">
							--请选择--
						</option>
					</select>   
					<LABEL class=ui-blue><INPUT  value='搜索房屋' type='submit' name=search></LABEL> 
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href='selHouse'>发布房屋</a>
		</DIV>
		</form>
		<!-- 列表 -->
		<DIV class="main wrap">
			<TABLE class=house-list>
				<TBODY>
					<c:forEach items="${houseList }" var="list">
					<TR >
						<TD class=house-thumb>
							<span><A href="details.htm" target="_blank"><img
										src="images/thumb_house.gif" width="100" height="75" alt="">
							</a>
							</span>
						</TD>
						<TD>
							<DL>
								<DT>
									<A href="details.htm" target="_blank">${list.topic }</A>
								</DT>
								<DD>
									${list.dis.dname}${list.str.sname }${list.area }平米
									<BR>
									联系方式：${list.user.phone}
								</DD>
							</DL>
						</TD>
						<TD class=house-type>
							${list.type.htName }
						</TD>
						<TD class=house-price>
							<SPAN>${list.price }</SPAN>元/月
						</TD>
						<TD class=house-price>
							<a href="getHouseById?hmid=${list.hmid}">修改</a> 
							<a class="del"  href='javascript:void(0)' hmid="${list.hmid} ">删除</a>
						</TD>
					</TR>
					</c:forEach>
				</TBODY>
				
			</TABLE>
			
			<DIV class=pager>
				<UL>
					<LI class=current>
						<A href="getHouse?index1=1&size=2&userName=${user.userName }">首页</A>
					</LI>
					<LI>
						<A href="getHouse?index1=${houseList.getPageNum()-1 }&size=2&userName=${user.userName }">上一页</A>
					</LI>
					<LI>
						<A href="getHouse?index1=${houseList.getPageNum()+1 }&size=2&userName=${user.userName }">下一页</A>
					</LI>
					<LI>
						<A href="getHouse?index1=${houseList.getPages() }&size=2&userName=${user.userName }">末页</A>
					</LI>
				</UL>
				<SPAN class=total>${houseList.getPageNum() }/${houseList.getPages() }</SPAN>
				
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

	</body>
</html>

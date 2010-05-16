$(document).ready(function() {
		
	// 隐藏所有域
	$("#div_nickName_valide").hide();
	$("#div_nickName_un_valide").hide();
	$("#div_nickName_null").hide();
	
	$("#div_logonName_valide").hide();
	$("#div_logonName_un_valide").hide();
	$("#div_logonName_null").hide();
	
	$("#div_logonPasswd_pass").hide();
	$("#div_logonPasswd_un_pass").hide();
	
	$("#div_logonPasswdValid_pass").hide();
	$("#div_logonPasswdValid_un_pass").hide();

	// 登录名校验
	$("#logonName").blur(function() {
		var logonName = $("#logonName").val();
		// 非空
		if(logonName.length==0){
			$("#div_logonName_valide").hide();
			$("#div_logonName_un_valide").hide();
			$("#div_logonName_null").show();
			$("#logonName").focus();
			return;
		}
		
		var url_suffix = "?logonName="+logonName;
	
		var jsonResponse = jQuery.getJSON('/dreamcube/enrollment/valideUserName.json'+url_suffix,function(data){

		if(data.isValide == true){
			$("#div_logonName_un_valide").hide();
			$("#div_logonName_null").hide();
			$("#div_logonName_valide").show();
		}else{
			$("#div_logonName_valide").hide();
			$("#div_logonName_null").hide();
			$("#div_logonName_un_valide").show();
			$("#logonName").focus();
		}
		
		});
	});
	
	// 昵称校验
	$("#nickName").blur(function() {
		var nickName = $("#nickName").val();
		
		// 非空
		if(nickName.length==0){
			$("#div_nickName_un_valide").hide();
			$("#div_nickName_valide").hide();
			$("#div_nickName_null").show();
			$("#nickName").focus();
			return;
		}
		
		var url_suffix = "?nickName="+nickName;
	
		var jsonResponse = jQuery.getJSON('/dreamcube/enrollment/valideUserName.json'+url_suffix,function(data){
		
		if(data.isValide == true){
			$("#div_nickName_un_valide").hide();
			$("#div_nickName_null").hide();
			$("#div_nickName_valide").show();
		}else{
			$("#div_nickName_valide").hide();
			$("#div_nickName_null").hide();
			$("#div_nickName_un_valide").show();
			$("#nickName").focus();
		}
		
		});
	});
	
	// 密码非空校验
	$("#logonPasswd").blur(function() {
		var logonPasswd = $("#logonPasswd").val();
		
		if(logonPasswd.length==0){
			$("#div_logonPasswd_pass").hide();
			$("#div_logonPasswd_un_pass").show();
			$("#logonPasswd").focus();
		} else{
			$("#div_logonPasswd_un_pass").hide();
			$("#div_logonPasswd_pass").show();
		}
		
	});
	
	// 密码一致性校验
	$("#logonPasswdValid").blur(function() {
		var logonPasswdValid = $("#logonPasswdValid").val();
		var logonPasswd = $("#logonPasswd").val();
		
		if(logonPasswdValid != logonPasswd){
			$("#div_logonPasswdValid_pass").hide();
			$("#div_logonPasswdValid_un_pass").show();
		} else{
			$("#div_logonPasswdValid_un_pass").hide();
			$("#div_logonPasswdValid_pass").show();
		}
		
	});
	
	
	
	
});   // end of ready function


// 生日控件
 
jQuery(function($){
$('#birthday').datepicker({
	changeMonth: true,
	changeYear: true,
	rangeSelect: true,
	firstDay: 1,
	showOn: 'both'});
});
 
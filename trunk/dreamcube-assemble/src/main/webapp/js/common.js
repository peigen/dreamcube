##是否确认删除
function deleteAction() {
	var alarm = "确定要删除吗?"
	if(confirm(alarm)){
	  return true;
	}
   return false;
}


/*
*@function name:查找页面对象函数
*@param:控件名称
*/
function findObj(controlName) { //v1.01
    var control;
    try{
        control = document.getElementsByName(controlName)[0];
        return control;
    }catch(e){
        return null;
    }
}

/**
 * 获取对象，可传如n个参数
 */
function ge(){
	var ea;
	var ee;
	for(var i=0;i<arguments.length;i++){
		var e=arguments[i];
		if(typeof e=='string'){
			ee=document.getElementById(e);
			if(ee==null){
				e=document.getElementsByName(e)[0];
			}
			else{
				e=ee;
			}
		}
		if(arguments.length==1)
			return e;
		if(!ea)
			ea=new Array();
		ea[ea.length]=e;
	}
	return ea;
}

// 清空界面上所有input
function cleanAll() {
	var els = $("input:text");
	els.each(
		function(i) {
			$(this).val("");
		}
	);
	
	els = $("input:hidden");
	els.each(
		function(i) {
			$(this).val("");
		}
	);
}

// 清空某个元素
function cleanField(objId){
	ge(objId).value="";
}
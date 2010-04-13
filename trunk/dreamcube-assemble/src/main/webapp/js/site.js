function foo(){
	alert('foo');
}

/*
*@function name:翻页函数
*@param:
*totalPage		总页数
*currentPage	当前页数
*totalCount		总记录数
*perPage		每页显示记录数
*rollPage		翻页数(rollPage可以不传，默认为20)
*formName		FORM名称
*pageControl	隐藏翻页控件名称
*imgUrlPrex		图片连接地址
*
*desc:rollPage可以不传，默认为20，增加了错误处理
*
*调用方式：try{
*   _do(100,1,100000,'','form1','dddd.d','http://img.taobao.net');
*}catch(ex){
*    alert('翻页输入参数传递错误');
*}
*/
function pageSlider(totalPage,currentPage,totalCount,perPage,rollPage,formName,pageControl,imgUrlPrex){
	
	// 设置pageSize，写死
	ge('pageSize').value=perPage;
	
    try{
		if((imgUrlPrex =='') || isNaN(imgUrlPrex)){
			imgUrlPrex='/img';
		}
		
		if ((rollPage == '') ||  isNaN(rollPage)){
			rollPage=20;
		}
		  
		if ((perPage == '') ||  isNaN(perPage)){
			perPage=20;
		}
		
	    var curPage = 0 ;
	    var divisor = (currentPage - currentPage%rollPage)/rollPage;
	    if ( currentPage%rollPage == 0){
	        divisor = divisor - 1;
	    }
	    
	    var prerollPage = currentPage - 1;
	    var nextrollPage = currentPage + 1;
	    var txt = "";
	    txt = txt + "<table width=\"99%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=center style=\"margin-top:5px;\">";
	    txt = txt + "<tr>";
	    txt = txt + "<td align=\"left\" width=\"25%\">";
	    
	    if ( totalCount <= 0 ){
	       txt = txt + 0 ;
	    }else{
	       txt = txt + ((currentPage - 1)*perPage + 1);
	    }
	    
	    txt = txt + " - ";
	    if ((currentPage*perPage) > totalCount ){
	        txt = txt + totalCount;
	    }else{
	        txt = txt + (currentPage*perPage);
	    }
	    
	    txt = txt + " 共 " + totalCount + " 条 " + totalPage + " 页";
	    txt = txt + "</td>";
	    txt = txt + "<td align=\"right\">";
	    if (prerollPage > 0){
	        txt = txt + "<a href=\"#?page=1\"><img src=\""+ imgUrlPrex + "/firstPage.gif\" border=\"0\" alt=\"首页\" onclick=\"findObj('" + pageControl + "').value=1; " + formName + ".submit(); \"></img></a>";
	        txt = txt + "&nbsp;";
	        txt = txt + "<a href=\"#?page=" + prerollPage + "\"><img src=\""+ imgUrlPrex + "/prevPage.gif\" border=\"0\" alt=\"前一页\" onclick=\"findObj('" + pageControl + "').value="+prerollPage+"; " + formName + ".submit(); \" align=\"absmiddle\"></img></a>";
	    }else{
	        txt = txt + "<img src=\""+ imgUrlPrex + "/firstPage.gif\" border=\"0\" alt=\"首页\" align=\"absmiddle\"></img>";
	        txt = txt + "&nbsp;";
	        txt = txt + "<img src=\""+ imgUrlPrex + "/prevPage.gif\" border=\"0\" alt=\"前一页\" align=\"absmiddle\"></img>";
	    }
	    txt = txt + "&nbsp;";
	    
	    for(i = 1; i <= rollPage; i++){
	        curPage = rollPage*divisor + i;
	        if (curPage <= totalPage){
	            if (curPage != currentPage){
	                txt = txt + "<a href=\"#?page=" +curPage+ " \" onclick=\" ge('" + pageControl + "').value=" +curPage+ "; " + formName + ".submit(); \">" +curPage+ "</a>";
	                txt = txt + "&nbsp;";
	            }else{
	                txt = txt + "<strong>" + curPage + "</strong>";
	                txt = txt + "&nbsp;";
	            }
	        }
	    }
	    
	    if ( nextrollPage <= totalPage ){
	        txt = txt + "<a href=\"#?page=" + nextrollPage + "\" onclick=\"ge('" + pageControl + "').value=" +nextrollPage+ "; " + formName + ".submit(); \">"+
	        "<img src=\""+ imgUrlPrex + "/nextPage.gif\" border=\"0\" alt=\"后一页\"></img></a>";
	        txt = txt + "&nbsp;";
	        txt = txt + "<a href=\"#?page=" + totalPage + "\" onclick=\"findObj('" + pageControl + "').value=" +totalPage+ "; " + formName + ".submit(); \">"+
	        "<img src=\""+ imgUrlPrex + "/lastPage.gif\" border=\"0\" alt=\"尾页\" align=\"absmiddle\"></img></a>";
	    }else{
	        txt = txt + "<img src=\""+ imgUrlPrex + "/nextPage.gif\" border=\"0\" alt=\"后一页\" align=\"absmiddle\"></img>";
	        txt = txt + "&nbsp;";
	        txt = txt + "<img src=\""+ imgUrlPrex + "/lastPage.gif\" border=\"0\" alt=\"尾页\" align=\"absmiddle\"></img>";
	    }
	    txt = txt + "</td>";
	    txt = txt + "</tr>";
	    txt = txt + "</table>";
	    document.write(txt);
	    }catch(e){
	    }
	    
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
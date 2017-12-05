	
/**
 * 表单校验的一些工具函数
 * @param img
 */

	function changeImg(img){
		//改变img标签中 src的值，实现重新加载的功能  每次的访问地址都不一样，因为有变量加入，所以每次都会访问新的资源。
		img.src = img.src+"?time="+new Date().getTime();
	 }
	//检查username输入框
	function checkUsrname(){
		var canSub = true;
		var username_v = this.value;
		if(checkNull("username","用户名不能为空！")==null){
			return ;
		}else{
			
		}
	}
	function checkPhonenum(label_phonenum){
		var phonenum_v = label_phonenum.value;
		if(checkNull("phonenum","手机号码不能为空！")==null){
			return ;
		}else{
			if(phonenum_v.length!=11){
				document.getElementById("phonenum_msg").innerHTML = "<font color='red'> 请输入11 位手机号码！</font>";
			}
		}
		return ;
	}
	function checkPsw(label_psw){
		var username_v = this.value;
		if(checkNull("password","密码不能为空！")==null){
			return ;
		}else{
			
		}
	}
	function checkPsw2(label_psw2){
		var psw2 = label_psw2.value;
		var psw1 = document.getElementsByName("password")[0].value;
		if(checkNull("password2","确认密码不能为空！")==null){
			return ;
		}else{
			if(psw1!=psw2 && psw1!=null){
				document.getElementById("password2_msg").innerHTML = "<font color='red'>两次密码不一致！</font>";
			}
		}
	}
	function checkEmail(label_email){
		var email_v = label_email.value;
		checkNull("email","邮箱不能为空！");
		if(email_v!=null && email_v!="" && !/^\w+@\w+(\.\w+)+$/.test(email_v)){
			document.getElementById("email_msg").innerHTML = "<font color='red'>邮箱格式不正确！</font>";
			return ;
		} 
	}
	function checkValiImg(label_valiStr){
		var valiStr = label_valiStr.value;
		checkNull("valistr","验证码不能为空！");
		return ;
	}
	
	
	
	function checkCp_num(){
		var CP_num = label_email.value;
		checkNull("CP_num","充电桩编号不能为空！");
		if(CP_num!=null && CP_num!="" && !/^[0-9]+$/.test(email_v)){
			document.getElementById("email_msg").innerHTML = "<font color='red'>充电桩编号必须为正整数！</font>";
			return ;
		} 
	}
	function checkCp_model(){
		var CP_num = label_email.value;
		checkNull("CP_num","充电桩型号不能为空！");
		if(CP_num!=null && CP_num!="" && !/^[A-Za-z]+[0-9]+$/.test(email_v)){
			document.getElementById("email_msg").innerHTML = "<font color='red'>充电桩型号必须是字母和数字的组合！</font>";
			return ;
		} 
	}
	function checkLongitude(){
		
	}
	function checkLatitude(){
		
	}
	
	function checkNull(name,msg){
		document.getElementById(name+"_msg").innerHTML = "";
		var objValue = document.getElementsByName(name)[0].value;
		if(objValue==null || objValue==""){
		document.getElementById(name+"_msg").innerHTML = "<font color='red'>"+msg+"</font>";
			return false;
		}
		return true;
	}
	
	window.onload=function(){
  		$("input[type='text'][name='username']").blur(function(){
  			var username = $(this).val();
  			$.get("/ValiNameServlet",{username:username},function(data){
  				//将返回的数据转换成json对象
  				var json = eval("("+data+")");
  				if(json.stat==1){
  					$("#username_msg").html("<font color='red'>"+json.msg+"</font>");
  				}else if(json.stat==0){
  					$("#username_msg").html("<font color='green'>"+json.msg+"</font>");
  				}
  			});
  		});
	};
$(document).ready(function(){
	$("#delete").keyup(function() {
		var reg = /^\w+$/;
		// 如果验证失败给出警告
		if(!/^\d+$/.test(this.value)&&this.value!=''){
			alert('请输入数字');
			this.value='';
		}
		});
});
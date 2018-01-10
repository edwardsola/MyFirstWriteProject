function pay(){
	/*var appid=$("#appid").val();
	var mch_id=$("#mch_id").val();
	var device_info=$("#device_info").val();
	var nonce_str=$("#nonce_str").val();
	var sign=$("#sign").val();
	var sign_type=$("#sign_type").val();
	var body=$("#body").val();
	var detail=$("#detail").val();
	var attach=$("#attach").val();
	var out_trade_no=$("#out_trade_no").val();
	var fee_type=$("fee_type").val();
	var total_fee=$("#total_fee").val();
	var spbill_create_ip=$("#spbill_create_ip").val();
	var time_start=$("#time_start").val();
	var time_expire=$("#time_expire").val();
	var goods_tag=$("#goods_tag").val();
	var notify_url=$("#notify_url").val();
	var trade_type=$("#trade_type").val();
	var limit_pay=$("#limit_pay").val();
	var openid=$("#openid").val();
	var arr=[];*/
	var params = {};//形式
	var ids=$(":input");
	for(var i=0;i<ids.length;i++){
		var id=$(ids[i]).attr("id");
		var value=$(ids[i]).attr("value");
		//设置参数的id作为key，value作为值
		params [id] = (value==undefined?"":value); 
	}
	console.log(params);
	//var url ="https://api.mch.weixin.qq.com/pay/unifiedorder";//请求地址
	var url ="http://127.0.0.1:8080/TestWechatPay2/wechatPay.action";
	var way="xml";//文件形式
	sendToWeChat(url,params,way);
}
function sendToWeChat(url,params,way){
	alert("准备发送请求");
	$.post(url,params,function(data){
		console.log(data);//微信返回的回调
	},way);
}
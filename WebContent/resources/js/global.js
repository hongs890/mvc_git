var global = {
	context : '',
	setContext : function(param){
		this.context = param;
	},
	init : function(param){
		var bt=document.querySelector('#bt_js_go');
		this.setContext(param);
		bt.onclick=this.move();
	},
	move : function(){
		location.href=this.context+"/douglas.do";
	}
};

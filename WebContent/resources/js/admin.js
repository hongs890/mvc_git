var admin = (function() {
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){ this._pass = pass;};
	return{
		getPass : getPass,
		setPass : setPass,
		init : function(){
			document.querySelector('#a_admin').addEventListener('click', this.check, false);
		},
		check : function(){
			setPass(1);
			var isAdmin = confirm('Are you admin?');
			if (!isAdmin) {
				alert('Only admin can Access this page');
			} else {
				var password = prompt('Please input admin password');
				if (password == 1) {
					location.href = sessionStorage.getItem('context')+'/global.do';
				}else{
					alert('Please check admin password');
				}
			}
		}
	};
})();
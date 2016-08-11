var move = function(context,page){
		location.href=context+'/douglas.do?page='+page;
	}

var douglas = (function(){
	var context = sessionStorage.getItem('context');
	return{
		init : function(){
			document.querySelector('#bt_bom').addEventListener('click',function(){move(context,'bom');},false);
			document.querySelector('#bt_dom').addEventListener('click',function(){move(context,'dom');},false);
			document.querySelector('#bt_kaup').addEventListener('click',function(){move(context,'kaup');},false);
			document.querySelector('#bt_account').addEventListener('click',function(){move(context,'account');},false);
		}
	};
})();

var account = (function(){
	var _account_no = 0, _money =0;
	return{
		init : function(){
			document.querySelector('#bt_spec_show').addEventListener('click',member.spec,false);
			document.querySelector('#bt_make_account').addEventListener('click',this.spec,false);
			document.querySelector('#bt_deposit').addEventListener('click',this.deposit,false);
			document.querySelector('#bt_withdraw').addEventListener('click',this.withdraw,false);
		},
		spec : function(){
			this.account_no = Math.floor(Math.random() * 899999) + 100000;
			document.querySelector('#result_account').innerHTML = this.account_no;
			_money = 0;
		},
		deposit : function(){
			var money = Number(document.querySelector('#money').value);
			_money = money + _money;
			document.querySelector('#rest_money').innerHTML = _money;
		},
		withdraw : function(){
			var money = Number(document.querySelector('#money').value);
			_money = _money - money;
			document.querySelector('#rest_money').innerHTML = _money;
		}
	};
})();

var member =(function(){
	var _ssn, _name, _gender, _age;
	return{
		spec : function(){
			
			_name = document.querySelector('#name').value;
			_ssn = document.querySelector('#ssn').value;
			var now = new Date().getFullYear();
			var ssnArr = _ssn.split("-");
		    var ageResult1 =ssnArr[0];
		    var genderResult = ssnArr[1];
		    var ageResult0 = 0;
		    
		     switch (Number(genderResult)) {
		         case 1: case 5:
		        	 _age = now-(1899+(ageResult1 /10000));
		             _gender = "남";
		             break;
		         case 3: case 7:
		        	_age = now-(1999+(ageResult1 /10000));
		            _gender = "남" ;
		         break;
		         case 2: case 6:
		        	 _age = now-(1899+(ageResult1 /10000));
		            _gender = "여" ;
		         break;
		         case 4: case 8:
		             _age = now-(1999+(ageResult1 /10000));
		            _gender = "여";
		         break;
		    }
		     document.querySelector('#result_name').innerHTML =_name;
		     document.querySelector('#result_gender').innerHTML = _gender;
		     document.querySelector('#result_age').innerHTML = Math.floor(_age);
		}
	};
})();

var kaup = (function(){
	var _name = '', _result='';
	return{
		init : function(){
			document.querySelector('#bt_kaup_calc').addEventListener('click',this.calc,false);
		},
		calc : function(){
			_name = document.querySelector('#name').value;
			var height = document.querySelector('#height').value;
			var weight = document.querySelector('#weight').value;
			var kaup = weight / (height / 100) / (height / 100);
			if (kaup < 18.5) {
		         _result = "저체중";
		    } else if (kaup >= 18.5 && kaup < 23) {
		    	_result = "정상체중" ;
		    } else if (kaup >= 23 && kaup < 25) {
		    	_result = "위험체중" ;
		    } else if (kaup >= 25 && kaup < 30) {
		    	_result = "비만 1단계" ;
		    } else if (kaup >= 30 && kaup < 40) {
		    	_result = "비만 2단계" ;
		    }
		     if (kaup >= 40) {
		    	 _result = "비만 3단계" ;
		    }
		     document.querySelector('#result').innerHTML=_name +"은 BMI지수는 "+Math.floor(kaup)+"이고," +_result +"이다.";
		}
	};
})();


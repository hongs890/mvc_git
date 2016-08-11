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
	var _account_no, _money;
	var setAccountNo = function(account_no){this._account_no = account_no;}
	var getAccountNo = function(){return this._account_no;}
	var setMoney = function(money){this._money=money;}
	var getMoney = function(){return this._money;}
	return{
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : function(){
			document.querySelector('#bt_spec_show').addEventListener('click',member.spec,false);
			document.querySelector('#bt_make_account').addEventListener('click',this.spec,false);
			document.querySelector('#bt_deposit').addEventListener('click',this.deposit,false);
			document.querySelector('#bt_withdraw').addEventListener('click',this.withdraw,false);
		},
		spec : function(){
			setAccountNo(Math.floor(Math.random() * 899999) + 100000);
			document.querySelector('#result_account').innerHTML = getAccountNo();
			setMoney(0);
		},
		deposit : function(){
			var money = Number(document.querySelector('#money').value);
			console.log("인풋머니체크 : "+(typeof money === 'number'));
			setMoney(getMoney() + money);
			document.querySelector('#rest_money').innerHTML = getMoney();
		},
		withdraw : function(){
			var money = Number(document.querySelector('#money').value);
			setMoney(getMoney() - money);
			document.querySelector('#rest_money').innerHTML = getMoney();
		}
	};
})();

var member =(function(){
	var _ssn, _name, _gender, _age;
	var setAge = function(age){this._age=age;}
	var setGender = function(gender){this._gender=gender;}
	var setSsn = function(ssn){this._ssn=ssn;}
	var setName = function(name){this._name=name;}
	var getAge = function(){return this._age;}
	var getGender = function(){return this._gender;}
	var getSsn = function(){return this._ssn;}
	var getName = function(){return this._name;}
	return{
		setAge : setAge,
		setGender : setGender,
		setSsn : setSsn,
		setName : setName,
		getAge : getAge,
		getGender : getGender,
		getSsn : getSsn,
		getName : getName,
		spec : function(){
			setName(document.querySelector('#name').value);
			setSsn(document.querySelector('#ssn').value);
			var now = new Date().getFullYear();
			var ssnArr = getSsn().split("-");
		    var ageResult1 =ssnArr[0];
		    var genderResult = ssnArr[1].toString().substring(0, 1);
		    var ageResult0 = 0;
		    
		     switch (genderResult) {
		         case "1": case "5":
		        	 setAge(now-(1899+(ageResult1 /10000)));
		             setGender("남");
		             break;
		         case "3": case "7":
		        	setAge(now-(1999+(ageResult1 /10000)));
		            setGender("남");
		         break;
		         case "2": case "6":
		        	 setAge(now-(1899+(ageResult1 /10000)));
		             setGender("여");
		         break;
		         case "4": case "8":
		             setAge(now-(1999+(ageResult1 /10000)));
		             setGender("여");
		         break;
		    }
		     document.querySelector('#result_name').innerHTML =getName();
		     document.querySelector('#result_gender').innerHTML = getGender();
		     document.querySelector('#result_age').innerHTML = Math.floor(getAge());
		}
	};
})();

var kaup = (function(){
	var _name, _result, _height, _weight;
	setName = function(name){this._name = name;}
	setResult = function(result){this._result = result;}
	setHeight = function(height){this._height = height;}
	setWeight = function(weight){this._weight = weight;}
	getName = function(){return this._name;}
	getResult = function(){return this._result;}
	getHeight = function(){return this._height;}
	getWeight = function(){return this._weight;}
	return{
		setName : setName,
		setResult : setResult,
		setHeight : setHeight,
		setWeight : setWeight,
		getName : getName,
		getResult : getResult,
		getHeight : getHeight,
		getWeight : getWeight,
		init : function(){
			document.querySelector('#bt_kaup_calc').addEventListener('click',this.calc,false);
		},
		calc : function(){
			setName(document.querySelector('#name').value);
			setHeight(document.querySelector('#height').value);
			setWeight(document.querySelector('#weight').value);
			var kaup = getWeight() / (getHeight() / 100) / (getHeight() / 100);
			if (kaup < 18.5) {
		         setResult("저체중");
		    } else if (kaup >= 18.5 && kaup < 23) {
		    	 setResult("정상체중");
		    } else if (kaup >= 23 && kaup < 25) {
		    	setResult("위험체중");
		    } else if (kaup >= 25 && kaup < 30) {
		    	setResult("비만 1단계");
		    } else if (kaup >= 30 && kaup < 40) {
		    	setResult("비만 2단계");
		    }
		     if (kaup >= 40) {
		    	 setResult("비만 3단계");
		    }
		     document.querySelector('#result').innerHTML=getName() +"은 BMI지수는 "+Math.floor(kaup)+"이고," +getResult() +"이다.";
		}
	};
})();


var context = {
	name : '',
	setContext : function(context){
		this.name = context;
	},
	init : function(context){
		this.setContext(context);
		var bt_bom = document.querySelector('#bt_bom');
		var bt_dom = document.querySelector('#bt_dom');
		var bt_kaup = document.querySelector('#bt_kaup');
		var bt_creator = document.querySelector('#bt_creator');
		bt_bom.addEventListener('click',this.bom_go,false);
		bt_dom.addEventListener('click',this.dom_go,false);
		bt_kaup.addEventListener('click',kaup_go,false);
		bt_creator.addEventListener('click',this.creator_go,false);
		console.log('디버깅 :' +this.name);
	},
	bom_go : function(){
		location.href=this.name+'/douglas.do?page=bom';
	},
	dom_go : function(){
		location.href=this.name+'/douglas.do?page=dom';
	},
	creator_go : function(){
		location.href=this.name+'/douglas.do?page=creator';
	}
};

var create = {
		creator_init : function(){
			document.querySelector('#bt_spec_show').
			addEventListener('click',member_spec,false);
			document.querySelector('#bt_make_account').
			addEventListener('click',account_spec,false);
			document.querySelector('#bt_deposit').
			addEventListener('click',account_deposit,false);
			document.querySelector('#bt_withdraw').
			addEventListener('click',account_withdraw,false);
		}
};

var member ={};

function kaup_init(){
	var bt_kaup_calc = document.querySelector('#bt_kaup_calc');
	bt_kaup_calc.addEventListener('click',kaup_calc,false);
}

//==================


function kaup_go(){
	location.href=context+'/douglas.do?page=kaup';
}


//==================

function account_deposit(){
	document.querySelector('#rest_money').innerHTML = document.querySelector('#money').value;
	
}

function account_withdraw(){
	document.querySelector('#rest_money').innerHTML = document.querySelector('#money').value;
}

function account_spec(){
	var account = {
		account_no : 0,
		money : 0
	}
	document.querySelector('#result_account').innerHTML = Math.floor(Math.random() * 899999) + 100000;	
}

function member_spec(){
	var member = new Object();
	member.name = document.querySelector('#name').value;
	member.ssn = document.querySelector('#ssn').value;
	member.age = 0;
	member.gender = '';
	var now = new Date().getFullYear();

	var ssnArr = member.ssn.split("-");
    var ageResult1 =ssnArr[0];
    var genderResult = ssnArr[1].toString().substring(0, 1);
    var ageResult0 = 0;
    
     switch (genderResult) {
         case "1": case "5":
        	 member.age = now-(1899+(ageResult1 /10000));
             member.gender = "남";
             break;
         case "3": case "7":
        	 member.age = now-(1999+(ageResult1 /10000));
             member.gender = "남" ;
         break;
         case "2": case "6":
        	 member.age = now-(1899+(ageResult1 /10000));
             member.gender = "여" ;
         break;
         case "4": case "8":
             member.age = now-(1999+(ageResult1 /10000));
             member.gender = "여";
         break;
    }
     document.getElementById('result_name').innerHTML = member.name;
     document.getElementById('result_gender').innerHTML = member.gender;
     document.getElementById('result_age').innerHTML = Math.floor(member.age);
}

function kaup_calc(){
	var name = document.querySelector('#name').value;
	var height = document.getElementById('height').value;
	var weight = document.getElementById('weight').value;
	console.log('name'+name);
	console.log('height'+height);
	console.log('weight'+weight);
	var result = '';
	var kaup = weight / ( height / 100) / (height / 100);
	if (kaup < 18.5) {
         result = "저체중";
    } else if (kaup >= 18.5 && kaup < 23) {
         result = "정상체중" ;
    } else if (kaup >= 23 && kaup < 25) {
         result = "위험체중" ;
    } else if (kaup >= 25 && kaup < 30) {
         result = "비만 1단계" ;
    } else if (kaup >= 30 && kaup < 40) {
         result = "비만 2단계" ;
    }
     if (kaup >= 40) {
         result = "비만 3단계" ;
    }
     document.getElementById('result').innerHTML=name +"은 BMI지수는 "+kaup+"이고," +result +"이다.";
}
	var context ='';
	
	function getContext(){
		return this.context;
	}
	function setContext(context){
		this.context = context;
	}

function init(context){
	var bt_bom = document.querySelector('#bom');
	var bt_dom = document.querySelector('#dom');
	var bt_kaup = document.querySelector('#kaup');
	var kaup_calc = document.querySelector('#kaup_calc');
	console.log('CONTEXT : '+context);
	this.setContext(context);
	console.log('CONTEXT : '+this.getContext());
	
	bt_bom.addEventListener('click',bom_go,false);
	bt_dom.addEventListener('click',dom_go,false);
	bt_kaup.addEventListener('click',kaup_go,false);
	
}

function bom_go(){
	console.log('TEST : ' + this.getContext());
	location.href=getContext()+'/douglas.do?page=bom';
}
function dom_go(){
	location.href=getContext()+'/douglas.do?page=dom';
}

function kaup_go(){
	location.href=getContext()+'/douglas.do?page=kaup';
}


//==================
function kaup_init(){
	var bt_kaup_calc = document.querySelector('#bt_kaup_calc');
	bt_kaup_calc.addEventListener('click',kaup_calc,false);
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
/**
 * 2023/01/19
 */
window.addEventListener('load', ()=>{
	document.getElementById('btnCheckUid').addEventListener('click', IdCheck);
	document.querySelector('input[name=uid]').addEventListener('change', IdChange);
	document.getElementById('passCheck').addEventListener('change', passwordCheck);
	document.querySelector('input[name=name]').addEventListener('change', NameCheck);
});

// 정규표현식
const reUid = /^[a-z]+[a-z0-9]{5,19}$/g;
const rePass = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,254}$/;
const reName = /^[ㄱ-힣]+$/;
const reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
const reHp = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;

// 확인 체크
let passOk = false
let IdOk = false
let isNameOk = false

// 이름 유효성 체크
function NameCheck() {
	const name = this.value
	const resultName = this.nextSibling;
	
	console.log(resultName)
	
	if(name.match(reName)) {
		isNameOk = true;
		resultName.innerText = ''
	} else {
		isNameOk = false;
		resultName.innerText = '이름을 정확히 입력하세요.'
	}
	
}

// 비밀번호 유효성 체크
function passwordCheck() {
	const pass = document.querySelector('input[name=pass]');
	const passCheck = document.querySelector('input[name=passCheck]')
	const resultPass = document.querySelector('.resultPass');
	
	if(passCheck.value.match(rePass)){
		if(pass.value != passCheck.value){
			resultPass.innerText = '비밀번호가 일치 하지 않습니다.'
			resultPass.style.color = 'red';
			passOk = false
		} else {
			resultPass.innerText = '사용할수 있는 비밀번호 입니다.'
			resultPass.style.color = 'green';
			passOk = true
		}
	} else {
		passOk = false
		resultPass.innerText = '비멀번호는 숫자,영문,특수문자 포함 8자리 이상 이어야 합니다.'
		resultPass.style.color = 'pink'
	}
}

// 아이디 변경 함수
function IdChange() {
	IdOk = false;
	document.querySelector('.resultUid').innerText = '';	
}

// 아이디 중복 확인
function IdCheck(){
	
	if(IdOk) {
		return;
	}
	
	const uid = document.querySelector('input[name=uid]').value;
	const resultUid = document.querySelector('.resultUid');
	
	if(!uid.match(reUid)) {
		IdOk = false;
		resultUid.innerText = '6자리 이상 숫자 영문을 포함한 아이디여야 합니다.';
		resultUid.style.color = 'red';
		return;
	}
	
	// AJAX 전송
	const xhr = new XMLHttpRequest();
	xhr.open("GET", "/Farmstory/user/checkUid?uid="+uid);
	xhr.responseType = "json";
	xhr.send();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == XMLHttpRequest.DONE){
			if(xhr.status != 200) alert("Request fail...")
			else {
				const data = xhr.response;
				
				if(data.result == 1){
					resultUid.innerText = '이미 사용중인 아이디 입니다.';
					resultUid.style.color = 'red';
					IdOk = false
				} else {
					resultUid.innerText = '사용 가능한 아이디 입니다.';
					resultUid.style.color = 'green';
					IdOk = true
				}
			
			}
		}
	}
};

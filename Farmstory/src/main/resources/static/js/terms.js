window.addEventListener('load', ()=>{
    document.getElementById('btnNext').addEventListener('click',btnNextClick);
});

function btnNextClick() {
    event.preventDefault();
    if(document.querySelector('input[class=terms]').checked && document.querySelector('input[class=privacy]').checked) {
        alert('약관 동의를 하셨습니다.');
        location.href='/Farmstory/user/register';
    }else{
        alert('약관 동의를 하셔야합니다.');
    }
}
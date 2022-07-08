
// student sign up form

const student_sign_form = document.getElementById('stu_signup_form');
const reg_no = document.getElementById('registration_no');
const firstName = document.getElementById('fist_name');
const lastName = document.getElementById('last_name');
const address = document.getElementById('address');
const userName2 = document.getElementById('username2');
const pwd = document.getElementById('password2');
const pwdConfirm = document.getElementById('confirmPassword');
const email = document.getElementById('email');
const phoneNumber = document.getElementById('phoneNumber');
const date = document.getElementById('date');
const program = document.getElementById('program');

student_sign_form.addEventListener('submit', (e) => {

    e.preventDefault();

    checkInput();
});

function checkInput() {

   const reg_noValue = reg_no.value.trim();

    if (reg_noValue == '') {
        setErrorFor(reg_no, 'Registration Number Cannot Be Empty!')
    } else {
        
    }

}

function setErrorFor(input, message) {
    const formGroup = input.parentElement;
    const small = formGroup.querySelector('small');

    // add error msg inside small tag
    small.innerText = message;

    // add error class
    // formGroup.className = 'form-group error';
    formGroup.className = 'form-group error';

}
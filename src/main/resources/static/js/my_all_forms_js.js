
const form = document.getElementById('form');
const username = document.getElementById('username');
const password = document.getElementById('password');

btn_submit.addEventListener('submit', (e) => {
    e.preventDefault();

    checkInput();

});


function checkInput() {
    // get values in the input
    const usernameValue = username.value.trim();
    const passwordValue = password.value.trim();

    if (usernameValue == '') {
        // show error
        // add error class
        setErrorFor(username, 'Username Cannot Be Empty!');
        return false;

    } else {
        // add success class
        setSuccessFor(username);
    }

    // password input
    if (passwordValue == '') {
        setErrorFor(password, 'Password Cannot Be Empty!');
        return false;
    } else if (passwordValue.length < 8) {
        setErrorFor(password, 'Password Cannot Be Less Than 8 Characters.');
        return false;
    }
     else {
        setSuccessFor(password);
    }

}

function setErrorFor(input, message) {
    const formControl = input.parentElement;  // .fm-control
    const small = formControl.querySelector('small');

    // add error msg inside small tag
    small.innerText = message;

    // add error class
    formControl.className = 'form-group error';
    
}

function setSuccessFor(input) {
    const formControl = input.parentElement;

    // add success class
    formControl.className = 'form-group success';
}


// hide passord
const iconPassword = document.querySelector("#iconPassword");
const password_hide = document.querySelector("#password");

iconPassword.addEventListener("click", function () {
    // toggle the type attribute
    const type = password.getAttribute("type") === "password" ? "text" : "password";
    password_hide.setAttribute("type", type);
    
    // toggle the icon
    this.classList.toggle("bi-eye");
});
// end of hide passord

// student sign up form


const firstName = document.getElementById('first_name');
const lastName = document.getElementById('last_name');
const username = document.getElementById('username');
const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirm_password');
const address = document.getElementById('address');
const email = document.getElementById('email');
const phoneNo = document.getElementById('phonoNo');


btn_submit.addEventListener('submit', (e) => {

    e.preventDefault();

    checkInput();
});

function checkInput() {

    const firstName_value = firstName.value.trim();
    const lastName_value = lastName.value.trim();
    const username_value = username.value.trim();
    const password_value = password.value.trim();
    const confirmPassword_value = confirmPassword.value.trim();
    const address_value = address.value.trim();
    const email_value = email.value.trim();
    const phoneNo_value = phoneNo.value.trim();


    if (firstName_value == '') {
        swal({
            title: "Error!",
            text: "First Name Cannot Be Empty!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (lastName_value == '') {
        swal({
            title: "Error!",
            text: "Last Name Cannot Be Empty!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (username_value == '') {
        swal({
            title: "Error!",
            text: "Username Cannot Be Empty!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (password_value == '') {
        swal({
            title: "Error!",
            text: "Password Cannot Be Empty!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (password_value.length < 8) {
        swal({
            title: "Error!",
            text: "Password Cannot Be Less Than 8 Characters!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (confirmPassword_value == '') {
        swal({
            title: "Error!",
            text: "Confirm Password Cannot Be Empty!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (password_value !== confirmPassword_value) {
        swal({
            title: "Error!",
            text: "Password Don't Match!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (address_value == '') {
        swal({
            title: "Error!",
            text: "Address Must Be Filled!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (email_value == '') {
        swal({
            title: "Error!",
            text: "Email Must Be Filled!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (email_value == '') {
        swal({
            title: "Error!",
            text: "Email Must Be Filled!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (!isEmail(email_value)) {
        swal({
            title: "Error!",
            text: "Email is not valid!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } else if (phoneNo_value == '') {
        swal({
            title: "Error!",
            text: "Phone Number Must Be Filled!!",
            icon: "warning",
            button: "Okay",
          });
        return false;

    } 


    //    validate e-mail
    function isEmail(email) {
        return /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email);
    }


}

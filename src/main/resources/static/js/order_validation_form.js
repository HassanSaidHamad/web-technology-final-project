
const orderDetails = document.getElementById('order_details');
const orderQunatity = document.getElementById('order_quantity');
const orderDate = document.getElementById('order_date');

btn_order_submit.addEventListener('submit', (e) => {

  e.preventDefault();

  checkInput();
});

function checkInput() {

    const orderDetails_value = orderDetails.value.trim();
    const orderQunatity_value = orderQunatity.value.trim();
    const orderDate_value = orderDate.value.trim();

    if (orderDetails_value == '') {
        swal({
            title: "Error!",
            text: "Oerder Details Cannot Be Empty!",
            icon: "warning",
            button: "Okay",
        });
        return false;

    } else if (orderQunatity_value == 0) {
        swal({
            title: "Error!",
            text: "Order Quantity Must Be Filled!",
            icon: "warning",
            button: "Okay",
        });
        return false;

    }
    else if (orderDate_value == '') {
        swal({
            title: "Error!",
            text: "Order Date Must Be Filled!",
            icon: "warning",
            button: "Okay",
        });
        return false;

    } 

}
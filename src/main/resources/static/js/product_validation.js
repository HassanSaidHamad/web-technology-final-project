
const proName = document.getElementById('product_name');
const prodesc = document.getElementById('product_desc');
const proPrice = document.getElementById('product_price');

btn_product_submit.addEventListener('submit', (e) => {

  e.preventDefault();

  checkInput();
});

function checkInput() {

    const product_name_value = proName.value.trim();
    const prodesc_value = prodesc.value.trim();
    const proPrice_value = proPrice.value.trim();

    if (product_name_value == '') {
        swal({
            title: "Error!",
            text: "Product Name Cannot Be Empty!",
            icon: "warning",
            button: "Okay",
        });
        return false;

    } else if (prodesc_value == '') {
        swal({
            title: "Error!",
            text: "Product Description Must Be Filled!",
            icon: "warning",
            button: "Okay",
        });
        return false;

    }
    else if (proPrice_value == 0) {
        swal({
            title: "Error!",
            text: "Product Price Must Be Filled!",
            icon: "warning",
            button: "Okay",
        });
        return false;

    }

}
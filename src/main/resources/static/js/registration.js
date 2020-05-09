function registration(){
    let username = document.getElementById("username");
    let password = document.getElementById("password");
    let successLabel = document.getElementById("appointmentSuccess");
    let errorLabel = document.getElementById("appointmentError");

    console.log(username.value)
    console.log(password.value)

    $.ajax('/registerUser', {
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            name: username.value,
            password: password.value,
            role: 'ROLE_CUSTOMER'
        }),
        success: function (result) {

            console.log(result)

            let messageNode = document.createTextNode(JSON.parse(result).message);
            successLabel.appendChild(messageNode);
            reloadCss();

            setTimeout(function () {
                successLabel.removeChild(messageNode);
            }, 4000);

        },
        error: function (result) {

            console.log(result)

            let messageNode = document.createTextNode(JSON.parse(result.responseText).message);
            errorLabel.appendChild(messageNode);
            reloadCss();

            setTimeout(function () {
                errorLabel.removeChild(messageNode);
            }, 4000);
        }
    });

}
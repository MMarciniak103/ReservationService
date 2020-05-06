 function makeAppointment() {
    let specialization = document.getElementById("specialization");
    let date = document.getElementById("date");
    let institution = document.getElementById("institution");
    let successLabel = document.getElementById("appointmentSuccess");
    let errorLabel = document.getElementById("appointmentError");

    $.ajax('/makeAppointment', {
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            specialization:specialization.value,
            date:date.value,
            institution:institution.value
        }),
        success: function(result){
            successLabel.empt

            let messageNode = document.createTextNode(JSON.parse(result).message);
            successLabel.appendChild(messageNode);
            reloadCss();

            setTimeout(function () {
                successLabel.removeChild(messageNode);
            },4000);
        },
        error: function (result) {


            let messageNode = document.createTextNode(JSON.parse(result.responseText).message);
            errorLabel.appendChild(messageNode);
            reloadCss();

            setTimeout(function () {
                errorLabel.removeChild(messageNode);
            },4000);
        }
    });
}

 function reloadCss()
 {
     var links = document.getElementsByTagName("link");
     for (var cl in links)
     {
         var link = links[cl];
         if (link.rel === "stylesheet")
             link.href += "";
     }
 }

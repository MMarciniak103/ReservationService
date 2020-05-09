function addDoctor() {

    let specialization = document.getElementById("specialization");
    let institution = document.getElementById("institution");
    let errorLabel = document.getElementById("appointmentError");


    console.log(specialization.value);
    console.log(institution.value);

    $.ajax('/addDoctor', {
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            specialization: specialization.value,
            institution: institution.value
        }),
        success: function (data) {
            let inst_label = document.getElementById("institution-label");
            let spec_label = document.getElementById("specialization-label");

            inst_label.innerText = "Institution: " + data.institution;
            spec_label.innerText = "Specialization: " + data.specialization;

            console.log(data);
        },
        error: function (data) {
            console.log(JSON.parse(data.responseText).message);


            let messageNode = document.createTextNode(JSON.parse(data.responseText).message);
            errorLabel.appendChild(messageNode);
            reloadCss();

            setTimeout(function () {
                errorLabel.removeChild(messageNode);
            }, 4000);
        }
    });

}
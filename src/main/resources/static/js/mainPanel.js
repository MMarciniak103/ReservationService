 function makeAppointment() {
    let specialization = document.getElementById("specialization");
    let date = document.getElementById("date");
    let institution = document.getElementById("institution");


    $.ajax('/makeAppointment', {
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            specialization:specialization.value,
            date:date.value,
            institution:institution.value
        })
    });
}

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
            specialization: specialization.value,
            date: date.value,
            institution: institution.value
        }),
        success: function (result) {

            let messageNode = document.createTextNode(JSON.parse(result).message);
            successLabel.appendChild(messageNode);
            reloadCss();

            setTimeout(function () {
                successLabel.removeChild(messageNode);
            }, 4000);

            getAppointments();

        },
        error: function (result) {


            let messageNode = document.createTextNode(JSON.parse(result.responseText).message);
            errorLabel.appendChild(messageNode);
            reloadCss();

            setTimeout(function () {
                errorLabel.removeChild(messageNode);
            }, 4000);
        }
    });

}

function reloadCss() {
    var links = document.getElementsByTagName("link");
    for (var cl in links) {
        var link = links[cl];
        if (link.rel === "stylesheet")
            link.href += "";
    }
}

function getAppointments(){
    $.ajax('/getAppointments/' + userName, {
        type: 'GET',
        success: function (data) {
            populateTable(data);
        }
    });
}

function populateTable(data) {

    let table = document.getElementById("appointment-table");
    let tbody = table.lastElementChild;

    tbody.innerHTML = "";



    data.forEach(function (value, index) {
        console.log(index, value);
        let row = tbody.insertRow(-1);

        let dateCell = row.insertCell(0);
        dateCell.innerText = value.date;
        let specializationCell = row.insertCell(1);
        specializationCell.innerText = value.doctor.specialization;
        let institutionCell = row.insertCell(2);
        institutionCell.innerText = value.doctor.institution;
        let cancelCell =  row.insertCell(3);

        let cancelBtn = document.createElement("input");
        cancelBtn.type = "button";
        cancelBtn.className = "btn";
        cancelBtn.value = "Cancel";
        cancelBtn.onclick = (function() {
            $.ajax("/cancelAppointment/"+value.id,{
                type:'DELETE',
                success: function () {
                    getAppointments();
                }
            })
        });

        cancelCell.appendChild(cancelBtn);

    });
}
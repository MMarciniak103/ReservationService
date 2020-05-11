function makeAppointment(appointment) {

    let successLabel = document.getElementById("appointmentSuccess");
    let errorLabel = document.getElementById("appointmentError");

    $.ajax('/makeAppointment', {
        type: 'POST',
        contentType: 'application/json',
        data: appointment,
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

function getAppointments() {
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
        dateCell.innerText = value.date + " " + value.time;
        let specializationCell = row.insertCell(1);
        specializationCell.innerText = value.doctor.specialization;
        let institutionCell = row.insertCell(2);
        institutionCell.innerText = value.doctor.institution;
        let cancelCell = row.insertCell(3);


        let cancelBtn = document.createElement("input");
        cancelBtn.type = "button";
        cancelBtn.className = "btn";
        cancelBtn.value = "Cancel";
        cancelBtn.onclick = (function () {
            $.ajax("/cancelAppointment/" + value.id, {
                type: 'DELETE',
                success: function () {
                    getAppointments();
                }
            })
        });

        cancelCell.appendChild(cancelBtn);

    });
}


function chooseTime() {

    let specialization = document.getElementById("specialization");
    let date = document.getElementById("date");
    let institution = document.getElementById("institution");


    $.ajax("/timePanel", {
        type: 'GET',
        success: function (data) {
            console.log($("#time-panel"));
            $("#time-panel").empty();
            $("#time-panel").append(data);
            reloadCss();


            $.ajax("/availableHours", {
                type: "POST",
                contentType: 'application/json',
                data: JSON.stringify({
                    specialization: specialization.value,
                    date: date.value,
                    time: null,
                    institution: institution.value
                }),
                success: function (data) {
                    var workingFrom = 7;
                    var workingTo = 16;

                    $.ajax("/getDoctor", {
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify({
                            specialization: specialization.value,
                            institution: institution.value
                        }),
                        success: function (doctor) {
                            workingFrom = doctor.workingFrom;
                            workingTo = doctor.workingTo;

                            console.log(data);

                            console.log(workingFrom);
                            console.log(workingTo);
                            for (let i = 7; i < 21; i++) {
                                let hourOption = document.createElement("option");
                                if (i <= 9)
                                    hourOption.value = "0" + i + ":00:00";
                                else
                                    hourOption.value = i + ":00:00";
                                hourOption.text = i + ":00";
                                hourOption.id = "hour-option" + i.toString();
                                if (i < workingFrom || i > workingTo) {
                                    hourOption.style.color = 'red';
                                    $("#time-select").append(hourOption);
                                } else {
                                    hourOption.style.color = '#03b406';
                                    $("#time-select").append(hourOption);
                                }
                            }
                            data.forEach(function (value, index) {
                                // let appointment = JSON.parse(value);
                                console.log("index: " + index + "  value: " + value.time);
                                console.log(value.time.split(":"));

                                let timeValue = parseInt(value.time.split(":")[0]);
                                let option = document.getElementById("hour-option" + timeValue);
                                option.style.color = "red";
                            });
                            reloadCss();


                        }
                    });

                }
            });


        }
    });
}

function confirmTime() {
    let specialization = document.getElementById("specialization");
    let date = document.getElementById("date");
    let institution = document.getElementById("institution");
    let time = document.getElementById("time-select");

    console.log(time.value);

    let appointment = JSON.stringify({
        specialization: specialization.value,
        date: date.value,
        time: time.value,
        institution: institution.value
    });

    $("#time-panel").empty();

    makeAppointment(appointment);
}



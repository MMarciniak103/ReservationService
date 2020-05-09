
function addDoctor() {

    let specialization = document.getElementById("specialization");
    let institutiton = document.getElementById("institution");

    $.ajax('/addDoctor', {
        type: 'POST',
        contentType: 'application/json',
        data: {
            specialization:specialization.value,
            institutiton:institutiton.value
        },
        success: function (data) {
           console.log(data.body);
        },
        error: function (data) {
            console.log(JSON.parse(data.responseText).message);
        }
    });

}
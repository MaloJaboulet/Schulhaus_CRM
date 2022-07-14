$(document).ready(function () {
    alert("Here");
    showMessage("empty", " ");


    $("#schuelerEditForm").submit(saveSchueler);


    $("#cancel").click(function () {
        window.location.href = "";
    });
});


function saveSchueler(form) {
    form.preventDefault();

    var list = document.getElementById("schuelerEditForm").elements;

    var schueler = {
        vorname: list["vorname"].val(),
        nachname:list["nachname"].val(),
        klasse:list["klasse"].val(),
        password: list["password"].val()
    }

    alert(schueler);

    $
        .ajax({
            url: "localhost:8080/api/v1/schueler",
            type: "post",
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify(schueler)
        })
        .done(function (jsonData) {
            window.location.href = "localhost:8080/schueler";
        })
        .fail(function (xhr, status, errorThrown) {
            showMessage("error", xhr.responseText);
        })
}
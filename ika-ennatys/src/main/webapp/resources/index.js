var duplicateClick = false;
$(document).ready(function () {
    $(".link").click(function(e) {
        duplicateClick = true;
    });
});
function update(tr, id, name, value, user, date, evidence, history) {
    if (duplicateClick) {
        duplicateClick = false;
        return;
    }
    $(".modal-title #name").text(name);
    $("#updateForm input#value").val(value);
    $("#updateForm input#user").val(user);
    $("#updateForm input#date").val(now());
    $("#updateForm input#evidence").val(evidence);
    $("#updateForm input#id").val(id);
    $("#updateModal .modal-dialog").css("top", $(tr).position().top - 500);
    $("#updateForm input").each(function (i, obj) {
        $(obj).parent(".form-group").removeClass("has-error has-feedback");
    });
    if (history.length) {
        var a = generateHistoryTable(history);
        $("#updateModal #history").html(a);
    }
    $("#updateModal").modal("show");
}
function submitUpdateForm() {
    if (!$("#updateForm")[0].checkValidity()) {
        $("#updateForm :invalid").each(function(i, obj) {
            $(obj).parent(".form-group").addClass("has-error has-feedback");
        });
        return;
    }
    $("#updateForm").submit();
}
function now() {
    var d = new Date();
    return pad(d.getDate()) + "." + pad(d.getMonth()+1) + "." + d.getFullYear();
}
function pad(n) {
    return n < 10 ? "0" + n : n;
}
function generateHistoryTable(history) {
    var table = $("<table id='historyTable'><thead><th>Ennätys</th><th>Haltija</th><th>Aika</th><th></th></thead></table>")
    for (var i = 0; i < history.length; i++) {
        var tr = $("<tr />");
        tr.append("<td class='value'>" + history[i].value + "</td>")
        tr.append("<td class='user'>" + history[i].user + "</td>")
        tr.append("<td class='date'>" + history[i].date + "</td>")
        tr.append("<td><a href='" + history[i].evidence + "' target='_blank'><span class='glyphicon glyphicon-new-window'></span></a></td>")
        table.append(tr);
    }
    return table;
}
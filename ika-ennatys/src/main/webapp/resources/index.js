function update(tr, id, name, value, user, date, evidence) {
    $(".modal-title #name").text(name);
    $("#updateForm input#value").val(value);
    $("#updateForm input#user").val(user);
    $("#updateForm input#date").val(now());
    $("#updateForm input#evidence").val(evidence);
    $("#updateForm input#id").val(id);
    $("#updateModal .modal-dialog").css("top", $(tr).position().top - 500);
    $("#updateModal").modal("show");
}
function now() {
    var d = new Date();
    return pad(d.getDate()) + "." + pad(d.getMonth()+1) + "." + d.getFullYear();
}
function pad(n) {
    return n < 10 ? "0" + n : n;
}
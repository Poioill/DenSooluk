function showExtraField() {
  var role = document.getElementById("selectRole").value;
  if (role == "ADMIN") {
    document.getElementById("extraField").innerHTML = '<input type="text" name="extraField" />';
  }
}
$(document).ready(function() {
  $("#login").submit(function(event) {
    event.preventDefault();

    var formData = {
      userId: $("#userid").val(),
      password: $("#password").val()
    };

    $.ajax({
      type: "POST",
      url: "/bin/newsportal/service/user-loing",
      data: formData,
      success: function(response) {
        alert(response);
      },
      error: function(xhr, status, error) {
        alert("Error: " + error);
      }
    });
  });
});

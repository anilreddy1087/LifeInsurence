
$(document).ready(function(){
  $("#submit").click(function(e){
        e.preventDefault();
    var userId = $("#userid").val();
    var firstName = $("#firstname").val();
    var lastName = $("#lastname").val();
    var age = $("#age").val();
    var email = $("#email").val();
    var phNumber = $("#phnumber").val();
    var password = $("#password").val();
    $.ajax({
      url: "/bin/newsportal/service/user-create",
      type: "POST",
      data: {
        userId: userId,
        firstName: firstName,
        lastName: lastName,
        age: age,
        email: email,
        phNumber: phNumber,
        password: password
      },
      success: function(response){
        console.log("Registration successful");
      },
      error: function(xhr, status, error){
        console.log("Error: " + error);
        alert("Registration failed. Please try again later.");
      }
    });
  });
});

$(document).ready(function() {
  $('#signupForm').submit(function(event) {
    // Prevent form from submitting normally
    event.preventDefault();
    
    // Get form data
    var formData = $(this).serialize();
    
    // Send AJAX request
    $.ajax({
      type: 'POST',
      url: 'reset_password.php', // Replace with your server-side script
      data: formData,
      success: function(response) {
        // Handle successful response
        alert(response);
      },
      error: function(xhr, status, error) {
        // Handle error response
        alert('Error: ' + error.message);
      }
    });
  });
});

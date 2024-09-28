function login() {
    alert("Login button clicked");
    // Redirect to login page or handle login logic
    // window.location.href = 'login.html';
  }
  
  function register() {
    alert("Register button clicked");
    // Redirect to register page or handle registration logic
    // window.location.href = 'register.html';
  }
  
  function registerUser(event) {
    event.preventDefault(); // Prevent the form from submitting
  
    // Get form values
    const mobileNumber = document.getElementById('mobile-number').value;
    const accountId = document.getElementById('account-id').value;
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const isCertified = document.getElementById('certify').checked;
  
    // Example of logging form data to the console
    console.log('Mobile Number:', mobileNumber);
    console.log('Account ID:', accountId);
    console.log('Username:', username);
    console.log('Password:', password); // In practice, never log passwords to the console
    console.log('Certified:', isCertified);
  
    // Add your form submission or processing logic here
    if (isCertified) {
      alert('Registration successful for user: ' + username);
      // Proceed with actual registration process, e.g., sending data to the server
    } else {
      alert('Please certify that you are a current customer of STL.');
    }
  }
  
  function loginUser(event) {
    event.preventDefault(); // Prevent the form from submitting
  
    // Get form values
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
  
    // Example of logging form data to the console
    console.log('Username:', username);
    console.log('Password :', password);
    alert('Login successful for user: ' + username);
   
  
   
  }
  
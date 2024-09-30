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
    window.location.href = '../services/index.html';

   
  
   
  }

  function activateService(serviceName) {
    alert(serviceName + ' activated!');
    // Add code here to send activation request to backend, if necessary
  }
  
  function startChat() {
    alert('Starting a new chat...');
    // Here, add logic to initiate a new chat with the support agent
  }

  function viewBill(month) {
    alert('Viewing eBill for ' + month + '...');
    // Here, add the logic to open/view the respective eBill
  }
  
  function payBills() {
    alert('Redirecting to payment page...');
    // Here, add the logic to redirect to the bill payment page
  }
  
  function editProfile() {
    alert('Redirecting to profile editing page...');
    // Add logic to redirect to an actual edit profile page
  }
  
  
  
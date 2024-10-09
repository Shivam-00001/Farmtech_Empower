function validateForm() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var errorMessage = document.getElementById("errorMessage");

    if (password !== confirmPassword) {
        errorMessage.textContent = "Passwords do not match.";
        errorMessage.style.display = "block";
        return false; // Prevent form submission
    }
    errorMessage.style.display = "none";
    return true; // Allow form submission
}



function checkPasswordsMatch() {
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;
    const errorMessage = document.getElementById("errorMessage");
    const submitButton = document.getElementById("submitButton");

    // Check if passwords match
    if (password !== confirmPassword) {
        errorMessage.textContent = "Passwords do not match!";
        errorMessage.style.display = "block"; // Show error message
        submitButton.disabled = true; // Disable the submit button
    } else {
        errorMessage.style.display = "none"; // Hide error message
        submitButton.disabled = false; // Enable the submit button
    }
}

// Attach event listeners to both password fields
document.getElementById("password").addEventListener("input", checkPasswordsMatch);
document.getElementById("confirmPassword").addEventListener("input", checkPasswordsMatch);
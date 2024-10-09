function validateForm() {
    let isValid = true;
    const cropSelect = document.getElementById('cropSelect');
    const fieldArea = document.getElementById('fieldArea');
    const cropSelectError = document.getElementById('cropSelectError');
    const fieldAreaError = document.getElementById('fieldAreaError');

    // Validate crop selection
    if (cropSelect.value === '') {
        cropSelectError.classList.add('show');
        isValid = false;
    } else {
        cropSelectError.classList.remove('show');
    }

    // Validate field area
    if (fieldArea.value.trim() === '' || fieldArea.value <= 0) {
        fieldAreaError.classList.add('show');
        isValid = false;
    } else {
        fieldAreaError.classList.remove('show');
    }

    if (!isValid) {
        alert('Please provide the necessary details.');
    }

    return isValid;
}
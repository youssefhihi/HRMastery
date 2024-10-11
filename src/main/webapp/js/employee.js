let form = document.getElementById('leaveRequestForm');

// Inputs
const employeeName = form.querySelector('#employeeName');
const startDate = form.querySelector('#startDate');
const endDate = form.querySelector('#endDate');
const duration = form.querySelector('#duration');
const reason = form.querySelector('#reason');
const certificate = form.querySelector('#certificate');

// Error message elements
const nameError = form.querySelector('#nameError');
const startDateError = form.querySelector('#startDateError');
const endDateError = form.querySelector('#endDateError');
const durationError = form.querySelector('#durationError');
const reasonError = form.querySelector('#reasonError');
const certificateError = form.querySelector('#certificateError');

// Regular expressions
const nameRegex = /^[a-zA-Z\s]{2,50}$/;

// Function to check if the date is today or in the future
function isTodayOrFuture(dateString) {
    const today = new Date();
    const inputDate = new Date(dateString);
    today.setHours(0, 0, 0, 0);
    inputDate.setHours(0, 0, 0, 0);
    return inputDate >= today;
}

// Form submission event
form.addEventListener('submit', function (e) {
    e.preventDefault();
    let isValid = true;

    // Validate employee name
    //if (!nameRegex.test(employeeName.value)) {
    // nameError.style.display = 'block';
    //  employeeName.style.border = '2px solid red';
    //  isValid = false;
    // } else {
    //  nameError.style.display = 'none';
    //  employeeName.style.border = '1px solid #ccc';
    //}

    // Validate start date
    if (!isTodayOrFuture(startDate.value)) {
        startDateError.style.display = 'block';
        startDate.style.border = '2px solid red';
        isValid = false;
    } else {
        startDateError.style.display = 'none';
        startDate.style.border = '1px solid #ccc';
    }

    // Validate end date
    if (new Date(startDate.value) >= new Date(endDate.value)) {
        endDateError.style.display = 'block';
        endDate.style.border = '2px solid red';
        isValid = false;
    } else {
        endDateError.style.display = 'none';
        endDate.style.border = '1px solid #ccc';
    }

    // Validate duration
    if (duration.value < 1) {
        durationError.style.display = 'block';
        duration.style.border = '2px solid red';
        isValid = false;
    } else {
        durationError.style.display = 'none';
        duration.style.border = '1px solid #ccc';
    }

    // Validate reason
    if (reason.value.length < 10) {
        reasonError.style.display = 'block';
        reason.style.border = '2px solid red';
        isValid = false;
    } else {
        reasonError.style.display = 'none';
        reason.style.border = '1px solid #ccc';
    }

    // Validate certificate
    if (certificate.files[0] && certificate.files[0].type !== "application/pdf") {
        certificateError.style.display = 'block';
        certificate.style.border = '2px solid red';
        isValid = false;
    } else {
        certificateError.style.display = 'none';
        certificate.style.border = '1px solid #ccc';
    }

    // Submit the form if valid
    if (isValid) {
        form.submit();
    }
});


let btn = document.querySelector('#btn');
let sidebar = document.querySelector('.sidebar');
let searchBtn = document.querySelector('.bx-search');

btn.addEventListener('click', () => {
    sidebar.classList.toggle('active');
});

searchBtn.addEventListener('click', () => {
    sidebar.classList.toggle('active');
});

document.querySelector(".showFormButton").onclick = function() {
    var form = document.getElementById("form-container");
    form.classList.toggle("show");
};

const form = document.getElementById('employeeForm');

// inputs
const name = form.querySelector('#name');
const email = form.querySelector('#email');
const address = form.querySelector('#address');
const phoneNumber = form.querySelector('#phoneNumber');
const department = form.querySelector('#department');
const salary = form.querySelector('#salary');
const numberOfChildren = form.querySelector('#children');
const jobPosition = form.querySelector('#jobPosition');
const hireDate = form.querySelector('#hireDate');
const cnss = form.querySelector('#cnss');

// error msg elements
const nameError = form.querySelector('#nameValid');
const emailError = form.querySelector('#emailValid');
const addressError = form.querySelector('#addressValid');
const phoneNumberError = form.querySelector('#phoneNumberValid');
const departmentError = form.querySelector('#departmentValid');
const salaryError = form.querySelector('#salaryValid');
const childrenError = form.querySelector('#childrenValid');
const jobPositionError = form.querySelector('#jobPositionValid');
const hireDateError = form.querySelector('#hireDateValid');
const cnssError = form.querySelector('#cnssValid');

// regex patterns
const nameRegex = /^[a-zA-Z0-9\s]{2,50}$/;
const emailRegex = /^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/;
const addressRegex = /^[a-zA-Z0-9\s,]{5,100}$/;
const phoneRegex = /^[0-9]{10}$/;
const departmentRegex = /^[a-zA-Z\s]{2,50}$/;
const postRegex = /^[a-zA-Z\s]{2,50}$/;
const cnssRegex = /^[0-9]{5,20}$/;

function isPastOrToday(dateString) {
    const today = new Date();
    const inputDate = new Date(dateString);

    today.setHours(0, 0, 0, 0);
    inputDate.setHours(0, 0, 0, 0);

    return inputDate <= today;
}
form.addEventListener('submit', function (e) {
    e.preventDefault();
    var isValid = true;

    // Validate name
    if (!nameRegex.test(name.value)) {
        nameError.style.display = 'block';
        name.style.border = '2px solid red';
        isValid = false;
    } else {
        nameError.style.display = 'none';
        name.style.border = '1px solid #ccc';
    }

    // Validate email
    if (!emailRegex.test(email.value)) {
        emailError.style.display = 'block';
        email.style.border = '2px solid red';
        isValid = false;
    } else {
        emailError.style.display = 'none';
        email.style.border = '1px solid #ccc';
    }

    // Validate address
    if (!addressRegex.test(address.value)) {
        addressError.style.display = 'block';
        address.style.border = '2px solid red';
        isValid = false;
    } else {
        addressError.style.display = 'none';
        address.style.border = '1px solid #ccc';
    }

    // Validate phone number
    if (!phoneRegex.test(phoneNumber.value)) {
        phoneNumberError.style.display = 'block';
        phoneNumber.style.border = '2px solid red';
        isValid = false;
    } else {
        phoneNumberError.style.display = 'none';
        phoneNumber.style.border = '1px solid #ccc';
    }

    // Validate department
    if (!departmentRegex.test(department.value)) {
        departmentError.style.display = 'block';
        department.style.border = '2px solid red';
        isValid = false;
    } else {
        departmentError.style.display = 'none';
        department.style.border = '1px solid #ccc';
    }

    // Validate salary
    if (salary.value <= 0) {
        salaryError.style.display = 'block';
        salary.style.border = '2px solid red';
        isValid = false;
    } else {
        salaryError.style.display = 'none';
        salary.style.border = '1px solid #ccc';
    }

    // Validate number of children
    if (numberOfChildren.value < 0) {
        childrenError.style.display = 'block';
        numberOfChildren.style.border = '2px solid red';
        isValid = false;
    } else {
        childrenError.style.display = 'none';
        numberOfChildren.style.border = '1px solid #ccc';
    }

    // Validate job position
    if (!postRegex.test(jobPosition.value)) {
        jobPositionError.style.display = 'block';
        jobPosition.style.border = '2px solid red';
        isValid = false;
    } else {
        jobPositionError.style.display = 'none';
        jobPosition.style.border = '1px solid #ccc';
    }

    // Validate hire date
    if (!isPastOrToday(hireDate.value)) {
        hireDateError.style.display = 'block';
        hireDate.style.border = '2px solid red';
        isValid = false;
    } else {
        hireDateError.style.display = 'none';
        hireDate.style.border = '1px solid #ccc';
    }

    // Validate CNSS
    if (!cnssRegex.test(cnss.value)) {
        cnssError.style.display = 'block';
        cnss.style.border = '2px solid red';
        isValid = false;
    } else {
        cnssError.style.display = 'none';
        cnss.style.border = '1px solid #ccc';
    }

    if (isValid) {
        form.submit();
    }
});

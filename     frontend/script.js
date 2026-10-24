const API_URL = "http://localhost:8080";

    const form = document.getElementById("registrationForm");
const message = document.getElementById("message");
const registrationList = document.getElementById("registrationList");
const listMessage = document.getElementById("listMessage");

form.addEventListener("submit", async function (event) {
    event.preventDefault();

    const student = {
        name: document.getElementById("name").value.trim(),
        email: document.getElementById("email").value.trim(),
        college: document.getElementById("college").value.trim(),
        department: document.getElementById("department").value.trim()
    };
    message.textContent = "Registering...";
    try {
        const response = await fetch(`${API_URL}/register`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(student)
        });
        const responseText = await response.text();
        if (!response.ok) {
            throw new Error(
                responseText || `Registration failed (${response.status})`
            );
        }
        message.textContent = "Registration successful!";
        form.reset();
    } catch (error) {
        message.textContent =
            "Could not register: " + error.message +
            ". Check that the backend is running.";
    }

});

document.getElementById("loadRegistrations")
.addEventListener("click", loadRegistrations);

async function loadRegistrations() {
    listMessage.textContent = "Loading registrations…";
    registrationList.replaceChildren();

    try {
        const response = await fetch(`${API_URL}/registrations`);
        if (!response.ok) {
            throw new Error(`Request failed (${response.status})`);
        }
        const students = await response.json();
        students.forEach(function (student) {
            const row = document.createElement("tr");
            [
                student.id,
                student.name,
                student.email,
                student.college,
                student.department
            ].forEach(function (value) {
                const cell = document.createElement("td");
                cell.textContent = value ?? "";
                row.appendChild(cell);
            });
            registrationList.appendChild(row);
        });
        listMessage.textContent =
            students.length === 0
                ? "No registrations yet."
                : `Total registrations: ${students.length}`;
    } catch (error) {
        listMessage.textContent =
            "Could not load registrations. Check the backend and API.";
    }

}
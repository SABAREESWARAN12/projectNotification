

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("registerForm").addEventListener("submit", function (event) {
        event.preventDefault();

        const task = {
            taskId: document.getElementById("taskId").value,
            password: document.getElementById("password").value,
            taskDesc: document.getElementById("taskDesc").value,
            status: document.getElementById("status").value
        };
        fetch("/createTask", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(task)
        })
        .then(response => {
            if (response.ok) {
                window.location.reload();
            } else {
                return response.text().then(text => { throw new Error(text); });
            }
        })
        .catch(error => console.error("Error:", error));
    });
});
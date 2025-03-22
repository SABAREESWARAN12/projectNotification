    document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("taskForm").addEventListener("submit", function (event) {
        event.preventDefault();

        const task = {
            taskId: document.getElementById("taskId").value,
            taskSubject: document.getElementById("taskSubject").value,
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

        document.getElementById("notify").addEventListener("notification", function (taskName) {
            event.preventDefault();
            var uri = '/enableNotification?taskName='+ taskName
            fetch("/enableNotification", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                }
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
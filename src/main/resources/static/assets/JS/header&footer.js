AOS.init({
    offset : 300,
    duration : 1000,
});

// JavaScript function to update the time every second in 12-hour format with AM/PM
function updateTime() {
    const now = new Date();
    let hours = now.getHours();
    const minutes = now.getMinutes().toString().padStart(2, '0');
    const seconds = now.getSeconds().toString().padStart(2, '0');
    const ampm = hours >= 12 ? 'PM' : 'AM';

    // Convert 24-hour format to 12-hour format
    hours = hours % 12;
    hours = hours ? hours : 12; // If hours is 0, set it to 12 (midnight or noon)

    const currentTime = `${hours}:${minutes}:${seconds} ${ampm}`;
    document.getElementById('time').innerText = currentTime;
}

// Set the clock to update every second
setInterval(updateTime, 1000);
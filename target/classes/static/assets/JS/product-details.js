// Select the carousel element
const carousel = document.querySelector('.carousel');
const scrollInterval = 2000; // Time interval between scrolls in milliseconds (2 seconds for example)

function autoScroll() {
    const cardWidth = carousel.querySelector('.card').offsetWidth; // Get the width of one card
    
    // Scroll by the width of one card
    carousel.scrollBy({
        left: cardWidth,
        behavior: 'smooth'
    });

    // After the scroll, move the first card to the end
    setTimeout(() => {
        // Select the first card
        const firstCard = carousel.querySelector('.card');

        // Remove the first card from the beginning and append it to the end
        carousel.appendChild(firstCard);

        // Reset scroll position to the beginning
        carousel.scrollLeft -= cardWidth;
    }, 500); // Timeout should match the duration of the smooth scroll
}

// Set an interval to call autoScroll function repeatedly
setTimeout(autoScroll, scrollInterval);
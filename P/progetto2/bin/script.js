function calculateTotal() {
    const car = document.getElementById('car');
    const pricePerDay = car.options[car.selectedIndex].getAttribute('data-price');
    
    const startDate = new Date(document.getElementById('start_date').value);
    const endDate = new Date(document.getElementById('end_date').value);

    const days = (endDate - startDate) / (1000 * 60 * 60 * 24); // Calcola differenza in giorni

    if (days > 0) {
        const totalCost = days * pricePerDay;
        document.getElementById('total_cost').value = `€${totalCost}`;
    } else {
        alert('La data di fine deve essere successiva alla data di inizio.');
    }
}

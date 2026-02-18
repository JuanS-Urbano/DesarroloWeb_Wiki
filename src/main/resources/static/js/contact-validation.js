// Validación del formulario de contacto
document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('contactForm');
    
    if (form) {
        form.addEventListener('submit', function (e) {
            const email = document.getElementById('correo').value;
            const nombre = document.getElementById('nombreCompleto').value;
            const mensaje = document.getElementById('mensaje').value;

            // Validación básica de email
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                e.preventDefault();
                alert('Por favor, ingresa un correo electrónico válido.');
                return;
            }

            // Validación de campos requeridos
            if (nombre.trim() === '' || mensaje.trim() === '') {
                e.preventDefault();
                alert('Por favor, completa todos los campos requeridos.');
                return;
            }

            console.log('Formulario validado correctamente.');
        });
    }
});

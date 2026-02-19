// Validación completa del formulario de contacto
document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('contactForm');
    if (!form) return;

    const fields = {
        nombreCompleto: {
            element: document.getElementById('nombreCompleto'),
            error: document.getElementById('nombreCompletoError'),
            validate: function (value) {
                if (!value || value.trim() === '') {
                    return 'El nombre completo es obligatorio.';
                }
                if (value.trim().length < 3) {
                    return 'El nombre debe tener al menos 3 caracteres.';
                }
                if (/^\s+$/.test(value)) {
                    return 'El nombre no puede contener únicamente espacios en blanco.';
                }
                return '';
            }
        },
        correo: {
            element: document.getElementById('correo'),
            error: document.getElementById('correoError'),
            validate: function (value) {
                if (!value || value.trim() === '') {
                    return 'El correo electrónico es obligatorio.';
                }
                // Debe contener @ y un punto después de la @
                var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailRegex.test(value.trim())) {
                    return 'Ingresa un correo electrónico válido (debe incluir @ y un punto después de la @).';
                }
                return '';
            }
        },
        telefono: {
            element: document.getElementById('telefono'),
            error: document.getElementById('telefonoError'),
            validate: function (value) {
                if (!value || value.trim() === '') {
                    return 'El teléfono es obligatorio.';
                }
                var cleaned = value.trim();
                if (!/^\d+$/.test(cleaned)) {
                    return 'El teléfono solo debe contener números.';
                }
                if (cleaned.length < 7) {
                    return 'El teléfono debe tener al menos 7 dígitos.';
                }
                if (cleaned.length > 15) {
                    return 'El teléfono no puede tener más de 15 dígitos.';
                }
                return '';
            }
        },
        asunto: {
            element: document.getElementById('asunto'),
            error: document.getElementById('asuntoError'),
            validate: function (value) {
                if (!value || value === '' || value === 'Seleccione una opción') {
                    return 'Debes seleccionar un asunto o motivo de contacto.';
                }
                return '';
            }
        },
        mensaje: {
            element: document.getElementById('mensaje'),
            error: document.getElementById('mensajeError'),
            validate: function (value) {
                if (!value || value.trim() === '') {
                    return 'El mensaje es obligatorio.';
                }
                var trimmed = value.trim();
                if (trimmed.length < 20) {
                    var faltan = 20 - trimmed.length;
                    return 'El mensaje debe tener al menos 20 caracteres. Faltan ' + faltan + ' caracteres.';
                }
                if (trimmed.length > 400) {
                    return 'El mensaje no puede superar los 400 caracteres.';
                }
                return '';
            }
        }
    };

    var validBanner = document.getElementById('formValidBanner');
    var charCount = document.getElementById('charCount');
    var charRemaining = document.getElementById('charRemaining');
    var mensajeTextarea = fields.mensaje.element;

    // Actualizar contador de caracteres en tiempo real
    function updateCharCounter() {
        if (!mensajeTextarea || !charCount || !charRemaining) return;
        var len = mensajeTextarea.value.trim().length;
        charCount.textContent = len;

        if (len < 20) {
            var faltan = 20 - len;
            charRemaining.textContent = 'Faltan al menos ' + faltan + ' caracteres';
            charRemaining.className = 'char-remaining-warning';
        } else if (len > 400) {
            charRemaining.textContent = 'Excediste el límite por ' + (len - 400) + ' caracteres';
            charRemaining.className = 'char-remaining-error';
        } else {
            charRemaining.textContent = 'Caracteres válidos ✔';
            charRemaining.className = 'char-remaining-ok';
        }
    }

    if (mensajeTextarea) {
        mensajeTextarea.addEventListener('input', updateCharCounter);
        updateCharCounter();
    }

    // Mostrar error en un campo
    function showError(field, message) {
        field.error.textContent = message;
        field.error.style.display = 'block';
        field.element.classList.add('input-error');
        field.element.classList.remove('input-valid');
    }

    // Limpiar error de un campo
    function clearError(field) {
        field.error.textContent = '';
        field.error.style.display = 'none';
        field.element.classList.remove('input-error');
        field.element.classList.add('input-valid');
    }

    // Validar un campo individual
    function validateField(fieldKey) {
        var field = fields[fieldKey];
        var value = field.element.value;
        var errorMsg = field.validate(value);

        if (errorMsg) {
            showError(field, errorMsg);
            return false;
        } else {
            clearError(field);
            return true;
        }
    }

    // Validar todo el formulario
    function validateForm() {
        var isValid = true;
        var fieldKeys = Object.keys(fields);
        for (var i = 0; i < fieldKeys.length; i++) {
            if (!validateField(fieldKeys[i])) {
                isValid = false;
            }
        }

        // Mostrar/ocultar banner de formulario válido
        if (validBanner) {
            validBanner.style.display = isValid ? 'block' : 'none';
        }

        return isValid;
    }

    // Validación en tiempo real al salir de cada campo
    var fieldKeys = Object.keys(fields);
    for (var i = 0; i < fieldKeys.length; i++) {
        (function (key) {
            var el = fields[key].element;
            el.addEventListener('blur', function () {
                validateField(key);
                checkFormValidity();
            });
            el.addEventListener('input', function () {
                // Si ya tenía error, revalidar al escribir
                if (fields[key].error.textContent !== '') {
                    validateField(key);
                }
                checkFormValidity();
            });
        })(fieldKeys[i]);
    }

    // Verificar validez completa sin mostrar errores nuevos
    function checkFormValidity() {
        var allValid = true;
        var keys = Object.keys(fields);
        for (var j = 0; j < keys.length; j++) {
            var f = fields[keys[j]];
            var err = f.validate(f.element.value);
            if (err) {
                allValid = false;
                break;
            }
        }
        if (validBanner) {
            validBanner.style.display = allValid ? 'block' : 'none';
        }
    }

    // Validación al enviar
    form.addEventListener('submit', function (e) {
        var isValid = validateForm();

        if (!isValid) {
            e.preventDefault();
            // Scroll al primer error
            var firstError = form.querySelector('.input-error');
            if (firstError) {
                firstError.scrollIntoView({ behavior: 'smooth', block: 'center' });
                firstError.focus();
            }
            return;
        }

        console.log('Formulario validado correctamente, enviando...');
    });
});

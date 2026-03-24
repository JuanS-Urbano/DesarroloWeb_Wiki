// JavaScript mínimo para la página inicial
document.addEventListener('DOMContentLoaded', function () {
  const btn = document.getElementById('btn');
  if (btn) {
    btn.addEventListener('click', () => {
      alert('¡Hola! Este es un ejemplo de JS estático.');
    });
  }
  console.log('app.js cargado');
});

// Reintentar cargar .webp si una imagen .jpg falla
function handleImgError(img) {
  try {
    // If an explicit alternative was provided in data-alt, try it first
    if (!img.dataset.triedAlt && img.dataset.alt) {
      img.dataset.triedAlt = '1';
      img.src = img.dataset.alt;
      return;
    }

    if (img.dataset.tried) {
      img.src = '/images/placeholder.svg';
      return;
    }
    img.dataset.tried = '1';
    const src = img.getAttribute('src') || img.src;
    if (src && src.match(/\.jpe?g$/i)) {
      img.src = src.replace(/\.jpe?g$/i, '.webp');
      return;
    }
    // final fallback
    img.src = '/images/placeholder.svg';
  } catch (e) {
    img.src = '/images/placeholder.svg';
  }
}
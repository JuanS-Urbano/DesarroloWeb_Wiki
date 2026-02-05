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

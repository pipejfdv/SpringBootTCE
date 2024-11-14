const toggleBtn = document.getElementById('toggleBtn');
const navbar = document.getElementById('navbar');
let isCollapsed = false;

// Función para alternar el menú entre expandido y contraído
toggleBtn.addEventListener('click', () => {
    if (window.innerWidth > 768) {
        // En pantallas grandes, cambiar entre expandido y contraído
        isCollapsed = !isCollapsed;
        navbar.classList.toggle('collapsed');
        toggleBtn.innerHTML = isCollapsed ? '<i class="fas fa-bars"></i>' : '<i class="fas fa-times"></i>';
    } else {
        // En pantallas móviles, alternar el menú de entrada
        navbar.classList.toggle('open');
        toggleBtn.innerHTML = navbar.classList.contains('open') ? '<i class="fas fa-times"></i>' : '<i class="fas fa-bars"></i>';
    }
});

// Detectar cambios en el tamaño de la ventana para asegurar el ícono correcto
window.addEventListener('resize', () => {
    if (window.innerWidth <= 768) {
        toggleBtn.innerHTML = '<i class="fas fa-bars"></i>';
        navbar.classList.remove('collapsed');
        navbar.classList.remove('open');
    } else {
        toggleBtn.innerHTML = isCollapsed ? '<i class="fas fa-bars"></i>' : '<i class="fas fa-times"></i>';
    }
});
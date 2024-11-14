async function informacion() {
    //al ser una consulta tipo api se debe manejar el tryCatch
    try {
        //toma la informaición y que manda el contorlador
        const response = await fetch('/v1/Plataforma/estadistica/informacion');
        //convierte la información en tipo Json
        const data = await response.json();

        // Extrae los datos (puntos) de juegos y categorías
        const titulosNombreJuegos = data.map(juego => juego.nombreJuego); // ["torres Hanoi", "memoria"]
        const datosJuegos = data.map(juego => juego.puntajeJuego); // [10, 10]
        // Extrae los datos (puntos) de juegos y categorías
        const titulosCategoriaJuegos = data.map(categoria => categoria.nombreCategoria); // ["logica", "memoria"]
        const datosCategorias = data.map(categoria => categoria.puntajeCategoria); // [10, 10]

        // Muestra las gráficas y les insertar los datos
        mostrarGraficaPuntajeJuego(titulosNombreJuegos, datosJuegos);
        mostrarGraficaPuntajeCategoria(titulosCategoriaJuegos, datosCategorias);
    } catch (error) {
        console.error("No se pudo obtener los datos:", error);
    }
}



function mostrarGraficaPuntajeJuego(labels, datos) {
    //identifica el canva
    const ctx = document.getElementById('graficaJuegos').getContext('2d');
    new Chart(ctx, {
        type: 'bar',//tipo de representación grafica
        data: {//información que tendra la grafica
            labels: labels, // ["Torres Hanoi", "Memoria"] eje x
            datasets: [{
                label: 'Puntaje por Juego', //titulo de la grafica
                data: datos, // [15, 30] data optenida para la grafica
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

function mostrarGraficaPuntajeCategoria(labels, datos) {
    const ctx = document.getElementById('graficaCategorias').getContext('2d');
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels, // ["Lógica", "Memoria"]
            datasets: [{
                label: 'Puntaje por Categoría',
                data: datos, // [20, 25]
                backgroundColor: 'rgba(153, 102, 255, 0.2)',
                borderColor: 'rgba(153, 102, 255, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

//función que carga los datos del java atraves de una consulta api
window.onload = function() {
    informacion();
};

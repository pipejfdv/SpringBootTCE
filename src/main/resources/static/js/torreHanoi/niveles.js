//seleccionar nivel
let nivel = 0;
export function niveles(){
    nivel = nivel + 1;
    switch(nivel){
        case 1:
            return 4;
        case 2:
            return 5;
        case 3:
            return 6;
        case 4:
            return 7;
        case 5:
            return 8;
        default:
            return alert("FIN DEL JUEGO");
    }
}
//cantidad de movimientos por nivel
let movimiento_Perfecto;
export function juego_Perfecto(discos){
    switch(discos){
        case 4:
            return movimiento_Perfecto = 15;
        case 5:
            return movimiento_Perfecto = 31;
        case 6:
            return movimiento_Perfecto = 63;
        case 7:
            return movimiento_Perfecto = 127;
        case 8:
            return movimiento_Perfecto = 255;
        default:
            return alert("calculo mal de movientos para el nivel");
    }
}
//se reinicia el juego completo
export function reinicio_Total(){
    nivel = 0;
    niveles();
    location.reload();
}
//activación de juego
export function instruccion(){
    document.getElementById("salir").style.display="";
    document.getElementById("confirmar").style.display="block";
    document.getElementById("Reiniciar").style.display="block";
    document.getElementById("instrucciones").style.display="none";
}
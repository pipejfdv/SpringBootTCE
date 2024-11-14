import { columna3, discos, usuario_Guio } from "./torres2.js";
//validar la victoria, todas las fichas en la torre 3
export function victoria_Hanoi(){
    //coger los elementos del contenerdor 
    const elementos = columna3.querySelectorAll('[class*="propiedad"]');
    if(discos == elementos.length){
        usuario_Guio();
        document.getElementById("siguiente").style.display = "block";
        document.getElementById("glass").style.display = "block";
        document.getElementById("confirmar").style.display = "none";
    }
    else{
        alert("Sigue intentando");
    }
}
//reiniciar juego
export function reiniciado(){
    const x = document.getElementById("Reinicio");
    if (x.style.display === "none"){
        x.style.display = "block";
    }
    else{
        x.style.display = "none";
    }
}
export function cerrando(){
    const x = document.getElementById("Reinicio");
    if (x.style.display === "none"){
        x.style.display = "block";
    }
    else{
        x.style.display = "none";
    }
}
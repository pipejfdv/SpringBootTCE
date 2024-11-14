import { columna1, columna2, columna3 } from "./torres2.js";
//modificación de las propiedas para su posición 
export function propiedades(id_Menor, A_Destino){ 
    //validar variable destino, array para elementos
    switch(A_Destino){
        case columna1:
            //recorrer columna
            //variable de seleccion de elementos div
            var div_Elementos = columna1.querySelectorAll('div');
            //variable que toma la cantidad
            var numero_Divs = div_Elementos.length;

            posicion(numero_Divs, id_Menor);
            break;
        case columna2:
            //recorrer columna
            var div_Elementos = columna2.querySelectorAll('div');
            var numero_Divs = div_Elementos.length;

            posicion(numero_Divs, id_Menor);
            break;
        case columna3:
            //recorrer columna
            var div_Elementos = columna3.querySelectorAll('div');
            var numero_Divs = div_Elementos.length;

            posicion(numero_Divs, id_Menor);
            break;
    }
}
//asignación de clase con su posicion respectiva
function posicion (numero_Divs, id_Menor){
    switch(numero_Divs){
        case 0:
            var numClases = id_Menor.classList.length;
            //se usa para cuando al div tenga una clase 3 poderla remplazar
            if (numClases > 2) {
                const terceraClase = id_Menor.classList.item(2);
                id_Menor.classList.replace(terceraClase, "disco_Posicion1");
            }
            id_Menor.classList.add("disco_Posicion1");
            diseño(id_Menor);
            break;
        case 1:
            var numClases = id_Menor.classList.length;
            if (numClases > 2) {
                const terceraClase = id_Menor.classList.item(2);
                id_Menor.classList.replace(terceraClase, "disco_Posicion2");
            }
            id_Menor.classList.add("disco_Posicion2");
            diseño(id_Menor);
            break;
        case 2:
            var numClases = id_Menor.classList.length;
            if (numClases > 2) {
                const terceraClase = id_Menor.classList.item(2);
                id_Menor.classList.replace(terceraClase, "disco_Posicion3");
            }
            id_Menor.classList.add("disco_Posicion3");
            diseño(id_Menor);
            break;
        case 3:
            var numClases = id_Menor.classList.length;
            if (numClases > 2) {
                const terceraClase = id_Menor.classList.item(2);
                id_Menor.classList.replace(terceraClase, "disco_Posicion4");
            }
            id_Menor.classList.add("disco_Posicion4");
            diseño(id_Menor);
            break;
        case 4:
            var numClases = id_Menor.classList.length;
            if (numClases > 2) {
                const terceraClase = id_Menor.classList.item(2);
                id_Menor.classList.replace(terceraClase, "disco_Posicion5");
            }
            id_Menor.classList.add("disco_Posicion5");
            diseño(id_Menor);
            break;
        case 5:
            var numClases = id_Menor.classList.length;
            if (numClases > 2) {
                const terceraClase = id_Menor.classList.item(2);
                id_Menor.classList.replace(terceraClase, "disco_Posicion6");
            }
            id_Menor.classList.add("disco_Posicion6");
            diseño(id_Menor);
            break;
        case 6:
            var numClases = id_Menor.classList.length;
            if (numClases > 2) {
                const terceraClase = id_Menor.classList.item(2);
                id_Menor.classList.replace(terceraClase, "disco_Posicion7");
            }
            id_Menor.classList.add("disco_Posicion7");
            diseño(id_Menor);
            break;
        case 7:
            var numClases = id_Menor.classList.length;
            if (numClases > 2) {
                const terceraClase = id_Menor.classList.item(2);
                id_Menor.classList.remove(terceraClase);
            }
            id_Menor.classList.add("disco_Posicion8");
            diseño(id_Menor);
            break;        
    }
}

function diseño(id_Menor){
    if(id_Menor.id == 1){
        id_Menor.classList.replace("disco", "propiedad1");
    }
    else if(id_Menor.id == 2){
        id_Menor.classList.replace("disco", "propiedad2");
    }
    else if(id_Menor.id == 3){
        id_Menor.classList.replace("disco", "propiedad3");
    }
    else if(id_Menor.id == 4){
        id_Menor.classList.replace("disco", "propiedad4");
    }
    else if(id_Menor.id == 5){
        id_Menor.classList.replace("disco", "propiedad5");
    }
    else if(id_Menor.id == 6){
        id_Menor.classList.replace("disco", "propiedad6");
    }
    else if(id_Menor.id == 7){
        id_Menor.classList.replace("disco", "propiedad7");
    }
    else if(id_Menor.id == 8){
        id_Menor.classList.replace("disco", "propiedad8");
    }
    else{
        alert("error de diseño")
    }
}
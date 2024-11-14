import { columna1, pila1, pila2, pila3 } from "./torres2.js";
import {propiedades} from "./propiedas_Posicionamiento.js";
import {asignarClasesAFichas} from "./inicial_Fichado.js";
export var id_Menor = null;
//creara el elemento en el contenedor 1
export function crear_Elemento(valor){
    //creación de elemento
    const ficha = document.createElement('div');
    //contenido a mostrar
    ficha.textContent = valor;
    //asignando atributos
    ficha.setAttribute('class','disco translate-middle Nvl1');
    ficha.setAttribute('id',valor);
    return ficha;
}
//crear varios discos 
export function discos_Multiples(discos){
    for(let i=1; i<=discos; i++){
        const nueva_Ficha = crear_Elemento(i);
        columna1.append(nueva_Ficha);
        asignarClasesAFichas(discos);
    }
}
//borrado de discos para no sobrescribir
export function borrarDiscos() {
    pila3.length=0;
    pila1.length=0;
    pila2.length=0;
    const discos = document.querySelectorAll('[class*="propiedad"]');
  
    // Si hay discos en el DOM
    if (discos.length) {
      discos.forEach(disco => disco.remove());
    }
}

export function cambio_Contenedor(A_Origen, A_Destino){
   // Convertir los hijos del contenedor en una lista iterable y filtrar solo los div
    const children = [...A_Origen.children].filter(child => child.nodeName === 'DIV');
       //si es mayor buscar
    if (children.length > 0) {
        // Buscar el div con el ID más bajo
        id_Menor = children.reduce((menor_Id, div_Actual) => {
                                                                //comparador si es correcto (condicional)
        return parseInt(div_Actual.id) < parseInt(menor_Id.id) ? div_Actual : menor_Id;
        });
        //cambio de propiedades
        propiedades(id_Menor, A_Destino);
        // Mover el div con el ID más bajo a container2
        A_Destino.append(id_Menor);
    }          
}
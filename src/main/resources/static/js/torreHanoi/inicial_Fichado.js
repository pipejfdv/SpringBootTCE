import { columna1, discos } from "./torres2.js";
export function asignarClasesAFichas() {
const fichas = columna1.querySelectorAll('.disco');

fichas.forEach(ficha => {
    // Comprobar si el elemento tiene la clase 'disco'
    if (ficha.classList.contains('disco')) {
    var resul_nivel = determinar_Nivel(discos);
    //determina el nivel
    switch(resul_nivel){
        case 1:
            //asignar propiedades de acuerdo al nivel
            sacar_ID(resul_nivel, ficha);
            break;
        case 2:
            //asignar propiedades de acuerdo al nivel
            sacar_ID(resul_nivel, ficha);
            break;
        case 3:
            //asignar propiedades de acuerdo al nivel
            sacar_ID(resul_nivel, ficha);
            break;
        case 4:
            //asignar propiedades de acuerdo al nivel
            sacar_ID(resul_nivel, ficha);
            break;
        case 5:
            //asignar propiedades de acuerdo al nivel
            sacar_ID(resul_nivel, ficha);
            break;
    }

    }
});
}
//determina el nivel para la asignación de propiedades
function determinar_Nivel(discos){
    if(discos == 4){
        return 1;
    }
    else if(discos == 5){
        return 2;
    }
    else if(discos == 6){
        return 3;
    }
    else if (discos == 7){
        return 4;
    }
    else if(discos == 8){
        return 5;
    }
    else{
        console.log("Fallo en determinar el nivel");
        return 0;
    }
}

function sacar_ID(resul_nivel, ficha){
    if (resul_nivel == 1) {
        switch (ficha.id) {
            case '1':
                ficha.classList.add('propiedad1', 'inicial_Nvl1_Ficha1');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '2':
                ficha.classList.add('propiedad2', 'inicial_Nvl1_Ficha2');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '3':
                ficha.classList.add('propiedad3', 'inicial_Nvl1_Ficha3');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '4':
                ficha.classList.add('propiedad4', 'inicial_Nvl1_Ficha4');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
        }
    } 
    else if (resul_nivel == 2){
        switch (ficha.id) {
            case '1':
                ficha.classList.add('propiedad1', 'inicial_Nvl2_Ficha1');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '2':
                ficha.classList.add('propiedad2', 'inicial_Nvl2_Ficha2');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '3':
                ficha.classList.add('propiedad3', 'inicial_Nvl2_Ficha3');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '4':
                ficha.classList.add('propiedad4', 'inicial_Nvl2_Ficha4');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '5':
                ficha.classList.add('propiedad5', 'inicial_Nvl2_Ficha5');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            default:
                alert("fallo de propiedades NIVEL 2");
        }
    }
    else if (resul_nivel == 3){
        switch (ficha.id) {
            case '1':
                ficha.classList.add('propiedad1', 'inicial_Nvl3_Ficha1');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '2':
                ficha.classList.add('propiedad2', 'inicial_Nvl3_Ficha2');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '3':
                ficha.classList.add('propiedad3', 'inicial_Nvl3_Ficha3');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '4':
                ficha.classList.add('propiedad4', 'inicial_Nvl3_Ficha4');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '5':
                ficha.classList.add('propiedad5', 'inicial_Nvl3_Ficha5');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '6':
                ficha.classList.add('propiedad6', 'inicial_Nvl3_Ficha6');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            default:
                alert("fallo de propiedades NIVEL 3");
        }
    }
    else if (resul_nivel == 4){
        switch (ficha.id) {
            case '1':
                ficha.classList.add('propiedad1', 'inicial_Nvl4_Ficha1');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '2':
                ficha.classList.add('propiedad2', 'inicial_Nvl4_Ficha2');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '3':
                ficha.classList.add('propiedad3', 'inicial_Nvl4_Ficha3');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '4':
                ficha.classList.add('propiedad4', 'inicial_Nvl4_Ficha4');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '5':
                ficha.classList.add('propiedad5', 'inicial_Nvl4_Ficha5');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '6':
                ficha.classList.add('propiedad6', 'inicial_Nvl4_Ficha6');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '7':
                ficha.classList.add('propiedad7', 'inicial_Nvl4_Ficha7');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            default:
                alert("fallo de propiedades NIVEL 4");
        }
    }
    else if (resul_nivel == 5){
        switch (ficha.id) {
            case '1':
                ficha.classList.add('propiedad1', 'inicial_Nvl5_Ficha1');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '2':
                ficha.classList.add('propiedad2', 'inicial_Nvl5_Ficha2');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '3':
                ficha.classList.add('propiedad3', 'inicial_Nvl5_Ficha3');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '4':
                ficha.classList.add('propiedad4', 'inicial_Nvl5_Ficha4');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '5':
                ficha.classList.add('propiedad5', 'inicial_Nvl5_Ficha5');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '6':
                ficha.classList.add('propiedad6', 'inicial_Nvl5_Ficha6');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '7':
                ficha.classList.add('propiedad7', 'inicial_Nvl5_Ficha7');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            case '8':
                ficha.classList.add('propiedad8', 'inicial_Nvl5_Ficha8');
                ficha.classList.remove('disco');
                ficha.classList.remove('Nvl1');
                break;
            default:
                alert("fallo de propiedades NIVEL 5");
        }
    }
    else{
        alert("fallo para propiedades iniciales");
    }
}
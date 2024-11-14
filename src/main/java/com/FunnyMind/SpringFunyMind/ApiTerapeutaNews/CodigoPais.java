package com.FunnyMind.SpringFunyMind.ApiTerapeutaNews;

import java.util.HashMap;
import java.util.Map;

//se crea para tener un diccionario de los códigos de los paises para retornar su nombre y no su código
public class CodigoPais {
    private static final Map<String, String> codigoPais = new HashMap<String, String>();
    static {
        codigoPais.put("us", "Estados Unidos");
        codigoPais.put("in", "India");
        codigoPais.put("pk", "Pakistán");
        codigoPais.put("fr", "Francia");
        codigoPais.put("cn", "China");
        codigoPais.put("jp", "Japón");
        codigoPais.put("de", "Alemania");
        codigoPais.put("ru", "Rusia");
        codigoPais.put("br", "Brasil");
        codigoPais.put("za", "Sudáfrica");
        codigoPais.put("au", "Australia");
        codigoPais.put("gb", "Reino Unido");
        codigoPais.put("it", "Italia");
        codigoPais.put("es", "España");
        codigoPais.put("mx", "México");
        codigoPais.put("ca", "Canadá");
        codigoPais.put("kr", "Corea del Sur");
        codigoPais.put("tr", "Turquía");
        codigoPais.put("ar", "Argentina");
        codigoPais.put("eg", "Egipto");
        codigoPais.put("id", "Indonesia");
        codigoPais.put("sa", "Arabia Saudita");
        codigoPais.put("nl", "Países Bajos");
        codigoPais.put("se", "Suecia");
        codigoPais.put("ch", "Suiza");
        codigoPais.put("ng", "Nigeria");
        codigoPais.put("pl", "Polonia");
        codigoPais.put("be", "Bélgica");
        codigoPais.put("th", "Tailandia");
        codigoPais.put("my", "Malasia");
        codigoPais.put("ph", "Filipinas");
        codigoPais.put("ua", "Ucrania");
        codigoPais.put("ve", "Venezuela");
        codigoPais.put("co", "Colombia");
        codigoPais.put("vn", "Vietnam");
        codigoPais.put("gr", "Grecia");
        codigoPais.put("pt", "Portugal");
        codigoPais.put("cz", "República Checa");
        codigoPais.put("at", "Austria");
        codigoPais.put("dk", "Dinamarca");
        codigoPais.put("hu", "Hungría");
        codigoPais.put("il", "Israel");
        codigoPais.put("no", "Noruega");
        codigoPais.put("fi", "Finlandia");
        codigoPais.put("cl", "Chile");
        codigoPais.put("pe", "Perú");
        codigoPais.put("sg", "Singapur");
        codigoPais.put("nz", "Nueva Zelanda");
        codigoPais.put("ie", "Irlanda");
        codigoPais.put("ro", "Rumania");
        codigoPais.put("bd", "Bangladés");
    }

    public static String nombrePais(String code) {
        //retorna un string con relacion al código si no hay retorna el código
        return codigoPais.getOrDefault(code, code);
    }
}

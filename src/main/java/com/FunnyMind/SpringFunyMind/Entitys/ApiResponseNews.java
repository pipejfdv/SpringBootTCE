package com.FunnyMind.SpringFunyMind.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//objeto de las noticias, se realiza para tomar el objeto.
public class ApiResponseNews {
    private String title;       // en lugar de "titulo"
    private String url;
    private String source;      // en lugar de "fuente"
    private String country;     // en lugar de "pais"
    private String image;       // en lugar de "imagen"
}

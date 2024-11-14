package com.FunnyMind.SpringFunyMind.Controllers;

import com.FunnyMind.SpringFunyMind.Entitys.Usuarios;
import com.FunnyMind.SpringFunyMind.Services.ServicesPuntajeActividades;
import com.FunnyMind.SpringFunyMind.Services.ServicesUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/v1/Plataforma/juegos")
@Slf4j
public class ControllerPuntajeActividades {
    int identificador;
    @Autowired
    private ServicesPuntajeActividades servicesPuntajeActividades;
    @Autowired
    private ServicesUsuario servicesUsuario;

    @GetMapping("/torresHanoi/{id}")
    public String torresHanoi(@PathVariable int id) {
        Optional<Usuarios> usuario = servicesUsuario.getUsario(id);
        identificador = usuario.get().getId_usuario();
        return "Juegos/torreHanoi";
    }

    @GetMapping("/memoria/{id}")
    public String memoria(@PathVariable int id) {
        Optional<Usuarios> usuario = servicesUsuario.getUsario(id);
        identificador = usuario.get().getId_usuario();
        return "Juegos/juegoMemoria";
    }

    @PostMapping("/guardarPuntaje")
    //retornar consulta del json enviado de "torres2.js" el puntaje del jugador
    //Map se usa para el diccionario de clave y valor del tipo json y guardaro en "datos"
    public ResponseEntity<String> guardarPuntaje(@RequestBody Map<String,Integer> datos) {
        servicesPuntajeActividades.guardarPuntaje(datos, identificador);
        return ResponseEntity.ok("puntaje guardado");
    }
}

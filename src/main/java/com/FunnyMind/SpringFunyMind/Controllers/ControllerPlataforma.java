package com.FunnyMind.SpringFunyMind.Controllers;

import com.FunnyMind.SpringFunyMind.ApiTerapeutaNews.ApiMediastack;
import com.FunnyMind.SpringFunyMind.Entitys.ApiResponseNews;
import com.FunnyMind.SpringFunyMind.Entitys.Usuarios;
import com.FunnyMind.SpringFunyMind.Services.ServicesGeneros;
import com.FunnyMind.SpringFunyMind.Services.ServicesPuntajeActividades;
import com.FunnyMind.SpringFunyMind.Services.ServicesUsuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/v1/Plataforma")//rutas privadas
@RequiredArgsConstructor
@Slf4j
public class ControllerPlataforma {
    @Autowired
    private ServicesUsuario servicesUsuario;
    @Autowired
    private ServicesGeneros servicesGeneros;
    @Autowired
    private ServicesPuntajeActividades servicesPuntajeActividades;

    int identificador;
    //traer datos del usuario al home
    @GetMapping("/home")
    @PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('USUARIO')")
    public String home(Model model) {
        //esto retorna una lista y se debe sacar el elemento deseado "servicesUsuario.getUsuario();
        Optional<Usuarios> usuarioLogueado = servicesUsuario.getDatosUsuario();
        //si esta presente el usuario logueado retorna sus elementos
        if (usuarioLogueado.isPresent()) {
            //se le asigna a la vista "datosUsuario" y se le extrae sus componentes
            model.addAttribute("datosUsuario", usuarioLogueado.get());
            //permite traer el valor de genero y asignarlo para mostrar al usuario
            model.addAttribute("genero", servicesGeneros.asignarGenero(usuarioLogueado.get()));
        }
        else {
            return "redirect:/login";
        }
        return "interfazUsuarios/usuarios";
    }

    //accion de actualizar datos de usuario
    @GetMapping("/actualizar/{id}")
    @PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('USUARIO')")
    public String actualizar(Model model, @PathVariable int id) {
        Optional<Usuarios> usuarioLogueado = servicesUsuario.getUsario(id);
        if (usuarioLogueado.isPresent()) {
            model.addAttribute("datosUsuario", usuarioLogueado.get());
            model.addAttribute("generos", servicesGeneros.listaGeneros());
        }
        else {
            model.addAttribute("error", "Usuario no encontrado");
        }
        return "actualizarDatos";
    }

    //guardar datos en la actualización de datos dentro de la interfaz
    @PostMapping("/guardar")
    @PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('USUARIO')")
    public String guardar(@Valid @ModelAttribute("datosUsuario") Usuarios usuarios, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("generos", servicesGeneros.listaGeneros());
            return "actualizarDatos";
        }
        servicesUsuario.crearActualizarUsuario(usuarios);
        return "interfazUsuarios/usuarios";
    }
    //identificar el usuario
    @GetMapping("/estadistica/{id}")
    @PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('TERAPEUTA')")
    public String estadistica(@PathVariable int id) {
        identificador = id;
        return "estadistica";
    }

    //envio de información al js estadistica
    @GetMapping("/estadistica/informacion")
    @ResponseBody//etiqueta para identificar el json
    //como retorna una lista por eso el tipo
    public List<Map<String, Object>> informacionEstadistica() {
        return servicesPuntajeActividades.datosEstadisticas(identificador);
    }
}

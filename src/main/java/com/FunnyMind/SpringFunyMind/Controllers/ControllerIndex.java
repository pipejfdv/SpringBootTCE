package com.FunnyMind.SpringFunyMind.Controllers;

import com.FunnyMind.SpringFunyMind.Entitys.Usuarios;
import com.FunnyMind.SpringFunyMind.Services.ServicesGeneros;
import com.FunnyMind.SpringFunyMind.Services.ServicesUsuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j //(permite realizar log en la ejecución métodos)
@RequestMapping("/FunnyMind")
@RequiredArgsConstructor
public class ControllerIndex {
    @Autowired
    private ServicesGeneros servicesgeneros;
    //importar servicios de usuario
    @Autowired
    private ServicesUsuario servicesUsuario;
    //pagina principal
    @GetMapping("/index")
    public String index() {
        log.info("modelo mvc");
        return "index";
    }
    //pagina de logeo redirección
    @GetMapping("/login")
    public String login(Model model) {
        log.info("entrando login");
        //crear objeto tipo usuario
        model.addAttribute("usuario", new Usuarios());
        //crear objeto de generos
        model.addAttribute("generos", servicesgeneros.listaGeneros());
        return "login";
    }

    @PostMapping("/registrar")
    public String registrar(@Valid @ModelAttribute("usuario") Usuarios usuario, Errors errors, Model model) {
        String estado;// información para el usuario
        if (errors.hasErrors()) {
            //permite cargar de nuevo la lista de generos
            model.addAttribute("generos", servicesgeneros.listaGeneros());
            model.addAttribute("estado", estado="No se pudo registrar" );
            return "login";
        }
        else {
            model.addAttribute("estado", estado="Registrado" );
            servicesUsuario.crearActualizarUsuario(usuario);
            return "login";
        }
    }

}

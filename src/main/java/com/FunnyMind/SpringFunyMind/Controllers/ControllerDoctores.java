package com.FunnyMind.SpringFunyMind.Controllers;

import com.FunnyMind.SpringFunyMind.ApiTerapeutaNews.ApiMediastack;
import com.FunnyMind.SpringFunyMind.Entitys.ApiResponseNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/PlataformaDoctor")
public class ControllerDoctores {
    @Autowired
    private ApiMediastack apiMediastack;

    @GetMapping("/home")
    @PreAuthorize("hasAuthority('TERAPEUTA')")
    public String homeDoctor(Model model) {
        List<ApiResponseNews> listaNoticias = apiMediastack.apiMediastackNoticias();
        model.addAttribute("listaNoticias", listaNoticias);
        return "interfazDoctores/doctores";
    }

}

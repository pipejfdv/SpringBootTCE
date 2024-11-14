package com.FunnyMind.SpringFunyMind.Config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class RedireccionRol implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("USUARIO"))){
            response.sendRedirect("/v1/Plataforma/home");
        }
        else if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("TERAPEUTA"))){
            response.sendRedirect("/v1/PlataformaDoctor/home");
        }
        else if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMINISTRADOR"))){
            //validar ruta de admin
            response.sendRedirect("/v1/Plataforma/home");
        }
        else if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("PACIENTE"))){
            //paciente
            response.sendRedirect("/v1/Plataforma/home");
        }
        else {
            response.sendRedirect("/FunnyMind/index");
        }
    }
}

package com.FunnyMind.SpringFunyMind.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {



    @Bean//crear objeto tipo "Bean" para filtrado de enlaces
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)//se desactiva para no activar el token que requiere adicional
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("FunnyMind/**","/css/**", "/js/**", "/imagenes/**", "/plantillas/pantallaCarga").permitAll() // permitir todas las rutas libres
                        .requestMatchers("/v1/PlataformaDoctor/**").hasAnyAuthority("TERAPEUTA") // autenticación rol MEDIC
                        .requestMatchers("/v1/Plataforma/**").authenticated() // requiere autenticación para acceso a la plataforma
                )
               .formLogin( form ->
                        form.loginPage("/FunnyMind/login")//pagina a la que debe dirigirse
                                .loginProcessingUrl("/FunnyMind/login")//proceso del controller el que debe realizar despues de ingresar credenciales
                                .successHandler(new RedireccionRol())//se remplaza para redirigir al usuario deacuerdo a su rol
                                //.defaultSuccessUrl("/v1/Plataforma/home",true)//pagina por defecto a la cual lo redirige
                                //.failureUrl("/FunnyMind/login?error")//permite ver log de seguridad
                                .permitAll()//permite que todos los usuarias tengan acceso al login
                )
                .logout(logout -> logout//permitir salir de la sesión
                        .permitAll()
                        .logoutSuccessUrl("/FunnyMind/login")//redirige a la página de inicio
                        .invalidateHttpSession(true)//invalida las credenciales
                        .deleteCookies("JSESSIONID")//borrar cookies de acceso
                )
                .build();//construye todo el objeto http
    }

    @Bean//permite que Security interprete la ecriptación de la contraseña
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


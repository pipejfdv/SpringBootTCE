package com.FunnyMind.SpringFunyMind.Services;

import com.FunnyMind.SpringFunyMind.Entitys.CategoriaJuegos;
import com.FunnyMind.SpringFunyMind.Entitys.Juegos;
import com.FunnyMind.SpringFunyMind.Entitys.PuntajeActividades;
import com.FunnyMind.SpringFunyMind.Repository.RepositoryCategoriaJuegos;
import com.FunnyMind.SpringFunyMind.Repository.RepositoryJuegos;
import com.FunnyMind.SpringFunyMind.Repository.RepositoryPuntajeActividades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ServicesPuntajeActividades {
    @Autowired
    private RepositoryPuntajeActividades repositoryPuntajeActividades;
    @Autowired
    private RepositoryJuegos repositoryJuegos;
    @Autowired
    private RepositoryCategoriaJuegos repositoryCategoriaJuegos;

    public List<com.FunnyMind.SpringFunyMind.Entitys.PuntajeActividades> listaPuntajeActividades(){
        return repositoryPuntajeActividades.findAll();
    }

    public List<Map<String, Object>> datosEstadisticas(int identificador) {
        // Buscar todos los puntajes asociados al usuario se almacena en una lista de para que retorne varios datos en el json
        List<PuntajeActividades> puntajes = repositoryPuntajeActividades.findById_usuario(identificador);
        //como se necesita almacenar varios datos se agrega dentro de una list
        List<Map<String, Object>> respuestaList = new ArrayList<>();
//"puntaje" variable iteradora de la lista de pntaje por usuario
        for (PuntajeActividades puntaje : puntajes) {
            //Lista de clave valor
            Map<String, Object> respuesta = new HashMap<>();

            // Obtener el nombre del juego de acuerdo al id, se escoge opcional por lo que tiene datos de diferente y solo un tipo de dato
            //al manejar el "Optional" es necesario manejar excepción o sino saca error
            Optional<Juegos> nombreJuego = repositoryJuegos.findByIdJuego(puntaje.getId_juego());

            // Agregar el puntaje del juego y de la categoría al mapa de respuesta
            respuesta.put("puntajeJuego", puntaje.getPuntaje_juego());
            respuesta.put("puntajeCategoria", puntaje.getPuntaje_categoria());

            // Si el juego existe, agregamos su nombre y categoría
            if (nombreJuego.isPresent()) {
                // Obtener la categoria del juego de acuerdo al id, se escoge opcional por lo que tiene datos de diferente y solo un tipo de dato
                Optional<CategoriaJuegos> categoriaJuegos = repositoryCategoriaJuegos.findByIdCategoriJuego(puntaje.getId_categoria());
                //se obtiene el nombre del juego y se agrega al mapa de respuesta
                respuesta.put("nombreJuego", nombreJuego.get().getNombre());
                //si esta presenta la categoria se agregara
                if (categoriaJuegos.isPresent()) {
                    //se toma el nombre y se agrega al map
                    respuesta.put("nombreCategoria", categoriaJuegos.get().getCategoria());
                } else {
                    respuesta.put("nombreCategoria", ""); // Si la categoría no existe
                }
            } else {
                respuesta.put("nombreJuego", "Juego no encontrado"); // Valor por defecto si el juego no existe
            }

            // Agregar el mapa de respuesta individual a la lista de respuestas
            respuestaList.add(respuesta);
        }

        return respuestaList;
    }




    //clasificación de juegos con su respectivo puntaje y categoria
    //"datos" - registro de datos del JSON que envia cada juego
    //"identificador" es el id de usuario recuperado cuando este entra al juego, lo cual permite identidificarlo
    public void guardarPuntaje(Map<String,Integer> datos, int identificador){
        //definir variable que almacene el puntaje obtenido
        int puntaje = datos.get("puntaje");
        //definir la categoria del juego
        int categoria = datos.get("categoria");
        //definir el id del juego
        int Idjuego = datos.get("IdJuego");
        //fecha actual
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //lista objetos de la entidada "PuntajeActividades" buscando por ID del jugador y el juego
        Optional<PuntajeActividades> registroExistente = repositoryPuntajeActividades.findById_usuarioAndIdJuego(identificador, Idjuego);
        //condición que evalua el registro del usuario y ese juego existe
        if(registroExistente.isPresent()){
            //del registro existente se crea el objeto "registroPuntaje" de la entidad "PuntajeActividades"
            PuntajeActividades registroPuntaje = registroExistente.get();
            if (registroPuntaje.getId_categoria() == categoria){
                // Actualizar el puntaje del juego y de la categoría
                registroPuntaje.setPuntaje_juego(registroPuntaje.getPuntaje_juego() + puntaje);
                registroPuntaje.setPuntaje_categoria(registroPuntaje.getPuntaje_categoria() + puntaje);
                registroPuntaje.setFecha_realizacion(timestamp);
                repositoryPuntajeActividades.save(registroPuntaje);
            }
        }
        // Si no hay un registro para este juego específico pero la categoría es la misma
        else {
            Optional<PuntajeActividades> registroCategoriaExistente = repositoryPuntajeActividades.findById_usuarioAndId_Categoria(identificador, categoria);
            if(registroCategoriaExistente.isPresent()){
                PuntajeActividades puntajeCategoriaExistente = registroCategoriaExistente.get();
                // Crear un nuevo registro para el nuevo juego, sumando el puntaje en la categoría existente
                PuntajeActividades nuevoPuntaje = new PuntajeActividades(
                        0,
                        identificador,
                        categoria,
                        Idjuego,
                        timestamp,
                        puntaje,
                        puntajeCategoriaExistente.getPuntaje_categoria()+puntaje
                );
                repositoryPuntajeActividades.save(nuevoPuntaje);
            }
            // Si no hay ningún registro en la categoría, crear uno nuevo para la categoría y el juego
            else {
                PuntajeActividades nuevoPuntaje = new PuntajeActividades(
                        0,
                        identificador,
                        categoria,
                        Idjuego,
                        timestamp,
                        puntaje,
                        puntaje
                );
                repositoryPuntajeActividades.save(nuevoPuntaje);
            }
        }
    }

}

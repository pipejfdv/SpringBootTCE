package com.FunnyMind.SpringFunyMind.Config;
//Esta clase fue diseña para que identificar y asignar rol de acuerdo al id que tenga
public class TipoUsuarioRol {
    public static String tipoUsuarioRol(int role) {
        switch (role) {
            case 1:
                return "USUARIO";
            case 2:
                return "PACIENTE";
            case 3:
                return "TERAPEUTA";
            case 4:
                return "ADMINISTRADOR";
            default:
                return "NULL";
        }
    }
}

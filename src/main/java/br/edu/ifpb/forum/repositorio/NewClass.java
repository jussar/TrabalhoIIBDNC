/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.repositorio;

import br.edu.ifpb.forum.entidades.Usuario;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class NewClass {
    private static final Usuarios usuarios = new Usuarios();
    public static void main(String[] args) throws SQLException {
        Usuario u = Usuario.of("uuffuf", "eee", "1234332");
        Usuario c = usuarios.logar(u.getEmail(), u.getSenha());
        System.err.println("rrrru " +c);
    }
}

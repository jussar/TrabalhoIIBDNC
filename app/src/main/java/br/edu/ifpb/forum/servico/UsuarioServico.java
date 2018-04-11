/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.servico;

import br.edu.ifpb.forum.entidades.Usuario;
import br.edu.ifpb.forum.repositorio.Usuarios;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jose
 */
@Stateless
public class UsuarioServico {
    @Inject
    private Usuarios repositorio;
    public void salvar(Usuario usuario) throws SQLException{
        repositorio.salvar(usuario);
    }
    public Usuario login(String email, String senha) throws SQLException{

        return repositorio.login(email, senha);
    }
}

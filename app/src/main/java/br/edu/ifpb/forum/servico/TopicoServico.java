/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.servico;

import br.edu.ifpb.forum.entidades.Topico;
import br.edu.ifpb.forum.entidades.Usuario;
import br.edu.ifpb.forum.repositorio.Topicos;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jose
 */
@Stateless
public class TopicoServico {
    @Inject
    private Topicos repositorio;
    public void salvar(Topico t) throws SQLException{
        repositorio.salvar(t);
    }
    
}

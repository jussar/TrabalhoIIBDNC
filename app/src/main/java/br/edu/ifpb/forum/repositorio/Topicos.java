/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.repositorio;

import br.edu.ifpb.forum.entidades.Topico;
import java.util.List;



/**
 *
 * @author jose
 */
public interface Topicos {

    public Topico buscar(String testo);
    public Topico buscar(int id);
    public List<Topico> buscarTodos();

    public void salvar(Topico t);
    public void remover(Topico t);
    
}

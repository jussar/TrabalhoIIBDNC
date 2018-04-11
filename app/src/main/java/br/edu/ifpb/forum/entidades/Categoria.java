/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.entidades;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author jose
 */
public class Categoria {
      private String tecnologia;
      private List<Topico> topicos;

    public Categoria() {
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public List<Topico> getTopicos() {
        return Collections.unmodifiableList(topicos);
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }
    public void addTopicos(Topico topico) {
        this.topicos.add(topico);
    }
    public void removeTopicos(Topico topico) {
        this.topicos.remove(topico);
    }
      
}

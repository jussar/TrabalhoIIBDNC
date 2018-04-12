/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.controle;

import br.edu.ifpb.forum.entidades.Topico;
import br.edu.ifpb.forum.entidades.Usuario;
import br.edu.ifpb.forum.servico.TopicoServico;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@RequestScoped
public class TopicoControle implements Serializable{
    private Topico topico;
    @Inject
    private Mensagem mensagem;
    @Inject
    private TopicoServico servico;
    @PostConstruct
    public void init(){
        this.topico = new Topico();
    }
    public String salvar(){
        try {
            servico.salvar(topico);
            mensagem.addMessage("topico salvo com sucesso");
            this.topico = new Topico();
             
             return "pag_usuario?faces-redirect=true";
        } catch (Exception e) {
            mensagem.addMessage("Erro ou salvar ");
        }
         return   "404?faces-redirect=true";
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }
    
     
}
    

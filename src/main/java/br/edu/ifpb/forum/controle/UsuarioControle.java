/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.controle;

import br.edu.ifpb.forum.entidades.Usuario;
import br.edu.ifpb.forum.servico.UsuarioServico;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@RequestScoped
public class UsuarioControle implements Serializable{
    private Usuario usuario;
    @Inject
    private Mensagem mensagem;
    @Inject
    private UsuarioServico servico;
    @PostConstruct
    public void init(){
        this.usuario = new Usuario();
    }
    public String salvar(){
        try {
            servico.salvar(usuario);
            mensagem.addMessage("Usuario salvo com sucesso");
            this.usuario = new Usuario();
        } catch (Exception e) {
            mensagem.addMessage("Erro ou salvar ");
        }
        return null;
    }
     public String login() throws SQLException {
         
        Usuario result = servico.login(usuario.getEmail(), usuario.getSenha());
        
        if (result != null) {
            usuario = result;
            mensagem.addMessage ("Bem vindo "+usuario.getNome()+"!");
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            return "home?faces-redirect=true";
        } else {
            mensagem.addMessage("Usuário ou senha inválido");
           
            return null;
        }
    }
     public String logout() {
         System.err.println("logout -----------------------------------");
             FacesContext.getCurrentInstance().getExternalContext()
             .invalidateSession();
                   
                 return "index?faces-redirect=true";
}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     
}
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.usuario;

import br.edu.ifpb.forum.bancos.postgre.Conecxao;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author Jussara
 */
@ManagedBean
@SessionScoped
public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private Conecxao conn;
    PreparedStatement stat= null;
    ResultSet rs;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void logar() throws SQLException {

        try {
            conn = new Conecxao();
            stat = conn.init().prepareStatement("select * from usuario where email = ? and senha = ?");
            stat.setString(1, getEmail());
            stat.setString(2, getSenha());
            stat.execute();
            rs = stat.executeQuery();
            if(rs.next()){
                FacesContext.getCurrentInstance().getExternalContext().redirect("pag_usuario.xhtml");
            }else{
                 FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Error", "usuario invalido")); 
            }    
        } catch (Exception e) {
        }
    }

    public void inserirusuario() throws SQLException, IOException {
        conn = new Conecxao();
        stat = conn.init().prepareStatement("INSERT INTO usuario(nome,email,senha) values(?,?,?);");
        stat.setString(1, getNome());
        stat.setString(2, getEmail());
        stat.setString(3, getSenha());
        if (stat.execute() == true) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "usuario invalido"));
            
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("pag_usuario.xhtml");
        }
    }
}

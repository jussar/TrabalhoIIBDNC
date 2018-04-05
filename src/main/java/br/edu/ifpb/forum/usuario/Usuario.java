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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


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
    PreparedStatement stat;

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

    public void login() throws SQLException {

        conn = new Conecxao();
        stat = conn.init().prepareStatement("select * from usuario where email= " + email + " and senha= " + senha + " );");

    }

    public void inserirusuario() throws SQLException {
        conn = new Conecxao();
        stat = conn.init().prepareStatement("INSERT INTO usuario(nome,email,senha) values(?,?,?);");
        stat.setString(1, getNome());
        stat.setString(2, getEmail());
        stat.setString(3, getSenha());
        
        stat.execute();
       
    }
}

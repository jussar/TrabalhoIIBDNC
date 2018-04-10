/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.entidades;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Jussara
 */
@Named
@Dependent
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    private  Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        
    }
    public  static Usuario of(int id, String nome, String email, String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        usuario.setId(id);
        return usuario;
    }
    public  static Usuario of(String nome, String email, String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        return usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

  
}
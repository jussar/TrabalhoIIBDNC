/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.entidades;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Jussara
 */

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 60,nullable = false,unique = true)
    private String nome;
    @Column(length = 60,nullable = false,unique = true)
    private String email;
    @Column(length = 20,nullable = false,unique = true)
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
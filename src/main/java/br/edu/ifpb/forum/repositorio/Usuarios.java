/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.repositorio;

import br.edu.ifpb.forum.bancos.Conecxao;
import br.edu.ifpb.forum.entidades.Usuario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Jussara
 */
//@Stateless
public class Usuarios implements Serializable{

    private List<Usuario> Usurios;
    private Conecxao conn;
  private PreparedStatement stat = null;
   private ResultSet rs;

    public Usuarios() {
    }

    public Usuario logar(String email, String senha) throws SQLException {
        Connection c = null;
        try {
            conn = new Conecxao();
            c = conn.init();
            stat = c.prepareStatement("select * from usuario where email = ? and senha = ?");
            stat.setString(1, email);
            stat.setString(2, senha);
            stat.execute();
            rs = stat.executeQuery();
            List<Usuario> r = montarUsurio(rs);
            return r.get(0);

        } catch (SQLException e) {
        } finally {
            conn.fecharConexao(c);
        }
        System.err.println("lista "+Usurios.size());
       
        return this.Usurios.get(0);
    }

    public void inserirusuario(Usuario usuario) throws SQLException {
         Connection c= null; 
        try {
              conn = new Conecxao();
            c = conn.init();
        stat = c.prepareStatement("INSERT INTO usuario(nome,email,senha) values(?,?,?);");
        stat.setString(1, usuario.getNome());
        stat.setString(2, usuario.getEmail());
        stat.setString(3, usuario.getSenha());
        stat.executeUpdate();
        } catch (SQLException e) {
            
        }
        finally{
            conn.fecharConexao(c);
        }
    }

    private List<Usuario> montarUsurio(ResultSet rs) throws SQLException {
         this.Usurios = new ArrayList<>();
        while (rs.next()) {
            Usuario u = Usuario.of(rs.getInt(rs.getInt("id")),
                    rs.getString("nome"), rs.getString("email"),
                    rs.getString("sennha"));
            System.err.println("usuario "+u.getNome());
            this.Usurios.add(u);
        }
        if(Usurios.isEmpty())
            Usurios.add(Usuario.of(-1,"", "", ""));

        return Collections.unmodifiableList(Usurios);
    }
}

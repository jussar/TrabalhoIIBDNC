/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.bancos.postgre;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Jussara
 */
public interface Conection {
    
     void fecharConexao(Connection c) throws SQLException;

    Connection init();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.bancos.postgre;

import static com.sun.org.glassfish.external.amx.AMXUtil.prop;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Jussara
 */
public class Conecxao {

     private static Properties prop = null;

    private Connection connection;

    public Connection init() {
        try {
            
              prop = new Properties();
                    prop.load(new FileInputStream(getClass().getResource("/postgreSQL/conect.properties").toURI().getPath()));
       
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            Class.forName("org.postgresql.Driver");
            return connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
                   
      
        return null;
    }
    public   void fecharConexao(Connection c) throws SQLException{
        c.close();
    }


}

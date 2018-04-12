/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.repositorio;
import br.edu.ifpb.forum.bancos.Conexao;
import br.edu.ifpb.forum.entidades.Topico;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.text.Document;
import br.edu.ifpb.forum.repositorio.Topicos;
import javax.ejb.Stateless;

/**
 *
 * @author jose
 */
@Stateless
public class TopicosImpl implements Topicos {
    private Conexao conexao;
    MongoDatabase database;

    public TopicosImpl() throws IOException, URISyntaxException {
        this.conexao = new Conexao("projetofinal");
        database = conexao.getConnection();
    }
    
    @Override
    public void salvar(Topico t){
        MongoCollection<Topico> collection = 
                database.getCollection("topico",Topico.class);
        collection.insertOne(t);
        conexao.close();
        
    }
    Block<Document> printBlock = new Block<Document>() {
       @Override
       public void apply(final Document document) {
           System.out.println(document.toString());
       }
};

    /**
     *
     * @param conteudo
     * @return
     */
    @Override
    public Topico buscar(String conteudo){
         MongoCollection<Topico> collection = 
                database.getCollection("topico",Topico.class);
        FindIterable<Topico> publicacaos = collection.find(Filters.text(conteudo));

        conexao.close();
        return publicacaos.first();
    }

    @Override
    public Topico buscar(int id) {
         MongoCollection<Topico> collection = 
                database.getCollection("topico",Topico.class);
        FindIterable<Topico> topicos = collection.find(Filters.all("id",id));

        conexao.close();
        return topicos.first();
    }

    @Override
    public List<Topico> buscarTodos() {
         MongoCollection<Topico> collection = 
                database.getCollection("topico",Topico.class);
        FindIterable<Topico> topicos = collection.find();

        conexao.close();
        List<Topico> resul = new ArrayList<>();
         for (Iterator<Topico> iterator = topicos.iterator(); iterator.hasNext();) {
            resul.add( iterator.next());
            
        }
         return resul;
    }

    @Override
    public void remover(Topico t) {
        
    }
}

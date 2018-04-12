/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.forum.bancos;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author jose
 */
public class Conexao {

    private final String host;
    private final String BD;
    private final int port;
    private Mongo mongo;

    public Conexao(String BD) throws IOException, URISyntaxException {

        this.host = "localhost";
        this.BD = BD;
        this.port = 27017;

    }

    public MongoDatabase getConnection() {

        mongo = new MongoClient(host, port);
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient = new MongoClient(host, MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        return mongoClient.getDatabase(BD);
    }

    public void close() {
        mongo.close();
    }
}

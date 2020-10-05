/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

//import com.mongodb.client.MongoClient;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
/**
 *
 * @author Ivan Esteban Castill
 */
public class paginaRoad {
    public String consultarClientes(){
        //return  "{\"clave\":\"hola Mundo\"}"; //{clave:"hola mundo"}
        //conexon a una base de  datos  remota
        MongoClient mongoClient;
        MongoClientURI uri = new
        MongoClientURI("mongodb://Lab3:passworduserLab3@93.188.167.110:27017/?authSource=lab3");
        
        MongoDatabase db;
        mongoClient = new MongoClient(uri);
        db = mongoClient.getDatabase("lab3");
        MongoCollection<Document> collection = db.getCollection("clientes");
        //Mostrar primer registro
        return collection.find().first().toJson();
        //conexion alservidor de base de datos
       // MongoClient  mongoClient = MongoClients.create("mongodb://127.0.0.0:27017");
        //MongoClient  mongoClient = MongoClients.create("mongodb://servercastell:27017");
        //conecxio a la base de datos
       // MongoDatabase database = mongoClient.getDatabase("Roadtosun");
        // Instancia  de la collecion
        //MongoCollection<Document> collection = database.getCollection("empleados");      
        //TODO:manejo adecuado si la coleccion no existe o esta vacia
        //return  collection.find().first().toJson();                

    }

}



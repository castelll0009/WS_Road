/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import junit.framework.Assert;  
//import com.mongodb.client.MongoClient;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;  
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
/**
 *
 * @author Ivan Esteban Castill
 */
public class paginaRoad {
        
    
    public String ConsultarEmpleados(){
    //return  "{\"clave\":\"hola Mundo\"}"; //{clave:"hola mundo"}
        //conexon a una base de  datos  remota
        MongoClient mongoClient;
        MongoClientURI uri = new
        MongoClientURI("mongodb://userLab3:passworduserLab3@93.188.167.110:27017/?authSource=lab3");        
        MongoDatabase db;
        mongoClient = new MongoClient(uri);
        db = mongoClient.getDatabase("lab3");
        MongoCollection<Document> collection = db.getCollection("empleados");
        //Mostrar primer registro
        return collection.find().first().toJson();
    
    }
    
    public String ConsultarUltimoUsuario(){   
        String cadena = "";
        
        MongoClient mongoClient;
        MongoClientURI uri = new
        MongoClientURI("mongodb://userLab3:passworduserLab3@93.188.167.110:27017/?authSource=lab3");        
        MongoDatabase db;        
        mongoClient = new MongoClient(uri);        
        db = mongoClient.getDatabase("lab3");
        
        MongoCollection<Document> collection = db.getCollection("usuarios");   
        //Mostrar ultimo registro
       //DBCollection usuarios = db.getCollection("usuarios");        
        Document findDocument = new Document();
        MongoCursor<Document> resultDocument = collection.find(findDocument).iterator();        
                
        while (resultDocument.hasNext() ) { //mientras exitan mas elementos para iterar continuar                               
                cadena = resultDocument.next().toJson();                             
         }

        return cadena;
    }

    // consultar los  ultimos 5 usuarios
     public String ConsultarUltimosCincoUsuarios(){       
        String cadena = "";
        
        MongoClient mongoClient;
        MongoClientURI uri = new
        MongoClientURI("mongodb://userLab3:passworduserLab3@93.188.167.110:27017/?authSource=lab3");        
        MongoDatabase db;        
        mongoClient = new MongoClient(uri);        
        db = mongoClient.getDatabase("lab3");
        
        MongoCollection<Document> collection = db.getCollection("usuarios");   
        
        //DBCollection usuarios = db.getCollection("usuarios");        
        Document findDocument = new Document();
        //MongoCursor<Document> resultDocument = collection.find(findDocument).iterator();
        MongoCursor<Document> resultDocument = collection.find(findDocument).limit(5).iterator();
        
        cadena+="ESTOS SON LOS 5 PRIMEROS USUARIOS\n\n";
        while (resultDocument.hasNext()) { //mientras exitan mas elementos para iterar continuar            
//            System.out.println(resultDocument.next().getString("name"));            
            //cadena += " ; "+resultDocument.next().getString("nombre");            
            cadena += resultDocument.next().toJson() + " \n\n";                        
         }
        return cadena;
        //Mostrar primer registro       
        //return collection.find().first().toJson();                 
    }   
    
}



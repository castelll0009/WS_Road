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
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;  
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import java.util.Arrays;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

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
     public String actualizarDocumento(String idUsuario){
         String cadena;
    MongoClient mongoClient;
    MongoClientURI uri = new
    MongoClientURI("mongodb://userLab3:passworduserLab3@93.188.167.110:27017/?authSource=lab3");
    MongoDatabase db;
    mongoClient = new MongoClient(uri);
    db = mongoClient.getDatabase("lab3");
    MongoCollection<Document> collection = db.getCollection("empleados");
   try {    Document findDocument = new Document("_id", new ObjectId(idUsuario)); 
               }
   catch (Exception IllegalArgumentException) {
            cadena =  "error al ingresar el formato o idea de archivo \n\n" + IllegalArgumentException.toString();
            return  cadena;
            }
    collection.replaceOne(
                eq("_id", new ObjectId(idUsuario)),
                new Document("nombre", "Alejando")
                        .append("cédula", 1238864)
                        .append("telefono", Arrays.asList(7713456, 9289552, 5545644)));
        //Document findDocument = new Document("nombre", identificador);            
         Document findDocument1 = new Document("_id", new ObjectId(idUsuario));         
        //collection.deleteOne(new Document("_id", new ObjectId(identificador)));
        MongoCursor<Document> resultDocument  = collection.find(findDocument1).iterator();       
        cadena = "CADENA ACTUALIZADA\n\n"+resultDocument.next().toJson();  
       return cadena;
        }
    
    }



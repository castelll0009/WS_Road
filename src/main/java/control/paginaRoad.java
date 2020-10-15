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
      public String EliminarDocumentoCon(String identificador){   
        String cadena = "";          
        MongoClient mongoClient;
        MongoClientURI uri = new
        MongoClientURI("mongodb://userLab3:passworduserLab3@93.188.167.110:27017/?authSource=lab3");        
        MongoDatabase db;        
        mongoClient = new MongoClient(uri);        
        db = mongoClient.getDatabase("lab3");
               
        //elegimos la collecion de la que desemaos eliminar el documento
        MongoCollection<Document> collection = db.getCollection("usuarios");   
        
        boolean banderaExepcion = false;
        Document findDocument = null;
        //creamos un documento para especificar lo csriterios de  busqueda
          try {
              findDocument = new Document("_id", new ObjectId(identificador));                 
          } catch (Exception e) {
              cadena = e.toString();
              banderaExepcion = true;
              cadena += " ,EL identificador no es un numero hexadecimal valido";
              return cadena;
          }
        MongoCursor<Document> resultDocumentCadena = null;
        if(!banderaExepcion){   
            boolean encontroDocumento = false;                    
            resultDocumentCadena = collection.find(findDocument).iterator();                             
            if(resultDocumentCadena.hasNext() == true){
                encontroDocumento = true;
                cadena = "Este documento fue eliminado con exito:\n\n ";  
                cadena +=resultDocumentCadena.next().toJson();                              
                //buscar una persona   y borrarla                 
                try {
                     resultDocumentCadena =  (MongoCursor<Document>) collection.findOneAndDelete(findDocument);    
                } catch (Exception e) {
                    //omite la exepcion
                }              
            } else{
                 cadena = "No se encontro un documento con  identificador: \n"+identificador;             
            }                                                                                                                      
        }                                
        return cadena;
    }
      
     public String MostrarDocumentoCon(String identificador) {
        String cadena ="El usuario encontrado con ese identificador fue: \n\n";          
        MongoClient mongoClient;
        MongoClientURI uri = new
        MongoClientURI("mongodb://userLab3:passworduserLab3@93.188.167.110:27017/?authSource=lab3");        
        MongoDatabase db;        
        mongoClient = new MongoClient(uri);        
        db = mongoClient.getDatabase("lab3");
               
        //elegimos la collecion de la que desemaos eliminar el documento
        MongoCollection<Document> collection = db.getCollection("usuarios");   
        //Document findDocument = new Document("nombre", identificador);            
         Document findDocument = new Document("_id", new ObjectId(identificador));         
         
       //collection.deleteOne(new Document("_id", new ObjectId(identificador)));
        MongoCursor<Document> resultDocument  = collection.find(findDocument).iterator();       
        cadena += resultDocument.next().toJson();  
       return cadena;
     }          
}



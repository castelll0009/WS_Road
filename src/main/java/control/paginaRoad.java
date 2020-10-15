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
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
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
        String cadena =null;
        
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
              if(identificador.length() > 3){
                  cadena = "espacio vacio en iusaidoop";
              }
          } catch (Exception e) {
              cadena = e.toString();
              banderaExepcion = true;
              cadena += " ,EL identificador no es un numero hexadecimal valido";
          }
          
        if(!banderaExepcion){
           MongoCursor<Document> resultDocumentCadena = null;
                  resultDocumentCadena = collection.find(findDocument).iterator();  
                while (resultDocumentCadena.hasNext() ) { //mientras exitan mas elementos para iterar continuar                               
                resultDocumentCadena.next().toJson();                             
         }
           if(resultDocumentCadena == null){
               cadena = resultDocumentCadena.toString();
               
               //cadena = "No se encontro un documento con ese identidicador";
           }else{
               cadena = "El documento fue eliminado con exito ";
               cadena += resultDocumentCadena.toString();
                //buscar una persona   y borrarla
               Document resultDocument  = collection.findOneAndDelete(findDocument);                      
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



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.paginaRoad;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Ivan Esteban Castill
 */
@Path("WS_road")
public class WS_road {

    @Context
    private UriInfo context;
    /**
     * Creates a new instance of WS_road
     */
    public WS_road() {
        
    }

     @GET
    @Path("consultarEmpleados")
    @Produces({"application/json"})
    public  String consultarEmpleados(){
        paginaRoad miPagina = new paginaRoad();
        return miPagina.ConsultarEmpleados();
    }
    
    @GET
    @Path("consultarUsuarios")
    @Produces({"application/json"}) 
    public String consultarUsuarios(){
       paginaRoad miRTS= new paginaRoad();
       //diseñar el metodo para mostrar los 5 usuarios       
       return miRTS.ConsultarUltimosCincoUsuarios();
    }    
    
    @GET
    @Path("consultarUltimoUsuario")
    @Produces({"application/json"}) 
    public String consultarUltimoUsuario(){
       paginaRoad miRTS= new paginaRoad();
       //diseñar el metodo para mostrar los 5 usuarios       
       return miRTS.ConsultarUltimoUsuario();
    }  
   
    @GET
    @Path("eliminarDocumentoCon/idUsuario/{idUsuario}")
    @Produces({"application/json"}) 
    public String EliminarDocumentoCon(@PathParam("idUsuario") String idUsuario){
        paginaRoad miPagina = new paginaRoad();
    return miPagina.EliminarDocumentoCon(idUsuario);
    }    
}

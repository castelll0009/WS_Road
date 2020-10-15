/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.mongodb.Mongo;
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
    public  String ConsultarEmpleados(){
        paginaRoad miPagina = new paginaRoad();
        return miPagina.ConsultarEmpleados();
    }
       @GET
    @Path("actualizarDocumento/idEmpleado/{idEmpleado}")
    @Produces({"application/json"}) 
    public String actualizarDocumento(@javax.ws.rs.PathParam("idEmpleado") String idEmpleado){
           WS_road miPagina = new WS_road();
    return miPagina.actualizarDocumento(idEmpleado);
    }  
    
}

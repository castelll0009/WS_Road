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
/*
    @GET
    @Path("consultarUsuario/idUsuario/{idUsuario}/nombre/{nombre}")
    @Produces({"application/json"})
    public String consultarUsuario(@PathParam("idUsuario ") String idUsuario,
    @PathParam("nombre ") String nombre){
    paginaRoad mipagina = new paginaRoad();
    return mipagina.consultarUsuario(idUsuario, nombre);
    }
    */
    
    @GET
    @Path("consultarEmpleados")
    @Produces({"application/json"})
    public  String ConsultarEmpleados(){
        paginaRoad miPagina = new paginaRoad();
        return miPagina.consultarEmpleados();
    }
    
}

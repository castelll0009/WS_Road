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
    @Path("consultarClientes")
    @Produces({"application/json"})
    public  String consultarClientes(){
        paginaRoad miPagina = new paginaRoad();
        return miPagina.consultarClientes();
    }
}

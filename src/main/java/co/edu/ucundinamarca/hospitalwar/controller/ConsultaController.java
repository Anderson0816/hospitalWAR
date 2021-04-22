/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalwar.controller;


import co.edu.ucundinamarca.hospitalejb.entity.Consulta;
import co.edu.ucundinamarca.hospitalejb.exception.ModelNotFoundException;
import co.edu.ucundinamarca.hospitalejb.interfaz.IConsultaService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ander
 */
@Stateless
@Path("/consultas")
public class ConsultaController {
    
    @EJB
    private IConsultaService service;
    
    @Path("/buscarPorId/{idConsulta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("idConsulta") int idConsulta) throws ModelNotFoundException {
            Consulta consulta = service.buscarPorId(idConsulta);
            return Response.status(Response.Status.OK)
                        .entity(consulta)
                        .build();
    }       
    
    
    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Consulta consulta) {
            service.guardar(consulta);
            return Response.status(Response.Status.CREATED)
                        .build();
    }
    
    @Path("/eliminar/{idConsulta}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("idConsulta") int idConsulta) throws ModelNotFoundException {
            service.eliminar(idConsulta);
            return Response.status(Response.Status.NO_CONTENT)
                        .build();
    }    
}


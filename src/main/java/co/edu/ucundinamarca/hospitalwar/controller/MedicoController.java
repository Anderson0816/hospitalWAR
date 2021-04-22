/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalwar.controller;

import co.edu.ucundinamarca.hospitalejb.entity.Medico;
import co.edu.ucundinamarca.hospitalejb.exception.ModelNotFoundException;
import co.edu.ucundinamarca.hospitalejb.interfaz.IMedicoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/medicos")
public class MedicoController {
    
    @EJB
    private IMedicoService service;
 
    @Path("/crear")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(@Valid Medico medico) {
        service.guardar(medico);
        return Response.status(Response.Status.CREATED).
                entity("el medico fue creado exitosamente").build();
    }
    
    
    
    
    @Path("/buscar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId() throws ModelNotFoundException {
            List<Medico> listaConsulta = service.buscar();
            return Response.status(Response.Status.OK)
                        .entity(listaConsulta)
                        .build();
    }       
    
    @Path("/buscar/{idMedico}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("idMedico") int idMedico) throws ModelNotFoundException {
            Medico consulta = service.buscarPorId(idMedico);
            return Response.status(Response.Status.OK)
                        .entity(consulta)
                        .build();
    }       
    
    
    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Medico medico) {
            service.guardar(medico);
            return Response.status(Response.Status.CREATED)
                        .build();
    }
    
    @Path("/guardar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Medico medico) throws ModelNotFoundException {
            service.editar(medico);
            return Response.status(Response.Status.CREATED)
                        .build();
    }    
    
    @Path("/eliminar/{idConsulta}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("idMedico") int idMedico) throws ModelNotFoundException {
            service.eliminar(idMedico);
            return Response.status(Response.Status.NO_CONTENT)
                        .build();
    }        
    
    
}

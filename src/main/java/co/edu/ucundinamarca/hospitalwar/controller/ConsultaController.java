/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalwar.controller;


import co.edu.ucundinamarca.hospitalejb.entity.Consulta;
import co.edu.ucundinamarca.hospitalejb.exception.IntegridadException;
import co.edu.ucundinamarca.hospitalejb.exception.NotFoundObjectException;
import co.edu.ucundinamarca.hospitalejb.interfaz.IConsultaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Erika Moreno
 */
@Stateless
@Path("/consultas")
public class ConsultaController {
    
    @EJB
    private IConsultaService service;
    
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() throws NoContentException, co.edu.ucundinamarca.hospitalejb.exception.NoContentException {
        List<Consulta> consulta = service.listar();
        return Response.status(Response.Status.OK).entity(consulta).build();
    }
    
    @Path("guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar (@Valid Consulta consulta) throws IntegridadException, BadRequestException {
        service.guardar(consulta);
        return Response.status(Response.Status.CREATED).entity("Se ha creado satisfactoriamente.").build();
    }
    @Path("eliminar/{idConsulta}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar (@PathParam("idConsulta") int idConsulta) throws IntegridadException, BadRequestException, NotFoundObjectException {
        service.eliminar(idConsulta);
        return Response.status(Response.Status.NO_CONTENT).entity("Se ha eliminado satisfactoriamente.").build();
    }
    @Path("buscarPorId/{idConsulta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId (@PathParam("idConsulta") int idConsulta) throws IntegridadException, BadRequestException, NotFoundObjectException, NoContentException, NotAllowedException, co.edu.ucundinamarca.hospitalejb.exception.NoContentException {
        Consulta consulta = service.BuscarPorId(idConsulta);
        return Response.status(Response.Status.OK).entity(consulta).build();
    }
     @Path("editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Consulta consulta) throws IntegridadException, NotFoundObjectException, BadRequestException{
        service.editar(consulta);
        return Response.status(Response.Status.OK).entity("Se ha editado satisfactoriamente.").build();
    }
}

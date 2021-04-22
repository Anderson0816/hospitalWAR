/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalwar.exception.filter;

import co.edu.ucundinamarca.hospitalwar.pojo.ErrorDto;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ander
 */
@Provider
public class WebAplicationFiltro implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException ex) {
        if (ex instanceof InternalServerErrorException) {
            ErrorDto error = new ErrorDto(ex.getMessage(),"18/03/2021 10:44 am"); 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
        } else if (ex instanceof NotAllowedException) {
            ErrorDto error = new ErrorDto(ex.getMessage(),"18/03/2021 10:44 am");
            return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(error).type(MediaType.APPLICATION_JSON).build();
        } else if (ex instanceof BadRequestException) {
            ErrorDto error = new ErrorDto(ex.getMessage(),"18/03/2021 10:44 am");
            return Response.status(Response.Status.BAD_REQUEST).entity(error).type(MediaType.APPLICATION_JSON).build();
        } else if (ex instanceof NotSupportedException) {
            ErrorDto error = new ErrorDto(ex.getMessage(),"18/03/2021 10:44 am");
            return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity(error).type(MediaType.APPLICATION_JSON).build();
        } else if (ex instanceof NotFoundException) {
            ErrorDto error = new ErrorDto(ex.getMessage(),"18/03/2021 10:44 am");
            return Response.status(Response.Status.NOT_FOUND).entity(error).type(MediaType.APPLICATION_JSON).build();
        }
        ErrorDto error = new ErrorDto(ex.getMessage(),"18/03/2021 10:44 am");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).type(MediaType.APPLICATION_JSON).build();
    }
}

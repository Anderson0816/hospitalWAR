/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalwar.exception.filter;

import co.edu.ucundinamarca.hospitalwar.pojo.ErrorDto;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author ander
 */
public class EJBExcepccionFilter implements ExceptionMapper<EJBTransactionRolledbackException> {

    @Override
    public Response toResponse(EJBTransactionRolledbackException ex) {
        ErrorDto error = new ErrorDto("error: " + ex.getMessage() + ex.getCause(), "18/03/2021 10:44 am");
        return Response.status(Response.Status.CONFLICT).entity(error).build();
    }
}

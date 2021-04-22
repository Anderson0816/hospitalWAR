/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.hospitalwar.exception.filter;

import co.edu.ucundinamarca.hospitalejb.exception.IntegridadException;
import co.edu.ucundinamarca.hospitalwar.pojo.ErrorDto;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ander
 */
@Provider
public class IntegridadExceptionFilter implements ExceptionMapper<IntegridadException>{

    @Override
    public Response toResponse(IntegridadException exception) {
            //Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);            
            ErrorDto error  = new ErrorDto(exception.getMessage(), "9/03/2021 10:44 am");
            return Response.status(Response.Status.CONFLICT)
                        .entity(error)
                        .build();                    
    }  
} 


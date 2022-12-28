package br.com.ada.excecoes;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class EscolaExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        if(e instanceof  NullPointerException) {
            return Response.status(Response.Status.NOT_FOUND).entity("Teste").build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(e.getMessage())
            .build();
    }
}

package br.com.ada.resource;

import br.com.ada.dto.AlunoRequest;
import br.com.ada.dto.AlunoResponse;
import br.com.ada.model.Aluno;
import br.com.ada.service.AlunoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("/alunos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {

    private AlunoService service;

    @Inject
    public AlunoResource(AlunoService service){
        this.service = service;
    }

    @GET
    public Response listarAlunos() {
        return Response.ok(service.listarAlunos()).build();
    }

    @GET
    @Path("/{id}")
    public Response listarAlunoPorId(@PathParam("id") Integer id){
        AlunoResponse alunoResponse = service.listarAlunoPorId(id);
        if(Objects.isNull(alunoResponse)){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(alunoResponse).build();
        }

    }

    @POST
    public Response salvarAluno(AlunoRequest alunoRequest){
        service.salvarAluno(alunoRequest);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterarAluno(@PathParam("id") Integer id, AlunoRequest alunoRequest){
        AlunoResponse alunoAlterado = service.alterarAluno(id, alunoRequest);
        if(Objects.isNull(alunoAlterado)){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(alunoAlterado).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletarAluno(@PathParam("id") Integer id){
        service.deletarAluno(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}

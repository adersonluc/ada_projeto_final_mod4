package br.com.ada.resource;

import br.com.ada.model.Disciplina;
import br.com.ada.service.DisciplinaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("/disciplinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisciplinaResource {

    private DisciplinaService service;

    @Inject
    public DisciplinaResource(DisciplinaService service){
        this.service = service;
    }

    @GET
    public Response listarDisciplinas(){
        return Response.ok(service.listarDisciplinas()).build();
    }

    @GET
    @Path("/{id}")
    public Response listarDisciplinaPorId(@PathParam("id") Integer id){
        Disciplina disciplina = service.listarDisciplinaPorId(id);
        if(Objects.isNull(disciplina)){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(disciplina).build();
        }
    }

    @POST
    public Response salvarDisciplina(Disciplina disciplina){
        service.salvarDisciplina(disciplina);
        return  Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterarDisciplina(@PathParam("id") Integer id, Disciplina disciplina){
        Disciplina disciplinaAlterada = service.alterarDisciplina(id, disciplina);
        if(Objects.isNull(disciplinaAlterada)){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(disciplinaAlterada).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletarDisciplina(@PathParam("id") Integer id){
        service.deletarDisciplina(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/{id-disciplina}/professor/{id-professor}")
    public Response atualizarProfessorDaDisciplina(@PathParam("id-disciplina") Integer idDisciplina, @PathParam("id-professor") Integer idProfessor){
        return Response.ok(service.atualizarProfessorDaDisciplina(idDisciplina, idProfessor)).build();
    }

}

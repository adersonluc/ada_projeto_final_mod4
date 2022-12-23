package br.com.ada.resource;

import br.com.ada.model.Professor;
import br.com.ada.service.ProfessorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/professores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorResource {

    private ProfessorService service;

    @Inject
    public ProfessorResource(ProfessorService service){
        this.service = service;
    }

    @GET
    public Response listarProfessores() {
        List<Professor> professores = service.listarProfessores();
        return Response.ok(professores).build();
    }

    @GET
    @Path("/{id}")
    public Response listarProfessorPorId(@PathParam("id") Integer id){
        Professor professor = service.getProfessorById(id);
        if(Objects.isNull(professor)){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(professor).build();
        }
    }

    @POST
    public Response salvarProfessor(Professor professor){
        service.salvarProfessor(professor);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterarProfessor(@PathParam("id") Integer id, Professor professor){
        Professor professorAlterado = service.alterarProfessor(id, professor);
        if(Objects.isNull(professorAlterado)){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(professorAlterado).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletarProfessor(@PathParam("id") Integer id){
        service.deletarProfessor(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
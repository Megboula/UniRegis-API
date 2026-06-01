package com.project.resource;

import com.project.model.Inscription;
import com.project.model.InscriptionDTO;
import com.project.service.InscriptionService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@Path("/inscriptions")
@OpenAPIDefinition(info = @Info(title = "UniRegis API", version = "1.0"))
@RequestScoped 
public class InscriptionResource {

    @Inject 
    private InscriptionService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON) 
    @Operation(summary = "Créer une inscription") 
    public Response inscrire(@Valid InscriptionDTO dto) {
        Inscription created = service.creer(dto);
        return Response.status(201).entity(created).build(); // Renvoie le statut HTTP 201 (Créé)
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String tester() {
        return "Bravo, le project fonctionne !";
    }
}
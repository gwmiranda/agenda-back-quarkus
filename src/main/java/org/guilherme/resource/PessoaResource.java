package org.guilherme.resource;

import org.guilherme.entity.Pessoa;
import org.guilherme.service.PessoaService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pessoa")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    PessoaService pessoaService;

    @POST
    @Transactional
    public void salvar(Pessoa pessoa){
        pessoaService.salvar(pessoa);
    }

    @GET
    @Transactional
    public List<Pessoa> listaPessoa(){
        return pessoaService.listar();
    }

    @GET
    @Path("/{id}")
    @Transactional
    public Pessoa procurarPessoa(@PathParam("id") Long id){
        return pessoaService.procurarPorId(id);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void atualizarPessoa(@PathParam("id") Long id, Pessoa pessoa){
        pessoaService.atualizar(id, pessoa);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void deletarPessoa(@PathParam("id") Long id){
        pessoaService.deletar(id);
    }
}
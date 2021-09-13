package org.guilherme.resource;

import org.guilherme.entity.Pessoa;
import org.guilherme.repository.PessoaRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    PessoaRepository pessoaRepository;

    @POST
    @Transactional
    public void salvar(Pessoa pessoa){
        pessoaRepository.persist(pessoa);
    }

    @GET
    @Transactional
    public List listaPessoa(){
        List<Pessoa> pessoas = pessoaRepository.listAll();
        return pessoas;
    }

    @GET
    @Path("/{id}")
    public Pessoa procurarPessoa(@PathParam("id") Long id){
        return pessoaRepository.findById(id);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void atualizarPessoa(@PathParam("id") Long id, Pessoa pessoa){
        Pessoa p = pessoaRepository.findById(id);
        if(p == null){
            throw new NotFoundException();
        }
        p.setNome(pessoa.getNome());
        p.setSobrenome(pessoa.getSobrenome());
        p.setNascimento(pessoa.getNascimento());
        p.setParentesco(pessoa.getParentesco());
        p.setContato(pessoa.getContato());
        pessoaRepository.persist(p);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void deletarPessoa(@PathParam("id") Long id){
        if (!pessoaRepository.deleteById(id)) {
            throw new WebApplicationException(404);
        }
    }
}
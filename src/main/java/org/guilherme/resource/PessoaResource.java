package org.guilherme.resource;

import org.guilherme.TokenUtils;
import org.guilherme.entity.Pessoa;
import org.guilherme.entity.UsuarioLogado;
import org.guilherme.service.PessoaService;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pessoa")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    PessoaService pessoaService;

    @POST
    @Transactional
    @RolesAllowed({ TokenUtils.ROLE_USER })
    public void salvar(Pessoa pessoa){
        pessoa.setUsername(UsuarioLogado.getUsuarioLogado().getUsername());
        pessoaService.gravar(pessoa);
    }

    @GET
    @Transactional
    @RolesAllowed({ TokenUtils.ROLE_USER })
    public List listaPessoa(){
        return pessoaService.contatosPorUsuario(UsuarioLogado.getUsuarioLogado().getUsername());
    }

    @GET
    @Path("/{id}")
    @Transactional
    @RolesAllowed({ TokenUtils.ROLE_USER })
    public Pessoa procurarPessoa(@PathParam("id") Long id){
        return pessoaService.procurarPorId(id);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({ TokenUtils.ROLE_USER })
    public void atualizarPessoa(@PathParam("id") Long id, Pessoa pessoa){
        pessoaService.atualizar(id, pessoa);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({ TokenUtils.ROLE_USER })
    public void deletarPessoa(@PathParam("id") Long id){
        pessoaService.deletar(id);
    }
}
package org.guilherme.resource;

import org.guilherme.entity.Usuario;
import org.guilherme.entity.UsuarioLogado;
import org.guilherme.service.TokenService;
import org.guilherme.service.UsuarioService;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @Inject
    TokenService tokenService;

    @POST
    @Transactional
    @PermitAll
    public String verificarLogin(Usuario usuario) {
        if (usuarioService.verificarLogin(usuario)) {
            UsuarioLogado.setUsuarioLogado(usuario);
            return tokenService.generate(usuario.getUsername());
        } else {
            throw new NotAuthorizedException("Erro de usuario ou senha");
        }
    }

    @POST
    @PermitAll
    @Transactional
    @Path("/cadastro")
    public void gravar(Usuario usuario) {
        usuarioService.gravar(usuario);
    }
}

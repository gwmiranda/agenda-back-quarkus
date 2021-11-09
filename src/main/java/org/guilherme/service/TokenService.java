package org.guilherme.service;

import org.eclipse.microprofile.jwt.Claims;
import org.guilherme.TokenUtils;
import org.jose4j.jwt.JwtClaims;

import javax.enterprise.context.RequestScoped;
import java.util.Arrays;

@RequestScoped
public class TokenService {
    public String generate(String usuario) {
        try {
            JwtClaims jwtClaims = new JwtClaims();
            jwtClaims.setIssuer("https://quarkus.io/using-jwt-rbac");
            jwtClaims.setJwtId("a-123");
            jwtClaims.setSubject(usuario);
            jwtClaims.setClaim(Claims.upn.name(), usuario);
            jwtClaims.setClaim(Claims.groups.name(), Arrays.asList(TokenUtils.ROLE_USER));
            jwtClaims.setAudience("using-jwt");
            jwtClaims.setExpirationTimeMinutesInTheFuture(10);

            String token = TokenUtils.generateTokenString(jwtClaims);

            return token;
        } catch (Exception e) {
            throw new RuntimeException("Oops!" + e);
        }
    }
}

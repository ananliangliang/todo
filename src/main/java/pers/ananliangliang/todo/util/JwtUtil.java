package pers.ananliangliang.todo.util;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    private final SecretKey secretKey;

    public JwtUtil() throws NoSuchAlgorithmException {
        secretKey = KeyGenerator.getInstance("HmacSHA512").generateKey();
    }

    public String createJwtToken(UserDetails userDetails) throws JOSEException {
        final var now = Instant.now();
        final var header = new JWSHeader.Builder(JWSAlgorithm.HS512)
                .type(JOSEObjectType.JWT)
                .build();
        final var claimsSet = new JWTClaimsSet.Builder()
                .jwtID("todo")
                .claim("authorities", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .subject(userDetails.getUsername())
                .issueTime(Date.from(now))
                .expirationTime(Date.from(now.plusSeconds(60)))

                .build();


        final var jwt = new SignedJWT(header, claimsSet);

        jwt.sign(new MACSigner(secretKey));

        return jwt.serialize();
    }


}

package com.example.movie;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class JWTHandler {

  private static final String SECRET_KEY = "k7jfjsdja89fksalmcfiusah9jfslamf9sdjfasldfn389fj2udshjfansdu"
      + "sdf89asjdf9asbdu9nfsa9ufnsad9f8uhaasnd9funbds9ufpn9ufabd9uffah";

  public static String createJWT(String id, String issuer, String subject) {

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(System.getenv("SECRET_KEY"));
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    JwtBuilder builder = Jwts.builder().setId(id)
        .setIssuedAt(now)
        .setSubject(subject)
        .setIssuer(issuer)
        .setExpiration(new Date(System.currentTimeMillis() + (1000*30)))
        .signWith(signatureAlgorithm, signingKey);

    return builder.compact();
  }

  public static Claims decodeJWT(String jwt) {
    return Jwts.parser()
        .setSigningKey(DatatypeConverter.parseBase64Binary(System.getenv("SECRET_KEY")))
        .parseClaimsJws(jwt).getBody();
  }

}

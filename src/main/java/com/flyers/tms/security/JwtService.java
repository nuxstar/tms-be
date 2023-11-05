package com.flyers.tms.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.function.Function;
import javax.crypto.SecretKey;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The JwtUtility class provides utility methods for working with JWT (JSON Web
 * Tokens).
 */
@Component
@Data
public class JwtService {

  @Value("${security.jwt.secret-key}")
  private String secretKey;

  @Value("${security.jwt.expiration}")
  private long jwtExpiration;

  private SecretKey getSecretKey() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
  }

  /**
   * Extract all the claims from token.
   */
  public Claims extractAllClaims(String token) {
    return Jwts.parserBuilder().setSigningKey(getSecretKey())
        .build().parseClaimsJws(token).getBody();
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  /**
   * validate our jwt access token using this method.
   */
  public boolean isTokenValid(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(getSecretKey()).build().parseClaimsJws(token);
    } catch (Exception e) {
      return false;
    }
    final Date tokenExpirationDate = extractClaim(token, Claims::getExpiration);
    return tokenExpirationDate.after(new Date());
  }
}

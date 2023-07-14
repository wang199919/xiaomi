package com.test.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import java.util.Date;

/**
 * @author: roy
 * @date: 2023/7/14 11:12
 * @description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "roy.jwt")
public class JwtUtils {
 private  long   expire;
 private  String secret;
 private  String header;

 /*生成JWT*/
 public  String generateToken(String username){
  Date date=new Date();
  Date expireDate=new Date(date.getTime()+1000*expire);
  return  Jwts.builder()
          .setHeaderParam("typ","JWT")
          .setSubject(username)
          .setIssuedAt(date)
          .setExpiration(expireDate)
          .signWith(SignatureAlgorithm.ES512,secret)
          .compact();
 }
 /*解析JWT*/
 public  Claims getClaimsByToken(String jwt){
  return Jwts.parser()
          .setSigningKey(secret)
          .parseClaimsJws(jwt)
          .getBody() ;
 }
/*判断jwt是否过期*/
 public  boolean isTokenExpired(Claims claims){
  return claims.getExpiration() .before(new Date());
 }
}



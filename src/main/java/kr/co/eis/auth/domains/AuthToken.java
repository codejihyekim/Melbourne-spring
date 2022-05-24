package kr.co.eis.auth.domains;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName: kr.co.eis.security.domains
 * fileName        : SecurityToken
 * author          : codejihyekim
 * date            : 2022-05-23
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-23         codejihyekim      최초 생성
 */
@Log
public class AuthToken {
    private String token;
    private String key;

    public AuthToken(String key) {
        this.key = key;
        this.token = createToken();
    }

    private String createToken() {
        try{
            Map<String, Object> headers = new HashMap<>();
            headers.put("typ","JWT");
            headers.put("alg","HS256");
            Map<String, Object> payload = new HashMap<>();
            payload.put("data","dummy");
            Date exp = new Date();
            exp.setTime(exp.getTime() + 1000 * 60L * 10L);

            return Jwts.builder()
                    .setHeader(headers)
                    .setClaims(payload)
                    .setSubject("user")
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256, key.getBytes())
                    .compact();
        }
        catch (SecurityException e){log.info("SecurityException");} //보안문제
        catch (MalformedJwtException e){log.info("MalformedJwtException");} //정당하지않은 토큰
        catch (ExpiredJwtException e){log.info("ExpiredJwtException");} //만료된 토큰
        catch (UnsupportedJwtException e){log.info("UnsupportedJwtException");} //위조
        catch (IllegalAccessError e){log.info("IllegalAccessError");} //불법 접속
        return null;
    }

}

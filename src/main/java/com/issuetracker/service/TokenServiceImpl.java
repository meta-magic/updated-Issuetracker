/*package com.issuetracker.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class TokenServiceImpl implements TokenService {

	@Value("${token.key}")
	private String tokenKey = null;

	@Value("${token.validity}")
	private Long tokenValidity = null;

	@Override

	public String generateToken(String loginId, Integer userId) {
		JSONObject json = new JSONObject();
		try {
			json.put("loginId", loginId);
			json.put("userId", userId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return generateTokenFromJson(json, tokenValidity);
	}

	@Override
	public JSONObject getTokenData(String tokenId) throws JSONException, ExpiredJwtException, UnsupportedJwtException,
			MalformedJwtException, SignatureException, IllegalArgumentException {
		String tokenData = Jwts.parser().setSigningKey(tokenKey).parseClaimsJws(tokenId).getBody().getSubject();
		return new JSONObject(tokenData);
	}

	private String generateTokenFromJson(JSONObject tokenJson, Long tokenExpiry) {
		return Jwts.builder().setSubject(tokenJson.toString())
				.setExpiration(new Date(System.currentTimeMillis() + tokenExpiry))
				.signWith(SignatureAlgorithm.HS512, tokenKey).compact();
	}

	public String generateToken(JSONObject tokenJson, Long tokenExpiry) {
		return generateTokenFromJson(tokenJson, tokenExpiry);
	}
}
*/
package com.camlait.global.erp.service.auth;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.camlait.global.erp.domain.auth.Ressource;
import com.camlait.global.erp.domain.model.json.auth.RessourceModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Transactional
public class AuthentificationServiceDelegate {

	@Autowired
	IAuthentificationService service;

	public Map<String, Object> menuItem() throws JsonProcessingException {
		ObjectMapper p = new ObjectMapper();
		Collection<Ressource> rs = service.listerRessource();
		System.out.println(p.writeValueAsString(rs));
		Map<String, Object> m = new HashMap<>();
		rs.stream().forEach(r -> {
			System.out.println(1);
			m.put("items", new RessourceModel(r));
		});
		return m;
	}
}

package com.camlait.global.erp.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.camlait.global.erp.domain.auth.Ressource;
import com.camlait.global.erp.domain.model.json.auth.RessourceModel;

@Transactional
public class AuthentificationServiceDelegate {

	@Autowired
	IAuthentificationService service;
	private StringBuilder recap = new StringBuilder();
	private List<Map<String, Object>> menus = new ArrayList<Map<String, Object>>();
	private Map<String, Object> feuille = new HashMap<>();
	private List<Map<String, Object>> noeud = new ArrayList<Map<String, Object>>();
	public Map<String, Object> menuItem() {
		Map<String, Object> map = new HashMap<>();
		Collection<Map<String, Object>> menus = new HashSet<>();
		for (RessourceModel r : listerRessource()) {
			// noeud(menus, map, r);
		}
		map.put("items", menus);
		return map;
	}

	private Collection<RessourceModel> listerRessource() {
		Collection<RessourceModel> rs = new HashSet<>();
		service.listerRessource().stream().forEach(c -> {
			Ressource r = service.obtenirRessource(c.getRessourceId());
			RessourceModel a = new RessourceModel(r);
			a.setTitle("{{getWord('" + r.getTitle() + "'}}");
			rs.add(a);
		});
		return rs;
	}
	
	private void buildRessourceModel(Map<String, Object> menus, RessourceModel racine){
		Map<String, Object> feuille = new HashMap<>();
		if(racine.getItems().isEmpty()){
			feuille.put("tiltle", racine.getTitle());			
			
		}else{
			feuille.put("tiltle", racine.getTitle());
			for(RessourceModel r:racine.getItems()){
				//buildRessourceModel(r);
			}
		}
		
	}
}

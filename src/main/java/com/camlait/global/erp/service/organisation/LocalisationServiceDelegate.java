package com.camlait.global.erp.service.organisation;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.camlait.global.erp.domain.model.json.organisation.CentreModel;
import com.camlait.global.erp.domain.model.json.organisation.LocalisationModel;
import com.camlait.global.erp.domain.model.json.organisation.RegionModel;
import com.camlait.global.erp.domain.model.json.organisation.SecteurModel;
import com.camlait.global.erp.domain.model.json.organisation.ZoneModel;
import com.camlait.global.erp.domain.organisation.Centre;
import com.camlait.global.erp.domain.organisation.Localisation;
import com.camlait.global.erp.domain.organisation.Region;
import com.camlait.global.erp.domain.organisation.Secteur;
import com.camlait.global.erp.domain.organisation.Zone;

public class LocalisationServiceDelegate {

	@Autowired
	private ILocalisationService service;

	public LocalisationModel ajouterLocalisation(Localisation local) {
		return new LocalisationModel(service.ajouterLocalisation(local));
	}

	public LocalisationModel modifierLocalisation(Localisation local) {
		return new LocalisationModel(service.modifierLocalisation(local));
	}

	public LocalisationModel obtenirLocalisation(Long localId) {
		return new LocalisationModel(service.obtenirLocalisation(Localisation.class, localId));
	}

	public LocalisationModel obtenirLocalisation(String codeLocalisation) {
		return new LocalisationModel(service.obtenirLocalisation(Localisation.class, codeLocalisation));
	}

	public CentreModel obtenirCentre(Long localId) {
		return new CentreModel(service.obtenirLocalisation(Centre.class, localId));
	}

	public CentreModel obtenirCentre(String codeLocalisation) {
		return new CentreModel(service.obtenirLocalisation(Centre.class, codeLocalisation));
	}

	public RegionModel obtenirRegion(Long localId) {
		return new RegionModel(service.obtenirLocalisation(Region.class, localId));
	}

	public RegionModel obtenirRegion(String codeLocalisation) {
		return new RegionModel(service.obtenirLocalisation(Region.class, codeLocalisation));
	}

	public SecteurModel obtenirSecteur(Long localId) {
		return new SecteurModel(service.obtenirLocalisation(Secteur.class, localId));
	}

	public SecteurModel obtenirSecteur(String codeLocalisation) {
		return new SecteurModel(service.obtenirLocalisation(Secteur.class, codeLocalisation));
	}

	public ZoneModel obtenirZone(Long localId) {
		return new ZoneModel(service.obtenirLocalisation(Zone.class, localId));
	}

	public ZoneModel obtenirZone(String codeLocalisation) {
		return new ZoneModel(service.obtenirLocalisation(Zone.class, codeLocalisation));
	}

	public Collection<CentreModel> listerCentre() {
		Collection<CentreModel> centres = new HashSet<>();
		service.listerCentre().stream().forEach(c -> {
			centres.add(new CentreModel(c));
		});
		return centres;
	}

	public Collection<RegionModel> listerRegion(Centre centre) {
		Collection<RegionModel> regions = new HashSet<>();
		service.listerRegion(centre).stream().forEach(r -> {
			regions.add(new RegionModel(r));
		});
		return regions;
	}

	public Collection<SecteurModel> listerSecteur(Region region) {
		Collection<SecteurModel> secteurs = new HashSet<>();
		service.listerSecteur(region).stream().forEach(s -> {
			secteurs.add(new SecteurModel(s));
		});
		return secteurs;

	}

	public Collection<ZoneModel> listerZone(Secteur secteur) {
		Collection<ZoneModel> zones = new HashSet<>();
		service.listerZone(secteur).stream().forEach(z -> {
			zones.add(new ZoneModel(z));
		});
		return zones;
	}
}

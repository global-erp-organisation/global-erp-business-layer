package com.camlait.global.erp.service.produit;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.camlait.global.erp.domain.enumeration.Portee;
import com.camlait.global.erp.domain.model.json.produit.CategorieProduitModel;
import com.camlait.global.erp.domain.model.json.produit.CategorieProduitTaxeModel;
import com.camlait.global.erp.domain.model.json.produit.ProduitModel;
import com.camlait.global.erp.domain.model.json.produit.ProduitTaxeModel;
import com.camlait.global.erp.domain.produit.CategorieProduit;

public class ProduitServiceDelegate {

    @Autowired
    private IProduitService produitService;

    public ProduitModel obtenirProduit(Long produitId) {
        return new ProduitModel(produitService.obtenirProduit(produitId));
    }

    public ProduitModel obtenirProduit(String codeProduit) {
        return new ProduitModel(produitService.obtenirProduit(codeProduit));
    }

    public Collection<ProduitModel> listerProduit(CategorieProduit categorie) {
        return produitService.listerProduit(categorie).stream().map(p -> {
            return ProduitModel.createProduitModel(p);
        }).collect(Collectors.toList());
    }

    public Page<ProduitModel> listerProduit(Pageable p) {
        final List<ProduitModel> pms = produitService.listerProduit(p).getContent().stream().map(pr -> {
            return new ProduitModel(pr);
        }).collect(Collectors.toList());
        return new PageImpl<ProduitModel>(pms, p, pms.size());
    }

    public Collection<ProduitModel> listerProduit(Collection<CategorieProduit> categories) {
        return produitService.listerProduit(categories).stream().map(p -> {
            return new ProduitModel(p);
        }).collect(Collectors.toList());
    }

    public CategorieProduitModel obtenirCategorieProduit(Long categorieId) {
        return new CategorieProduitModel(produitService.obtenirCategorieProduit(categorieId));
    }

    public CategorieProduitModel obtenirCategorieProduit(String codeCategorie) {
        return new CategorieProduitModel(produitService.obtenirCategorieProduit(codeCategorie));
    }

    public Collection<CategorieProduitModel> listerCategorieProduit() {
        return produitService.listerCategorieProduit().stream().map(c -> {
            return new CategorieProduitModel(c);
        }).collect(Collectors.toList());
    }

    public Collection<CategorieProduitModel> listerCategorie(Long parentId) {
        return produitService.listerCategorie(parentId).stream().map(c -> {
            return new CategorieProduitModel(c);
        }).collect(Collectors.toList());
    }

    public Collection<CategorieProduitModel> listerCategorieProduit(String motCle) {
        return produitService.listerCategorieProduit(motCle).stream().map(c -> {
            return new CategorieProduitModel(c);
        }).collect(Collectors.toList());
    }

    public Collection<ProduitModel> listerProduit(String motCle) {
        return produitService.listerProduit(motCle).stream().map(p -> {
            return new ProduitModel(p);
        }).collect(Collectors.toList());
    }

    public ProduitTaxeModel obtenirProduitTaxe(Long produitTaxeId) {
        return new ProduitTaxeModel(produitService.obtenirProduitTaxe(produitTaxeId));
    }

    public CategorieProduitTaxeModel obtenirCategorieProduitTaxe(Long categorieProduitTaxeId) {
        return new CategorieProduitTaxeModel(produitService.obtenirCategorieProduitTaxe(categorieProduitTaxeId));
    }

    public Collection<CategorieProduitModel> listerCategorie(Portee portee) {
        return produitService.listerCategorie(portee).stream().map(c -> {
            return new CategorieProduitModel(c);
        }).collect(Collectors.toList());
    }
}

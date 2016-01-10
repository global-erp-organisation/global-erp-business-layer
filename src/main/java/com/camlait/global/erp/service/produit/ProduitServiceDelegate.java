package com.camlait.global.erp.service.produit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

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
import com.camlait.global.erp.domain.produit.CategorieProduitTaxe;
import com.camlait.global.erp.domain.produit.ProduitTaxe;

@Transactional
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
        final Collection<ProduitModel> pms = new HashSet<>();
        produitService.listerProduit(categorie).stream().forEach(p -> {
            pms.add(new ProduitModel(p));
        });
        return pms;
    }
    
    public Page<ProduitModel> listerProduit(Pageable p) {
        final List<ProduitModel> pms = new ArrayList<>();
        produitService.listerProduit(p).getContent().stream().forEach(pr -> {
            pms.add(new ProduitModel(pr));
        });
        return new PageImpl<ProduitModel>(pms, p, pms.size());
    }
    
    public Collection<ProduitModel> listerProduit(Collection<CategorieProduit> categories) {
        final Collection<ProduitModel> pms = new HashSet<>();
        produitService.listerProduit(categories).stream().forEach(p -> {
            pms.add(new ProduitModel(p));
        });
        return pms;
    }
    
    public CategorieProduitModel obtenirCategorieProduit(Long categorieId) {
        return new CategorieProduitModel(produitService.obtenirCategorieProduit(categorieId));
    }
    
    public CategorieProduitModel obtenirCategorieProduit(String codeCategorie) {
        return new CategorieProduitModel(produitService.obtenirCategorieProduit(codeCategorie));
    }
    
    public Collection<CategorieProduitModel> listerCategorieProduit() {
        Collection<CategorieProduitModel> cms = new HashSet<>();
        produitService.listerCategorieProduit().stream().forEach(c -> {
            cms.add(new CategorieProduitModel(c));
        });
        return cms;
    }
    
    public Collection<CategorieProduitModel> listerCategorie(Long parentId) {
        Collection<CategorieProduitModel> cms = new HashSet<>();
        produitService.listerCategorie(parentId).stream().forEach(c -> {
            cms.add(new CategorieProduitModel(c));
        });
        return cms;
    }
    
    public Collection<CategorieProduitModel> listerCategorieProduit(String motCle) {
        Collection<CategorieProduitModel> cms = new HashSet<>();
        produitService.listerCategorieProduit(motCle).stream().forEach(c -> {
            cms.add(new CategorieProduitModel(c));
        });
        return cms;
        
    }
    
    public Collection<ProduitModel> listerProduit(String motCle) {
        final Collection<ProduitModel> pms = new HashSet<>();
        produitService.listerProduit(motCle).stream().forEach(p -> {
            pms.add(new ProduitModel(p));
        });
        return pms;
    }
    
    public ProduitTaxeModel obtenirProduitTaxe(Long produitTaxeId) {
        return new ProduitTaxeModel(produitService.obtenirProduitTaxe(produitTaxeId));
    }
    
    public CategorieProduitTaxeModel obtenirCategorieProduitTaxe(Long categorieProduitTaxeId) {
        return new CategorieProduitTaxeModel(produitService.obtenirCategorieProduitTaxe(categorieProduitTaxeId));
    }
    
    public Collection<CategorieProduitModel> listerCategorie(Portee portee) {
        Collection<CategorieProduitModel> cms = new HashSet<>();
        produitService.listerCategorie(portee).stream().forEach(c -> {
            cms.add(new CategorieProduitModel(c));
        });
        return cms;
    }
}

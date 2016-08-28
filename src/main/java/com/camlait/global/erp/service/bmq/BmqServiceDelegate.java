package com.camlait.global.erp.service.bmq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.camlait.global.erp.domain.bmq.Bmq;
import com.camlait.global.erp.domain.bmq.LigneBmq;
import com.camlait.global.erp.domain.bmq.LigneBmqTaxe;
import com.camlait.global.erp.domain.document.Document;
import com.camlait.global.erp.domain.document.commerciaux.Taxe;
import com.camlait.global.erp.domain.model.json.bmq.BmqModel;
import com.camlait.global.erp.domain.model.json.bmq.LigneBmqModel;
import com.camlait.global.erp.domain.model.json.bmq.LigneBmqTaxeModel;
import com.camlait.global.erp.domain.model.json.operation.RecouvrementModel;
import com.camlait.global.erp.domain.operation.Recouvrement;
public class BmqServiceDelegate {

    @Autowired
    private IBmqService bmqService;

    public BmqModel ajouterBmq(Bmq bmq) {
        return new BmqModel(bmqService.ajouterBmq(bmq));
    }

    public BmqModel modifierBmq(Bmq bmq) {
        return new BmqModel(bmqService.modifierBmq(bmq));
    }

    public BmqModel obtenirBmq(Long bmqId) {
        return new BmqModel(bmqService.obtenirBmq(bmqId));
    }

    public BmqModel obtenirBmq(String codeBmq) {
        return new BmqModel(bmqService.obtenirBmq(codeBmq));
    }

    public void supprimerBmq(Long bmqId) {
        bmqService.supprimerBmq(bmqId);
    }

    public Page<BmqModel> listerBmq(Pageable p) {
        final List<BmqModel> bmqs = new ArrayList<>();
        bmqService.listerBmq(p).getContent().forEach(b -> {
            bmqs.add(new BmqModel(b));
        });
        return new PageImpl<>(bmqs);
    }

    public Page<BmqModel> listerBmq(Long vendeurId, Pageable p) {
        final List<BmqModel> bmqs = bmqService.listerBmq(vendeurId, p).getContent().stream().map(b -> {
            return new BmqModel(b);
        }).collect(Collectors.toList());
        return new PageImpl<>(bmqs);
    }

    public Page<BmqModel> listerBmq(Date debut, Date fin, Pageable p) {
        final List<BmqModel> bmqs = bmqService.listerBmq(debut, fin, p).getContent().stream().map(b -> {
            return new BmqModel(b);
        }).collect(Collectors.toList());
        return new PageImpl<>(bmqs);
    }

    public Page<BmqModel> listerBmq(Long vendeurId, Date debut, Date fin, Pageable p) {
        final List<BmqModel> bmqs = bmqService.listerBmq(vendeurId, p).getContent().stream().map(b -> {
            return new BmqModel(b);
        }).collect(Collectors.toList());
        return new PageImpl<>(bmqs);
    }

    public Collection<LigneBmqModel> ajouterLigneBmq(Collection<LigneBmq> ligneBmqs) {
        return bmqService.ajouterLigneBmq(ligneBmqs).stream().map(lb -> {
            return new LigneBmqModel(lb);
        }).collect(Collectors.toList());
    }

    public LigneBmqModel obtenirLigneBmq(Long ligneBmqId) {
        return new LigneBmqModel(bmqService.obtenirLigneBmq(ligneBmqId));
    }

    public void supprimerLigneBmq(Long ligneBmqId) {
        bmqService.supprimerLigneBmq(ligneBmqId);
    }

    public BmqModel genererBmq(Long bmqId, Collection<Document> documents, Collection<Recouvrement> recouvrements) {
        return new BmqModel(bmqService.genererBmq(bmqId, documents, recouvrements));
    }

    public RecouvrementModel ajouterRecouvrement(Recouvrement recouvrement) {
        return new RecouvrementModel(bmqService.ajouterRecouvrement(recouvrement));
    }

    public RecouvrementModel modifierRecouvrement(Recouvrement recouvrement) {
        return new RecouvrementModel(bmqService.modifierRecouvrement(recouvrement));
    }

    public RecouvrementModel obtenirRecouvrement(Long recouvrementId) {
        return new RecouvrementModel(bmqService.obtenirRecouvrement(recouvrementId));
    }

    public void supprimerRecouvrement(Long recouvrementId) {
        bmqService.supprimerRecouvrement(recouvrementId);
    }

    public void supprimerLigneBmq(Bmq bmq) {
        bmqService.supprimerLigneBmq(bmq);
    }

    public LigneBmqTaxeModel ajouterLigneBmqTaxe(LigneBmqTaxe ligneBmqTaxe) {
        return new LigneBmqTaxeModel(bmqService.ajouterLigneBmqTaxe(ligneBmqTaxe));
    }

    public LigneBmqTaxeModel modifierLigneBmqTaxe(LigneBmqTaxe ligneBmqTaxe) {
        return new LigneBmqTaxeModel(bmqService.modifierLigneBmqTaxe(ligneBmqTaxe));
    }

    public LigneBmqTaxeModel obtenirLigneBmqTaxe(Long ligneBmqTaxeId) {
        return new LigneBmqTaxeModel(bmqService.trouverLigneBmqTaxe(ligneBmqTaxeId));
    }

    public void supprimerLigneBmqTaxe(Long ligneBmqTaxeId) {
        bmqService.supprimerLigneBmqTaxe(ligneBmqTaxeId);
    }

    public double chiffreAffaireHorsTaxe(Bmq bmq) {
        return bmqService.chiffreAffaireHorsTaxe(bmq);
    }

    public double chiffreAffaireTTC(Bmq bmq) {
        return bmqService.chiffreAffaireTTC(bmq);
    }

    public double valeurTotaleTaxe(Bmq bmq) {
        return bmqService.valeurTotaleTaxe(bmq);
    }

    public double valeurTaxe(Taxe taxe, Bmq bmq) {
        return bmqService.valeurTaxe(taxe, bmq);
    }

    public double venteComptant(Bmq bmq) {
        return bmqService.venteComptant(bmq);
    }

    public double valeurMarge(Bmq bmq) {
        return bmqService.valeurMarge(bmq);
    }

    public void genererVenteComptant(Bmq bmq) {
        bmqService.genererVenteComptant(bmq);
    }
}

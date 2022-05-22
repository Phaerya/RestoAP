package com.example.restoap;

import java.io.Serializable;

public class Resto implements Serializable {
    protected Integer idResto;
    protected String nomResto;
    protected String numAdrR;
    protected String voieAdrR;
    protected String codePostal;
    protected String ville;
    protected String horaires;
    protected String description;

    public Resto(Integer idResto, String nomResto,  String codePostal, String ville) {
        this.idResto = idResto;
        this.nomResto = nomResto;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Resto(Integer idResto, String nomResto, String numAdrR, String voieAdrR, String codePostal, String ville, String horaires, String description) {
        this.idResto = idResto;
        this.nomResto = nomResto;
        this.numAdrR = numAdrR;
        this.voieAdrR = voieAdrR;
        this.codePostal = codePostal;
        this.ville = ville;
        this.horaires = horaires;
        this.description = description;
    }

    public String getNumAdrR() {
        return numAdrR;
    }

    public void setNumAdrR(String numAdrR) {
        this.numAdrR = numAdrR;
    }

    public String getVoieAdrR() {
        return voieAdrR;
    }

    public void setVoieAdrR(String voieAdrR) {
        this.voieAdrR = voieAdrR;
    }

    public Integer getidResto() {
        return idResto;
    }

    public void setIdResto(Integer idResto) {
        this.idResto = idResto;
    }

    public String getNomResto() {
        return nomResto;
    }

    public void setNomResto(String nomResto) {
        this.nomResto = nomResto;
    }

    public String getLocalisation() {
        return numAdrR;
    }

    public void setLocalisation(String localisation) {
        this.numAdrR = numAdrR;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return nomResto + "\n" + codePostal + " " + ville;
    }
}

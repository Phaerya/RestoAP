package com.example.restoap;

import java.io.Serializable;

public class Reserv implements Serializable {
    protected Integer idResto;
    protected Integer id;
    protected Integer idReservation;
    protected String date_heure;
    protected Integer nbpersonne;

public Reserv (Integer idResto, Integer id, Integer idReservation, String date_heure, Integer nbpersonne) {
    this.idResto = idResto;
    this.id = id;
    this.idReservation = idReservation;
    this.date_heure = date_heure;
    this.nbpersonne = nbpersonne;
}
    public Integer getIdResto() {
        return idResto;
    }

    public void setIdResto(Integer idResto) {
        this.idResto = idResto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public String getDateHeure() {
        return date_heure;
    }

    public void setNumAdrR(String date_heure) {
        this.date_heure = date_heure;
    }

    public Integer getNbpersonne() {
        return nbpersonne;
    }

    public void setNbpersonne(Integer nbpersonne) {
        this.nbpersonne = nbpersonne;
    }
}
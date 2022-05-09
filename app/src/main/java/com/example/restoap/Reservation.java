package com.example.restoap;

import java.io.Serializable;

public class Reservation  implements Serializable {
    protected Integer id;
    protected String nomresa;
    protected Integer nbresa;
    protected Integer idutil;

    public Reservation(String nomresa, Integer idutil) {
        this.nomresa = nomresa;
        //this.nbresa = nbresa;
        this.idutil = idutil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomresa() {
        return nomresa;
    }

    public void setNomresa(String nomresa) {
        this.nomresa = nomresa;
    }

    public Integer getNbresa() {
        return nbresa;
    }

    public void setNbresa(Integer nbresa) {
        this.nbresa = nbresa;
    }

    public Integer getIdutil() {
        return idutil;
    }

    public void setIdutil(Integer idutil) {
        this.idutil = idutil;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", nomresa='" + nomresa + '\'' +
                ", nbresa='" + nbresa + '\'' +
                ", idutil=" + idutil +
                '}';
    }
}

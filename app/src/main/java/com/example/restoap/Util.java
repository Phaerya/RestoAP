package com.example.restoap;

public class Util {
    protected long id;
    protected String pseudo;
    protected String email;
    protected String mdp;
    protected int moderation;

    @Override
    public String toString() {
        return "Util{" +
                "idUtil=" + id +
                ", util='" + pseudo + '\'' +
                ", mail='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", moderation='" + moderation + '\'' +
                '}';
    }

    public Util(String pseudo, String email, String mdp) {
        this.pseudo = pseudo;
        this.email = email;
        this.mdp = mdp;

    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

}

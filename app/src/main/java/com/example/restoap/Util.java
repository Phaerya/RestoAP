package com.example.restoap;

public class Util {
    protected long idUtil;
    protected String util;
    protected String mail;
    protected String mdp;

    @Override
    public String toString() {
        return "Util{" +
                "idUtil=" + idUtil +
                ", util='" + util + '\'' +
                ", mail='" + mail + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }

    public Util(String util, String mail, String mdp) {
        this.util = util;
        this.mail = mail;
        this.mdp = mdp;
    }

    public String getUtil() {
        return util;
    }

    public void setUtil(String util) {
        this.util = util;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

}

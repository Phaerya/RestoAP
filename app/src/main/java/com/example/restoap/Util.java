package com.example.restoap;

import android.os.Parcel;
import android.os.Parcelable;

public class Util implements Parcelable {
    protected long id;
    protected String pseudo;
    protected String email;
    protected String mdp;
    protected int moderation;

    protected Util(Parcel in) {
        id = in.readLong();
        pseudo = in.readString();
        email = in.readString();
        mdp = in.readString();
        moderation = in.readInt();
    }

    public static final Creator<Util> CREATOR = new Creator<Util>() {
        @Override
        public Util createFromParcel(Parcel in) {
            return new Util(in);
        }

        @Override
        public Util[] newArray(int size) {
            return new Util[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(pseudo);
        parcel.writeString(email);
        parcel.writeString(mdp);
        parcel.writeInt(moderation);
    }
}

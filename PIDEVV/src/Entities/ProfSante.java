/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author DELL
 */
public class ProfSante extends User {
private String nomProfS ;
    private String photoProfS ; 
    private int phoneProfS ; 
    private String emailProfS ; 
    private String AdrProfS ; 
    private String titreProfS ; 
    @Override
    public String toString() {
        return "ProfSante{" + "nomProfS=" + nomProfS + ", photoProfS=" + photoProfS + ", phoneProfS=" + phoneProfS + ", emailProfS=" + emailProfS + ", AdrProfS=" + AdrProfS + ", titreProfS=" + titreProfS + '}';
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProfSante other = (ProfSante) obj;
        if (this.phoneProfS != other.phoneProfS) {
            return false;
        }
        if (!Objects.equals(this.nomProfS, other.nomProfS)) {
            return false;
        }
        if (!Objects.equals(this.photoProfS, other.photoProfS)) {
            return false;
        }
        if (!Objects.equals(this.emailProfS, other.emailProfS)) {
            return false;
        }
        if (!Objects.equals(this.AdrProfS, other.AdrProfS)) {
            return false;
        }
        if (!Objects.equals(this.titreProfS, other.titreProfS)) {
            return false;
        }
        return true;
    }

    public String getNomProfS() {
        return nomProfS;
    }

    public void setNomProfS(String nomProfS) {
        this.nomProfS = nomProfS;
    }

    public String getPhotoProfS() {
        return photoProfS;
    }

    public void setPhotoProfS(String photoProfS) {
        this.photoProfS = photoProfS;
    }

    public int getPhoneProfS() {
        return phoneProfS;
    }

    public void setPhoneProfS(int phoneProfS) {
        this.phoneProfS = phoneProfS;
    }

    public String getEmailProfS() {
        return emailProfS;
    }

    public void setEmailProfS(String emailProfS) {
        this.emailProfS = emailProfS;
    }

    public String getAdrProfS() {
        return AdrProfS;
    }

    public void setAdrProfS(String AdrProfS) {
        this.AdrProfS = AdrProfS;
    }

    public String getTitreProfS() {
        return titreProfS;
    }

    public void setTitreProfS(String titreProfS) {
        this.titreProfS = titreProfS;
    }
    

    public ProfSante(String nomUser, String photoUser, int phoneUser, String emailUser, String AdrUser, String RoleUser) {
        super(nomUser, photoUser, phoneUser, emailUser, AdrUser, RoleUser);
    }
    
}

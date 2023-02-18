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
public class Pharmacien extends ProfSante {
  private String nomPharmacien ;
    private String photoPharmacien ; 
    private int phonePharmacien ; 
    private String emailPharmacien ; 
    private String AdrPharmacien ; 

    public Pharmacien(String nomUser, String photoUser, int phoneUser, String emailUser, String AdrUser, String RoleUser) {
        super(nomUser, photoUser, phoneUser, emailUser, AdrUser, RoleUser);
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
        final Pharmacien other = (Pharmacien) obj;
        if (this.phonePharmacien != other.phonePharmacien) {
            return false;
        }
        if (!Objects.equals(this.nomPharmacien, other.nomPharmacien)) {
            return false;
        }
        if (!Objects.equals(this.photoPharmacien, other.photoPharmacien)) {
            return false;
        }
        if (!Objects.equals(this.emailPharmacien, other.emailPharmacien)) {
            return false;
        }
        if (!Objects.equals(this.AdrPharmacien, other.AdrPharmacien)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pharmacien{" + "nomPharmacien=" + nomPharmacien + ", photoPharmacien=" + photoPharmacien + ", phonePharmacien=" + phonePharmacien + ", emailPharmacien=" + emailPharmacien + ", AdrPharmacien=" + AdrPharmacien + '}';
    }

    public String getNomPharmacien() {
        return nomPharmacien;
    }

    public void setNomPharmacien(String nomPharmacien) {
        this.nomPharmacien = nomPharmacien;
    }

    public String getPhotoPharmacien() {
        return photoPharmacien;
    }

    public void setPhotoPharmacien(String photoPharmacien) {
        this.photoPharmacien = photoPharmacien;
    }

    public int getPhonePharmacien() {
        return phonePharmacien;
    }

    public void setPhonePharmacien(int phonePharmacien) {
        this.phonePharmacien = phonePharmacien;
    }

    public String getEmailPharmacien() {
        return emailPharmacien;
    }

    public void setEmailPharmacien(String emailPharmacien) {
        this.emailPharmacien = emailPharmacien;
    }

    public String getAdrPharmacien() {
        return AdrPharmacien;
    }

    public void setAdrPharmacien(String AdrPharmacien) {
        this.AdrPharmacien = AdrPharmacien;
    }

   
  
    
}

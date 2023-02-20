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
public class Patient extends User{

    public Patient(String nomPatient, int phonePatient, String emailPatient, String AdrPatient, String mdp, String RoleUser) {
        super(RoleUser);
        this.nomPatient = nomPatient;
        this.phonePatient = phonePatient;
        this.emailPatient = emailPatient;
        this.AdrPatient = AdrPatient;
        this.mdp = mdp;
    }

  
     private String nomPatient ;
    private int phonePatient ; 
    private String emailPatient ; 
    private String AdrPatient ;
    private String mdp ; 


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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
        final Patient other = (Patient) obj;
        if (this.phonePatient != other.phonePatient) {
            return false;
        }
        if (!Objects.equals(this.nomPatient, other.nomPatient)) {
            return false;
        }
       
        if (!Objects.equals(this.emailPatient, other.emailPatient)) {
            return false;
        }
        if (!Objects.equals(this.AdrPatient, other.AdrPatient)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Patient{" + "nomPatient=" + nomPatient + ", phonePatient=" + phonePatient + ", emailPatient=" + emailPatient + ", AdrPatient=" + AdrPatient + '}';
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

  

    public int getPhonePatient() {
        return phonePatient;
    }

    public void setPhonePatient(int phonePatient) {
        this.phonePatient = phonePatient;
    }

    public String getEmailPatient() {
        return emailPatient;
    }

    public void setEmailPatient(String emailPatient) {
        this.emailPatient = emailPatient;
    }

    public String getAdrPatient() {
        return AdrPatient;
    }

    public void setAdrPatient(String AdrPatient) {
        this.AdrPatient = AdrPatient;
    }
      
   
 
}

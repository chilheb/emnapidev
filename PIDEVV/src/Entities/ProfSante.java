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
    private int phoneProfS ; 
    private String emailProfS ; 
    private String AdrProfS ; 
    private String titreProfS ; 
    private String Mdp ; 
    
    
    public ProfSante(String RoleUser) {
        super(RoleUser);
    }

    public ProfSante(String nomProfS, int phoneProfS, String emailProfS, String AdrProfS,String Titre ,String RoleUser,String Mdp) {
        super(RoleUser);
        this.nomProfS = nomProfS;
        this.phoneProfS = phoneProfS;
        this.emailProfS = emailProfS;
        this.AdrProfS = AdrProfS;
        this.titreProfS = AdrProfS;
        this.Mdp=Mdp ; 
    }

    
   
  
    
 @Override
      public String getMdp() {
        return Mdp;
    }

 @Override
    public void setMdp(String mdp) {
        this.Mdp = mdp;
    }
    @Override
    public String toString() {
        return "ProfSante{" + "nomProfS=" + nomProfS + ", phoneProfS=" + phoneProfS + ", emailProfS=" + emailProfS + ", AdrProfS=" + AdrProfS + ", titreProfS=" + titreProfS + '}';
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
           if (!Objects.equals(this.Mdp, other.Mdp)) {
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
    

  
    
}

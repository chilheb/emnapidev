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
public class Pharmacie {
    
   private  String nomPharmacie ; 
    private String Emplacement ; 
    private int numTel ; 
    
    @Override
    public String toString() {
        return "Pharmacie{" + "nomPharmacie=" + nomPharmacie + ", Emplacement=" + Emplacement + ", numTel=" + numTel + '}';
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
        final Pharmacie other = (Pharmacie) obj;
        if (this.numTel != other.numTel) {
            return false;
        }
        if (!Objects.equals(this.nomPharmacie, other.nomPharmacie)) {
            return false;
        }
        if (!Objects.equals(this.Emplacement, other.Emplacement)) {
            return false;
        }
        return true;
    }

    public String getNomPharmacie() {
        return nomPharmacie;
    }

    public void setNomPharmacie(String nomPharmacie) {
        this.nomPharmacie = nomPharmacie;
    }

    public String getEmplacement() {
        return Emplacement;
    }

    public void setEmplacement(String Emplacement) {
        this.Emplacement = Emplacement;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public Pharmacie(String nomPharmacie, String Emplacement, int numTel) {
        this.nomPharmacie = nomPharmacie;
        this.Emplacement = Emplacement;
        this.numTel = numTel;
    }
   
}

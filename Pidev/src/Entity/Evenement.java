/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Evenement {
    private int Id;
    private String Nom ;
    private String Type ;
    private Date DteEve  ;
    private String LieuEve ;
    private String HrEve;
    private String DescrEve ; 

    public Evenement (int Id,String Nom,String Type,Date DteEve, String LieuEve, String HrEve,String DescrEve) {
        this.Id = Id;
        this.Nom = Nom;
        this.Type = Type;
        this.DteEve = DteEve;
        this.LieuEve = LieuEve;
        this.HrEve = HrEve;
        this.DescrEve = DescrEve;
        
    }

    public Evenement(int aInt, String string, String string0, java.sql.Date date, String string1, Time time, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Evenement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

   
     public String getNom() {
        return Nom;
    }

    public void setNom (String Nom) {
        this.Nom = Nom;
    }
    
     public String getType() {
        return Type;
    }

    public void setType (String Nom) {
        this.Type = Type;
    }
    
    
     public Date getDteEve() {
        return DteEve;
    }

    public void setDteEve(Date DteEve) {
        this.DteEve = DteEve;
    }

     public String getLieuEve() {
        return LieuEve;
    }

    public void setLieuEve(String LieuEve) {
        this.LieuEve = LieuEve;
    }

    public String getHrEve() {
        return HrEve;
    }

    public void setHrEve(String HrEve) {
        this.HrEve = HrEve;
    }

    public void setDescrEve(String DescrEve) {
        this.DescrEve = DescrEve;
    }

    public String getDescrEve() {
        return DescrEve;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.Id;
        hash = 47 * hash + Objects.hashCode(this.Nom);
        hash = 47 * hash + Objects.hashCode(this.Type);
        hash = 47 * hash + Objects.hashCode(this.DteEve);
        hash = 47 * hash + Objects.hashCode(this.LieuEve);
        hash = 47 * hash + Objects.hashCode(this.HrEve);
        hash = 47 * hash + Objects.hashCode(this.DescrEve);
        return hash;
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
        final Evenement other = (Evenement) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.Type, other.Type)) {
            return false;
        }
        if (!Objects.equals(this.LieuEve, other.LieuEve)) {
            return false;
        }
        if (!Objects.equals(this.DescrEve, other.DescrEve)) {
            return false;
        }
        if (!Objects.equals(this.DteEve, other.DteEve)) {
            return false;
        }
        if (!Objects.equals(this.HrEve, other.HrEve)) {
            return false;
        }
        return true;
    }

    public Evenement(String Nom, String Type, Date DteEve, String LieuEve, String HrEve, String DescrEve) {
        this.Nom = Nom;
        this.Type = Type;
        this.DteEve = DteEve;
        this.LieuEve = LieuEve;
        this.HrEve = HrEve;
        this.DescrEve = DescrEve;
    }
    
    





}
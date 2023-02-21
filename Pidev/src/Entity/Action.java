/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author Asus
 */

public class Action {
    private int Id;
    private String Nom ;
    private String LieuAct ;
    private Date DteAct  ;
    public  String HrAct;
    private String DescrAct ;

    public Action(int Id, String Nom, String LieuAct, Date DteAct, String HrAct, String DescrAct) {
        this.Id = Id;
        this.Nom = Nom;
        this.LieuAct = LieuAct;
        this.DteAct = DteAct;
        this.HrAct = HrAct;
        this.DescrAct = DescrAct;
    }
    
    public Action (){
    this.Nom = "";
    this.LieuAct = "";
    this.DteAct =new Date(0);
    this.HrAct = "";
    this.DescrAct = "";
    }

    public int getId() {
        return Id;
    }

    public String getNom() {
        return Nom;
    }

    public String getLieuAct() {
        return LieuAct;
    }

    public Date getDteAct() {
        return DteAct;
    }

    public String getHrAct() {
        return HrAct;
    }

    public String getDescrAct() {
        return DescrAct;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setLieuAct(String LieuAct) {
        this.LieuAct = LieuAct;
    }

    public void setDteAct(Date DteAct) {
        this.DteAct = DteAct;
    }

    public void setHrAct(String HrAct) {
        this.HrAct = HrAct;
    }

    public void setDescrAct(String DescrAct) {
        this.DescrAct = DescrAct;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.Id;
        hash = 59 * hash + Objects.hashCode(this.Nom);
        hash = 59 * hash + Objects.hashCode(this.LieuAct);
        hash = 59 * hash + Objects.hashCode(this.DteAct);
        hash = 59 * hash + Objects.hashCode(this.HrAct);
        hash = 59 * hash + Objects.hashCode(this.DescrAct);
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
        final Action other = (Action) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.LieuAct, other.LieuAct)) {
            return false;
        }
        if (!Objects.equals(this.HrAct, other.HrAct)) {
            return false;
        }
        if (!Objects.equals(this.DescrAct, other.DescrAct)) {
            return false;
        }
        if (!Objects.equals(this.DteAct, other.DteAct)) {
            return false;
        }
        return true;
    }

    public Object getDteact() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



  
}

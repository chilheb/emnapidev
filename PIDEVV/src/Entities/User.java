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
public class User {

    private String nomUser ;
    private int phoneUser ; 
    private String emailUser ; 
    private String AdrUser ; 
    private String RoleUser ;
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
        final User other = (User) obj;
        if (this.phoneUser != other.phoneUser) {
            return false;
        }
        if (!Objects.equals(this.nomUser, other.nomUser)) {
            return false;
        }
      
        if (!Objects.equals(this.emailUser, other.emailUser)) {
            return false;
        }
        if (!Objects.equals(this.AdrUser, other.AdrUser)) {
            return false;
        }
        if (!Objects.equals(this.RoleUser, other.RoleUser)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomUser +" " + phoneUser + " " + emailUser +" " + AdrUser + " " + RoleUser+ "\n" ;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

   

    public int getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(int phoneUser) {
        this.phoneUser = phoneUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getAdrUser() {
        return AdrUser;
    }

    public void setAdrUser(String AdrUser) {
        this.AdrUser = AdrUser;
    }

    public String getRoleUser() {
        return RoleUser;
    }

    public void setRoleUser(String RoleUser) {
        this.RoleUser = RoleUser;
    }

    public User(String nomUser, int phoneUser, String emailUser, String AdrUser, String mdp , String RoleUser) {
        this.nomUser = nomUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
        this.AdrUser = AdrUser;
        this.RoleUser = RoleUser;
        this.mdp=mdp; 
    }
    public User(String RoleUser){
        
        this.RoleUser = RoleUser;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Entity;


/**
 *
 * @author steffen
 */
public class Partner {

    
    private String partnerName;
    private String country;
    
    public Partner(String name, String country) {
        this.partnerName = name;
        this.country = country;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getCountry() {
        return country;
    }
    @Override
    public String toString() {
        return "Partner{" + "partnerName=" + partnerName + ", country=" + country + '}';
    }
    
}

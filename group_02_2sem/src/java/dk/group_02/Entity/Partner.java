/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Entity;

import java.awt.Image;
import java.io.File;
import java.util.Date;

/**
 *
 * @author steffen
 */
public class Partner {
    
    private String partnerName;
    private String country;
    private final String PARTNER_ID;

    public Partner(String name, String country, String partnerId) {
        this.partnerName = name;
        this.country = country;
        this.PARTNER_ID = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getPARTNER_ID() {
        return PARTNER_ID;
    }

    public String getCountry() {
        return country;
    }
}

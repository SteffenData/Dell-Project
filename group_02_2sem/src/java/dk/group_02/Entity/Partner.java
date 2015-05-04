/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.Entity;

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

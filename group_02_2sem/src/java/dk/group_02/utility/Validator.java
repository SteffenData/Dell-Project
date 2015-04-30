/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.utility;

public class Validator {
    
    public boolean validateProjectInfo(String projectName, Double cost, String status, String description, String goal) {

        if (projectName.length() > 30 || status.length() > 30 || cost > 10000000 || description.length() > 250 || goal.length() > 250) {
            return false;
        } else {
            return true;
        }
    }
    
}

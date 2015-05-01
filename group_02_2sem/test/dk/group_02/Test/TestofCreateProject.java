/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */

package dk.group_02.Test;
import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.data.DataManager;
import dk.group_02.control.Controller;
import dk.group_02.control.Manager;
import dk.group_02.utility.Validator;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestofCreateProject {
    
    Partner partner;
    Project project;
    Manager manager;
    Controller ctrl;
    Validator val;
    String stringLong;
    String stringTooLong;
    
    @Before
    public void setUp() {
        partner = new Partner("elgiganten", "Denmark");
        project = new Project(0, "1992-10-10", "TestProject", 1.0, "testing", "test", "test", partner);
        manager = new DataManager();
        ctrl = new Controller();
        val = new Validator();
        stringLong = new String(new char[250]).replace('\0', 'm');
        stringTooLong = new String(new char[251]).replace('\0', 'm');
    }

    @Test
    public void testValidateProjectInfo() {
        assertTrue(val.validateProjectInfo("allGood", 1.0, "status", "des", "goal")); // her tester vi for alle begrænsninger i alle felter om det går godt
    }

    @Test
    public void testValidateProjectInfoName() {
        assertTrue(val.validateProjectInfo("thisNameIsThirtyCharactersLong", 1.0, "status", "des", "goal")); // her tester vi en String med 30 characters
        assertFalse(val.validateProjectInfo("thisNameIsMoreThanThirtyCharacters", 1.0, "status", "des", "goal")); // her tester vi en String med over de tilladte 30 characters
    }

    @Test
    public void testValidateProjectInfoCost() {
        assertTrue(val.validateProjectInfo("Name", 10000000.0, "status", "des", "goal")); // tester på budget lige på grænsen af det tilladte
        assertFalse(val.validateProjectInfo("Name", 10000000.1, "status", "des", "goal")); // tester på budget lige over grænsen af det tilladte
    }

    @Test
    public void testValidateProjectInfoStatus() {
        assertTrue(val.validateProjectInfo("Name", 1.0, "thisNameIsThirtyCharactersLong", "des", "goal")); // tester på status lige på grænsen af det tilladte
        assertFalse(val.validateProjectInfo("Name", 1.0, "thisNameIsMoreThanThirtyCharacters", "des", "goal")); // tester på status lidt over grænsen af det tilladte
    }

    @Test
    public void testValidateProjectInfoDescription() {
        assertTrue(val.validateProjectInfo("Name", 1.0, "status", stringLong, "goal")); // her tester vi Description lige på grænsen af det tilladte
        assertFalse(val.validateProjectInfo("Name", 1.0, "status", stringTooLong, "goal")); // her tester vi Description lige over grænsen af det tilladte
    }

     @Test
    public void testValidateProjectInfoGoal() {
        assertTrue(val.validateProjectInfo("Name", 1.0, "status", "des", stringLong)); // her tester vi goal lige på grænsen af det tilladte
        assertFalse(val.validateProjectInfo("Name", 1.0, "status", "des", stringTooLong)); // her tester vi goal lige over grænsen af det tilladte
    }
    @Test
    public void testSaveProject() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {
        manager.SaveProject(project);
        Project project2 = manager.getProject(project.getProjectId());

        assertTrue(project.getStartDate().equals(project2.getStartDate()));
        assertTrue(project.getProjectName().equals(project2.getProjectName()));
        assertTrue(Double.valueOf(project.getCost()).equals(project2.getCost()));
        assertTrue(project.getDescription().equals(project2.getDescription()));
        assertTrue(project.getGoal().equals(project2.getGoal()));
        assertTrue(project.getPartner().equals(project2.getPartner()));
        assertTrue(project.getStatus().equals(project2.getStatus()));
    }

    @Test
    public void testSaveProjectWithAttributeNull() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {
        assertFalse(ctrl.saveProject(null, "bronze", 1.0, "gold", "silver", partner, "titanium")); // her tester vi de enkelte værdier ikke er null
        assertFalse(ctrl.saveProject("1992-10-10", null, 1.0, "gold", "silver", partner, "titanium"));
        assertFalse(ctrl.saveProject("1992-10-10", "bronze", null, "gold", "silver", partner, "titanium"));
        assertFalse(ctrl.saveProject("1992-10-10", "bronze", 1.0, null, "silver", partner, "titanium"));
        assertFalse(ctrl.saveProject("1992-10-10", "bronze", 1.0, "gold", null, partner, "titanium"));
        assertFalse(ctrl.saveProject("1992-10-10", "bronze", 1.0, "gold", "silver", null, "titanium"));
        assertFalse(ctrl.saveProject("1992-10-10", "bronze", 1.0, "gold", "silver", partner, null));
    }
}

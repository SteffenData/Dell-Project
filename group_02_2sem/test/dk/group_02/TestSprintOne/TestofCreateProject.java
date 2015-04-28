package dk.group_02.TestSprintOne;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.data.DataManager;
import dk.group_02.control.Controller;
import dk.group_02.control.Manager;
import dk.group_02.utility.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author steffen
 */
public class TestofCreateProject {

    Partner partner;
    Project project;
    Manager manager;
    Controller ctrl;
    Validator val;

    @Before
    public void setUp() {

        partner = new Partner("elgiganten", "Denmark");
        project = new Project(0, "1992-10-10", "TestProject", 1.0, "testing", "test", "test", partner);
        manager = new DataManager();
        ctrl = new Controller();
        val = new Validator();

    }

    @Test
    public void testOfValidateProjectInfoAllGood() {

        assertTrue(val.validateProjectInfo("allGood", 1.0, "status", "des", "goal")); // her tester vi for alle begrænsninger i alle felter om det går godt
    }

    @Test
    public void testOfValidateProjectInfoName() {

        assertFalse(val.validateProjectInfo("thisNameIsMoreThanThirtyCharacters", 1.0, "status", "des", "goal")); // her tester vi en String med over de tilladte 30 characters
        assertTrue(val.validateProjectInfo("thisNameIsMoreThanThirtyCharac", 1.0, "status", "des", "goal")); // her tester vi en String med 30 characters

    }

    @Test
    public void testOfValidateProjectInfoCost() {

        assertTrue(val.validateProjectInfo("Name", 10000000.0, "status", "des", "goal")); // tester på budget lige på grænsen af det tilladte
        assertFalse(val.validateProjectInfo("Name", 10000000.1, "status", "des", "goal")); // tester på budget lige over grænsen af det tilladte

    }

    @Test
    public void testOfValidateProjectInfoStatus() {

        assertTrue(val.validateProjectInfo("Name", 1.0, "thisNameIsMoreThanThirtyCharac", "des", "goal")); // tester på status lige på grænsen af det tilladte
        assertFalse(val.validateProjectInfo("Name", 1.0, "thisNameIsMoreThanThirtyCharacters", "des", "goal")); // tester på status lidt over grænsen af det tilladte

    }

    @Test
    public void testOfValidateProjectInfoDesAndGoal() {

        String stringLong = new String(new char[250]).replace('\0', 'm');
        String stringTooLong = new String(new char[251]).replace('\0', 'm');
        assertTrue(val.validateProjectInfo("Name", 1.0, "status", stringLong, "goal")); // her tester vi Description lige på grænsen af det tilladte
        assertFalse(val.validateProjectInfo("Name", 1.0, "status", stringTooLong, "goal")); // her tester vi Description lige over grænsen af det tilladte
        assertTrue(val.validateProjectInfo("Name", 1.0, "status", "des", stringLong)); // her tester vi goal lige på grænsen af det tilladte
        assertFalse(val.validateProjectInfo("Name", 1.0, "status", "des", stringTooLong)); // her tester vi goal lige over grænsen af det tilladte

    }

    @Test
    public void testOpretTrue() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {

        manager.SaveProject(project);
        int testId = manager.getProjectId(project);
        assertTrue(project.getProjectName().equals(manager.getProject(testId).getProjectName()));
        assertTrue(project.getGoal().equals(manager.getProject(testId).getGoal()));
        assertTrue(project.getDescription().equals(manager.getProject(testId).getDescription()));
        assertTrue(project.getProjectName().equals(manager.getProject(testId).getProjectName()));
        assertTrue(project.getStartDate().equals(manager.getProject(testId).getStartDate()));
        assertTrue(project.getStatus().equals(manager.getProject(testId).getStatus()));

    }

    @Test
    public void testOpretMedFileTrue() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("task liste.jpg");

        project.setUpload(file);
        manager.SaveProject(project);

//        assertTrue(project.getUpload().equals(DataManager.getUpload(project, partner)));
    }

    @Test
    public void testOpretFalse() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {
        assertFalse(ctrl.saveProject(null, "huli", 1.0, "gold", "silver", partner, "mikkel")); // her tester vi de enkelte værdier ikke er null
        assertFalse(ctrl.saveProject("1992-10-10", null, 1.0, "gold", "silver", partner, "mikkel"));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", 1.0, null, "silver", partner, "mikkel"));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", 1.0, "gold", null, partner, "mikkel"));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", 1.0, "gold", "silver", partner, null));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", 1.0, "gold", "silver", null, "Mikkel"));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", null, "gold", "silver", partner, "Mikkel"));

    }

}

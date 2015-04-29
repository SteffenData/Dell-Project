/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Entity.tilEgetForbrug.SkalIkkeMedIEndeligeProgram;

import dk.group_02.Entity.Partner;
import dk.group_02.control.Manager;
import dk.group_02.data.DataManager;
import java.sql.SQLException;

/**
 *
 * @author steffen
 */
public class TestcasesReelOutput {
    Manager manager = new DataManager();
    public static void main(String[] args) throws SQLException {
        TestcasesReelOutput testcase = new TestcasesReelOutput();
        testcase.TestCase001();
        testcase.TestCase002();
        testcase.TestCase003();
        testcase.TestCase004();
        testcase.TestCase005();
        testcase.TestCase006();
    }
    public void TestCase001()throws SQLException{
        System.out.println(manager.getPartnerProjects(new Partner("Dell","Denmark")));
    }
    public void TestCase002()throws SQLException{
        System.out.println(manager.getPartnerProjects(new Partner("Elgiganten","Denmark")));
    }
    public void TestCase003()throws SQLException{
        System.out.println(manager.getPartnerProjects(new Partner("Elgigant","Denmark")));
    }
    public void TestCase004()throws SQLException{
        System.out.println(manager.getPartnerProjects(new Partner(null,null)));
    }
    public void TestCase005()throws SQLException{
        System.out.println(manager.getPartnerProjects(new Partner(null,"Denmark")));
    }
    public void TestCase006()throws SQLException{
        System.out.println(manager.getPartnerProjects(new Partner("Elgiganten",null)));
    }
}

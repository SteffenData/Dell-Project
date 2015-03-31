package dk.group_02.TestSprintOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dk.group_02.Entity.Partner;
import java.awt.Image;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author steffen
 */
public class TestofCreateProject {

    Partner partner;

    @Before
    public void setUp() {
        partner = new Partner("ElGigantos", "Danmark");
    }

    @Test
    public void testOpretTrue() {

        assertTrue(partner.makeProject("LlamaCreame", "Bente LLama", 1.0, "AOK MFUcKER", "Jeg er ironman", "Jeg vil gerne være første kvinde på mars"));
    }

    @Test
    public void testOpretFalse() {

        assertFalse(partner.makeProject( null, "Bente LLama", 1.0, "AOK MFUcKER", "Jeg er ironman", "Jeg vil gerne være første kvinde på mars"));
        assertFalse(partner.makeProject( "LlamaCreame", null, 1.0, "AOK MFUcKER", "Jeg er ironman", "Jeg vil gerne være første kvinde på mars"));
        assertFalse(partner.makeProject( "LlamaCreame", "Bente LLama", 1.0, null, "Jeg er ironman", "Jeg vil gerne være første kvinde på mars"));
        assertFalse(partner.makeProject( "LlamaCreame", "Bente LLama", 1.0, "AOK MFUcKER", null, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(partner.makeProject( "LlamaCreame", "Bente LLama", 1.0, "AOK MFUcKER", "Jeg er ironman", null));

    }

}

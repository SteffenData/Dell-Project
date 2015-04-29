/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.utility;

import java.sql.SQLException;

/**
 *
 * @author steffen
 */
public class DatabaseException extends SQLException {

    public DatabaseException(String message) {

        super(message);

    }

    
    
}


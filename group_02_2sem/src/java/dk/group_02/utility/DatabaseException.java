/**
 *
 * @author steffen/Bente/Mikkel/Kasper
 */
package dk.group_02.utility;

import java.sql.SQLException;

public class DatabaseException extends SQLException {

    public DatabaseException(String message) {

        super(message);

    }
}


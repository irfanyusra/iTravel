package iTravel;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AircraftsAdapter {
    Connection connection;

    public AircraftsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE Aircrafts");
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE Aircrafts ("
                        + "AircraftId CHAR(15) NOT NULL PRIMARY KEY, "
                        + "Type CHAR(15)" + ")");
                System.out.print("Created Aircrafts Table");
                System.out.println();
            }
        }
    }

    public ResultSet getTable() throws SQLException {
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM Aircrafts");
        return rs;
    }



    public void setAircraftType(String id, String type) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE Aircrafts SET Type = '" + type + "' WHERE AircraftId = '" + id + "'");
    }
}

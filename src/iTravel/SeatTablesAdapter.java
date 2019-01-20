package iTravel;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeatTablesAdapter {

    Connection connection;

    public SeatTablesAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE SeatTables");//
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE SeatTables ("//
                        + "SeatNo CHAR(15) NOT NULL PRIMARY KEY, "//
                        + "TicketNumber CHAR(15),"
                        + "ClassOfSeat CHAR(15), "
                        + "Status CHAR(15), "
                        + "PassengerEmail CHAR(15), "
                        + "Fare DOUBLE" + ")");//
                System.out.print("Created SeatTables Table");//
                System.out.println();
            }
        }
    }

    public ResultSet getTable() throws SQLException {
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM SeatTables");
        return rs;
    }

    public void setPassengerEmail(String seatNo, String passengerEmail) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE SeatTables SET PassengerEmail = '" + passengerEmail + "' WHERE SeatNo = '" + seatNo + "'");
    }

}

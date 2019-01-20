package iTravel;

import javafx.beans.property.StringProperty;
import java.sql.Time;

public class DatabaseServer {
    private final Time time;
    private final StringProperty databaseData;

    public DatabaseServer(Time time, StringProperty databaseData) {
        this.time = time;
        this.databaseData = databaseData;
    }

    public Time getTime() {
        return time;
    }

    public String getDatabaseData() {
        return databaseData.get();
    }

    public StringProperty databaseDataProperty() {
        return databaseData;
    }

    public void setDatabaseData(String databaseServer) {
        this.databaseData.set(databaseServer);
    }

}


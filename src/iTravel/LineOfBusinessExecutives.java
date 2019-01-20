package iTravel;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;

public class LineOfBusinessExecutives {
    private final StringProperty customerHelped[];
    private final IntegerProperty numOfCustomerHelped;

    public LineOfBusinessExecutives(StringProperty[] customerHelped, IntegerProperty numOfCustomerHelped) {
        this.customerHelped = customerHelped;
        this.numOfCustomerHelped = numOfCustomerHelped;
    }

    public StringProperty[] getCustomer() {
        return customerHelped;
    }

    public int getNumOfCustomerHelped() {
        return numOfCustomerHelped.get();
    }

    public IntegerProperty numOfCustomerHelpedProperty() {
        return numOfCustomerHelped;
    }

    public void setNumOfCustomerHelped(int numOfCustomerHelped) {
        this.numOfCustomerHelped.set(numOfCustomerHelped);
    }





}

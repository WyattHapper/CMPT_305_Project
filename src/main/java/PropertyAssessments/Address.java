package PropertyAssessments;

import java.util.Objects;

/**
 * Class representing a house address with suite #, house # and street name
 */
public class Address {
    private final String suite;
    private final String house;
    private final String street;

    public Address (String suite, String house, String street) {
        this.suite = suite;
        this.house = house;
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public String getHouse() {
        return house;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        if (suite.isEmpty())
            return house + " " + street;
        else
            return house + " " + street + " #" + suite;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || this.getClass() != object.getClass())
            return false;

        Address other = (Address) object;
        return suite.equals(other.getSuite()) && house.equals(other.getHouse()) && street.equals(other.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(suite, house, street);
    }

}

package PropertyAssessments;

import java.util.Objects;

/**
 * Class representing all the data associated with a property. Uses Region, Location, AssessmentClass and Address
 */
public class PropertyAssessment implements Comparable<PropertyAssessment> {
    private final String accountNum;
    private final Address address;
    private final Region region;
    private final int value;
    private final String taxClass;
    private final String garage;
    private final AssessmentClass assessmentClass;
    private final Location location;

    public PropertyAssessment(String accountNum, Address address, Region region, int value, String taxClass, String garage, AssessmentClass assessmentClass, Location location) {
        this.accountNum = accountNum;
        this.address = address;
        this.region = region;
        this.value = value;
        this.taxClass = taxClass;
        this.garage = garage;
        this.assessmentClass = assessmentClass;
        this.location = location;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public Address getAddress() {
        return address;
    }

    public Region getRegion() {
        return region;
    }

    public int getValue() {
        return value;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public String getGarage() {
        return garage;
    }

    public AssessmentClass getAssessmentClass() {
        return assessmentClass;
    }

    public Location getLocation() {
        return location;
    }

    /**
     * Overrides compareTo function to allow automatic comparison by property value
     * @param other the object to be compared.
     * @return -
     */
    @Override
    public int compareTo(PropertyAssessment other) {
        return Integer.compare(this.value, other.getValue());
    }

    @Override
    public String toString(){
        return "Account: " + accountNum +
                "\nAddress: " + address +
                "\nRegion: " + region +
                "\nValue: " + value +
                "\nTax Class: " + taxClass +
                "\nGarage: " + garage +
                "\nAssessment Class: " + assessmentClass +
                "\nLocation: " + location;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || this.getClass() != object.getClass())
            return false;
        PropertyAssessment other = (PropertyAssessment) object;
        return accountNum.equals(other.getAccountNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNum);
    }
}

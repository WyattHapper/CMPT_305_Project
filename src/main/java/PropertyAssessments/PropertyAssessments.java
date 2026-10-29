package PropertyAssessments;

import java.util.*;

/**
 * Class representing the csv data
 * State representation is a list of PropertyAssessment
 */
public class PropertyAssessments {
    private final List<PropertyAssessment> properties = new ArrayList<>();

    /**
     * Initializer that transforms csv data into list of PropertyAssessment with Region, Location and Address fields
     * @param data - csv data
     */
    public PropertyAssessments (String[][] data) {
        for (String[] item: data) {
            Address address = new Address(item[1], item[2], item[3]);
            Region region = new Region(item[4], item[5], item[6]);
            List<String> classes = new ArrayList<>(List.of(item[10], item[11], item[12]));
            List<String> percentages = new ArrayList<>(List.of(item[13], item[14], item[15]));
            AssessmentClass assessmentClass = new AssessmentClass(classes, percentages);
            Location location = new Location(Double.parseDouble(item[16]), Double.parseDouble(item[17]));
            PropertyAssessment propertyAssessment = new PropertyAssessment(item[0], address, region, Integer.parseInt(item[7]), item[8], item[9], assessmentClass, location);
            properties.add(propertyAssessment);
        }
        //Sort around property.value
        Collections.sort(properties);
    }

    /**
     * Gets properties state
     * @return current properties state
     */
    public List<PropertyAssessment> getProperties() {
        return properties;
    }

    /**
     * Gets total # of properties
     * @return - list length
     */
    public int getSize() {
        return properties.size();
    }

    /**
     * Gets minimum property value
     * @return - First value since list is always sorted
     */
    public int getMinValue() {
        return properties.getFirst().getValue();
    }

    /**
     * Gets maximum property value
     * @return - Last value since list is always sorted
     */
    public int getMaxValue() {
        return properties.getLast().getValue();
    }

    /**
     * Gets range of property values
     * @return - Max minus min
     */
    public int getRange() {
        return properties.getLast().getValue() - properties.getFirst().getValue();
    }

    /**
     * Gets average property value
     * @return - Sums all values and divides by total # of properties
     */
    public long getMean() {
        long sum = 0;
        for (PropertyAssessment property: properties) {
            sum += property.getValue();
        }
        return (sum / properties.size());
    }

    /**
     * Gets median property value
     * @return - Middle value if size is odd. Average of two middle values if size is even
     */
    public int getMedian() {
        int size = properties.size();
        int middle = size/2;
        if (size%2 == 1)
            return properties.get(middle).getValue();
        else {
            return (properties.get(middle).getValue() + properties.get(middle - 1).getValue())/2;
        }
    }

    /**
     * Retrieves property based on account #
     * @param account - String account #
     * @return - PropertyAssessment form of property or null if DNE
     */
    public PropertyAssessment getProperty(String account) {
        for (PropertyAssessment property : properties) {
            if (property.getAccountNum().equals(account))
                return property;
        }
        return null;
    }

    /**
     * Finds properties residing in a given neighbourhood
     * @param neighbourhood - neighbourhood name to search for
     * @return - PropertyAssessments with only properties in that neighbourhood or null if DNE
     */
    public PropertyAssessments getNeighbourhoodProperties(String neighbourhood) {
        PropertyAssessments newProperties = new PropertyAssessments(new String[0][]);
        for (PropertyAssessment property: properties) {
            if (property.getRegion().getNeighbourhood().equals(neighbourhood.toUpperCase())) {
                newProperties.properties.add(property);
            }
        }
        return newProperties;
    }

    /**
     * Finds properties according to assessment class
     * @param assessmentClass class to search for
     * @return New properties with all properties that belong to the assessment class
     */
    public PropertyAssessments getAssessmentClassProperties(String assessmentClass) {
        PropertyAssessments newProperties = new PropertyAssessments(new String[0][]);
        for (PropertyAssessment property: properties) {
            if (property.getAssessmentClass().getClasses().contains(assessmentClass.toUpperCase()))
                newProperties.getProperties().add(property);
        }
        return newProperties;
    }

    /**
     * Finds all properties that have a garage
     * @return - PropertyAssessments containing all properties with a garage
     */
    public PropertyAssessments getWithGarages() {
        PropertyAssessments newProperties = new PropertyAssessments(new String[0][]);
        for (PropertyAssessment property: properties) {
            if (property.getGarage().equals("Y"))
                newProperties.getProperties().add(property);
        }
        return newProperties;
    }

    /**
     * Finds all properties that do not have a garage
     * @return - PropertyAssessments containing all properties without a garage
     */
    public PropertyAssessments getWithoutGarages() {
        PropertyAssessments newProperties = new PropertyAssessments(new String[0][]);
        for (PropertyAssessment property: properties) {
            if (property.getGarage().equals("N"))
                newProperties.getProperties().add(property);
        }
        return newProperties;
    }

    /**
     * Override to string representation
     * @return String of all account numbers
     */
    @Override
    public String toString() {
        return properties.toString();
    }

    /**
     * Override of the equals function
     * @param object   the reference object with which to compare.
     * @return false if account numbers do not match exactly
     */
    @Override
    public boolean equals(Object object){
        if (this == object)
            return true;

        if (object == null || this.getClass() != object.getClass())
            return false;

        PropertyAssessments other = (PropertyAssessments) object;
        return (properties.equals(other.getProperties()));
    }

    /**
     * Override hashCode
     * @return hash of properties
     */
    @Override
    public int hashCode() {
        return Objects.hash(properties);
    }
}

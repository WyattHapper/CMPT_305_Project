package PropertyAssessments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Class representing a region that a house resides with neighbourhood and ward name
 */
public class Region {
    private final String neighbourhoodID;
    private final String neighbourhood;
    private final List<String> ward;

    public Region(String neighbourhoodID, String neighbourhood, String ward) {
        this.neighbourhoodID = neighbourhoodID;
        this.neighbourhood = neighbourhood;
        this.ward = new ArrayList<>(Arrays.asList(ward.split(", ")));
    }

    public String getNeighbourhoodID() {
        return neighbourhoodID;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public List<String> getWard() {
        return ward;
    }

    @Override
    public String toString() {
        return neighbourhood + " (" + String.join(", ", ward) + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || this.getClass() != object.getClass())
            return false;
        Region other = (Region) object;
        return neighbourhoodID.equals(other.getNeighbourhoodID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(neighbourhoodID);
    }
}

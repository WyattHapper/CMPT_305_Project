package PropertyAssessments;

import java.util.Objects;

/**
 * Class representing a location with latitude and longitude coordinates
 */
public class Location {
    private final double latitude;
    private final double longitude;

    public Location (double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "(" + latitude + ", " + longitude + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || this.getClass() != object.getClass())
            return false;
        Location other = (Location) object;
        return latitude == other.getLatitude() && longitude == other.getLongitude();
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}

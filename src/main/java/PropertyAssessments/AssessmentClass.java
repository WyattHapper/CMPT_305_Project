package PropertyAssessments;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class representing the three potential assessment classes and their percentages
 */
public class AssessmentClass {
    private final List<String> classes = new ArrayList<>();
    private final List<String> percentages = new ArrayList<>();

    public AssessmentClass(List<String> classes, List<String> percentages) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).isEmpty())
                continue;
            this.classes.add(classes.get(i));
            this.percentages.add(percentages.get(i));
        }
    }

    public List<String> getClasses() {
        return classes;
    }

    public List<String> getPercentages() {
        return percentages;
    }

    @Override
    public String toString() {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < classes.size(); i++) {
            output.add(classes.get(i) + " " + percentages.get(i) + "%");
        }
        return String.join(", ", output);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || this.getClass() != object.getClass())
            return false;
        AssessmentClass other = (AssessmentClass) object;
        return classes.equals(other.getClasses()) && percentages.equals(other.getPercentages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(classes, percentages);
    }
}

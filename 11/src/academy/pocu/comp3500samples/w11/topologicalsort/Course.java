package academy.pocu.comp3500samples.w11.topologicalsort;

import java.util.ArrayList;

public final class Course {
    private final String title;
    private final ArrayList<Course> dependants = new ArrayList<>();

    public Course(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<Course> getDependants() {
        return this.dependants;
    }
}
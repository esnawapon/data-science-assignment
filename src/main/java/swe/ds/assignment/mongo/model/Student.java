package swe.ds.assignment.mongo.model;

import org.springframework.data.annotation.Id;

public class Student {
    @Id
    private String id;
    private String name;

    public static Student create(String id, String name) {
        Student model = new Student();
        model.id = id;
        model.name = name;
        return model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

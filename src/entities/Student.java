package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Student {
    private final String Id;
    private final String Name;

    private final Collection<Mark> Marks = new ArrayList<>();

    public Student(String name) {
        Id = UUID.randomUUID().toString();
        Name = name;
    }

    public Collection<Mark> getMarksByLesson(Lesson lesson) {
        return Marks.stream().filter(mark -> mark.getLesson() == lesson).toList();
    }

    public String getName() {
        return Name;
    }

    public void addMark(Lesson lesson, AttendanceType attendance, int mark) {
        Marks.add(new Mark(this, lesson, attendance, mark));
    }
}

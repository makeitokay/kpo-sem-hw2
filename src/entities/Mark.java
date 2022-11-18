package entities;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class Mark {
    private final String Id;

    private final Student Student;

    private final Lesson Lesson;

    @Nullable
    private final AttendanceType Attendance;

    private final int Score;

    public Mark(Student student, Lesson lesson, @Nullable AttendanceType attendance, int score) {
        Id = UUID.randomUUID().toString();
        Student = student;
        Lesson = lesson;
        Attendance = attendance;
        Score = score;
    }

    public entities.Lesson getLesson() {
        return Lesson;
    }

    @Nullable
    public AttendanceType getAttendance() {
        return Attendance;
    }

    public int getScore() {
        return Score;
    }
}

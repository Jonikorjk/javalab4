package task3;

import java.util.Arrays;

public class Group {
    private int numberOfGroup;
    Student[] students = null;

    public Group() {}

    public Group(int numberOfGroup, Student[] students) {
        this.numberOfGroup = numberOfGroup;
        this.students = students;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudentToGroup(Student student) {
        Student[] newStudents = Arrays.copyOf(students, students.length + 1);
        newStudents[newStudents.length - 1] = student;
        students = newStudents;
    }

    @Override
    public String toString() {
        String groupInfo = "Number of group: " + numberOfGroup;
        for (var v : students) {
            groupInfo += "\n" + v.toString();
        }
        return groupInfo;
    }
}

package task3;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Andrii", "Mayorov", 31),
                new Student("Kirill", "Koval", 15),
                new Student("Anton", "Rydnik", 18),
                new Student("Habibi", "Abib", 15)
        };

        Group group = new Group(171, students);
        group.addStudentToGroup(new Student("Kto", "Ya", 22));

        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream("resultTask3"))) {
            encoder.writeObject(group);
            encoder.flush();
        } catch (Exception exception) {
            exception.getStackTrace();
        }

        Group someGroup = new Group();

        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream("resultTask3"))) {
            someGroup = (Group) decoder.readObject();
        } catch (Exception exception) {
            exception.getStackTrace();
        }

        System.out.println(someGroup);
    }
}

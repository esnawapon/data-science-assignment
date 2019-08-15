package swe.ds.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe.ds.assignment.mongo.model.Student;
import swe.ds.assignment.mongo.repository.StudentRepository;

import java.util.List;

@Service
public class Assignment3 implements Demoable {
    @Autowired private StudentRepository studentRepository;
    private static final Student STUDENT_1 = Student.create("1001", "John Doe");
    private static final Student STUDENT_2 = Student.create("1002", "Janne Smith");
    private static final Student STUDENT_3 = Student.create("1003", "Robert Johnson");

    @Override
    public void demo() throws Exception {
        System.out.println("delete all students..");
        studentRepository.deleteAll();

        System.out.println("save new students..");
        studentRepository.save(STUDENT_1);
        studentRepository.save(STUDENT_2);
        studentRepository.save(STUDENT_3);

        List<Student> students = findAndPrintAllStudent();

        System.out.println("edit student names");
        for (Student student: students) {
            student.setName(student.getName() + " **EDIT**");
            studentRepository.save(student);
        }

        findAndPrintAllStudent();
    }

    private List<Student> findAndPrintAllStudent() {
        System.out.println("find all students..");
        List<Student> students = studentRepository.findAll();
        System.out.println("found " + students.size() + " student(s)");
        for (Student student: students) {
            System.out.println(" - " + student.toString());
        }
        return students;
    }
}

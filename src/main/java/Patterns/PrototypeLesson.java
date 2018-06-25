package Patterns;

public class PrototypeLesson {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cache cache = new Cache();
        cache.setStudent(new Student());
        Student student = cache.getStudent();
        System.out.println(student);
    }
}

class Student implements Cloneable {
    @Override
    public Student clone() throws CloneNotSupportedException {
        System.out.println("Student!!!");
        return(Student) super.clone();
    }
}

class Cache {
    private Student student;

    public Student getStudent() throws CloneNotSupportedException {
        return student.clone();
    }
    public void setStudent(Student student) {
        this.student = student;
    }
}

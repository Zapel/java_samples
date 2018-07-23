package Patterns;

public class MVCLesson {
    public static void main(String[] args) {
        Controller controller = new Controller ();
        controller.execute ();
    }
}

class StudentMVC {
    String name = "Max";
    int age = 20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface ModelLayer {
    StudentMVC getStudent();
}

class DBLayer implements ModelLayer {
    @Override
    public StudentMVC getStudent() {
        return new StudentMVC ();
    }
}

interface View {
    void showStudentMVC(StudentMVC studentMVC);
}

class ConsoleView implements View {
    @Override
    public void showStudentMVC(StudentMVC studentMVC) {
        System.out.println ("Student name: " + studentMVC.getName () + " age: " + studentMVC.getAge ());
    }
}

class Controller {
    ModelLayer modelLayer = new DBLayer ();
    View view = new ConsoleView ();
    void execute() {
        StudentMVC studentMVC = modelLayer.getStudent ();
        view.showStudentMVC ( studentMVC );
    }
}

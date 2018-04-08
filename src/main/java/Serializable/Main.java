package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        UserChilld user = new UserChilld();
        user.lifeLevel = 55;
        user.staticField = 45;
        Sword sword = new Sword();
        sword.level = 5;
        user.sword = sword;
        user.childLevel = 65;

        FileOutputStream fileOutputStream = new FileOutputStream("tempFile");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        user.staticField = 35;

        FileInputStream fileInputStream = new FileInputStream("tempFile");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        UserChilld newUser = (UserChilld) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(newUser.lifeLevel);
        System.out.println(newUser.staticField);
        System.out.println(newUser.sword.level);
        System.out.println(newUser.childLevel);
    }
}


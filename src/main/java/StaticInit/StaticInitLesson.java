package StaticInit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StaticInitLesson {
    static {
        i =10;
    }
    static int i = 0;
    static {
        i ++;
    }

    /*
    static int[] i = new int[3];
    static {
        i[0] = 0;
        i[1] = 1;
        i[2] = 2;
    }
    */

    /*
    static int getI() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("");
        return 5;
    }
    static {
        try {
            i = getI();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    */

    public static void main(String[] args) {
        //new StaticInitLesson();
        System.out.println(i);

    }
}

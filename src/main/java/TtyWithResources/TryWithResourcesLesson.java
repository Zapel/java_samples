package TtyWithResources;

import java.io.*;

public class TryWithResourcesLesson {
    static class MyClass implements AutoCloseable {

        @Override
        public void close() throws Exception {

        }
    }

    public static void main(String[] args) {

        /*
        Reader reader = null;
        try {
            reader = new FileReader(new File("sameFileName"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (Reader reader = new FileReader(new File("sameFileName"))) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        try (MyClass myClass = new MyClass()) {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

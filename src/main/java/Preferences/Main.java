package Preferences;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Main {
    public static void main(String[] args) throws IOException, BackingStoreException {
        Preferences root = Preferences.systemRoot();
        Preferences user = Preferences.userRoot();
        user.put("key", "value");
        System.out.println(user.get("key", "default value"));
        Preferences node = user.node("myPackage");
        Preferences myPackage = Preferences.userNodeForPackage(PreferencesLesson.class);
        user.exportSubtree(new FileOutputStream("myProperties.xml"));
    }
}

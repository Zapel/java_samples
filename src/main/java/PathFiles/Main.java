package PathFiles;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("temp.txt").toAbsolutePath();
        /*
        //path = file.toPath().toAbsolutePath();

        //Files files;
        //File file = new File("temp.txt");

        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.getRoot());
        System.out.println(path.isAbsolute());

        Files.copy(Paths.get("temp.txt"), Paths.get("temp2.txt"), StandardCopyOption.REPLACE_EXISTING);
        Files.move(Paths.get("temp2.txt"), Paths.get("temp3.txt"), StandardCopyOption.REPLACE_EXISTING);
        Files.deleteIfExists(Paths.get("temp3.txt"));

        System.out.println(Files.size(path));
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isHidden(path));
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));

        System.out.println();

        System.out.println(Files.getAttribute(path, "size", LinkOption.NOFOLLOW_LINKS));

        System.out.println();

        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        //PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        attributes.creationTime();
        System.out.println(attributes);

        byte[] bytes = Files.readAllBytes(path);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        Files.write(path, "bla\nbla".getBytes());


        List<String> list = Files.readAllLines(Paths.get("temp.txt"));
        for(String s : list) {
            System.out.println(s);
        }

        List<String> list1 = new ArrayList<String>();
        list1.add("new");
        list1.add("bla");
        Files.write(path, list1);


        try(DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get("."))) {
            for(Path path1 : entries) {
                System.out.println(path1.getFileName());
            }
        }
        */
        Files.walkFileTree(Paths.get("."), new HashSet<FileVisitOption>(), 1, new MyFileVisitor());

    }
}

class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}

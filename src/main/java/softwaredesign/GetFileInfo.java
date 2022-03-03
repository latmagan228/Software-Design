package softwaredesign;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class GetFileInfo {
    public static void main (String[] args) throws IOException{
        File myObj = new File("sample.gpx");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
            Path fileName = Path.of("sample.gpx");
            String actual = Files.readString(fileName);
            System.out.println(actual);
        } else {
            System.out.println("The file does not exist.");
        }
    }
}

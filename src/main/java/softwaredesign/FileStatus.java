package softwaredesign;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class FileStatus {
    public void FileInfo() throws IOException {
        File myObj = new File("sample.gpx");

        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
            System.out.println();
        }
        else {
            System.out.println("The file does not exist.");
        }
    }
}
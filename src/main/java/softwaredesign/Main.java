package softwaredesign;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        FileStatus fileStatus = new FileStatus();
        FileInfo fileInfo = new FileInfo();

        fileStatus.FileInfo();
        fileInfo.ReadFile();

    }
}




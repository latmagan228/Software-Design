package softwaredesign;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        FileStatus fileStatus = new FileStatus();
        fileStatus.FileInfo();
        GetFileInfo getFileInfo = new GetFileInfo();
        getFileInfo.ReadFile();
    }
}




package softwaredesign;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {
        FileStatus fileStatus = new FileStatus();
        fileStatus.CheckStatus();
        FileInfo fileInfo = new FileInfo();
        fileInfo.ReadFile();

        Vector<Double> latitudes = fileInfo.GetLatitude();
        Vector<Double> longitudes = fileInfo.GetLongitude();
        Vector<Double> elevations = fileInfo.GetElevation();
        Vector<Double> timeStamps = fileInfo.GetTimestamp();

        for (int i = 0; i < latitudes.size(); i++) {
            System.out.print("Waypoint: ");
            System.out.println(i + 1);
            System.out.print("Latitude: ");
            System.out.print(latitudes.elementAt(i) + " ");
            System.out.print("Longitude: ");
            System.out.print(longitudes.elementAt(i) + " ");
            System.out.print("Elevation: ");
            System.out.print(elevations.elementAt(i) + " ");
            System.out.print("Time stamp: ");
            System.out.println(timeStamps.elementAt(i) + " ");
        }

    }

}




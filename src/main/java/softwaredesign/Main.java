package softwaredesign;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        FileStatus fileStatus = new FileStatus();
        fileStatus.CheckStatus();

        ArrayList<Double> latitudes = FileInfo.ReadFile().get(0);
        ArrayList<Double> longitudes = FileInfo.ReadFile().get(1);
        ArrayList<Double> elevations = FileInfo.ReadFile().get(2);

        for (int i = 0; i < latitudes.size(); i++) {
            System.out.print("Waypoint: ");
            System.out.println(i + 1);
            System.out.print("Latitude: ");
            System.out.print(latitudes.get(i) + " ");
            System.out.print("Longitude: ");
            System.out.print(longitudes.get(i) + " ");
            System.out.print("Elevation: ");
            System.out.print(elevations.get(i) + " ");
            System.out.println();
        }
        Statistics.totalDistance();
    }
}

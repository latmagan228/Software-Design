package softwaredesign;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {
        FileStatus fileStatus = new FileStatus();
        fileStatus.CheckStatus();
        FileInfo fileInfo = new FileInfo();
        fileInfo.ReadFile();

        ArrayList<Double> latitudes = fileInfo.GetLatitude();
        ArrayList<Double>  longitudes = fileInfo.GetLongitude();
        ArrayList<Double>  elevations = fileInfo.GetElevation();
        ArrayList<String>  timeStamps = fileInfo.GetTimestamp();


        for (int i = 0; i < latitudes.size(); i++) {
            System.out.print("Waypoint: ");
            System.out.println(i + 1);
            System.out.print("Latitude: ");
            System.out.print(latitudes.get(i) + " ");
            System.out.print("Longitude: ");
            System.out.print(longitudes.get(i) + " ");
            System.out.print("Elevation: ");
            System.out.print(elevations.get(i) + " ");
            System.out.print("Time stamp: ");
            System.out.println(timeStamps.get(i) + " ");
        }

    }

}




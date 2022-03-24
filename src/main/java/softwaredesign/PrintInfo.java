package softwaredesign;

import java.io.IOException;
import java.util.ArrayList;



public class PrintInfo {

    public static void PrintInfo() throws IOException {
        FileStatus fileStatus = new FileStatus();
        fileStatus.CheckStatus();
        ArrayList<Double> latitudes = FileInfo.ReadFile().get(0);
        ArrayList<Double> longitudes = FileInfo.ReadFile().get(1);
        ArrayList<Double> elevations = FileInfo.ReadFile().get(2);
        String day = Date.Date();

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

        System.out.println();
        System.out.println("Day: " + day);
        System.out.println();

        System.out.println("The total distance of the track is: ");
        System.out.println(Statistics.totalDistance() + " meters.");
        System.out.println();

        int timeDifference = Statistics.totalTime();
        int totalHours = timeDifference / 3600;
        int totalMinutes = (timeDifference / 60) % 60;

        System.out.println("The total time completed of the track is: ");
        System.out.print(totalHours + " hours, ");
        System.out.print(totalMinutes + " minutes, ");
        System.out.println(timeDifference % 60 + " seconds.");
        System.out.println();

        System.out.println("The average speed is: ");
        System.out.println(Statistics.averageSpeed() + " Km/h");
        System.out.println();

        System.out.println("The elevation difference of the track is: ");
        System.out.println(Statistics.altitudeDifference() + " meters");
    }


}
package softwaredesign;
import java.io.IOException;
import java.util.ArrayList;

public class Statistics {

    static void totalDistance() throws IOException {
        ArrayList<Double> latitudes = FileInfo.ReadFile().get(0);
        ArrayList<Double>  longitudes = FileInfo.ReadFile().get(1);
        ArrayList<Double>  elevations = FileInfo.ReadFile().get(2);

        final int R = 6371;
        double d = 0;
        double latDistance = 0;
        double lonDistance = 0;
        double a = 0;
        double b = 0;
        double distance = 0;
        double height = 0;

        for (int i = 0; i < latitudes.size() - 1; i++) {
            latDistance = Math.toRadians(latitudes.get(i + 1) - latitudes.get(i));
            lonDistance = Math.toRadians(longitudes.get(i + 1) - longitudes.get(i));

            a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                    Math.cos(Math.toRadians(latitudes.get(i))) * Math.cos(Math.toRadians(latitudes.get(i + 1))) *
                            Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

            b = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            distance = R * b * 1000;
            height = elevations.get(i) - elevations.get(i + 1);
            distance = Math.pow(distance, 2) + Math.pow(height, 2);

            d = Math.sqrt(distance) + d;
        }
        System.out.println();
        System.out.println("The total distance of the track is: " + d + " meters.");
    }

}

package softwaredesign;
import java.util.ArrayList;


public final class Statistics {

    public  void totalDistance() {

        FileInfo fileInfo = new FileInfo();
        ArrayList<Double> latitudes = fileInfo.GetLatitude();
        ArrayList<Double>  longitudes = fileInfo.GetLongitude();
        ArrayList<Double>  elevations = fileInfo.GetElevation();

        double lat1 = latitudes.get(0);
        double lat2 = latitudes.get(1);
        double lon1 = longitudes.get(0);
        double lon2 = longitudes.get(1);
        double el1 = elevations.get(0);
        double el2 = elevations.get(1);

        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000;
        double height = el1 - el2;
        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        double d = Math.sqrt(distance);
        System.out.println(d);
    }
}

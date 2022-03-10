package softwaredesign;
import java.util.Vector;

public class Statistics {

    FileInfo polla = new FileInfo();
    Vector<Double> latitudess = polla.GetLatitude();
    Vector<Double> longitudess = polla.GetLongitude();
    Vector<Double> elevationss = polla.GetElevation();

    double lat1 = latitudess.elementAt(0);
    double lat2 = latitudess.elementAt(1);
    double lon1 = longitudess.elementAt(0);
    double lon2 = longitudess.elementAt(1);
    double el1 = elevationss.elementAt(0);
    double el2 = elevationss.elementAt(1);

    public void totalDistance() {
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

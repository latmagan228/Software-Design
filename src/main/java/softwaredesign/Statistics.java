package softwaredesign;
import java.io.IOException;
import java.util.ArrayList;

public class Statistics {

    static public Double totalDistance() throws IOException {
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
        return  d;
    }

    static public Integer totalTime() throws IOException {
        ArrayList<String> time = Date.Time();
        ArrayList<Integer> hour = new ArrayList<Integer>();
        ArrayList<Integer> minute = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        Integer starTime;
        Integer totalTime;
        Integer timeDifference;

        for (int i = 0; i < time.size(); i++) {
            int startHour = time.get(i).indexOf("T");
            int endHour = 0;
            String hourStamp = time.get(i).substring(startHour + 1, endHour + 3);
            String minuteStamp = time.get(i).substring(startHour + 4, endHour + 6);
            String secondStamp = time.get(i).substring(startHour + 7, endHour + 9);
            int hours = Integer.parseInt(hourStamp);
            int minutes = Integer.parseInt(minuteStamp);
            int seconds = Integer.parseInt(secondStamp);
            hour.add(hours);
            minute.add(minutes);
            second.add(seconds);
        }

        starTime = hour.get(0) * 3600 + minute.get(0) * 60 + second.get(0);
        totalTime = hour.get(hour.size() - 1) * 3600 + minute.get(hour.size() - 1) * 60 + second.get(hour.size() - 1);
        timeDifference = totalTime - starTime;

        return timeDifference;
    }

    static public Double averageSpeed() throws IOException {
        double totalTime = Statistics.totalTime();
        double totalDistance = Statistics.totalDistance();
        double speed;

        speed = (totalDistance / 1000) / (totalTime / 3600);
        return speed;
    }

    static public Double altitudeDifference() throws IOException {
        ArrayList<Double> elevations = FileInfo.ReadFile().get(2);

        Double elevationDifference = elevations.get(elevations.size() - 1) - elevations.get(0);
        return elevationDifference;
    }
}

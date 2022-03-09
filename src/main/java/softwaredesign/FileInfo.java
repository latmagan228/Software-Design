package softwaredesign;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.*;

public class FileInfo {
    Vector<Double> latitudes = new Vector<Double>();
    Vector<Double> longitudes = new Vector<Double>();
    Vector<Double> elevations = new Vector<Double>();
    Vector<String> timeStamps = new Vector<String>();

    public void ReadFile() throws IOException {
        Path fileName = Path.of("sample.gpx");
        String actual = Files.readString(fileName);

        int startIndex = actual.indexOf("<trkseg>");
        int endIndex = actual.indexOf("</trkseg>");

        String parseInfo = actual.substring(startIndex + 8,endIndex);
        String[] trackPointInfo = parseInfo.split("<trkpt");

        for (int i = 1; i < trackPointInfo.length; i++) {
            int startLat = trackPointInfo[i].indexOf("lat=");
            int endLat = trackPointInfo[i].indexOf("lon");
            String latitudeString = trackPointInfo[i].substring(startLat + 5, endLat - 2);
            double latitude = Double.parseDouble(latitudeString);
            latitudes.add(latitude);
        }

        for (int i = 1; i < trackPointInfo.length; i++) {
            int startLong = trackPointInfo[i].indexOf("lon=");
            int endLong = trackPointInfo[i].indexOf(">");
            String longitudeString = trackPointInfo[i].substring(startLong + 5, endLong - 1);
            double longitude = Double.parseDouble(longitudeString);
            longitudes.add(longitude);
        }

        for (int i = 1; i < trackPointInfo.length; i++) {
            int startEle = trackPointInfo[i].indexOf("<ele>");
            int endEle = trackPointInfo[i].indexOf("</ele>");
            String elevationString = trackPointInfo[i].substring(startEle + 5, endEle);
            double elevation = Double.parseDouble(elevationString);
            elevations.add(elevation);
        }

        for (int i = 1; i < trackPointInfo.length; i++) {
            int startTime = trackPointInfo[i].indexOf("<time>");
            int endTime = trackPointInfo[i].indexOf("</time>");
            String timeStamp = trackPointInfo[i].substring(startTime + 6, endTime);
            timeStamps.add(timeStamp);
        }
    }
    Vector GetLatitude() {
        return latitudes;
    }
    Vector GetLongitude() {
        return longitudes;
    }
    Vector GetElevation() {
        return elevations;
    }
    Vector GetTimestamp() {
        return timeStamps;
    }
}

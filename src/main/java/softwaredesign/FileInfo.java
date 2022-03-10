package softwaredesign;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.*;

 public  class  FileInfo {

     static  ArrayList<ArrayList<Double>> ReadFile() throws IOException {
        ArrayList<Double> latitudes = new ArrayList<Double>();
        ArrayList<Double> longitudes = new ArrayList<Double>();
        ArrayList<Double> elevations = new ArrayList<Double>();
        ArrayList<String> timeStamps = new ArrayList<String>();

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
         }

        ArrayList<ArrayList<Double>> waypoint = new ArrayList<>();
        waypoint.add(latitudes);
        waypoint.add(longitudes);
        waypoint.add(elevations);

        return waypoint;

    }
 }

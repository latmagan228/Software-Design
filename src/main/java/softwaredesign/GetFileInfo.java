package softwaredesign;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.*;

public class GetFileInfo {
    public static void main (String[] args) throws IOException{
        File myObj = new File("sample.gpx");
        Vector<Double> latitudes = new Vector<Double>();
        Vector<Double> longitudes = new Vector<Double>();
        Vector<Double> elevations = new Vector<Double>();
        Vector<String> timeStamps = new Vector<String>();

        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
            System.out.println();
            Path fileName = Path.of("sample.gpx");
            String actual = Files.readString(fileName);

            int startIndex = actual.indexOf("<trkseg>");
            int endIndex = actual.indexOf("</trkseg>");
            String parseInfo = actual.substring(startIndex + 8,endIndex);

            String[] trackPointInfo = parseInfo.split("<trkpt");

             for(int i = 1; i < trackPointInfo.length; i++) {
                int startLat = trackPointInfo[i].indexOf("lat=");
                int endLat = trackPointInfo[i].indexOf("lon");
                String latitudeString = trackPointInfo[i].substring(startLat + 5, endLat - 2);
                double latitude = Double.parseDouble(latitudeString);
                latitudes.add(latitude);
            }

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startLong = trackPointInfo[i].indexOf("lon=");
                int endLong = trackPointInfo[i].indexOf(">");
                String longitudeString = trackPointInfo[i].substring(startLong + 5, endLong - 1);
                double longitude = Double.parseDouble(longitudeString);
                longitudes.add(longitude);
            }

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startEle = trackPointInfo[i].indexOf("<ele>");
                int endEle = trackPointInfo[i].indexOf("</ele>");
                String elevationString = trackPointInfo[i].substring(startEle + 5, endEle);
                double elevation = Double.parseDouble(elevationString);
                elevations.add(elevation);
            }

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startTime = trackPointInfo[i].indexOf("<time>");
                int endTime = trackPointInfo[i].indexOf("</time>");
                String timeStamp = trackPointInfo[i].substring(startTime + 6, endTime);
                timeStamps.add(timeStamp);
            }

        }
        else {
            System.out.println("The file does not exist.");
        }

        for (int i = 0; i < latitudes.size(); i++ ){
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

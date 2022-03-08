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
                System.out.println(latitude);
            }

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startLong = trackPointInfo[i].indexOf("lon=");
                int endLong = trackPointInfo[i].indexOf(">");
                String longitudeString = trackPointInfo[i].substring(startLong + 5, endLong - 1);
                double longitude = Double.parseDouble(longitudeString);
                longitudes.add(longitude);
                System.out.println(longitude);
            }

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startEle = trackPointInfo[i].indexOf("<ele>");
                int endEle = trackPointInfo[i].indexOf("</ele>");
                String elevationString = trackPointInfo[i].substring(startEle + 5, endEle);
                double elevation = Double.parseDouble(elevationString);
                elevations.add(elevation);
                System.out.println(elevation);
            }

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startTime = trackPointInfo[i].indexOf("<time>");
                int endTime = trackPointInfo[i].indexOf("</time>");
                String timeStamp = trackPointInfo[i].substring(startTime + 6, endTime);
                timeStamps.add(timeStamp);
                System.out.println(timeStamp);
            }

        }
        else {
            System.out.println("The file does not exist.");
        }

        for (int i = 1; i < latitudes.size(); i++ ){
            System.out.println("This is the waypoint number: ");
            System.out.print(i);
            System.out.println();
            System.out.println("Latitude: ");
            System.out.print(latitudes.elementAt(i));
        }
    }

}

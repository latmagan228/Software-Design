package softwaredesign;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class GetFileInfo {
    public static void main (String[] args) throws IOException{
        File myObj = new File("sample.gpx");
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
            System.out.println(trackPointInfo[1]);

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startLat = trackPointInfo[i].indexOf("lat=");
                int endLat = trackPointInfo[i].indexOf("lon");
                String latitude = trackPointInfo[i].substring(startLat + 5, endLat - 2);
                System.out.println(latitude);
            }

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startLong = trackPointInfo[i].indexOf("lon=");
                int endLong = trackPointInfo[i].indexOf(">");
                String longitude = trackPointInfo[i].substring(startLong + 5, endLong - 1);
                System.out.println(longitude);
            }

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startEle = trackPointInfo[i].indexOf("<ele>");
                int endEle = trackPointInfo[i].indexOf("</ele>");
                String elevation = trackPointInfo[i].substring(startEle + 5, endEle);
                System.out.println(elevation);
            }

            for(int i = 1; i < trackPointInfo.length; i++) {
                int startTime = trackPointInfo[i].indexOf("<time>");
                int endTime = trackPointInfo[i].indexOf("</time>");
                String timeStamp = trackPointInfo[i].substring(startTime + 6, endTime);
                System.out.println(timeStamp);
            }

        }
        else {
            System.out.println("The file does not exist.");
        }
    }

}

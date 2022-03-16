package softwaredesign;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Calendar {

    static String Date() throws IOException {
        String actual = FileInfo.GpxString();

        int startIndex = actual.indexOf("<trkseg>");
        int endIndex = actual.indexOf("</trkseg>");

        String parseInfo = actual.substring(startIndex + 8,endIndex);
        String[] trackPointInfo = parseInfo.split("<trkpt");

        int startTime = trackPointInfo[1].indexOf("<time>");
        int endTime = trackPointInfo[1].indexOf("T");
        String day = trackPointInfo[1].substring(startTime + 6, endTime);

        return day;
    }

    static ArrayList<String> Time() throws IOException {
        ArrayList<String> time = new ArrayList<String>();
        String actual = FileInfo.GpxString();

        int startIndex = actual.indexOf("<trkseg>");
        int endIndex = actual.indexOf("</trkseg>");

        String parseInfo = actual.substring(startIndex + 8,endIndex);
        String[] trackPointInfo = parseInfo.split("<trkpt");

        for (int i = 1; i < trackPointInfo.length; i++) {
            int startTime = trackPointInfo[i].indexOf("T");
            int endTime = trackPointInfo[i].indexOf("Z");
            String timeStamp = trackPointInfo[i].substring(startTime, endTime);
            time.add(timeStamp);
        }

        return time;
    }
}
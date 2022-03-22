package softwaredesign.MAP;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.*;
import softwaredesign.FileInfo;

import javax.swing.*;
import java.io.IOException;
import java.util.*;


public class VisualizeMap {

    public static void visualizeGPX () throws IOException {
        JXMapViewer mapViewer = new JXMapViewer();
        ArrayList<Double> latitudes = FileInfo.ReadFile().get(0);
        ArrayList<Double> longitudes = FileInfo.ReadFile().get(1);
        ArrayList<GeoPosition> trackPoints = new ArrayList<GeoPosition>();

        // Display the viewer in a JFrame
        JFrame frame = new JFrame("JXMapviewer2 Example 2");
        frame.getContentPane().add(mapViewer);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Create a TileFactoryInfo for OpenStreetMap
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);

        for (int i = 0; i < latitudes.size(); i++) {
            GeoPosition waypoint = new GeoPosition(latitudes.get(i), longitudes.get(i));
            trackPoints.add(waypoint);
        }


        // Create a track from the geo-positions
        List<GeoPosition> track = trackPoints;
        RoutePainter routePainter = new RoutePainter(track);

        // Set the focus
        mapViewer.zoomToBestFit(new HashSet<GeoPosition>(track), 0.7);

        // Create waypoints from the geo-positions

        Set<Waypoint> waypoints = new HashSet<Waypoint>(Arrays.asList(
                new DefaultWaypoint(trackPoints.get(0)),
                new DefaultWaypoint(trackPoints.get(trackPoints.size() - 1))));

        // Create a waypoint painter that takes all the waypoints
        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
        waypointPainter.setWaypoints(waypoints);

        // Create a compound painter that uses both the route-painter and the waypoint-painter
        List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
        painters.add(routePainter);
        painters.add(waypointPainter);

        CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
        mapViewer.setOverlayPainter(painter);
    }
}

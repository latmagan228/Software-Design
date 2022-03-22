package softwaredesign.sample2_waypoints;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.*;
import softwaredesign.FileInfo;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

/**
 * A simple sample application that shows
 * a OSM map of Europe containing a route with waypoints
 * @author Martin Steiger
 */
public class Sample2
{
    /**
     * @param args the program args (ignored)
     */
    public static void main(String[] args) throws IOException {
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

        GeoPosition frankfurt = new GeoPosition(latitudes.get(0), longitudes.get(0));
        GeoPosition wiesbaden = new GeoPosition(50,  5, 0, 8, 14, 0);
        GeoPosition mainz     = new GeoPosition(50,  0, 0, 8, 16, 0);
        GeoPosition darmstadt = new GeoPosition(49, 52, 0, 8, 39, 0);
        GeoPosition offenbach = new GeoPosition(50,  6, 0, 8, 46, 0);

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

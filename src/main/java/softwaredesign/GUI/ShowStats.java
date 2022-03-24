package softwaredesign.GUI;

import softwaredesign.Date;
import softwaredesign.Statistics;

import javax.swing.*;
import java.io.IOException;

interface GPXSportPlugin {
    String running = "running";
    void Running() throws IOException;
}

public class ShowStats extends JFrame implements GPXSportPlugin {

    private JLabel dateLabel;
    private JLabel totalDisLabel;
    private JLabel totalTimeLabel;
    private JLabel averageSpeedLabel;
    private JLabel elevationDifLabel;
    private JPanel panelMain;

    public ShowStats() throws IOException {
        super("GPX Manager");

        this.setContentPane(this.panelMain);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(600,150);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] Args) throws IOException {
        ShowStats sport = new ShowStats();
        sport.Running();
    }

    @Override
    public void Running() throws IOException {

        int timeDifference = Statistics.totalTime();
        int totalHours = timeDifference / 3600;
        int totalMinutes = (timeDifference / 60) % 60;

        dateLabel.setText("Date: " + Date.Date());
        totalDisLabel.setText("Total distance of the track is: " + Statistics.totalDistance() + "m");
        totalTimeLabel.setText("The total time completed of the track is: " + totalHours + " hours, " + totalMinutes + " minutes, " + timeDifference % 60 + " seconds." );
        averageSpeedLabel.setText("Average speed of the track is: " + Statistics.averageSpeed() + "km/h");
        elevationDifLabel.setText("The elevation difference in the track is: " + Statistics.altitudeDifference() + "m");
    }

}

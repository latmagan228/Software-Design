package softwaredesign.GUI;

import softwaredesign.MAP.VisualizeMap;
import softwaredesign.PrintInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomePage extends JFrame {

    private JButton ShowStatsButton;
    private JButton visualizeGPXFileButton;
    private JLabel label;
    private JPanel panelMain;


    public HomePage() {

        super("GPX Manager");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(600,150);
        this.pack();
        this.setVisible(true);

        ShowStatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ShowStats();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        visualizeGPXFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    VisualizeMap.visualizeGPX();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }


    public static void main() throws IOException {
        new HomePage();
        PrintInfo.PrintInfo();
    }
}

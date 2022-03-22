package softwaredesign.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomePage extends JFrame {

    private JButton calendarButton;
    private JButton visualizeGPXFileButton;
    private JLabel label;
    private JPanel panelMain;

    public HomePage() {

        super("GPX Manager");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,150);
        this.pack();
        this.setVisible(true);

        calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        visualizeGPXFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new VisualizeGPX();
                try {
                    new ShowStats();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) {
        new HomePage();
    }
}

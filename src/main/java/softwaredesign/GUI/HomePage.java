package softwaredesign.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {

    private JButton calendarButton;
    private JButton visualizeGPXFileButton;
    private JLabel label;
    private JPanel panelMain;

    public HomePage() {

        super("GPX Manager");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,180);
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

            }
        });
    }

    public static void main(String[] args) {
        new HomePage();
    }
}

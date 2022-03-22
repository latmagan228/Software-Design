package softwaredesign.GUI;

import javax.swing.*;

public class VisualizeGPX extends JFrame {

    private JPanel panelMain;

    public VisualizeGPX(){
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,180);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new VisualizeGPX();
    }
}

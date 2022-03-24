package softwaredesign.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LogIn extends JFrame {
    private JPanel panelMain;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JLabel logInLabel;
    private JButton logInButton;
    private JLabel successfulLabel;

    public LogIn() {
        super("GPX Manager");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300,150);
        this.pack();
        this.setVisible(true);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();

                if (Objects.equals(username, "user1") && Objects.equals(password, "12345")) {
                    successfulLabel.setText("Login Successful!");
                    new HomePage();
                }
                else{
                    successfulLabel.setText("Login Failed, Please try again");
                }

            }
        });
    }

    public static void main(String[] args) {
        new LogIn();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart Home Automation");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Create devices
        Light light = new Light("Living Room Light");
        Fan fan = new Fan("Bedroom Fan");
        AC ac = new AC("Main AC");
        DoorLock doorLock = new DoorLock("Front Door Lock");

        // Add devices to the frame
        addDeviceToFrame(frame, light);
        addDeviceToFrame(frame, fan);
        addDeviceToFrame(frame, ac);
        addDeviceToFrame(frame, doorLock);

        frame.setVisible(true);
    }

    private static void addDeviceToFrame(JFrame frame, Device device) {
        JLabel label = new JLabel(device.getName() + " is OFF");
        JButton button = new JButton("Turn ON");

        // Set initial background color for OFF state
        label.setBackground(Color.RED);
        label.setOpaque(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (device.isOn()) {
                    device.turnOff();
                    label.setText(device.getName() + " is OFF");
                    button.setText("Turn ON");
                    label.setBackground(Color.RED);  // Set background to red when OFF
                } else {
                    device.turnOn();
                    label.setText(device.getName() + " is ON");
                    button.setText("Turn OFF");
                    label.setBackground(Color.GREEN);  // Set background to green when ON
                }
            }
        });

        // Add label and button to frame
        frame.add(label);
        frame.add(button);
    }
}

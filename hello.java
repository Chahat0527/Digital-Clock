import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private DateTimeFormatter timeFormat;

    DigitalClock() {
        setTitle("Digital Clock");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Time format
        timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Label to show time
        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));

        add(timeLabel, BorderLayout.CENTER);

        // Timer to update time every second
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        setVisible(true);
        updateClock(); // initialize with current time
    }

    private void updateClock() {
        LocalTime now = LocalTime.now();
        String formattedTime = now.format(timeFormat);
        timeLabel.setText(formattedTime);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}

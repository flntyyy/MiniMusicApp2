import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SimpleGui3C implements ActionListener {
    JFrame frame;

    public static void main(String[] args) {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }


    private void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change color");
        button.addActionListener(this);

        MyDrawPanel drawP = new MyDrawPanel();


        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawP);
        frame.setSize(300, 370);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
       frame.repaint();
    }
}

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            Color randomColor = new Color(red, green, blue);

            g.setColor(randomColor);
            g.fillOval(50, 50, 120, 120);

        }
}

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class commentDriver {
    public static void main(String[] args) {
        JFrame main = new JFrame();
        JButton b = launchCommenButton();

        main.add(b);
        main.setSize(400, 400);
        main.setLayout(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static JButton launchCommenButton() {
        JButton cButton = new JButton("Comment Page");
        cButton.setBounds(10, 150, 100, 50);

        cButton.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = createFrame();
            }

        });
        return cButton;
    }

    public static JFrame createFrame() {
        JFrame jFrame = new JFrame();
        return jFrame;
    }
}

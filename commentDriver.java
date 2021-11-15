import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
// import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class commentDriver {
    public static void main(String[] args) {
        JFrame main = new JFrame("Comment Site");

        JButton b = launchCommentButton();
        b.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.dispose();
                JTableCreate newTable = new JTableCreate();
            }

        });

        main.add(b);
        main.setSize(800, 400);
        main.setLayout(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Here I create a JButton that when pressed launch a new Frame: where the comment page will be.
     * @return a JButton
     */
    public static JButton launchCommentButton() {
        JButton cButton = new JButton("All Comments");
        cButton.setBounds(10, 150, 100, 50);
        
        return cButton;
    }

}

/**
 * Class JTableCreate: Create a JTable for comments.
 */
class JTableCreate {
    private JFrame jFrame;
    private JTable jTable;

    public JTableCreate() {
        jFrame = new JFrame();
        jFrame.setTitle("Discussion Forum");

        // Here I create a table where comments will go.
        // Suggestion: Create a JTextArea where user can fill in their comments and add it back to the 2D Array below.
        String[][] cmt = {{"janedoe", "Netflix", "Love it!"}, 
                          {"johndoe", "Canvas", "Hate it!"}};
        String[] column = {"Username", "Application", "Comment"};

        // Initialize JTable
        jTable = new JTable(cmt, column); 
        jTable.setBounds(30, 40, 200, 300);

        JScrollPane scrollPane = new JScrollPane(jTable);
        jFrame.add(scrollPane);
        jFrame.setSize(jTable.getWidth(), jTable.getHeight());
        jFrame.setVisible(true);

        JButton jButton = new JButton("RETURN TO HOME");
        jButton.setBounds(10, 150, 0, 0);
        jButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
// import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class commentDriver {
    public static void main(String[] args) {
        JFrame main = new JFrame("Comment Site");

        JButton all = launchCommentButton();
        all.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                main.dispose();
                JTableCreate newTable = new JTableCreate();
            }

        });

        
        main.add(all);
        main.setSize(800, 400);
        main.setLayout(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // creates the text fields to get user info for a comment 
        
        // creates appName text box and label 
        
        JLabel appLabel = new JLabel("App Name");
        appLabel.setBounds(50, 100, 200, 30);
        main.add(appLabel);
        
        JTextField appName = new JTextField("App Name");
        Border bored= BorderFactory.createLineBorder(Color.GRAY,1, true);
        appName.setBorder(bored);
        appName.setBackground(Color.white);
        appName.setForeground(Color.black);
        main.add(appName);
        appName.setBounds(50, 150, 100, 30);
      
        // creates comment text box and label 
        JLabel commentLabel = new JLabel("Comment");
        commentLabel.setBounds(175, 100, 200, 30);
        main.add(commentLabel);
        
        JTextField comment = new JTextField("Comment");
        comment.setBorder(bored);
        comment.setBackground(Color.white);
        comment.setForeground(Color.black);
        main.add(comment);
        comment.setBounds(175, 150, 100, 30);
        
        // creates the add submit button
        JButton submit = new JButton("Submit");
        submit.setBounds(300, 150, 100, 30);
        main.add(submit);
        
        
        
    }

    /**
     * Here I create a JButton that when pressed launch a new Frame: where the comment page will be.
     * @return a JButton
     */
    public static JButton launchCommentButton() {
        JButton cButton = new JButton("All Comments");
        cButton.setBounds(50, 200, 100, 50);
        
        return cButton;
    }

}

/** 
 * Adds comments entered by the user to the JTable if they are logged in when add button is pushed 
 */

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
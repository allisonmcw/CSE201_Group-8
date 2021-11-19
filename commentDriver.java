import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class commentDriver extends JFrame implements ItemListener{
    @SuppressWarnings("rawtypes")
    static
    JComboBox type;
    static String appNameString = "Candy Crush";
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        // name of JFrame
        // System.out.println(args[0]);
    	JFrame main = new JFrame("Comment Site");
    	
    	List<App> apps;
    	apps = GUI.readAppsFromCSV("src/Application Information - Sheet1 (1).csv");
    	String[] appNames = GUI.sort(apps);
        
    	commentDriver s = new commentDriver();
        //String s1[] = {"User", "Admin", "Moderator"}; 
        type = new JComboBox(appNames);
        type.addItemListener(s);
        type.setBounds(175, 150, 100, 30);
        main.add(type);
    	
    	//array list of original values 
    	ArrayList<String[]> cl = new ArrayList<String[]>(); 
    	String[] temp = {"janedoe", "Netflix", "Love it!"}; 
    	cl.add(temp); 
    	String[] temp2 = {"johndoe", "Canvas", "Hate it!"};
    	cl.add(temp2); 
        
    	// Links the comment button to the JTable
        JButton all = launchCommentButton();
        all.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //main.dispose();
                JTableCreate newTable = new JTableCreate(cl);
            }

        });

        // adds the allComment button and sets the size of the JFrame
        main.add(all);
        main.setSize(800, 400);
        main.setLayout(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // creates the text fields to get user info for a comment 
        // creates name label and text field 
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 100, 200, 30);
        main.add(nameLabel);
        
        JLabel name = new JLabel(args[0]);
        Border bored= BorderFactory.createLineBorder(Color.GRAY,1, true);
        name.setBorder(bored);
        name.setBackground(Color.white);
        name.setForeground(Color.black);
        main.add(name);
        name.setBounds(50, 150, 100, 30);
        //name.setVisible(false);
        
        // creates appName text box and label 
        JLabel appLabel = new JLabel("App Name");
        appLabel.setBounds(175, 100, 200, 30);
        main.add(appLabel);
        
        JTextField appName = new JTextField("App Name");
        bored= BorderFactory.createLineBorder(Color.GRAY,1, true);
        appName.setBorder(bored);
        appName.setBackground(Color.white);
        appName.setForeground(Color.black);
        main.add(appName);
        appName.setBounds(175, 150, 100, 30);
        appName.setVisible(false);
       
        // creates comment text box and label 
        JLabel commentLabel = new JLabel("Comment");
        commentLabel.setBounds(300, 100, 200, 30);
        main.add(commentLabel);
        
        JTextField comment = new JTextField("Comment");
        comment.setBorder(bored);
        comment.setBackground(Color.white);
        comment.setForeground(Color.black);
        main.add(comment);
        comment.setBounds(300, 150, 100, 30);
        
        // creates the add submit button
        JButton add = new JButton("Add");
        add.setBounds(425, 150, 100, 30);
        add.setVisible(true);
        main.add(add);
       
       
        // adds a comment to list 
        add.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String[] temp = {name.getText(), appNameString, comment.getText()}; 
            	cl.add(temp); 
            	JTableCreate newTable = new JTableCreate(cl); 
            	//name.setText("");
            	appName.setText("");
            	comment.setText("");
            }

        });
        
        // text field of which comment number to delete and button to delete 
        JTextField deleteNum = new JTextField("Comment #");
        deleteNum.setBorder(bored);
        deleteNum.setBackground(Color.white);
        deleteNum.setForeground(Color.black);
        main.add(deleteNum);
        deleteNum.setBounds(300, 200, 100, 30);
        if (args[1].compareTo("User") == 0) { 
        	deleteNum.setVisible(false);  
        }
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(425, 200, 100, 30);
        deleteButton.setVisible(true);
        main.add(deleteButton);
        if (args[1].compareTo("User") == 0) { 
        	deleteButton.setVisible(false);  
        }
        
        // deletes a comment from the list 
        deleteButton.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	try { 
            		int num = Integer.valueOf(deleteNum.getText());
            		cl.remove(num - 1); 
                	JTableCreate newTable = new JTableCreate(cl);
            	} catch(Exception e1) { 
            		JOptionPane.showMessageDialog(null,
                            "Invalid Comment #");
            	}
            	 
            	 
            }

        });
        
        
    }

    /**
     * Creates a JButton that when pressed launch a new Frame containing the comment page
     * @return a JButton
     */
    public static JButton launchCommentButton() {
        JButton cButton = new JButton("All Comments");
        cButton.setBounds(50, 200, 100, 50);
        
        return cButton;
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == type) {
            appNameString = type.getSelectedItem() + "";
            //l1.setText(c1.getSelectedItem() + " selected");
        }
    }

}


/**
 * Class JTableCreate: Create a JTable for comments.
 */
class JTableCreate {
    private JFrame jFrame;
    private JTable jTable;
    private ArrayList<String[]> commentsList; 

    public JTableCreate(ArrayList<String[]> cl) {
        jFrame = new JFrame();
        jFrame.setTitle("Discussion Forum");
        commentsList = cl; 
        
        // creates the columns of the table 
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Comment #");
        model.addColumn("Username");
        model.addColumn("Application");
        model.addColumn("Comment");
        jTable = new JTable(model);
        jTable.setBounds(30, 40, 300, 300);
        
        
        
        JScrollPane scrollPane = new JScrollPane(jTable);
        jFrame.add(scrollPane);
        jFrame.setSize(jTable.getWidth(), jTable.getHeight());
        jFrame.setVisible(true);
        
        // adds the rows based on information specified in commentsList 
        DefaultTableModel model2 = (DefaultTableModel) jTable.getModel();
        int i = 1; 
        for (String[] row : commentsList) { 
        	model2.addRow(new Object[]{Integer.toString(i), row[0], row[1], row[2]});
        	i++; 
        }
       
        // handles closing the JFrame 
        JButton jButton = new JButton("RETURN TO HOME");
        jButton.setBounds(10, 150, 0, 0);
        jButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }    

}
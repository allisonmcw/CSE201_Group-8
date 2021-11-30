import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * 
 */

/**
 * @author Tanmay Bahtkar
 *
 */
public class appReqs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame main = new JFrame("Pending Requests");

		ArrayList<String[]> tempo = new ArrayList<String[]>();
		tempo = commentsFromFile("appRequests.txt");
		final ArrayList<String[]> cl = tempo;

		JButton appReq = new JButton("All Pending Requests");
		main.add(appReq);
		appReq.setVisible(true);
		appReq.setBounds(100, 200, 150, 30);

		JTextField deleteNum = new JTextField("Request #");
		deleteNum.setBackground(Color.white);
		deleteNum.setForeground(Color.black);
		main.add(deleteNum);
		deleteNum.setBounds(300, 200, 100, 30);
//        if (args[1].compareTo("User") == 0) { 
//          deleteNum.setVisible(false);  
//        }

		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(425, 200, 100, 30);
		deleteButton.setVisible(true);
		main.add(deleteButton);

		JButton approve = new JButton("Approve");
		approve.setBounds(425, 250, 100, 30);
		approve.setVisible(true);
		main.add(approve);

		main.setSize(800, 400);
		main.setLayout(null);
		main.setVisible(true);
		main.setDefaultCloseOperation(1);

		main.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {

				FileWriter myObj;
				try {
					myObj = new FileWriter("appRequests.txt", false);
					PrintWriter pr = new PrintWriter(myObj);
					for (String[] a : cl) {
						pr.write(a[0] + "," + a[1] + "," + a[2] + "," + a[3] + "," + a[4] + "," + a[5] + "," + a[6]
								+ "," + a[7] + "\n");
					}

					// HashMap<String, String> map = new HashMap<String,
					// String>();
					myObj.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		appReq.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				JTableCreate1 newTable = new JTableCreate1(cl);
			}

		});

		approve.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileWriter myObj;
				try {
					myObj = new FileWriter("Application Information - Sheet1 (1).csv", true);
					PrintWriter pr = new PrintWriter(myObj);
					String[] a = cl.get(Integer.valueOf(deleteNum.getText()) - 1);

					pr.write("\n" + a[0] + "," + a[1] + "," + a[2] + "," + a[3] + "," + a[4] + "," + a[5] + "," + a[6]
							+ "," + a[7]);

					// HashMap<String, String> map = new HashMap<String,
					// String>();
					myObj.close();

					int num = Integer.valueOf(deleteNum.getText());
					// String[] temp = cl.get(num-1);
					// if((args[1].compareTo("Moderator") == 0) || (args[1].compareTo("Admin") == 0)
					// || (args[0].compareTo(temp[0]) == 0)) {
					cl.remove(num - 1);
					@SuppressWarnings("unused")
					JTableCreate newTable = new JTableCreate(cl);
					GUI.main(args);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Comment #");
				}
			}

		});

		deleteButton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					int num = Integer.valueOf(deleteNum.getText());
					// String[] temp = cl.get(num-1);
					// if((args[1].compareTo("Moderator") == 0) || (args[1].compareTo("Admin") == 0)
					// || (args[0].compareTo(temp[0]) == 0)) {
					cl.remove(num - 1);
					@SuppressWarnings("unused")
					JTableCreate newTable = new JTableCreate(cl);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Comment #");
				}
			}

		});

	}

	private static ArrayList<String[]> commentsFromFile(String fileName) {
		ArrayList<String[]> comments = new ArrayList<String[]>();
		Scanner sc;

		try {
			sc = new Scanner(new File(fileName));

			String line;

			while (sc.hasNext()) {
				line = sc.nextLine();

				String[] attributes = line.split(",");
				comments.add(attributes);

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return comments;
	}

}

class JTableCreate1 {
	private JFrame jFrame;
	private JTable jTable;
	private ArrayList<String[]> commentsList;

	public JTableCreate1(ArrayList<String[]> cl) {
		jFrame = new JFrame();
		jFrame.setTitle("Discussion Forum");
		commentsList = cl;

		// creates the columns of the table
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Request #");
		model.addColumn("Name");
		model.addColumn("Description");
		model.addColumn("Platform");
		model.addColumn("Versions");
		model.addColumn("Price");
		model.addColumn("Category");
		model.addColumn("Store Name");
		model.addColumn("Store Link");

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
			model2.addRow(new Object[] { Integer.toString(i), row[0], row[1], row[2], row[3], row[4], row[5], row[6],
					row[7] });
			i++;
		}

		// handles closing the JFrame
		JButton jButton = new JButton("RETURN TO HOME");
		jButton.setBounds(10, 150, 0, 0);
		jButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		// jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

package graphInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import files.ArrayDirectory;
import files.Entry;

public class ClickInsert extends JFrame {
	
  private JPanel insertPanel;
	
  // Constructor for ClickInsert class that creates a new panel, sets the layout, adds the entry and repaints the frame
  public ClickInsert(JFrame frame, ArrayDirectory arrDir, JPanel panel) {	
    insertPanel = new JPanel();
    insertPanel.setLayout(new BoxLayout(insertPanel, BoxLayout.Y_AXIS));
    insertEntry(insertPanel, frame, arrDir, panel);
    frame.setContentPane(insertPanel);
    frame.revalidate();
    frame.repaint();
  }
	
  // method to add the entry when insert button is clicked
  public void insertEntry(JPanel insertPanel, JFrame frame, ArrayDirectory arrDir, JPanel panel) {
    // text field to enter the surname
    JTextField surnameField = new JTextField(30);
    surnameField.setText("Enter the surname");
    // when the field is clicked set it to be empty
    surnameField.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        surnameField.setText("");
      }
    });	

    // add space after the text field
    insertPanel.add(Box.createRigidArea(new Dimension(0, 50)));		
    // give the text field center alignment and set its size
    surnameField.setAlignmentX(surnameField.CENTER_ALIGNMENT);
    surnameField.setMinimumSize(new Dimension(300, 30));
    surnameField.setPreferredSize(new Dimension(300, 30));
    surnameField.setMaximumSize(new Dimension(300, 30));	
    // add the text field to the panel
    insertPanel.add(surnameField);
		
    // text field to enter the initials
    JTextField initialsField = new JTextField(30);
    initialsField.setText("Enter the initials");
    // when the field is clicked set it to be empty
    initialsField.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        initialsField.setText("");
      }
    });	

    // add space after the text field
    insertPanel.add(Box.createRigidArea(new Dimension(0, 10)));		
    // give the text field center alignment and set its size
    initialsField.setAlignmentX(initialsField.CENTER_ALIGNMENT);
    initialsField.setMinimumSize(new Dimension(300, 30));
    initialsField.setPreferredSize(new Dimension(300, 30));
    initialsField.setMaximumSize(new Dimension(300, 30));	
    // add the text field to the panel
    insertPanel.add(initialsField);

    // text field to enter the telephone extension number
    JTextField telExtensionField = new JTextField(30);
    telExtensionField.setText("Enter the telephone extension");
    // when the field is clicked set it to be empty
    telExtensionField.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        telExtensionField.setText("");
      }
    });

    // add space after the text field
    insertPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    telExtensionField.setAlignmentX(telExtensionField.CENTER_ALIGNMENT);
    // give the text field center alignment and set its size
    telExtensionField.setMinimumSize(new Dimension(300, 30));
    telExtensionField.setPreferredSize(new Dimension(300, 30));
    telExtensionField.setMaximumSize(new Dimension(300, 30));
    // add the text field to the panel
    insertPanel.add(telExtensionField);
		
    // create submit button
    JButton submitButton = new JButton("Submit");
    // when the button is clicked
    submitButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // if the fields are empty provide messages
        if (surnameField.getText().equals("")) {
          JOptionPane.showMessageDialog(insertPanel, "You have not entered the surname");
        }
        if (initialsField.getText().equals("")) {
          JOptionPane.showMessageDialog(insertPanel, "You have not entered the initials");
        }
        if (telExtensionField.getText().equals("")) {
          JOptionPane.showMessageDialog(insertPanel, "You have not entered the telephone extension number");
        }
				
        // create new entry from the input entered by the user and add it to the array of entries
        Entry newEntry = new Entry(surnameField.getText(), initialsField.getText(), telExtensionField.getText());
        arrDir.insertion(arrDir.getEntryArray(), newEntry);
				
        // change the content pane and repaint the frame
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
      }
    });
		
    // button to go back to the menu
    JButton backButton = new JButton("Go back");
    // when the button is clicked
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // change the content pane and repaint the frame
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
      }
    });
        
    // add submit and back buttons to the panel, set their alignment and add space between them
    insertPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    submitButton.setAlignmentX(submitButton.CENTER_ALIGNMENT);
    insertPanel.add(submitButton);
    insertPanel.add(Box.createRigidArea(new Dimension(0, 100)));
    backButton.setAlignmentX(backButton.CENTER_ALIGNMENT);
    insertPanel.add(backButton);
    insertPanel.add(Box.createRigidArea(new Dimension(0, 10)));
  }
}

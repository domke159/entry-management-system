package graphInterface;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import files.ArrayDirectory;

public class ClickLookup {

  private JPanel lookupPanel;
	
  // Constructor for ClickLookup class that creates a new panel, sets the layout, finds the entry and repaints the frame
  public ClickLookup(JFrame frame, ArrayDirectory arrDir, JPanel panel) {
    lookupPanel = new JPanel();
    lookupPanel.setLayout(new BoxLayout(lookupPanel, BoxLayout.Y_AXIS));
    lookupEntry(lookupPanel, frame, arrDir, panel);
    frame.setContentPane(lookupPanel);
    frame.revalidate();
    frame.repaint();
  }

  // method to find the entry when find button is clicked
  public void lookupEntry(JPanel lookupPanel, JFrame frame, ArrayDirectory arrDir, JPanel panel) {
    // create new text field and set its size
    JTextField lookupField = new JTextField(30);
    lookupField.setText("Enter the surname");
    lookupField.setMinimumSize(new Dimension(300, 30));
    lookupField.setPreferredSize(new Dimension(300, 30));
    lookupField.setMaximumSize(new Dimension(300, 30));
		
    // when the text field is clicked
    lookupField.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        lookupField.setText("");
      }
    });
		
    // create a find button and labels to display the number
    JButton findButton = new JButton("Find");
    JLabel number = new JLabel("Telephone extension number is:");
    JLabel foundEntry = new JLabel();
		
    // hide number and found entry labels
    number.setVisible(false);
    foundEntry.setVisible(false);
		
    // when find button is clicked
    findButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // check if the array empty or if there's no entry with provided surname and if either is true display a message
        if (arrDir.getEntryArray()[0] == null || 
            arrDir.lookup(arrDir.getEntryArray(), lookupField.getText()).equals("There is no person with such surname")) {
          JOptionPane.showMessageDialog(lookupPanel, "There is no entry with such surname");
        }
        // if there is an entry with provided surname display the telephone extension number of that person
        else {
          foundEntry.setText(arrDir.lookup(arrDir.getEntryArray(), lookupField.getText()));
          number.setVisible(true);
          foundEntry.setVisible(true);
        }
      }
    });
		
    // button to go back to the menu
    JButton backButton = new JButton("Go back");
    // when go back button is clicked
    backButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // change the content pane and repaint the frame
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
      }
    });
		
    // add the text field, buttons, labels to the panel, align them and add space between them
    lookupPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    lookupField.setAlignmentX(lookupField.CENTER_ALIGNMENT);
    lookupPanel.add(lookupField);
    lookupPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    findButton.setAlignmentX(findButton.CENTER_ALIGNMENT);
    lookupPanel.add(findButton);
    number.setAlignmentX(number.CENTER_ALIGNMENT);
    lookupPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    lookupPanel.add(number);
    foundEntry.setAlignmentX(foundEntry.CENTER_ALIGNMENT);
    lookupPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    lookupPanel.add(foundEntry);
    backButton.setAlignmentX(backButton.CENTER_ALIGNMENT);
    lookupPanel.add(Box.createRigidArea(new Dimension(0, 170)));
    lookupPanel.add(backButton);
  }
}

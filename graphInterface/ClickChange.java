package graphInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import files.ArrayDirectory;
import files.Entry;

public class ClickChange {
	
  private JPanel changePanel;
	
  // Constructor for ClickChange class that creates a new panel, sets the layout, changes telephone extension number and repaints the frame
  public ClickChange(JFrame frame, ArrayDirectory arrDir, JPanel panel) {
    changePanel = new JPanel();
    changePanel.setLayout(new BoxLayout(changePanel, BoxLayout.Y_AXIS));
    changeEntry(changePanel, frame, arrDir, panel);
    frame.setContentPane(changePanel);
    frame.revalidate();
    frame.repaint();
  }
	
  // method to change the telephone extension number when change button is clicked
  public void changeEntry(JPanel changePanel, JFrame frame, ArrayDirectory arrDir, JPanel panel) {
    // new label and combo box to display information
    JLabel select = new JLabel("Please select the entry to change its number");
    JComboBox<Entry> entries = new JComboBox<Entry>();
		
    // add entries to the combo box
    int i = 0;
    while (arrDir.getEntryArray()[i] != null) {
      entries.addItem(arrDir.getEntryArray()[i]);
      i++;
    }
		
    // create new text field and hide it
    JTextField numberField = new JTextField(30);
    numberField.setVisible(false);
    numberField.setText("Enter the new number");
    // when the text field is clicked
    numberField.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        numberField.setText("");
      }
    });
		
    // create new button and hide it
    JButton changeButton = new JButton("Submit");
    changeButton.setVisible(false);	
		
    // when the combo box is clicked
    entries.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // make the button and text field visible
        changeButton.setVisible(true);
        numberField.setVisible(true);
        // when button is clicked
        changeButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent event) {
            // create new entry from selected combo box element
            Entry e = (Entry)entries.getSelectedItem();
            // change the number of the entry
            arrDir.changeNumber(arrDir.getEntryArray(), e, numberField.getText());
            // change the content pane and repaint the frame
            frame.setContentPane(panel);
            frame.revalidate();
            frame.repaint();
          }
        });
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
		
    // add the label, combo box, text field and buttons to the panel, align them and add space between them
    changePanel.add(Box.createRigidArea(new Dimension(0, 20)));
    select.setAlignmentX(select.CENTER_ALIGNMENT);
    changePanel.add(select);
    changePanel.add(Box.createRigidArea(new Dimension(0, 10)));
    entries.setMaximumSize(new Dimension(300, 25));
    entries.setPreferredSize(new Dimension(300, 25));
    entries.setAlignmentX(entries.CENTER_ALIGNMENT);
    changePanel.add(entries);
    changePanel.add(Box.createRigidArea(new Dimension(0, 10)));
    numberField.setAlignmentX(numberField.CENTER_ALIGNMENT);
    numberField.setMinimumSize(new Dimension(300, 30));
    numberField.setPreferredSize(new Dimension(300, 30));
    numberField.setMaximumSize(new Dimension(300, 30));
    changePanel.add(numberField);
    changePanel.add(Box.createRigidArea(new Dimension(0, 10)));
    changeButton.setAlignmentX(changeButton.CENTER_ALIGNMENT);
    changePanel.add(changeButton);
    changePanel.add(Box.createRigidArea(new Dimension(0, 210)));
    backButton.setAlignmentX(backButton.CENTER_ALIGNMENT);
    changePanel.add(backButton);
    changePanel.add(Box.createRigidArea(new Dimension(0, 10)));
  }
}

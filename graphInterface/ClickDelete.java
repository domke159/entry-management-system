package graphInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import files.ArrayDirectory;

public class ClickDelete {
	
  private JPanel deletePanel;
	
  // Constructor for ClickDelete class that creates a new panel, sets the layout, deletes the entry and repaints the frame
  public ClickDelete(JFrame frame, ArrayDirectory arrDir, JPanel panel) {
    deletePanel = new JPanel();
    deletePanel.setLayout(new BoxLayout(deletePanel, BoxLayout.Y_AXIS));
    deleteEntry(deletePanel, frame, arrDir, panel);
    frame.setContentPane(deletePanel);
    frame.revalidate();
    frame.repaint();
  }
	
  // method to delete the entry when delete button is clicked
  public void deleteEntry(JPanel deletePanel, JFrame frame, ArrayDirectory arrDir, JPanel panel) {
    // add space in the panel
    deletePanel.add(Box.createRigidArea(new Dimension(10, 10)));
		
    // Label, two radio buttons and select button to allow user to choose the delete parameter
    JLabel deleteOption = new JLabel("Delete an entry by:");
    JRadioButton bySurname = new JRadioButton("Surname"); 
    JRadioButton byTelExtension = new JRadioButton("Telephone extension number"); 
    ButtonGroup parameterGroup = new ButtonGroup();
    JButton selectButton = new JButton("Select");
		
    // when select button is clicked
    selectButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // if neither of the radio buttons are selected provide a message
        if (!bySurname.isSelected() && !byTelExtension.isSelected()) {
          JOptionPane.showMessageDialog(deletePanel, "Please select the delete parameter");		    
        }					
        else {
          // hide the label, radio and select buttons
          deleteOption.setVisible(false);
          bySurname.setVisible(false);
          byTelExtension.setVisible(false);
          selectButton.setVisible(false);
					
          // create a text field to enter the delete parameter and set its size
          JTextField deleteField = new JTextField();
          deleteField.setMinimumSize(new Dimension(300, 30));
          deleteField.setPreferredSize(new Dimension(300, 30));
          deleteField.setMaximumSize(new Dimension(300, 30));
					
          // create a submit button
          JButton submitButton = new JButton("Submit");	
					
          // add the text field to the panel
          deletePanel.add(deleteField);
			    	
          // repaint the panel
          deletePanel.revalidate();
          deletePanel.repaint();
				    
          // if user selects to delete by surname
          if (bySurname.isSelected()) {			    	
            deleteField.setText("Enter the surname");
            // when the field is clicked set it to be empty
            deleteField.addMouseListener(new MouseAdapter() {
              public void mouseClicked(MouseEvent e) {
                deleteField.setText("");
              }
            });
						
            // add space after the text field
            deletePanel.add(Box.createRigidArea(new Dimension(0, 10)));
						
            // align the submit button and add it to the panel
            submitButton.setAlignmentX(submitButton.CENTER_ALIGNMENT);
            deletePanel.add(submitButton);
						
            // when the submit button is clicked
            submitButton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent event) {
                // check if there is an entry with provided surname
                int i = 0;
                boolean correctSurname = false;
                while (arrDir.getEntryArray()[i] != null) {
                  if (arrDir.getEntryArray()[i].getSurname() == deleteField.getText()) {
                    correctSurname = true;
                    break;
                  }
                  i++;
                }
                // if there isn't an entry with provided surname display a message
                if (correctSurname == false) {
                  JOptionPane.showMessageDialog(deletePanel, "There is no entry with such surname");
                }
								
                // delete the entry with provided surname
                arrDir.deletion(arrDir.getEntryArray(), deleteField.getText());
								
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
				        
            // add space before and after the back button, align it, add it to the panel 
            deletePanel.add(Box.createRigidArea(new Dimension(0, 200)));				        
            backButton.setAlignmentX(backButton.CENTER_ALIGNMENT);
            deletePanel.add(backButton);
            deletePanel.add(Box.createRigidArea(new Dimension(0, 10)));
          }
				    
          // if user selects to delete by telephone extension number
          if (byTelExtension.isSelected()) {					
            deleteField.setText("Enter the telephone extension number");
            // when the field is clicked set it to be empty
            deleteField.addMouseListener(new MouseAdapter() {
              public void mouseClicked(MouseEvent e) {
                deleteField.setText("");
              }
            });
						
            // add space after the text field
            deletePanel.add(Box.createRigidArea(new Dimension(0, 10)));
						
            // align the submit button and add it to the panel
            submitButton.setAlignmentX(submitButton.CENTER_ALIGNMENT);
            deletePanel.add(submitButton);
						
            // when the submit button is clicked
            submitButton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent event) {
                // check if there is an entry with provided surname
                int i = 0;
                boolean correctTelExtension = false;
                while (arrDir.getEntryArray()[i] != null) {
                  if (arrDir.getEntryArray()[i].getSurname() == deleteField.getText()) {
                    correctTelExtension = true;
                    break;
                  }
                  i++;
                }
                // if there isn't an entry with provided surname display a message
                if (correctTelExtension == false) {
                  JOptionPane.showMessageDialog(deletePanel, "There is no entry with such telephone extension number");
                }
								
                // delete the entry with provided telephone extenson number
                arrDir.deletion(arrDir.getEntryArray(), deleteField.getText());
								
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
				        
            // add space before and after the back button, align it, add it to the panel 
            deletePanel.add(Box.createRigidArea(new Dimension(0, 200)));
            backButton.setAlignmentX(backButton.CENTER_ALIGNMENT);
            deletePanel.add(backButton);
            deletePanel.add(Box.createRigidArea(new Dimension(0, 10)));
          }
        }
      }
    });
		
    // add radio buttons to parameter group
    parameterGroup.add(bySurname);
    parameterGroup.add(byTelExtension);
		
    // add the label, buttons and space between them to the panel
    deletePanel.add(deleteOption);
    deletePanel.add(Box.createRigidArea(new Dimension(0, 5)));
    deletePanel.add(bySurname);
    deletePanel.add(byTelExtension);
    deletePanel.add(Box.createRigidArea(new Dimension(0, 10)));
    deletePanel.add(selectButton);
    deletePanel.add(Box.createRigidArea(new Dimension(0, 10)));
  }
}

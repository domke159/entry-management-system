package graphInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import files.ArrayDirectory;
import files.Entry;

public class ClickPrint {
	
  private JPanel printPanel;
	
  // Constructor for ClickPrint class that creates a new panel, sets the layout, print the entries and repaints the frame
  public ClickPrint(JFrame frame, ArrayDirectory arrDir, JPanel panel) {
    printPanel = new JPanel();
    printPanel.setLayout(new BoxLayout(printPanel, BoxLayout.Y_AXIS));
    printEntry(printPanel, frame, arrDir, panel);
    frame.setContentPane(printPanel);
    frame.revalidate();
    frame.repaint();
  }
	
  // method to print the entries when print button is clicked
  public void printEntry(JPanel printPanel, JFrame frame, ArrayDirectory arrDir, JPanel panel) {
    //create a copy of the entry array with all entries that have data
    int i = 0;
    while (arrDir.getEntryArray()[i] != null) {
      i++;
    }
    Entry[] entryArrayCopy = new Entry[i];
    for (int j = 0; j < entryArrayCopy.length; j++) {
      entryArrayCopy[j] = arrDir.getEntryArray()[j];
    }
		
    // create a list of entries and add scroll function
    JList entries = new JList(entryArrayCopy);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView(entries);
    entries.setLayoutOrientation(JList.VERTICAL);
        
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
       
    // add the entry list and button to the panel, align them and add space between them
    printPanel.add(scrollPane);
    backButton.setAlignmentX(backButton.CENTER_ALIGNMENT);
    printPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    printPanel.add(backButton);
    printPanel.add(Box.createRigidArea(new Dimension(0, 10)));
  }
}

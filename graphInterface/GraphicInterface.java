package graphInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import files.ArrayDirectory;

public class GraphicInterface {

  public static void main(String[] args) {
    // set up a new JFrame
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    // set up a new JPanel
    JPanel panel = new JPanel();
    // add buttons to insert, delete, find an entry, change the telephone extension number and print all entries
    JButton insertButton = new JButton("Insert new entry");
    JButton deleteButton = new JButton("Delete an entry");
    JButton findButton = new JButton("Find a telephone extenson no.");
    JButton changeButton = new JButton("Change person's telephone extension no.");
    JButton printButton = new JButton("Print entry list");
    // set the layout of the panel to box layout
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(boxLayout);
		
    // align the buttons to be in the center
    insertButton.setAlignmentX(insertButton.CENTER_ALIGNMENT);
    deleteButton.setAlignmentX(deleteButton.CENTER_ALIGNMENT);
    findButton.setAlignmentX(findButton.CENTER_ALIGNMENT);
    changeButton.setAlignmentX(changeButton.CENTER_ALIGNMENT);
    printButton.setAlignmentX(printButton.CENTER_ALIGNMENT);
		
    // add space between buttons
    panel.add(Box.createRigidArea(new Dimension(0, 50)));
		
    // set the size of the buttons
    insertButton.setMinimumSize(new Dimension(300, 30));
    insertButton.setPreferredSize(new Dimension(300, 30));
    insertButton.setMaximumSize(new Dimension(300, 30));
		
    deleteButton.setMinimumSize(new Dimension(300, 30));
    deleteButton.setPreferredSize(new Dimension(300, 30));
    deleteButton.setMaximumSize(new Dimension(300, 30));

    findButton.setMinimumSize(new Dimension(300, 30));
    findButton.setPreferredSize(new Dimension(300, 30));
    findButton.setMaximumSize(new Dimension(300, 30));
		
    changeButton.setMinimumSize(new Dimension(300, 30));
    changeButton.setPreferredSize(new Dimension(300, 30));
    changeButton.setMaximumSize(new Dimension(300, 30));
		
    printButton.setMinimumSize(new Dimension(300, 30));
    printButton.setPreferredSize(new Dimension(300, 30));
    printButton.setMaximumSize(new Dimension(300, 30));
		
    // add space between buttons
    panel.add(Box.createRigidArea(new Dimension(0, 20)));
		
    // new ArrayDirectory object to initialise an array to store entries
    ArrayDirectory arrDir = new ArrayDirectory();
		
    // when insert button is clicked
    insertButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // new ClickInsert object
        ClickInsert click = new ClickInsert(frame, arrDir, panel);
      }
    });
		
    // when delete button is clicked
    deleteButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // new ClickDelete object
        ClickDelete cd = new ClickDelete(frame, arrDir, panel);
      }
    });
		
    // when find button is clicked
    findButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // new ClickLookup object
        ClickLookup cd = new ClickLookup(frame, arrDir, panel);
      }
    });
		
    // when change button is clicked
    changeButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // new ClickChange object
        ClickChange cc = new ClickChange(frame, arrDir, panel);
      }
    });
		
    // when print button is clicked
    printButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event) {
        // new ClickPrint object
        ClickPrint cp = new ClickPrint(frame, arrDir, panel);
      }
    });


    // add buttons to the panel
    panel.add(insertButton);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(deleteButton);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(findButton);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(changeButton);
    panel.add(Box.createRigidArea(new Dimension(0, 10)));
    panel.add(printButton);
		
    // add panel to the frame
    frame.add(panel);
    // set the frame to be visible
    frame.setVisible(true);
  }
}

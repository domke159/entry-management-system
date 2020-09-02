package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListDirectory implements Directory<List<Entry>>{
	
  private List<Entry> entryList;
	
  // Constructor for ListDirectory class that initialises a Linked List to store entries
  public ListDirectory() {
    entryList = new LinkedList<>();
  }
	
  public List<Entry> getEntryList() {
    return entryList;
  }
	
  @Override
  // method to insert a new entry
  public void insertion(List<Entry> entryList, Entry e){
    // if there are no elements in the list add the first element
    if (entryList.isEmpty()) {
      entryList.add(e);
      // when the entry is inserted return
      return;
    }
    else {
      // initialise iterator for the list of entries
      ListIterator<Entry> iterator = entryList.listIterator();
      // while there are elements in the list
      while (iterator.hasNext()) {
        // find the place where the entry has to be inserted
        if (iterator.next().getSurname().compareTo(e.getSurname()) > 0) {
          // move iterator back to get to the right place to insert the new entry
          iterator.previous();
          iterator.add(e);
          // when the entry is inserted return
          return;
        }			
      }
      // if the new entry has the highest value alphabetically insert it at the end of the list
      if (!iterator.hasNext()) {
        iterator.add(e);
      }
    }
  }


  @Override
  // method to delete an entry
  public void deletion(List<Entry> entryList, String delParameter) {
    // check if there are elements to delete
    if (entryList.isEmpty()) {
      throw new NoSuchElementException("Data storage is empty");
    }
    else {
      // initialise iterator for the list of entries
      ListIterator<Entry> iterator = entryList.listIterator();
      // while the list has entries with data about the person
      while (iterator.hasNext()) {
        // find the entry that has the same surname or telephone extension number as the delete parameter and remove it
        if (delParameter.compareTo(iterator.next().getSurname()) == 0 || delParameter.compareTo(iterator.previous().getTelExtension()) == 0) {
          iterator.remove();
          // when the entry is deleted return
          return;
        }
        iterator.next();
      }
    }
    // If there are no entries with the specified delete parameter
    throw new NoSuchElementException("There is no entry with such surname or telephone extension number");
  }

  @Override
  // method to find an entry using binary search
  public String lookup(List<Entry> entryList, String surname) {
    // check if there are elements to find
    if (entryList.isEmpty()) {
      throw new NoSuchElementException("Data storage is empty");
    }
    int left = 0;
    int right = entryList.size() - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      // compare the surname of the middle element with the one that needs to be found
      int result = entryList.get(mid).getSurname().compareTo(surname);
      // if the middle element's surname is the same as the one that needs to be found return it
      if (result == 0) {
        return entryList.get(mid).getTelExtension();
      }
      // if the middle element's surname is higher alphabetically change the variable right to be mid - 1
      else if (result > 0) {
        right = mid - 1;
      }
      // if the middle element's surname is lower alphabetically change the variable left to be mid + 1
      else {
        left = mid + 1;
      }
    }
    // If there are no entries with the surname that needs to be found
    return "There is no person with such surname";
  }

  @Override
  // method to change the telephone extension number of an entry
  public void changeNumber(List<Entry> entryList, Entry e, String number) {
    // check if the entry is in the list and if that is the case change its telephone extension number
    ListIterator<Entry> iterator = entryList.listIterator();
    while (iterator.hasNext()) {
      if (iterator.next() == e) {
        e.setTelExtension(number);
        // when the number is changed return
        return;
      }
    }
    // if the entry is not in the list throw an exception
    throw new NoSuchElementException("There is no such entry");
  }

  @Override
  // method to print all entries and their data
  public void printData(List<Entry> entryList) {
    System.out.println("-----------------------------------------------------------------");
    System.out.format("| %8s%-16s | %2s%-10s | %-11s | %n", "", "Surname", "", "Initials", "Telephone Extension");
    System.out.println("-----------------------------------------------------------------");
    // initialise iterator for the list of entries
    ListIterator<Entry> iterator = entryList.listIterator();
    // while the list has entries with data about the person
    while(iterator.hasNext()) {
      // store the current entry into another entry variable temp to allow the printing of the data
      Entry temp = iterator.next();
      System.out.format("| %-24s | %4s%-8s | %7s%-12s | %n", temp.getSurname(), "", temp.getInitials(), "", temp.getTelExtension());
    }
    System.out.println("-----------------------------------------------------------------");
  }
	
  public static void main(String[] args) throws FileNotFoundException {
    try {
      // scanner with file reader as an argument to read data from file
      Scanner inFile = new Scanner(new FileReader("C:\\Users\\Dominykas\\Desktop\\Data.txt"));
      // array of strings to store entry data (surname, initials, telephone extension number)
      String[] information = new String[3];
      // new ListDirectory object to initialise a linked list to store entries
      ListDirectory listDir = new ListDirectory();
      // delete method test before adding any entries
      //listDir.deletion(listDir.getEntryList(), "11111");
      // lookup method test before adding any entries
      //System.out.println(listDir.lookup(listDir.getEntryList(), "Speirs"));
      while(inFile.hasNextLine()) {
        // read a line of data
        String inputLine = inFile.nextLine();
        // split the data using tab as delimiter
        information = inputLine.split("\t");
        // create new entry with the obtained data
        Entry e = new Entry(information[0], information[1], information[2]);
        // insert the entry into the array
        listDir.insertion(listDir.getEntryList(), e);
      }
  			
      // efficiency test of the insertion method
      // variable to store time
      long t = 0;
      for (int i = 0; i <= 1000; i++) {
        // new stopwatch
        StopWatch s = new StopWatch();
        // start the stopwatch
        s.start();
        Entry e1 = new Entry("Taylor", "D.T.", "88590");
        listDir.insertion(listDir.getEntryList(), e1);
        Entry e2 = new Entry("Davies", "A.D.", "85391");
        listDir.insertion(listDir.getEntryList(), e2);
        // stop the stopwatch
        s.stop();
        // add the time spent to the total time
        t = t + s.getElapsedTime();
      }
      // print out the time spent
      System.out.println("INSERTION TIME - " + t/1000);
			
      // delete method test with a number that none of the entries have
      //listDir.deletion(listDir.getEntryList(), "11111");
			
      // efficiency test of the lookup method
      // variable to store time
      t = 0;
      for (int i = 0; i <= 1000; i++) {
        // new stopwatch
        StopWatch s = new StopWatch();
        // start stopwatch
        s.start();
        listDir.lookup(listDir.getEntryList(), "Speirs");
        // stop stopwatch
        s.stop();
        // add the time spent to the total time
        t = t + s.getElapsedTime();
      }
      // print out the time spent
      System.out.println("LOOKUP TIME - " + t/1000);
			
      // lookup method test with a surname that is not in the entry list
      //System.out.println(listDir.lookup(listDir.getEntryList(), "Speirss"));
			
      // changeNumber method test when the entry is not inserted into the list
      //Entry entryToFind = new Entry("Jackson", "A.J.", "56475");
      //listDir.changeNumber(listDir.getEntryList(), entryToFind, "44435");
			
      // print data method test
      //listDir.printData(listDir.getEntryList());
      inFile.close();
    }
    catch(FileNotFoundException e) {
    System.out.println("File not found");
    }
  }
}

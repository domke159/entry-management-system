package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.NoSuchElementException;


public class ArrayDirectory implements Directory<Entry[]> {
	
  private Entry[] entryArray;
	
  // Constructor for ArrayDirectory class that initialises an array to store entries
  public ArrayDirectory() {
    entryArray = new Entry[5000];
  }
	
  public Entry[] getEntryArray() {
    return entryArray;
  }

  // method to insert a new entry
  @Override
  public void insertion(Entry[] entryArray, Entry e) {
    // if there are no elements in the array store the entry in the index 0 of the array
    if (entryArray[0] == null) {
      entryArray[0] = e;
      // when the entry is inserted return
      return;
    }
    else {
      int i = 0;
      // while the array has entries with data about the person
      while(entryArray[i] != null) { 
        // ensure that the array has space to insert a new entry
        if (i == entryArray.length-2) {
          throw new ArrayIndexOutOfBoundsException("Data storage needs to be increased");
        }
        // find the place where the entry has to be inserted
        if (entryArray[i].getSurname().compareTo(e.getSurname()) > 0) {
          // create the copy of the entry that will be changed to the new one
          Entry copy = entryArray[i];
          // place the new entry in the place of the old one
          entryArray[i] = e;
          // for loop to move each entry after the inserted one by one position
          for (int j = i+1; j < entryArray.length-1 && copy != null; j++) {
            Entry temp = entryArray[j];
            entryArray[j] = copy;
            copy = temp;
          }
          // when the entry is inserted return
          return;
        }
        // if the new entry has the highest value alphabetically insert it at the end of the array
        else {
          if (entryArray[i+1] == null) {					
            entryArray[i+1] = e;
            // when the entry is inserted return
            return;
          }
        }
        i++;
      }
    }	
  }
	
  @Override
  // method to delete an entry
  public void deletion(Entry[] entryArray, String delParameter) {
    // check if there are elements to delete
    if (entryArray[0] == null) {
      throw new NoSuchElementException("Data storage is empty");
    }
    else {
      int i = 0;
      // while the array has entries with data about the person
      while(entryArray[i] != null) {
        // find the entry that has the same surname or telephone extension number as the delete parameter
        if (delParameter.compareTo(entryArray[i].getSurname()) == 0 || delParameter.compareTo(entryArray[i].getTelExtension()) == 0) {
          // for loop to move each entry back after the inserted one by one position
          for (int j = i; j < entryArray.length && entryArray[j] != null; j++) {
            entryArray[j] = entryArray[j+1];
          }
          // when the entry is deleted return
          return;
        }
        i++;
      }
      // If there are no entries with the specified delete parameter
      throw new NoSuchElementException("There are no element with such surname or telephone extension number");
    }
  }


  @Override
  // method to find an entry using binary search
  public String lookup(Entry[] entryArray, String surname) {
    // check if there are elements to find
    if (entryArray[0] == null) {
      throw new NoSuchElementException("Data storage is empty");
    }
    int left = 0;
    int right = entryArray.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      // if the data storage has a lot of extra space and the middle element is null, find the index where the last element with data is
      if(entryArray[mid] == null) {
        int i = 0;
        while (entryArray[i] != null) {
          i++;
        }
        // change the values of right and mid according to the new value of i
        right = i - 1;
        mid = (left + right) / 2;
      }
      // compare the surname of the middle element with the one that needs to be found
      int result = entryArray[mid].getSurname().compareTo(surname);		
      // if the middle element's surname is the same as the one that needs to be found return it
      if (result == 0) {
        return entryArray[mid].getTelExtension();
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
  public void changeNumber(Entry[] entryArray, Entry e, String number) {
    // check if the entry is in the array and if that is the case change its telephone extension number
    int i = 0;
    while (entryArray[i] != null) {
      if(entryArray[i] == e) {
        e.setTelExtension(number);
        // when the number is changed return
        return;
      }
      i++;
    }
    // if the entry is not in the array throw an exception
    throw new NoSuchElementException("There is no such entry");
  }

  @Override
  // method to print all entries and their data
  public void printData(Entry[] entryArray) {
    System.out.println("-----------------------------------------------------------------");
    System.out.format("| %8s%-16s | %2s%-10s | %-11s | %n", "", "Surname", "", "Initials", "Telephone Extension");
    System.out.println("-----------------------------------------------------------------");
    int i = 0;
    // while the array has entries with data about the person
    while(entryArray[i] != null) {
      System.out.format("| %-24s | %4s%-8s | %7s%-12s | %n", entryArray[i].getSurname(), "", entryArray[i].getInitials(), "", entryArray[i].getTelExtension());
      i++;
    }
    System.out.println("-----------------------------------------------------------------");
  }
	
  public static void main(String[] args) throws FileNotFoundException {
    try {
      // scanner with file reader as an argument to read data from file
      Scanner inFile = new Scanner(new FileReader("C:\\Users\\Dominykas\\Desktop\\Data.txt"));
      // array of strings to store entry data (surname, initials, telephone extension number)
      String[] information = new String[3];
      // new ArrayDirectory object to initialise an array to store entries
      ArrayDirectory arrDir = new ArrayDirectory();
      // delete method test before adding any entries
      //arrDir.deletion(arrDir.getEntryArray(), "11111");
      // lookup method test before adding any entries
      //System.out.println(arrDir.lookup(arrDir.getEntryArray(), "Speirs"));
      while(inFile.hasNextLine()) {
        // read a line of data
        String inputLine = inFile.nextLine();
        // split the data using tab as delimiter
        information = inputLine.split("\t");
        // create new entry with the obtained data
        Entry e = new Entry(information[0], information[1], information[2]);
        // insert the entry into the array
        arrDir.insertion(arrDir.getEntryArray(), e);
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
        arrDir.insertion(arrDir.getEntryArray(), e1);
        Entry e2 = new Entry("Davies", "A.D.", "85391");
        arrDir.insertion(arrDir.getEntryArray(), e2);
        // stop the stopwatch
        s.stop();
        // add the time spent to the total time
        t = t + s.getElapsedTime();
      }
      
      // print out the time spent
      System.out.println("INSERTION TIME - " + t/1000);
			
      // delete method test with a number that none of the entries have
      //arrDir.deletion(arrDir.getEntryArray(), "11111");
			
      // lookup method test with a surname that is not in the entry array
      //System.out.println(arrDir.lookup(arrDir.getEntryArray(), "Speirss"));
			
      // efficiency test of the lookup method
      // variable to store time
      t = 0;
      for (int i = 0; i <= 1000; i++) {
        // new stopwatch
        StopWatch s = new StopWatch();
        // start stopwatch
        s.start();
        arrDir.lookup(arrDir.getEntryArray(), "Speirs");
        // stop stopwatch
        s.stop();
        // add the time spent to the total time
        t = t + s.getElapsedTime();
      }
      // print out the time spent
      System.out.println("LOOKUP TIME - " + t/1000);

      // changeNumber method test when the entry is not inserted into the array
      //Entry entryToFind = new Entry("Jackson", "A.J.", "56475");
      //arrDir.changeNumber(arrDir.getEntryArray(), entryToFind, "44435");

      // print data method test
      //arrDir.printData(arrDir.getEntryArray());
      inFile.close();
    }
    catch(FileNotFoundException e) {
      System.out.println("File not found");
    }
  }
}
package test;

import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import files.ArrayDirectory;
import files.Entry;
import files.ListDirectory;

public class ListDirectoryTest {

  @Test
  public void testInsertion() {
    ListDirectory listDir = new ListDirectory();
    List<Entry> testList = new LinkedList<>();
    Entry e1 = new Entry("Barnes", "J.B.", "33456");
    testList.add(e1);
    Entry e2 = new Entry("Heels", "L.H.", "83604");
    testList.add(e2);
    Entry e3 = new Entry("Johnson", "J.J.", "55605");
    testList.add(e3);
    Entry e4 = new Entry("Jones", "H.J.", "43798");
    testList.add(e4);
    Entry e5 = new Entry("Lord", "P.L.", "87827");
    testList.add(e5);
    Entry e6 = new Entry("Mickevicius", "D.M.", "12345");
    testList.add(e6);
    Entry e7 = new Entry("Smith", "J.S.", "00293");
    testList.add(e7);
    Entry e8 = new Entry("Speirs", "N.S.", "88166");
    testList.add(e8);
    Entry e9 = new Entry("Steggles", "J.S.", "88035");
    testList.add(e9);
    Entry e10 = new Entry("Warrender", "J.W.", "88154");
    testList.add(e10);
    Entry e11 = new Entry("Williams", "G.B.", "54264");
    testList.add(e11);
    listDir.insertion(listDir.getEntryList(), e2);
    listDir.insertion(listDir.getEntryList(), e5);
    listDir.insertion(listDir.getEntryList(), e8);
    listDir.insertion(listDir.getEntryList(), e1);
    listDir.insertion(listDir.getEntryList(), e3);
    listDir.insertion(listDir.getEntryList(), e11);
    listDir.insertion(listDir.getEntryList(), e9);
    listDir.insertion(listDir.getEntryList(), e10);
    listDir.insertion(listDir.getEntryList(), e4);
    listDir.insertion(listDir.getEntryList(), e6);
    listDir.insertion(listDir.getEntryList(), e7);
    Assert.assertEquals(listDir.getEntryList(), testList);
  }

  @Test
  public void testDeletion() {
    ListDirectory listDir = new ListDirectory();
    List<Entry> testList = new LinkedList<>();
    Entry e1 = new Entry("Barnes", "J.B.", "33456");
    testList.add(e1);
    Entry e2 = new Entry("Heels", "L.H.", "83604");
    testList.add(e2);
    Entry e3 = new Entry("Johnson", "J.J.", "55605");
    testList.add(e3);
    Entry e4 = new Entry("Jones", "H.J.", "43798");
    testList.add(e4);
    Entry e5 = new Entry("Lord", "P.L.", "87827");
    testList.add(e5);
    Entry e6 = new Entry("Mickevicius", "D.M.", "12345");
    testList.add(e6);
    Entry e7 = new Entry("Smith", "J.S.", "00293");
    testList.add(e7);
    Entry e8 = new Entry("Speirs", "N.S.", "88166");
    testList.add(e8);
    Entry e9 = new Entry("Steggles", "J.S.", "88035");
    testList.add(e9);
    Entry e10 = new Entry("Warrender", "J.W.", "88154");
    testList.add(e10);
    Entry e11 = new Entry("Williams", "G.B.", "54264");
    testList.add(e11);
    listDir.insertion(listDir.getEntryList(), e2);
    listDir.insertion(listDir.getEntryList(), e5);
    listDir.insertion(listDir.getEntryList(), e8);
    listDir.insertion(listDir.getEntryList(), e1);
    listDir.insertion(listDir.getEntryList(), e3);
    listDir.insertion(listDir.getEntryList(), e11);
    listDir.insertion(listDir.getEntryList(), e9);
    listDir.insertion(listDir.getEntryList(), e10);
    listDir.insertion(listDir.getEntryList(), e4);
    listDir.insertion(listDir.getEntryList(), e6);
    listDir.insertion(listDir.getEntryList(), e7);
    listDir.insertion(listDir.getEntryList(), new Entry("Green", "E.G.", "34634"));
    //listDir.deletion(listDir.getEntryList(), "Green");
    listDir.deletion(listDir.getEntryList(), "34634");
    Assert.assertEquals(listDir.getEntryList(), testList);
  }

  @Test
  public void testLookup() {
    ListDirectory listDir = new ListDirectory();
    Entry e1 = new Entry("Barnes", "J.B.", "33456");
    Entry e2 = new Entry("Heels", "L.H.", "83604");
    Entry e3 = new Entry("Johnson", "J.J.", "55605");
    Entry e4 = new Entry("Jones", "H.J.", "43798");
    Entry e5 = new Entry("Lord", "P.L.", "87827");
    Entry e6 = new Entry("Mickevicius", "D.M.", "12345");
    Entry e7 = new Entry("Smith", "J.S.", "00293");
    Entry e8 = new Entry("Speirs", "N.S.", "88166");
    Entry e9 = new Entry("Steggles", "J.S.", "88035");
    Entry e10 = new Entry("Warrender", "J.W.", "88154");
    Entry e11 = new Entry("Williams", "G.B.", "54264");
    listDir.insertion(listDir.getEntryList(), e2);
    listDir.insertion(listDir.getEntryList(), e5);
    listDir.insertion(listDir.getEntryList(), e8);
    listDir.insertion(listDir.getEntryList(), e1);
    listDir.insertion(listDir.getEntryList(), e3);
    listDir.insertion(listDir.getEntryList(), e11);
    listDir.insertion(listDir.getEntryList(), e9);
    listDir.insertion(listDir.getEntryList(), e10);
    listDir.insertion(listDir.getEntryList(), e4);
    listDir.insertion(listDir.getEntryList(), e6);
    listDir.insertion(listDir.getEntryList(), e7);
    Assert.assertEquals(listDir.lookup(listDir.getEntryList(), "Warrender"), "88154");
  }

  @Test
  public void testChangeNumber() {
    ListDirectory listDir = new ListDirectory();
    Entry e = new Entry("Barnes", "J.B.", "33456");
    listDir.insertion(listDir.getEntryList(), e);
    listDir.changeNumber(listDir.getEntryList(), e, "12389");
    Assert.assertEquals(e.getTelExtension(), "12389");
  }
}

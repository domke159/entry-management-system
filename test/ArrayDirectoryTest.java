package test;


import org.junit.Assert;
import org.junit.Test;

import files.ArrayDirectory;
import files.Entry;

public class ArrayDirectoryTest {

  @Test
  public void testInsertion() {
    Entry[] testArray = new Entry[5000];
    ArrayDirectory arrDir = new ArrayDirectory();
    Entry e1 = new Entry("Barnes", "J.B.", "33456");
    testArray[0] = e1;
    Entry e2 = new Entry("Heels", "L.H.", "83604");
    testArray[1] = e2;
    Entry e3 = new Entry("Johnson", "J.J.", "55605");
    testArray[2] = e3;
    Entry e4 = new Entry("Jones", "H.J.", "43798");
    testArray[3] = e4;
    Entry e5 = new Entry("Lord", "P.L.", "87827");
    testArray[4] = e5;
    Entry e6 = new Entry("Mickevicius", "D.M.", "12345");
    testArray[5] = e6;
    Entry e7 = new Entry("Smith", "J.S.", "00293");
    testArray[6] = e7;
    Entry e8 = new Entry("Speirs", "N.S.", "88166");
    testArray[7] = e8;
    Entry e9 = new Entry("Steggles", "J.S.", "88035");
    testArray[8] = e9;
    Entry e10 = new Entry("Warrender", "J.W.", "88154");
    testArray[9] = e10;
    Entry e11 = new Entry("Williams", "G.B.", "54264");
    testArray[10] = e11;
    arrDir.insertion(arrDir.getEntryArray(), e2);
    arrDir.insertion(arrDir.getEntryArray(), e5);
    arrDir.insertion(arrDir.getEntryArray(), e8);
    arrDir.insertion(arrDir.getEntryArray(), e1);
    arrDir.insertion(arrDir.getEntryArray(), e3);
    arrDir.insertion(arrDir.getEntryArray(), e11);
    arrDir.insertion(arrDir.getEntryArray(), e9);
    arrDir.insertion(arrDir.getEntryArray(), e10);
    arrDir.insertion(arrDir.getEntryArray(), e4);
    arrDir.insertion(arrDir.getEntryArray(), e6);
    arrDir.insertion(arrDir.getEntryArray(), e7);
    Assert.assertArrayEquals(testArray, arrDir.getEntryArray());
  }

  @Test
  public void testDeletion() {
    Entry[] testArray = new Entry[5000];
    ArrayDirectory arrDir = new ArrayDirectory();
    Entry e1 = new Entry("Barnes", "J.B.", "33456");
    testArray[0] = e1;
    Entry e2 = new Entry("Heels", "L.H.", "83604");
    testArray[1] = e2;
    Entry e3 = new Entry("Johnson", "J.J.", "55605");
    testArray[2] = e3;
    Entry e4 = new Entry("Jones", "H.J.", "43798");
    testArray[3] = e4;
    Entry e5 = new Entry("Lord", "P.L.", "87827");
    testArray[4] = e5;
    Entry e6 = new Entry("Mickevicius", "D.M.", "12345");
    testArray[5] = e6;
    Entry e7 = new Entry("Smith", "J.S.", "00293");
    testArray[6] = e7;
    Entry e8 = new Entry("Speirs", "N.S.", "88166");
    testArray[7] = e8;
    Entry e9 = new Entry("Steggles", "J.S.", "88035");
    testArray[8] = e9;
    Entry e10 = new Entry("Warrender", "J.W.", "88154");
    testArray[9] = e10;
    Entry e11 = new Entry("Williams", "G.B.", "54264");
    testArray[10] = e11;
    arrDir.insertion(arrDir.getEntryArray(), e2);
    arrDir.insertion(arrDir.getEntryArray(), e5);
    arrDir.insertion(arrDir.getEntryArray(), e8);
    arrDir.insertion(arrDir.getEntryArray(), e1);
    arrDir.insertion(arrDir.getEntryArray(), e3);
    arrDir.insertion(arrDir.getEntryArray(), e11);
    arrDir.insertion(arrDir.getEntryArray(), e9);
    arrDir.insertion(arrDir.getEntryArray(), e10);
    arrDir.insertion(arrDir.getEntryArray(), e4);
    arrDir.insertion(arrDir.getEntryArray(), e6);
    arrDir.insertion(arrDir.getEntryArray(), e7);
    arrDir.insertion(arrDir.getEntryArray(), new Entry("Green", "E.G.", "34634"));
    //arrDir.deletion(arrDir.getEntryArray(), "Green");
    arrDir.deletion(arrDir.getEntryArray(), "34634");
    Assert.assertArrayEquals(testArray, arrDir.getEntryArray());
  }

  @Test
  public void testLookup() {
    ArrayDirectory arrDir = new ArrayDirectory();
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
    arrDir.insertion(arrDir.getEntryArray(), e2);
    arrDir.insertion(arrDir.getEntryArray(), e5);
    arrDir.insertion(arrDir.getEntryArray(), e8);
    arrDir.insertion(arrDir.getEntryArray(), e1);
    arrDir.insertion(arrDir.getEntryArray(), e3);
    arrDir.insertion(arrDir.getEntryArray(), e11);
    arrDir.insertion(arrDir.getEntryArray(), e9);
    arrDir.insertion(arrDir.getEntryArray(), e10);
    arrDir.insertion(arrDir.getEntryArray(), e4);
    arrDir.insertion(arrDir.getEntryArray(), e6);
    arrDir.insertion(arrDir.getEntryArray(), e7);
    Assert.assertEquals(arrDir.lookup(arrDir.getEntryArray(), "Warrender"), "88154");
  }

  @Test
  public void testChangeNumber() {
    ArrayDirectory arrDir = new ArrayDirectory();
    Entry e = new Entry("Barnes", "J.B.", "33456");
    arrDir.insertion(arrDir.getEntryArray(), e);
    arrDir.changeNumber(arrDir.getEntryArray(), e, "12389");
    Assert.assertEquals(e.getTelExtension(), "12389");
  }
}

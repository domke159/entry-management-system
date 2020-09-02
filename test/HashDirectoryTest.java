package test;

import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import files.Entry;
import files.HashDirectory;
import files.ListDirectory;

public class HashDirectoryTest {

  @SuppressWarnings("deprecation")
  @Test
  public void testInsertion() {
    HashDirectory hashDir = new HashDirectory();
    List<Entry>[] listArrayTest = new LinkedList[26];;
    for (int i = 0; i < listArrayTest.length; i++) {
      listArrayTest[i] = new LinkedList<>();
    }
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
    listArrayTest[1].add(e1);
    listArrayTest[7].add(e2);
    listArrayTest[9].add(e3);
    listArrayTest[9].add(e4);
    listArrayTest[11].add(e5);
    listArrayTest[12].add(e6);
    listArrayTest[18].add(e7);
    listArrayTest[18].add(e8);
    listArrayTest[18].add(e9);
    listArrayTest[22].add(e10);
    listArrayTest[22].add(e11);
    hashDir.insertion(hashDir.getListArray(), e2);
    hashDir.insertion(hashDir.getListArray(), e5);
    hashDir.insertion(hashDir.getListArray(), e8);
    hashDir.insertion(hashDir.getListArray(), e1);
    hashDir.insertion(hashDir.getListArray(), e3);
    hashDir.insertion(hashDir.getListArray(), e11);
    hashDir.insertion(hashDir.getListArray(), e9);
    hashDir.insertion(hashDir.getListArray(), e10);
    hashDir.insertion(hashDir.getListArray(), e4);
    hashDir.insertion(hashDir.getListArray(), e6);
    hashDir.insertion(hashDir.getListArray(), e7);
    Assert.assertEquals(hashDir.getListArray(), listArrayTest);
  }

  @Test
  public void testDeletion() {
    HashDirectory hashDir = new HashDirectory();
    List<Entry>[] listArrayTest = new LinkedList[26];;
    for (int i = 0; i < listArrayTest.length; i++) {
      listArrayTest[i] = new LinkedList<>();
    }
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
    listArrayTest[1].add(e1);
    listArrayTest[7].add(e2);
    listArrayTest[9].add(e3);
    listArrayTest[9].add(e4);
    listArrayTest[11].add(e5);
    listArrayTest[12].add(e6);
    listArrayTest[18].add(e7);
    listArrayTest[18].add(e8);
    listArrayTest[18].add(e9);
    listArrayTest[22].add(e10);
    listArrayTest[22].add(e11);
    hashDir.insertion(hashDir.getListArray(), e2);
    hashDir.insertion(hashDir.getListArray(), e5);
    hashDir.insertion(hashDir.getListArray(), e8);
    hashDir.insertion(hashDir.getListArray(), e1);
    hashDir.insertion(hashDir.getListArray(), e3);
    hashDir.insertion(hashDir.getListArray(), e11);
    hashDir.insertion(hashDir.getListArray(), e9);
    hashDir.insertion(hashDir.getListArray(), e10);
    hashDir.insertion(hashDir.getListArray(), e4);
    hashDir.insertion(hashDir.getListArray(), e6);
    hashDir.insertion(hashDir.getListArray(), e7);
    hashDir.insertion(hashDir.getListArray(), new Entry("Green", "E.G.", "34634"));
    //hashDir.deletion(hashDir.getListArray(), "Green");
    hashDir.deletion(hashDir.getListArray(), "34634");
    Assert.assertEquals(hashDir.getListArray(), listArrayTest);
  }

  @Test
  public void testLookup() {
    HashDirectory hashDir = new HashDirectory();
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
    hashDir.insertion(hashDir.getListArray(), e2);
    hashDir.insertion(hashDir.getListArray(), e5);
    hashDir.insertion(hashDir.getListArray(), e8);
    hashDir.insertion(hashDir.getListArray(), e1);
    hashDir.insertion(hashDir.getListArray(), e3);
    hashDir.insertion(hashDir.getListArray(), e11);
    hashDir.insertion(hashDir.getListArray(), e9);
    hashDir.insertion(hashDir.getListArray(), e10);
    hashDir.insertion(hashDir.getListArray(), e4);
    hashDir.insertion(hashDir.getListArray(), e6);
    hashDir.insertion(hashDir.getListArray(), e7);
    Assert.assertEquals(hashDir.lookup(hashDir.getListArray(), "Warrender"), "88154");
  }

  @Test
  public void testChangeNumber() {
    HashDirectory hashDir = new HashDirectory();
    Entry e = new Entry("Barnes", "J.B.", "33456");
    hashDir.insertion(hashDir.getListArray(), e);
    hashDir.changeNumber(hashDir.getListArray(), e, "12389");
    Assert.assertEquals(e.getTelExtension(), "12389");
  }
}

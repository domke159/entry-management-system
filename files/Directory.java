package files;
import java.util.*;

// Directory interface with methods to insert, delete and find the entry. Also to change the telephone extension number of the entry and print all entries.
// Interface uses generic data storage to store entries to allow differen implementations
public interface Directory<E> {
  void insertion(E dataStructure, Entry e);
  void deletion(E dataStructure, String delParameter);
  String lookup(E dataStructure, String surname);
  void changeNumber(E dataStructure, Entry e, String number);
  void printData(E dataStructure);
}

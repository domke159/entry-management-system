package files;

public class Entry {
	
  private String surname;
  private String initials;
  private String telExtension;
	
  //constructor for Entry class that sets the values of surname, initials and telephone extension number
  public Entry(String surname, String initials, String telExtension) {
    this.surname = surname;
    this.initials = initials;
    this.telExtension = telExtension;
  }
	
  // get methods for surname, initials and telephone extension number
  public String getSurname() {
    return surname;
  }
	
  public String getInitials() {
    return initials;
  }
	
  public String getTelExtension() {
    return telExtension;
  }
	
  // set methods for surname, initials and telephone extension number
  public void setSurname(String surname) {
    this.surname = surname;
  }
	
  public void setInitials(String initials) {
    this.initials = initials;
  }
	
  public void setTelExtension(String telExtension) {
    this.telExtension = telExtension;
  }
	
  @Override
  // override toString method to print entry data
  public String toString() {
    return this.surname + " | " + this.initials + " | " + this.telExtension;
  }
}

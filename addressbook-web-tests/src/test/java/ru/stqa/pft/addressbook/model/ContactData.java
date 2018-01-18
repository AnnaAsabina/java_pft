package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String name;
    private final String middlename;
    private final String lastname;
  private String group;


  public ContactData(String name, String middlename, String lastname, String group) {
    this.name = name;
    this.middlename = middlename;
    this.lastname =lastname;
    this.group = group;
  }



  public String getName() {
    return name;
  }
  public String getMiddleName () { return middlename;}

  public String getLastName() {
    return lastname;
  }


  public String getGroup() {
    return group;
  }
}



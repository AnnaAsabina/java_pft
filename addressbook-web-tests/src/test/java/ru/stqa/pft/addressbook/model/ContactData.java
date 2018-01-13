package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String name;
    private final String middlename;
    private final String lastname;

  public ContactData(String name, String middlename, String lastname) {
    this.name = name;
    this.middlename = middlename;
    this.lastname =lastname;
  }

  public String getName() {
    return name;
  }
  public String getMiddleName () { return middlename;}

  public String getLastName() {
    return lastname;
  }
}


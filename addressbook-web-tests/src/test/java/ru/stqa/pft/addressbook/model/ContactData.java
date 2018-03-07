package ru.stqa.pft.addressbook.model;

public class ContactData {
   private int id;
    private final String name;
    private final String middlename;
    private final String lastname;
  private String group;


  public ContactData(int id,String name, String middlename, String lastname, String group) {
    this.id = 0;
    this.name = name;
    this.middlename = middlename;
    this.lastname =lastname;
    this.group = group;
  }


  public ContactData(String name, String middlename, String lastname, String group) {
    this.id = 0;
    this.name = name;
    this.middlename = middlename;
    this.lastname =lastname;
    this.group = group;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    return name != null ? name.equals(that.name) : that.name == null;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  public int getId() {
    return id;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

}



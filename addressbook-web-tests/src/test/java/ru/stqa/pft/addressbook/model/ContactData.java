package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id =0;
  private String name;
  private String middlename;
  private String lastname;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allEmails;
  private String email1;
  private String email2;
  private String email3;


  public String getAllEmails() {
    return allEmails;
  }
  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }


  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }



  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }



  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }


  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  private String allPhones;

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData  withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }


  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return id == that.id;
  }

  @Override
  public int hashCode() {
    return id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMiddleName() {
    return middlename;
  }

  public String getLastName() {
    return lastname;
  }


  public String getGroup() {
    return group;
  }



  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }


}



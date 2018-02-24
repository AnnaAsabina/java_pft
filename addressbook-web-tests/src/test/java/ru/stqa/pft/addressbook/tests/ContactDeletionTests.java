package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends  TestBase {
  @Test
  public void testContactDeletion() {

    if(!app.getContactHelper().isThereAContact()){
      app.getContactHelper().CreateContact(new ContactData ("Anna","Pavlovna","Asabina", "test1"));
    }

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().CheckTheContact(before.size()-1);
    app.getContactHelper().DeleteContact();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size()-1);
  }
}

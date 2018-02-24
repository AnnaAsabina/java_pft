package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactModificationTests extends  TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if(!app.getContactHelper().isThereAContact()){
      app.getContactHelper().CreateContact(new ContactData ("Anna","Pavlovna","Asabina", "test1"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getContactHelper().CheckTheContact(before.size()+1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Pavlovna", "Asabina", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(),after.size());
    System.out.println(before);
    System.out.println(after);
  }
}

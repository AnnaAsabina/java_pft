package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testCroupCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoNewAddressPage();
    app.getContactHelper().fillContactForm(new ContactData ("Anna","Pavlovna","Asabina", "test1"), true);
    app.getContactHelper().submitEdition();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()+1);
  }
}
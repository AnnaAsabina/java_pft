package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testCroupCreation() {
    app.getNavigationHelper().gotoNewAddressPage();
    app.getContactHelper().fillContactForm(new ContactData ("Anna","Pavlovna","Asabina", "test1"), true);
    app.getContactHelper().submitEdition();
    app.getNavigationHelper().gotoHomePage();
  }
}
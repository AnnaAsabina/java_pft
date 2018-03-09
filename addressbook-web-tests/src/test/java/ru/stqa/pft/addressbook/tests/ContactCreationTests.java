package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testCroupCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoNewAddressPage();
    ContactData contact = new ContactData("Anna","Pavlovna","Asabina", "test1");
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().submitEdition();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);


    /*int max=0;
    for (ContactData c:after){
      if(c.getId()>max){
        max = c.getId();
      }
    }*/

    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId =(c1, c2)-> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    Assert.assertEquals(before,after);
  }
}
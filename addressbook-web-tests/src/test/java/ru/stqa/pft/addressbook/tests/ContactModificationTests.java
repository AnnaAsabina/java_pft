package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends  TestBase {
  @Test (enabled = false)
  public void testContactModification() {
    app.goTo().HomePage();
    if(!app.getContactHelper().isThereAContact()){
      app.getContactHelper().CreateContact(new ContactData ("Anna","Pavlovna","Asabina", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().CheckTheContact(before.size()-1);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Sergey", "Pavlovna", "Asabina", null);
    app.getContactHelper().fillContactForm((contact), false);
    app.getContactHelper().submitContactModification();
    app.goTo().HomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(),after.size());
    System.out.println(before);
    System.out.println(after);

    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId =(c1,c2)-> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    Assert.assertEquals(before,after);
  }
}

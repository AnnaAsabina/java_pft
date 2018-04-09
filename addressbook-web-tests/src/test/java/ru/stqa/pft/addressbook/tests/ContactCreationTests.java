package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test(enabled = true
  )
  public void testCroupCreation() {
    app.goTo().HomePage();
    List<ContactData> before = app.contact().list();
    app.contact().gotoNewAddressPage();
    ContactData contact = new ContactData().withName("Anna").withMiddlename("Pavlovna").withLastname("Asabina").withGroup("test1");
    app.contact().createcontact(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size()+1);


   /* int max=0;
    for (ContactData c:after){
      if(c.getId()>max){
        max = c.getId();
      }
    }*/

    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId =(c1,c2)-> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
    /*Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));*/


}


}
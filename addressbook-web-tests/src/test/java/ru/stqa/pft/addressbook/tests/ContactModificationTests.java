package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends  TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withName("Anna").withMiddlename("Pavlovna").withLastname("Asabina").withGroup("test1"));
    }
  }
  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Alla").withMiddlename("Pavlovna").withLastname("Asabina").withGroup("test1");
    app.contact().modify(contact);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertEquals(before.size(),after.size());
    System.out.println(before);
    System.out.println(after);

    /*Comparator<? super ContactData> byId =(c1,c2)-> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));*/

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}

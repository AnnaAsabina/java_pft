package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends  TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData().withName("Anna").withMiddlename("Pavlovna").withLastname("Asabina").withGroup("test1"));
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() {

    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact );
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()-1);


     before.remove(deletedContact);
     assertThat(after, equalTo(before.without(deletedContact)));

      Assert.assertEquals(before,after);

  }


}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().HomePage();
    Contacts before = app.contact().all();
    app.contact().gotoNewAddressPage();
    File photo = new File("src/test/resources/flower.jpg");
    ContactData contact = new ContactData().withName("Anna").withMiddlename("Pavlovna").withLastname("Asabina").withPhoto(photo).withGroup("test1");
    app.contact().createcontact(contact);
    assertThat(app.contact().count(),equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));


   /* int max=0;
    for (ContactData c:after){
      if(c.getId()>max){
        max = c.getId();
      }
    }*/


    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    /*Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));*/

  }

    @Test(enabled = true)
    public void testBadContactCreation() {
      app.goTo().HomePage();
      Contacts before = app.contact().all();
      app.contact().gotoNewAddressPage();
      ContactData contact = new ContactData().withName("Anna'").withMiddlename("Pavlovna").withLastname("Asabina").withGroup("test1");
      app.contact().createcontact(contact);
      assertThat(app.contact().count(),equalTo(before.size()));
      Contacts after = app.contact().all();
      assertThat(after.size(),equalTo(before.size()));


   /* int max=0;
    for (ContactData c:after){
      if(c.getId()>max){
        max = c.getId();
      }
    }*/



      assertThat(after, equalTo(before));
    /*Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));*/


    }
 @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
   System.out.println(currentDir.getAbsolutePath());
   File photo = new File("src/test/resources/flower.jpg");
   System.out.println(photo.getAbsolutePath());
   System.out.println(photo.exists());
 }

  }



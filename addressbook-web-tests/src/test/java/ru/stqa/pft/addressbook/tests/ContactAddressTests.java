package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {
   @BeforeMethod
   public void ensurePreconditions() {
     app.goTo().HomePage();
     if (app.contact().allcont().size() == 0) {
       app.contact().create(new ContactData().withName("testFirstName1").withHomePhone("11111").withMobilePhone("22222").withWorkPhone("333333").withGroup("testName"), true);
            }
     }

     @Test
    public void testContactAdress(){
            app.goTo().HomePage();
            ContactData contact = app.contact().allcont().iterator().next();
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            assertThat(contact.getAddress(), CoreMatchers.equalTo(contactInfoFromEditForm.getAddress()));
            System.out.println(contact.getAddress());
            System.out.println(contactInfoFromEditForm.getAddress());
      }

}
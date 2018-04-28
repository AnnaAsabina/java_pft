package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactEmailTests extends TestBase {


  @BeforeMethod
 public void ensurePreconditions() {
          app.goTo().HomePage();
           if (app.contact().all().size() == 0) {
               app.contact().create(new ContactData().withName("testFirstName1").withHomePhone("11111").withMobilePhone("22222").withWorkPhone("333333").withGroup("testName"), true);
             }
      }
  @Test
     public void testContactEmail(){
    app.goTo().HomePage();
          ContactData contact = app.contact().allemails().iterator().next();
           ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
           MatcherAssert.assertThat(contact.getAllEmails(), CoreMatchers.equalTo(mergeEmails(contactInfoFromEditForm)));
     }

              private String mergeEmails(ContactData contact) {
              return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
               .stream().filter((s) -> ! s.equals(""))
               .map(ContactEmailTests::cleaned)
              .collect(Collectors.joining("\n"));
       }

            public static String cleaned(String phone){
          return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
        }
}


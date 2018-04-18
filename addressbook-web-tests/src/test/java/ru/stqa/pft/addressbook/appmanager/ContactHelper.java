package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitEdition() {
    click(By.name("submit"));
  }

  public void initContactModification() {

    click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void gotoNewAddressPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry"))
            {
      return;
    }
    click(By.linkText("add new"));
  }


  private void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }



 public void create(ContactData contact) {
    gotoNewAddressPage();
    fillForCheckContactForm(contact);
    submitEdition();
    gotoHomePage(); }

  public void createcontact(ContactData contact) {
   fillContactForm(contact, true);
   submitEdition();
   gotoHomePage();
  }


  private void createnew(ContactData contact) {
   fillContactForm(contact, true);
 submitEdition();
    gotoHomePage();
  }

  public void modify(ContactData contact) {
    CheckTheContactById(contact.getId());
    initContactModification();
    fillContactForm((contact), false);
    submitContactModification();
    gotoHomePage();
  }
  private void fillForCheckContactForm(ContactData contact) {
    type(By.name("firstname"), contact.getName());
    type(By.name("middlename"), contact.getMiddleName());
    type(By.name("lastname"), contact.getLastName());

  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
  }

  public void CheckTheContact( int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void CheckTheContactById( int id) {
    wd.findElement(By.cssSelector("input[value ='"+id +"']")).click();
  }

  public void CloseAlert(){
    wd.switchTo().alert().accept();
  }

  public void DeleteContact() {
    click(By.cssSelector("input[value='Delete']"));
    CloseAlert();
  }
  public void delete(int index) {
    CheckTheContact(index);
    DeleteContact();
    gotoHomePage();
  }
  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
    for (WebElement element: elements){
      String name = element.findElement(By.xpath(".//td[3]")).getText();
       int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withName(name));
    }
    return contacts;
  }

  private Contacts contactCache =null;

  public Contacts all() {
    if(contactCache !=null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
    for (WebElement element: elements){
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withName(name));
    }
    return new Contacts(contactCache);
  }

  public void delete(ContactData contact) {
    CheckTheContactById(contact.getId());
    DeleteContact();
    contactCache = null;
    gotoHomePage();
  }
}



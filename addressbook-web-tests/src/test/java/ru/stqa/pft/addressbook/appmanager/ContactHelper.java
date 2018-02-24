package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData objectData, boolean creation) {

    type(By.name("firstname"), objectData.getName());
    type(By.name("middlename"), objectData.getMiddleName());
    type(By.name("lastname"), objectData.getLastName());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(objectData.getGroup());
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



  public void CreateContact(ContactData contact) {
    gotoNewAddressPage();
    fillForCheckContactForm(contact);
    submitEdition();
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

  public void CloseAlert(){
    wd.switchTo().alert().accept();
  }

  public void DeleteContact() {
    click(By.cssSelector("input[value='Delete']"));
    CloseAlert();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements){
      String name = element.getText();
      ContactData contact = new ContactData(name,null,null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}



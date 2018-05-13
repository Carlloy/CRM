package crm.app.services.content;

import crm.app.data.model.Contact;

public interface ContentService {
    boolean doesCompanyexist(String company);

    void createContact(Contact contact);
}

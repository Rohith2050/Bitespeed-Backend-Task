package com.BackendTask.IdentityReconciliation.Data;

public class outputData {
    private contact contact;

    public outputData(contact c) {
        this.contact = c;
    }

    public outputData() {

    }

    public contact getContact() {
        return contact;
    }

    public void setContact(contact contact) {
        this.contact = contact;
    }

    public void setPrimaryContactId(int id) {
    }

    public void addEmail(String email) {
    }

    public void addPhoneNumber(String phoneNumber) {
    }

    public void addSecondaryContactId(int linkedId) {
    }
}

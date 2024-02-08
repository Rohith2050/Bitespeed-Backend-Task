package com.BackendTask.IdentityReconciliation.Data;

public class contact {
    private int primaryContactId;
    private String[] emails;
    private String[] phoneNumbers;
    private int[] secondaryContactIds;

    public int getPrimaryContactId() {
        return primaryContactId;
    }

    public void setPrimaryContactId(int primaryContactId) {
        this.primaryContactId = primaryContactId;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public int[] getSecondaryContactIds() {
        return secondaryContactIds;
    }

    public void setSecondaryContactIds(int secondaryContactIds) {
        this.secondaryContactIds = new int[]{secondaryContactIds};
    }
}

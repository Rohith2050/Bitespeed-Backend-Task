package com.BackendTask.IdentityReconciliation.Data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class inputData {
    private String email;
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

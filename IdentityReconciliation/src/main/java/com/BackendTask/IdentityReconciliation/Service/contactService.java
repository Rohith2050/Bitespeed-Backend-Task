package com.BackendTask.IdentityReconciliation.Service;

import com.BackendTask.IdentityReconciliation.Data.inputData;
import com.BackendTask.IdentityReconciliation.Data.outputData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.BackendTask.IdentityReconciliation.Dao.contactDAO;
@Service
public class contactService {

    private final contactDAO contactDAO;
    public contactService(@Qualifier("jdbc")contactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public ResponseEntity<outputData> identify(inputData inputData) {
        return new ResponseEntity<>(contactDAO.identify(inputData), HttpStatus.OK);
    }
}

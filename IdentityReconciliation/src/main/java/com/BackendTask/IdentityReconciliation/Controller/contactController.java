package com.BackendTask.IdentityReconciliation.Controller;


import com.BackendTask.IdentityReconciliation.Data.inputData;
import com.BackendTask.IdentityReconciliation.Data.outputData;
import com.BackendTask.IdentityReconciliation.Service.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class contactController {

    @Autowired
    private contactService contactService;

    @PostMapping("/identify")
    public ResponseEntity<outputData> identify(@RequestBody inputData inputData){
        return contactService.identify(inputData);
    }
}

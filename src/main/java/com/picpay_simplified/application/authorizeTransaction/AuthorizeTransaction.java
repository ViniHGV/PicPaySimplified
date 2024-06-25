package com.picpay_simplified.application.authorizeTransaction;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class AuthorizeTransaction {
    private RestTemplate restTemplate;

    public void execute(){
        var url = "https://util.devi.tools/api/v2/authorize";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if(response.getStatusCode().value() != 200)
            throw new RuntimeException("Transação não autorizada!");
    }
}

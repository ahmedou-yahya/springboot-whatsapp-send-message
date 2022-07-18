package com.example.whatsapp_messagery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class WhatsappMessageryApplication {

	public static void main(String[] args) {

		SpringApplication.run(WhatsappMessageryApplication.class, args);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "Bearer EAAKV62RxupMBAAImJs5o91ZAkN14y0Cu6UCZAizrfpRs1PqiIlKGqIcKORP3VlRwGAzNui4QXEl38rVZAx3Rtnwxr9zaq6NZAZAW7jaYZCbFnJ36h4fqdDsD5TdyZCdrghrOxtAeKFwpTCmc56gATmeisJkncFPfUqOR5m213exsUsZCB93gC8eySI1I1R9sz8u96cU7qb3zjwZDZD");
		Map<String, Object> body = new HashMap<>();
		body.put("messaging_product", "whatsapp");
		body.put("to", "22238191833");
		body.put("type", "template");
		Map<String, Object> template = new HashMap<>();
		template.put("name", "hello_world");
		Map<String, Object> language = new HashMap<>();
		language.put("code", "en_US");
		template.put("language", language);
		body.put("template", template);
		HttpEntity httpEntity = new HttpEntity(body, httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange("https://graph.facebook.com/v13.0/102037062588316/messages", HttpMethod.POST, httpEntity, String.class);
		System.out.println(response.getStatusCode());
	}

}

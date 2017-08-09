package br.com.code.sorcerers.spring_boot_api_financial;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author victor
 *
 */
@RestController
public class FincancialController {

	@RequestMapping("/consultScore")
	public ResponseEntity<Financial> consultScore(@RequestBody Financial financial) {
		
		financial.setId(1);
		financial.setName("NAME TESTE");
		financial.setCredit(50000.00);
		financial.setAccount("1234");
		
		
		HttpClient httpClient = HttpClientBuilder.create().build(); 

		try {

		    HttpPost request = new HttpPost("http://localhost:9090/socket");
		    request.addHeader("content-type", "application/json");
		    StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
		    request.setEntity(params);
		    HttpResponse response = httpClient.execute(request);

		    //handle response here...

		}catch (Exception ex) {

		    //handle exception here

		} finally {
		    httpClient.getConnectionManager().shutdown(); //Deprecated
		}

		return new ResponseEntity<Financial>(financial, HttpStatus.OK);
	}

}

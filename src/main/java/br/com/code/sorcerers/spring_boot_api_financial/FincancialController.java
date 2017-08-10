package br.com.code.sorcerers.spring_boot_api_financial;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
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
	public HttpResponse consultScore(@RequestBody Financial financial) {
		
		/*financial.setId(1);
		financial.setName("NAME TESTE");
		financial.setCredit(50000.00);
		financial.setAccount("1234");*/

		Map<String, Financial> map = new HashMap<String, Financial>();
		map.put("finance",financial);
		
		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpResponse response = null;

		try {

		    HttpPost request = new HttpPost("http://localhost:9090/socket");
		    request.addHeader("content-type", "application/json");
			JSONObject json = new JSONObject(map);
		    StringEntity params = new StringEntity(json.toString());
		    request.setEntity(params);
		    response = httpClient.execute(request);

		    //handle response here...

		}catch (Exception ex) {

		    //handle exception here

		} finally {
		    httpClient.getConnectionManager().shutdown(); //Deprecated
		}

		return response;
	}

}

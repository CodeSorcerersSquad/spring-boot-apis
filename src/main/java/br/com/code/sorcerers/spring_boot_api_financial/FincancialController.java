package br.com.code.sorcerers.spring_boot_api_financial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
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
	public String consultScore(@RequestBody Financial financial) {
		

		Map<String, Financial> map = new HashMap<String, Financial>();
		map.put("finance",financial);
		
		StringBuffer result = new StringBuffer();
		
		String uri = "http://localhost:9090/socket";

		HttpClient client = new DefaultHttpClient();

		try {

			JSONObject json = new JSONObject(map);
		    StringEntity params = new StringEntity(json.toString());

		    URL url = new URL(uri);
			HttpPost post = new HttpPost(url.toString());

			params.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setEntity(params);

			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
			System.out.println(response.toString());

		}catch (Exception ex) {


		} finally {
		    client.getConnectionManager().shutdown(); 
		}

		return result.toString();
	}
	
}

package kr.cloudscape.java;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FormServletTest {

    @Test
    public void whenPostRequestUsingHttpClient_thenCorrect() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:18080/javax-servlets/calculateServlet");
//        HttpPost httpPost = new HttpPost("http://localhost:18080/calculateServlet");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("height", String.valueOf(2)));
        params.add(new BasicNameValuePair("weight", String.valueOf(80)));

        httpPost.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse response = client.execute(httpPost);

        assertEquals("Success", response.getHeaders("Test")[0].getValue());
        assertEquals("20.0", response.getHeaders("BMI")[0].getValue());

        client.close();
    }
}

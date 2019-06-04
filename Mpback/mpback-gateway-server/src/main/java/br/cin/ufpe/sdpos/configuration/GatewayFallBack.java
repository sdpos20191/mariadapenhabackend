package br.cin.ufpe.sdpos.configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@Configuration
public class GatewayFallBack {

	@Bean
	public ZuulFallbackProvider zuulFallbackProvider(String route, Throwable cause) {
		
	    return new ZuulFallbackProvider() {
	    	
	        @Override
	        public String getRoute() {
	            return null;
	        }

	        @Override
	        public ClientHttpResponse fallbackResponse() {
	        	
	        	HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	    		
	    		Error error = Error.builder()
	    				.cause(cause)
	    				.route(route)
	    				.build();
	        	
	            return new ClientHttpResponse() {
	                @Override
	                public HttpStatus getStatusCode() throws IOException {
	                    return status;
	                }

	                @Override
	                public int getRawStatusCode() throws IOException {
	                    return status.value();
	                }

	                @Override
	                public String getStatusText() throws IOException {
	                    return status.toString();
	                }

	                @Override
	                public void close() {

	                }

	                @Override
	                public InputStream getBody() throws IOException {
	                	return new ByteArrayInputStream(error.toJSONString().getBytes());
	                }

	                @Override
	                public HttpHeaders getHeaders() {
	                    HttpHeaders headers = new HttpHeaders();
	                    headers.setContentType(MediaType.APPLICATION_JSON);
	                    return headers;
	                }
	            };
	        }
	    };
	}
	
}

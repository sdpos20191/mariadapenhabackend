package br.cin.ufpe.sdpos.configuration;

import com.google.gson.Gson;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {

	private static final String ERROR_TRY_AGAIN = "{ \"error\" : \"Try again\" }";

	
	private String message = ERROR_TRY_AGAIN;
	private String route;
	private Throwable cause;
	
	public String toJSONString() {
		
		return new Gson().toJson(this);
	}
	
}

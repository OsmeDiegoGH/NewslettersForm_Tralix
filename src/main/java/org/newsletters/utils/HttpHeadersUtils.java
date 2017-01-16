package org.newsletters.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HttpHeadersUtils {
    
    public static final HttpHeadersUtils INSTANCE = new HttpHeadersUtils();
    
    private HttpHeadersUtils(){}
    
    public HttpHeaders generateCustomHeaders(MediaType mediaType){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(mediaType);
        return responseHeaders;
    }
}

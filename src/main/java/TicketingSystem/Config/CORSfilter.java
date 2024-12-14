// CORS filter to handle Cross-Origin Resource Sharing
package TicketingSystem.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSfilter implements Filter {

    // injects the client application URL from the application's properties file
    @Value("${app.client.url}")
    private String clientAppUrl = "";

    // default constructor
    public CORSfilter() {
    }

    // processes CORS requests
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        Map<String, String> map = new HashMap<>();
        String originHeader = req.getHeader("Origin"); // gets the "Origin" header from request

        // sets CORS header in the response
        res.setHeader("Access-Control-Allow-Origin", originHeader);
        res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        res.setHeader("Access-Control-Max-Age", "3600");

        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            res.setStatus(HttpServletResponse.SC_OK); // if the request method is "OPTIONS", respond with HTTP status 200
        } else {
            chain.doFilter(request, response); // // continue with the next filter in the chain
        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}

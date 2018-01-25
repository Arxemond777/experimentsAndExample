package ch_15_web_programmin_server_side;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;

public class LinkResponceFilter implements Filter
{
    FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        WrappedResponse wrappedResponse =
                new WrappedResponse((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, wrappedResponse);
        wrappedResponse.close();
    }

    public void destroy() {
    }

    class WrappedResponse extends HttpServletResponseWrapper
    {
        boolean linkText;
        PrintWriter client;

        WrappedResponse(HttpServletResponse response) {
            super(response);
        }

        public void setContentType(String mime) {
            super.setContentType(mime);
            if (mime.startsWith("text/html"))
                linkText = true;
        }

        void close() {
            if (client != null)
                client.close();
        }
    }

    class LinkWriter extends PrintWriter
    {
        ByteArrayOutputStream buffer;
        Writer client;

        LinkWriter(Writer client, ByteArrayOutputStream buffer) {
            super(buffer);
            this.buffer = buffer;
            this.client = client;
        }

        public void close() {
            try {
                flush();
                client.write(linkText(buffer.toString()));
                client.close();
            } catch (IOException e) {
                setError();
            }
        }

        String linkText(String text) {
            Enumeration en = filterConfig.getInitParameterNames();
            while (en.hasMoreElements()) {
                String pattern = (String) en.nextElement();
                String value = filterConfig.getInitParameter(pattern);
                text = text.replaceAll(pattern, "<a href=" + value + ">$0</a>");
            }
            return text;
        }
    }
}

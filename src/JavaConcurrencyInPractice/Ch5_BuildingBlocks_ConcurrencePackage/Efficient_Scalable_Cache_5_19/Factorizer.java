package JavaConcurrencyInPractice.Ch5_BuildingBlocks_ConcurrencePackage.Efficient_Scalable_Cache_5_19;

import JavaConcurrencyInPractice.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;

@ThreadSafe
public class Factorizer implements Servlet {
    private final Computable<BigInteger, BigInteger[]>
            c = arg -> factor(arg),
            cache = new Memorizer<>(c);

    private BigInteger[] factor(BigInteger arg) {
        BigInteger[] bigIntegers = {getRandomBigInteger(arg)};

        return bigIntegers;
    }

    public void service(ServletRequest req, ServletResponse resp) throws IOException {
        try {
            BigInteger i = extractFromRequest(req);
            encodeIntoResponse(resp, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(resp, "factorization interrupted");
        }
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] compute)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Hello, World</title></head>");
            out.println("<body>");
            out.println("<h1>Hello, world!</h1>");
            out.println("<h1>" + Arrays.toString(compute) + "</h1>");
            // Generate a random number upon each request
            out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();  // Always close the output writer
        }
    }

    private RuntimeException encodeError(final ServletResponse resp, final String factorizationInterrupted) {
        return new RuntimeException(factorizationInterrupted);
        
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return getRandomBigInteger();
    }
    
    private BigInteger getRandomBigInteger() {
        return this.getRandomBigInteger(BigInteger.valueOf(new SecureRandom().nextInt(100)));
    }

    private BigInteger getRandomBigInteger(BigInteger bigInteger) {
        return new BigInteger(bigInteger.bitLength(), new SecureRandom()).mod(bigInteger);
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

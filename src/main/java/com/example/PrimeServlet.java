package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("num");

        out.println("<html><body>");

        try {
            int num = Integer.parseInt(input);

            if (num <= 1) {
                out.println("<h3 style='color:red;'>Enter number greater than 1</h3>");
            } else {
                boolean isPrime = true;

                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime)
                    out.println("<h2 style='color:green;'>" + num + " is a Prime Number</h2>");
                else
                    out.println("<h2 style='color:blue;'>" + num + " is NOT a Prime Number</h2>");
            }

        } catch (NumberFormatException e) {
            // ERROR HANDLING
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Error
            out.println("<h2 style='color:red;'>Error: Invalid Input! Please enter a valid number.</h2>");
        }

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
package pl.javastart.batch.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/copy")
public class CopyJobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long jobId = jobOperator.start("copyJob", new Properties());
        response.getWriter().println("Copy job started with id: " + jobId);
    }
}
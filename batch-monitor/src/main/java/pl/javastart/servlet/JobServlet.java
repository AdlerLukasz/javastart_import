package pl.javastart.servlet;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/job")
public class JobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long jobId = jobOperator.start("job", new Properties());
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JobExecution jobExecution = jobOperator.getJobExecution(jobId);
        printExecutionTime(jobExecution);
        System.out.println("Job finished with exit-status: " + jobExecution.getExitStatus());
        response.getWriter().append("CSV job started with id: " + jobId);
    }
    
    private void printExecutionTime(JobExecution jobExecution) {
        Date startTime = jobExecution.getStartTime();
        Date endTime = jobExecution.getEndTime();
        Instant startTimeInstant = Instant.ofEpochMilli(startTime.getTime());
        Instant endTimeInstant = Instant.ofEpochMilli(endTime.getTime());
        Duration duration = Duration.between(startTimeInstant, endTimeInstant);
        System.out.println(duration.getNano());
    }
}
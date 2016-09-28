package pl.javastart.servlet;

import java.io.IOException;
import java.text.*;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import pl.javastart.constraint.group.*;
import pl.javastart.model.Project;

@WebServlet("/project")
public class ProjectController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource
    private Validator validator;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        Date date = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
            date = format.parse(request.getParameter("date"));
        } catch (ParseException e) {
            //no date
        }
        String description = request.getParameter("description");
        String owner = request.getParameter("owner");
        String save = request.getParameter("save");
        Project project = new Project(title, date, description, owner);
        if("Draft".equals(save)) {
            saveDraft(project);
        } else if("Complete".equals(save)) {
            saveComplete(project);
        }
    }
    
    private void saveDraft(Project project) {
        Set<ConstraintViolation<Project>> violations = validator.validate(project, Draft.class);
        printViolations(violations);
    }
    
    private void saveComplete(Project project) {
        Set<ConstraintViolation<Project>> violations = validator.validate(project, Full.class);
        printViolations(violations);
    }
    
    private <T> void printViolations(Collection<ConstraintViolation<T>> violations) {
        for (ConstraintViolation<T> v : violations) {
            System.out.printf("%s - %s (%s)\n", 
                    v.getPropertyPath(),
                    v.getInvalidValue(),
                    v.getMessage());
        }
    }
}
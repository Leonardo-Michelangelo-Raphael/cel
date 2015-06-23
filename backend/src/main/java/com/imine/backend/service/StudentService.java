package com.imine.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.imine.backend.model.Student;
import org.apache.log4j.Logger;

/**
 * Created by ypbai on 2015/4/10.
 */
@Path("/students")
public class StudentService {
    private static Logger logger = Logger.getLogger(StudentService.class);
    private static int index = 1;
    private static Map<Integer, Student> studentList =
            new HashMap<Integer, Student>();

    public StudentService() {
        if (studentList.size() == 0) {
            studentList.put(index, new Student(index++, "Frank", "CS"));
            studentList.put(index, new Student(index++, "Jersey", "Math"));
        }
    }

    @GET
    @Path("{studentId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student getMetadata(@PathParam("studentId") int studentId) {
        if (studentList.containsKey(studentId))
            return studentList.get(studentId);
        else
            return new Student(0, "Nil", "Nil");
    }

    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        students.addAll(studentList.values());
        return students;
    }

    @POST
    @Path("add")
    @Produces("text/plain")
    public String addStudent(@FormParam("name") String name,
                             @FormParam("dept") String dept) {
        studentList.put(index, new Student(index++, name, dept));
        return String.valueOf(index - 1);
    }

    @DELETE
    @Path("delete/{studentId}")
    @Produces("text/plain")
    public String removeStudent(@PathParam("studentId") int studentId) {
        logger.info("Receieving quest for deleting student: " + studentId);

        Student removed = studentList.remove(studentId);
        if (removed == null)
            return "failed!";
        else
            return "success!";
    }

    @PUT
    @Path("put")
    @Produces("text/plain")
    public String putStudent(@QueryParam("studentId") int studentId,
                             @QueryParam("name") String name, @QueryParam("dept") String dept) {
        logger.info("Receiving quest for putting student: " + studentId);
        if (!studentList.containsKey(studentId))
            return "failed!";
        else
            studentList.put(studentId, new Student(studentId, name, dept));

        return String.valueOf(studentId);
    }
}
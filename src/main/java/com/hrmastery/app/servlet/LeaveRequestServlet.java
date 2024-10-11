package com.hrmastery.app.servlet;

import com.hrmastery.app.Utils.Validation.LeaveRequestValidation;
import com.hrmastery.app.entity.Employee;
import com.hrmastery.app.entity.LeaveRequest;
import com.hrmastery.app.enums.StatusLeaveRequest;
import com.hrmastery.app.service.impl.EmployeeServiceImpl;
import com.hrmastery.app.service.impl.LeaveRequestServiceImpl;
import com.hrmastery.app.service.interfaces.EmployeeService;
import com.hrmastery.app.service.interfaces.LeaveRequestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "leaveRequestServlet", value = {"/leaveRequests", "/leaveRequest/add","/leaveRequests/pending"})
@MultipartConfig
public class LeaveRequestServlet extends HttpServlet {
    LeaveRequestService leaveRequestService;
    EmployeeService employeeService;

    public void init() {
        leaveRequestService = new LeaveRequestServiceImpl();
        employeeService = new EmployeeServiceImpl();

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getServletPath();

        switch (action) {
            case "/leaveRequests/pending":
                penidngLeaveRequest(req, res);
                break;
            case "/leaveRequest/update":
                break;
            case "/leaveRequests":
               Employee employee = employeeService.getEmployee(UUID.fromString("b0477412-ee2c-445c-a2a1-aa339b0bb63e"));
                HttpSession session = req.getSession();
                session.setAttribute("employee", employee);
                req.getServletContext().getRequestDispatcher("/view/employee/employee.jsp").forward(req, res);
                break;
            default:
                break;
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getServletPath();

        switch (action) {
            case "/leaveRequest/add":
                createLeaveRequest(req, res);
                break;
            case "/leaveRequest/update":
                break;
            case "/leaveRequests":
                break;
            default:
                break;
        }
    }

        private void penidngLeaveRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        }
        private void createLeaveRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        List<String> errors = new ArrayList<>();
        String certificatePath = null; // Variable to hold the certificate path

        // Get the uploaded file part
        Part filePart = req.getPart("certificate");
        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String fileExtension = ""; // To store the file extension (e.g., .pdf)

        // Check if the file has an extension
        if (originalFileName.contains(".")) {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }

        // Generate new file name using the current timestamp
        String newFileName = System.currentTimeMillis() + fileExtension;
        System.out.println("New file name: " + newFileName);

        // Define the file upload directory (use "/uploads/applicationsResume")
        String uploadDirectory = Paths.get(getServletContext().getRealPath("/uploads/applicationsResume")).toString();
        File uploadDir = new File(uploadDirectory);

        // Ensure the directory exists
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Create the directories if they do not exist
        }

        // Combine directory and new file name
        String filePath = Paths.get(uploadDirectory, newFileName).toString();

        try {
            // Save the file on disk
            filePart.write(filePath);
            certificatePath = "/uploads/applicationsResume/" + newFileName; // Store relative path for further use
            System.out.println("File saved at: " + certificatePath);
        } catch (Exception e) {
            errors.add("Error saving file: " + e.getMessage());
        }

        // Create Employee object
        HttpSession session = req.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        System.out.println("Employee email: " + employee.getEmail());

        // Create LeaveRequest object
        try {
            LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
            int duration = Integer.parseInt(req.getParameter("duration"));
            String reason = req.getParameter("reason");

            LeaveRequest leaveRequest = new LeaveRequest(
                    startDate.atStartOfDay(),
                    duration,
                    certificatePath, // Use the certificate path here
                    StatusLeaveRequest.PENDING,
                    reason,
                    employee
            );

            // Validate leave request
            errors.addAll(LeaveRequestValidation.validateLeaveRequest(leaveRequest));

            // If no errors, create leave request
            if (errors.isEmpty()) {
                String success = leaveRequestService.createLeaveRequest(leaveRequest);
                req.setAttribute("success", success);
            }

        } catch (Exception e) {
            errors.add("Error creating leave request: " + e.getMessage());
        }

        // Set errors in the request and forward to the success page
        req.setAttribute("errors", errors);
        req.getServletContext().getRequestDispatcher("/view/admin/dashboard.jsp").forward(req, res);
    }



//
//    public void uploadPDF(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//        if (ServletFileUpload.isMultipartContent((javax.servlet.http.HttpServletRequest) req)) {
//            try {
//                // Create a factory for disk-based file items
//                DiskFileItemFactory factory = new DiskFileItemFactory();
//                // Create a new file upload handler
//                ServletFileUpload upload = new ServletFileUpload(factory);
//
//                // Parse the req
//                List<FileItem> formItems = upload.parseRequest((javax.servlet.http.HttpServletRequest) req);
//
//                if (formItems != null && formItems.size() > 0) {
//                    for (FileItem item : formItems) {
//                        // Process the uploaded file item
//                        if (!item.isFormField()) {
//                            String fileName = item.getName();
//                            String filePath = Paths.get( "uploads/applicationsResume", fileName).toString();
//                            File storeFile = new File(filePath);
//
//                            // Save the file on disk
//                            item.write(storeFile);
//                        }
//                    }
//                }
//            } catch (FileUploadException e) {
//
//            } catch (Exception e) {
//
//            }
//        } else {
//            req.setAttribute("message", "This req does not contain upload data");
//        }
//    }


//    private final static Logger LOGGER = Logger.getLogger(FileUploadServlet.class.getCanonicalName());
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
//        // creating path components for saving the file
//        final String path = request.getParameter("destination");
//        final Part filePart = request.getPart("file");
//        final String fileName = getFileName(filePart);
//
//        // declare instances of OutputStream, InputStream, and PrintWriter classes
//        OutputStream otpStream = null;
//        InputStream iptStream = null;
//        final PrintWriter writer = response.getWriter();
//
//        // try section handles the code for storing file into the specified location
//        try {
//            // initialize instances of OutputStream and InputStream classes
//            otpStream = new FileOutputStream(new File(path + File.separator + fileName));
//            iptStream = filePart.getInputStream();
//
//            int read = 0;
//
//            // initialize bytes array for storing file data
//            final byte[] bytes = new byte[1024];
//
//            // use while loop to read data from the file using iptStream and write into  the desination folder using writer and otpStream
//            while ((read = iptStream.read(bytes)) != -1) {
//                otpStream.write(bytes, 0, read);
//            }
//            writer.println("New file " + fileName + " created at " + path);
//            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", new Object[]{fileName, path});
//        }
//        // catch section handles the errors
//        catch (FileNotFoundException fne){
//            writer.println("You either did not specify a file to upload or are trying to upload a file to a protected or nonexistent location.");
//            writer.println("<br/> ERROR: " + fne.getMessage());
//            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", new Object[]{fne.getMessage()});
//        }
//        // finally section will close all the open classes
//        finally {
//            if (otpStream != null) {
//                otpStream.close();
//            }
//            if (iptStream != null) {
//                iptStream.close();
//            }
//            if (writer != null) {
//                writer.close();
//            }
//        }
//    }
//    // getFileName() method to get the file name from the part
//    private String getFileName(final Part part) {
//        // get header(content-disposition) from the part
//        final String partHeader = part.getHeader("content-disposition");
//        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
//
//        // code to get file name from the header
//        for (String content : part.getHeader("content-disposition").split(";")) {
//            if (content.trim().startsWith("filename")) {
//                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
//            }
//        }
//        // it will return null when it doesn't get file name in the header
//        return null;
//    }
}

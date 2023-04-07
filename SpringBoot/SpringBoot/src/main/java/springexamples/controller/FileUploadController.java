package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

// 4/6 notes file upload
@Slf4j
@Controller
public class FileUploadController {
    @GetMapping("/fileupload")
    public ModelAndView fileUpload() throws IOException {
        ModelAndView response = new ModelAndView("fileupload");

        return response;
    }

    // you can use the same url so long as you have two different mapping types such as GetMapping and PostMapping
    @PostMapping("/fileupload")
    public ModelAndView fileUpload(@RequestParam("fileUpload") MultipartFile fileUpload) throws IOException {
        ModelAndView response = new ModelAndView("fileupload");

        // the . stands for the current project folder, in this example, springboot
        // the target location of where i want the file to be saved
        // intellij considered the root path to be folder inside the RTT-45 folder (springboot)
        // so by using ./ we are saying start at the project root and build the path to where we want to save the file
        // notice we are using a filesystem address and not a URL address
        File target = new File("./src/main/webapp/pub/images/" + fileUpload.getOriginalFilename());
        log.debug(target.getAbsolutePath());

        // this line is a convenience method provided from commons-io library
        // the browser offers the file to be uploaded as an inputstream to the server
        // this method does all of the work reading the file upload input stream and writing it out to a target file on the filesystem
        FileUtils.copyInputStreamToFile(fileUpload.getInputStream(), target);

        // this is just code that will display the file on the page after it has been uploaded.
        // it adds the url to the file to our model to pass to the jsp page
        // notice that we are using a URL address and not a filesystem address
        response.addObject("fileUrl", "/pub/images/" + fileUpload.getOriginalFilename());
        return response;
    }
}

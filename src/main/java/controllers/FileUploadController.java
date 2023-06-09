package controllers;

import models.UploadedFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import repos.UploadedFileRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@Controller
public class FileUploadController {

    private final UploadedFileRepository uploadedFileRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    public FileUploadController(UploadedFileRepository uploadedFileRepository) {
        this.uploadedFileRepository = uploadedFileRepository;
    }



    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("survey_no") String surveyNo,
                                                   @RequestParam("extent") String extent,
                                                   @RequestParam("ref_no") String refNo,
                                                   @RequestParam("landname") String landname,
                                                   @RequestParam Map<String, String> dynamicValues,
                                                   Model model) {

        String filename = UUID.randomUUID().toString() + "." + "pdf";
        File dest = new File(uploadDir, filename);

        try {
            file.transferTo(dest);
            UploadedFile uploadedFile = new UploadedFile();
            uploadedFile.setFilename(file.getOriginalFilename());
            uploadedFile.setFilepath(dest.getAbsolutePath());
            uploadedFile.setSurvey_no(surveyNo);
            uploadedFile.setExtent(extent);
            uploadedFile.setRef_no(refNo);
            uploadedFile.setLandname(landname);
            uploadedFile.setDynamicValues(dynamicValues); // Set the dynamic values

            uploadedFileRepository.save(uploadedFile);

            model.addAttribute("message", "File uploaded successfully!");
            String message = "File uploaded successfully!";
            return ResponseEntity.ok().body("{\"message\": \"" + message + "\"}");

        } catch (IOException e) {
            model.addAttribute("error", "An error occurred while uploading the file.");
            String error = "An error occurred while uploading the file.";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"" + error + "\"}");
        }
    }



    @PutMapping("/update/{filename}")
    public ResponseEntity<Void> updateFiles(@PathVariable String filename, @RequestParam("file") MultipartFile file) {
        Optional<UploadedFile> optionalUploadedFile = Optional.ofNullable(uploadedFileRepository.findByFilename(filename));
        if (optionalUploadedFile.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UploadedFile uploadedFile = optionalUploadedFile.get();
        String oldFilePath = uploadedFile.getFilepath();

        try {
            // Generate a new file name
            String newFileName = UUID.randomUUID().toString() + "." + "pdf";

            // Modify the file path
            String directoryPath = "C:/Users/Bocxy.com/Desktop/HB_Land_Spring/asset/";
            String newPath = directoryPath + newFileName;

            // Create the directory if it doesn't exist
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File newFile = new File(newPath);
            file.transferTo(newFile);

            // Update the file name and file path
            uploadedFile.setFilename(file.getOriginalFilename());
            uploadedFile.setFilepath(newPath);
            uploadedFileRepository.save(uploadedFile);

            // Delete the old file if it exists
            File oldFile = new File(oldFilePath);
            if (oldFile.exists()) {
                oldFile.delete();
            }

            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }







    @GetMapping("/getfile/{land_name}")
    public ResponseEntity<List<UploadedFile>> getFileslandname(@PathVariable String land_name) {
        List<UploadedFile> uploadedFiles = uploadedFileRepository.findAllByLandname(land_name);
        if (!uploadedFiles.isEmpty()) {
            for (UploadedFile file : uploadedFiles) {
                file.getDynamicValues(); // Trigger lazy loading of dynamic values
            }
            return ResponseEntity.ok().body(uploadedFiles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }






    

}
//package controllers;
//
//import models.AwardOtherDetails;
//import org.springframework.http.Httptatus;
//import org.springframework.http.RespnseEntity;
//import org.springframework.util.StrigUtils;
//import org.springframework.web.bind.nnotation.*;
//import org.springframework.web.multiart.MultipartFile;
//import repos.AwardOtherDetailsReposiory;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOpton;
//import java.time.LocalDateTime;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/award-details")
//public class AwardOtherDetailsFileUpoader {
//
//    private  AwardOtherDetailsReposiory awardOtherDetailsRepository;
//
//
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> upoadFile(@RequestParam("file") MultipartFile file,
//                                            @RequestParam("name") String name,
//                                            @RequestParam("status") String status) {
//
//        if (file.isEmpty() || Stringtils.isEmpty(name) || StringUtils.isEmpty(status)) {
//            return ResponseEntity.baRequest().body("File, name, and status are required.");
//        }
//
//        try {
//
//            String timestamp = LocalateTime.now().toString();
//            String fileName = timestmp + "_" + file.getOriginalFilename();
//
//
//            String filePath = "C:/Usrs/Admin/Desktop/TNHB" + fileName;
//
//
//            Path destinationPath = Pth.of(filePath);
//            Files.copy(file.getInputtream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
//
//
//            AwardOtherDetails awardOherDetails = new AwardOtherDetails();
//            awardOtherDetails.setFilname(fileName);
//            awardOtherDetails.setFilpath(filePath);
//            awardOtherDetails.setNam(name);
//            awardOtherDetails.setStaus(status);
//
//
//            awardOtherDetailsRepositry.save(awardOtherDetails);
//
//            return ResponseEntity.ok"File uploaded successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.sttus(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the file.");
//        }
//    }
//
//    @GetMapping("/getawardother/{nam}/{landname}")
//    public ResponseEntity<List<AwardtherDetails>> getFilesByLandName(
//            @PathVariable String nam,
//            @PathVariable String lanname
//    ) {
//        List<AwardOtherDetails> uplodedFiles = awardOtherDetailsRepository.findAllByNameAndLandname(name, landname);
//        if (!uploadedFiles.isEmpty() {
//            return ResponseEntity.ok).body(uploadedFiles);
//        } else {
//            return ResponseEntity.noFound().build();
//        }
//    }
//    @GetMapping("/getawardother/all"
//    public ResponseEntity<List<AwardtherDetails>> getAllFiles() {
//        List<AwardOtherDetails> allFles = awardOtherDetailsRepository.findAll();
//        if (!allFiles.isEmpty()) {
//            return ResponseEntity.ok).body(allFiles);
//        } else {
//            return ResponseEntity.noFound().build();
//        }
//    }
//
//
//
//
//}

package controllers;

import models.AwardOtherDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import repos.AwardOtherDetailsRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class AwardOtherDetailsFileUploader  {

    private final AwardOtherDetailsRepository awardOtherDetailsRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    public AwardOtherDetailsFileUploader(AwardOtherDetailsRepository awardOtherDetailsRepository) {
        this.awardOtherDetailsRepository = awardOtherDetailsRepository;
    }

    @PostMapping("/awardother/upload")
    @ResponseBody

    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("name") String name,
                                                   @RequestParam("status") String status,
                                                   @RequestParam("landname") String landname,
                                                   Model model) {

        String filename = UUID.randomUUID().toString() + "." + "pdf";
        File dest = new File(uploadDir, filename);

        try {
            file.transferTo(dest);
            AwardOtherDetails uploadedFile = new AwardOtherDetails();
            uploadedFile.setFilename(file.getOriginalFilename());
            uploadedFile.setFilepath(dest.getAbsolutePath());
            uploadedFile.setName(name);
            uploadedFile.setStatus(status);

            uploadedFile.setLandname(landname);
            awardOtherDetailsRepository.save(uploadedFile);


            model.addAttribute("message", "File uploaded successfully!");
            String message = "File uploaded successfully!";
            return ResponseEntity.ok().body("{\"message\": \"" + message + "\"}");

        } catch (IOException e) {
            model.addAttribute("error", "An error occurred while uploading the file.");
            String error = "An error occurred while uploading the file.";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"" + error + "\"}");

        }
    }




//    @PutMapping("/update/{filename}")
//    public ResponseEntity<Void> updateFiles(@PathVariable String filename, @RequestParam("file") MultipartFile file) {
//        Optional<AwardOtherDetails> optionalUploadedFile = Optional.ofNullable(awardOtherDetailsRepository.findByFilename(filename));
//        if (optionalUploadedFile.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        AwardOtherDetails uploadedFile = optionalUploadedFile.get();
//        String oldFilePath = uploadedFile.getFilepath();
//
//        try {
//            // Generate a new file name
//            String newFileName = UUID.randomUUID().toString() + "." + "pdf";
//
//            // Modify the file path
//            String directoryPath = "C:/Users/Bocxy.com/Desktop/HB_Land_Spring/asset/";
//            String newPath = directoryPath + newFileName;
//
//            // Create the directory if it doesn't exist
//            File directory = new File(directoryPath);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            File newFile = new File(newPath);
//            file.transferTo(newFile);
//
//            // Update the file name and file path
//            uploadedFile.setFilename(file.getOriginalFilename());
//            uploadedFile.setFilepath(newPath);
//            uploadedFileRepository.save(uploadedFile);
//
//            // Delete the old file if it exists
//            File oldFile = new File(oldFilePath);
//            if (oldFile.exists()) {
//                oldFile.delete();
//            }
//
//            return ResponseEntity.ok().build();
//        } catch (IOException e) {
//            return ResponseEntity.status(500).build();
//        }
//    }






    @GetMapping("/getawardotherfile/{name}/{landname}")
    public ResponseEntity<List<AwardOtherDetails>> getFileslandname(@PathVariable String name,@PathVariable String landname) {
        List<AwardOtherDetails> uploadedFiles = awardOtherDetailsRepository.findByNameAndLandname(name,landname);
        if (!uploadedFiles.isEmpty()) {
            return ResponseEntity.ok().body(uploadedFiles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }









}
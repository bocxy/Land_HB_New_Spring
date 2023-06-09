package controllers;

import models.AwardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repos.AwardDetailsRepository;
@RestController
public class AwardController {

    @Autowired
    private AwardDetailsRepository awardDetailsRepo;



    @PostMapping("/awarddetails")
    public AwardDetails createAwardDetails(@RequestBody AwardDetails awardDetails) {
        return awardDetailsRepo.save(awardDetails);
    }





    @GetMapping("/awarddetails/{filename}/{landname}")
    public ResponseEntity<AwardDetails> getAwardDetailsByLandnameAndFilename(@PathVariable String filename, @PathVariable String landname) {
        AwardDetails awardDetails = awardDetailsRepo.findByFilenameAndLandname(filename,landname );
        if (awardDetails != null) {
            return ResponseEntity.ok(awardDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/awarddetails/{filename}")
    public AwardDetails updateLandDigitData(@PathVariable String filename, @RequestBody AwardDetails data) {
        data.setFilename(filename); // set the id of the data to update
        return awardDetailsRepo.save(data); // save and return the updated data
    }

}

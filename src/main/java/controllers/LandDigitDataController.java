package controllers;

import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repos.CountRepo;
import repos.LandDigitDataRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/landdigitdata")
public class LandDigitDataController {

    @Autowired
    private LandDigitDataRepo landDigitDataRepo;
    
    @Autowired
    private CountRepo countRepo;

    // Create a new LandDigitData
    @PostMapping("/add")
    public LandDigitData createLandDigitData(@RequestBody LandDigitData landDigitData) {
    	return landDigitDataRepo.save(landDigitData);
    }

    // Get all LandDigitData entries
    @GetMapping("/GetAllData")
    public List<LandDigitData> getAllLandDigitData() {
        return landDigitDataRepo.findAll();
    }

    // Get a specific LandDigitData entry by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<LandDigitData> getLandDigitDataById(@PathVariable(value = "id") Long landDigitDataId) {
        Optional<LandDigitData> landDigitData = landDigitDataRepo.findById(landDigitDataId);
        if (landDigitData.isPresent()) {
            return ResponseEntity.ok().body(landDigitData.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update an existing LandDigitData entry
    @PutMapping("/edit/{id}")
    public LandDigitData updateLandDigitData(@PathVariable Long id, @RequestBody LandDigitData data) {
        data.setId(id); // set the id of the data to update
        return landDigitDataRepo.save(data); // save and return the updated data
    }
    // Delete a LandDigitData entry by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLandDigitData(@PathVariable(value = "id") Long landDigitDataId) {
        Optional<LandDigitData> optionalLandDigitData = landDigitDataRepo.findById(landDigitDataId);
        if (optionalLandDigitData.isPresent()) {
            landDigitDataRepo.delete(optionalLandDigitData.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/GetData")
    public List<LandDigitData>getAllemployees(@RequestParam( "types")String types,@RequestParam( "values")String values)
    {
        if(types.equals("circle")   ) {
            return landDigitDataRepo.findByCircle(values);
        }
        if(types.equals("All")   ) {
            return landDigitDataRepo.findAll();
        }
        if(types.equals("chief")   ) {
            return landDigitDataRepo.findByCitynrural(values);
        }
        else {
            return  landDigitDataRepo.findByDivision(values);
        }
    }
    
    @GetMapping("/GetDataCount")
    public List<Count>getAllemployeess(@RequestParam( "types")String types,@RequestParam( "values")String values)
    {
        if(types.equals("circle")   ) {
            return countRepo.findByCircle(values);
        }
        if(types.equals("All")   ) {
            return countRepo.findAll();
        }
        if(types.equals("chief")   ) {
            return countRepo.findByCitynrural(values);
        }
        else {
            return  countRepo.findByDivision(values);
        }
    }


    @Autowired
    landDigitDataimpl landDigitDataimpl;

    @GetMapping("/GetDataDivisions")
    public List<LandDigitData>getdivision(@RequestParam( "circle")String circle) {
        if(circle.equals("All")   ) {
            return landDigitDataimpl.getalldivisionforcircleall();
        }
        if(circle.equals("City")   ) {
            return landDigitDataimpl.getalldivisionforcircleall();
        }
        if(circle.equals("Rural")   ) {
            return landDigitDataimpl.getalldivisionforcircleall();
        }
        else {
            return landDigitDataimpl.getalldivisionforcircle(circle);
        }
    }

    }


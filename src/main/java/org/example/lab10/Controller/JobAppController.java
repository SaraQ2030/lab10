package org.example.lab10.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.lab10.API.ApiRessponse;
import org.example.lab10.Model.JobApp;
import org.example.lab10.Model.JobPost;
import org.example.lab10.Model.User;
import org.example.lab10.Service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jobsystem/job-app")
@AllArgsConstructor
public class JobAppController {
    private final JobApplicationService jobApplicationService;
@GetMapping("/get")
    public ResponseEntity getJobApp(){
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApp());
    }

    @PutMapping("/apply/{user_id}/{jobPost_id}/{jobApp_id}")
    public ResponseEntity applyJop(@PathVariable Integer user_id,Integer jobPost_id ,Integer jobApp_id){
//    if (errors.hasErrors()){
//        String message=errors.getFieldError().getDefaultMessage();
//        return ResponseEntity.status(200).body(message);
//    }
    Boolean isApply=jobApplicationService.applyJob(user_id,jobPost_id,jobApp_id);
    if (isApply){
        return ResponseEntity.status(200).body(new ApiRessponse("apply successfully"));
    }

        return ResponseEntity.status(400).body(new ApiRessponse("Not found job to apply"));
    }
@DeleteMapping("/delete/{user_id}/{jobPost_id}/{jobApp_id}")
    public ResponseEntity withdraw(@PathVariable Integer user_id,Integer jobPost_id ,Integer jobApp_id){
        Boolean withdraw=jobApplicationService.deleteJobApp(user_id,jobPost_id,jobApp_id);
        if (withdraw){
            return ResponseEntity.status(200).body(new ApiRessponse("withdraw application successfully"));
        }

        return ResponseEntity.status(400).body(new ApiRessponse("Not found application"));
    }
    }



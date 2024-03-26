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

    @PutMapping("/apply/{user_id}/{jobPost_id}")
    public ResponseEntity applyJop(@RequestBody @Valid JobApp jobApp,Errors errors){
    if (errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(200).body(message);
    }
        int test=jobApplicationService.applyJob(jobApp);
        if (test==0){
            return ResponseEntity.status(200).body(new ApiRessponse("apply successfully"));
        }
        else if (test==1){
            return ResponseEntity.status(400).body(new ApiRessponse("Not found user id"));
        }
        else if (test==2){
            return ResponseEntity.status(400).body(new ApiRessponse("Not found job post id"));
        }
     return ResponseEntity.status(400).body(new ApiRessponse("wrong data entered"));

    }
@DeleteMapping("/delete/{jobApp_id}")
    public ResponseEntity withdraw(@PathVariable Integer jobApp_id){
        Boolean withdraw=jobApplicationService.deleteJobApp(jobApp_id);
        if (withdraw){
            return ResponseEntity.status(200).body(new ApiRessponse("withdraw application successfully"));
        }

        return ResponseEntity.status(400).body(new ApiRessponse("Not found application"));
    }
    }



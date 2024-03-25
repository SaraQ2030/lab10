package org.example.lab10.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.lab10.API.ApiRessponse;
import org.example.lab10.Model.JobPost;
import org.example.lab10.Service.JobPostService;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jobsystem/job")
@AllArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;
    @GetMapping("/get")
    public ResponseEntity getJobPost(){
        return ResponseEntity.status(200).body(jobPostService.getJobPost());
    }

    @PostMapping("/add")
    public ResponseEntity addJobPost(@RequestBody @Valid JobPost jobPost, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Boolean isAdd=jobPostService.addJobPost(jobPost);
        if (isAdd){
            return ResponseEntity.status(200).body(new ApiRessponse("Job Post added "));
        }
        return ResponseEntity.status(400).body(new ApiRessponse("User already exist"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUserPost(@PathVariable Integer id , @RequestBody @Valid JobPost jobPost ,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdate=jobPostService.updateJobPost(id,jobPost);
        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiRessponse("Job Post Updated") );
        }
        return ResponseEntity.status(400).body(new ApiRessponse("Not found ID"));
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id){
        Boolean isDelete=jobPostService.deleteJobPost(id);
        if (isDelete){
            return ResponseEntity.status(200).body(new ApiRessponse("deleted"));
        }
        return ResponseEntity.status(400).body(new ApiRessponse("Not found ID"));

    }

}

package org.example.lab10.Service;

import lombok.AllArgsConstructor;
import org.example.lab10.Model.JobApp;
import org.example.lab10.Model.JobPost;
import org.example.lab10.Model.User;
import org.example.lab10.Repository.JobApplicationRepository;
import org.example.lab10.Repository.JobPostRepository;
import org.example.lab10.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List<JobApp> getAllJobApp(){
        return jobApplicationRepository.findAll();
    }

    public int applyJob(JobApp jobApp){
       if( userRepository.existsById(jobApp.getUserID())) {
          if (jobPostRepository.existsById(jobApp.getJobPostID())){
              jobApp.setUserID(jobApp.getUserID());
              jobApp.setJobPostID(jobApp.getJobPostID());
              jobApplicationRepository.save(jobApp);
              return 0;
          }
          return 2;
      }
       return 1;

    }


    public Boolean deleteJobApp(Integer id_jobapp){
        JobApp jobApp=jobApplicationRepository.getReferenceById(id_jobapp);
        if( userRepository.existsById(jobApp.getUserID())  &&  jobPostRepository.existsById(jobApp.getJobPostID())){
            jobApplicationRepository.delete(jobApp);
            return true;
        }
        return false;
    }
}

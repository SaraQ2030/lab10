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

    public Boolean applyJob(Integer userId,Integer jobPostId,Integer jobAppId){
        JobApp jobApp=jobApplicationRepository.getReferenceById(jobAppId);
      if( userRepository.existsById(userId)  &&  jobPostRepository.existsById(jobPostId)) {
          jobApplicationRepository.save(jobApp);
          return true;
      }
      return false;
    }


    public Boolean deleteJobApp(Integer id_user,Integer id_jobpost,Integer id_jobapp){
        JobApp jobApp=jobApplicationRepository.getReferenceById(id_jobapp);
        if( userRepository.existsById(id_user)  &&  jobPostRepository.existsById(id_jobpost)){
            jobApplicationRepository.delete(jobApp);
            return true;
        }
        return false;
    }
}

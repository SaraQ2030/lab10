package org.example.lab10.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab10.Model.JobPost;
import org.example.lab10.Repository.JobPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;

    public List<JobPost> getJobPost(){
        return jobPostRepository.findAll();
    }
    public Boolean addJobPost(JobPost jobPost){
       if (jobPostRepository.equals(jobPost)){
           return false;
       }
       jobPostRepository.save(jobPost) ;
       return true;
    }

    public Boolean updateJobPost(Integer id , JobPost jobPost){
        JobPost jp=jobPostRepository.getReferenceById(id);
        if (jobPostRepository.existsById(id)){
            jp.setTitle(jobPost.getTitle());
            jp.setDescription(jobPost.getDescription());
            jp.setSalary(jobPost.getSalary());
            jp.setLocation(jobPost.getLocation());
            jp.setPostingDate(jobPost.getPostingDate());

            jobPostRepository.save(jp);
            return true;
        }
        return false;
    }

    public Boolean deleteJobPost(Integer id){
        JobPost jp=jobPostRepository.getReferenceById(id);
        if (jobPostRepository.existsById(id)){
            jobPostRepository.delete(jp);
            return true;
        }
        return false;
    }
}

package org.example.lab10.Repository;

import org.example.lab10.Model.JobApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApp,Integer> {
}

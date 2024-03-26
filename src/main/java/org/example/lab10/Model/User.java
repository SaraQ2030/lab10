package org.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "user name cannot be empty ")
    @Length(min = 5,message = "user name length should be more than 4 characters ")
    @Column(columnDefinition = "varchar(10) not null  ")//check(length(userName)>4)
    private String userName;
    @Email
    @Column(columnDefinition = "varchar(20) not null  unique")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    @Column(columnDefinition = "varchar(10) not null ")
    private String password;
    @NotNull(message = "the age cannot be empty")
    @Min( value = 22 , message = "the age should be more than 21 ")
    @Column(columnDefinition = "int not null")// check(age>21)
    private Integer age;
    @NotEmpty(message = "role cannot be empty ")
    @Pattern(regexp = "(JOB_SEEKER|EMPLOYER)" ,message = "the role should be job_seeker OR employer")
    @Column(columnDefinition = "varchar(10) not null check(role ='JOB_SEEKER' OR role ='EMPLOYER')")
    private String role;
}

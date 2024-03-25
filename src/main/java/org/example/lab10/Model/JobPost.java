package org.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "the title cannot be empty ")
    @Length(min = 5,message = "the length must be more than 4 letters ")
    @Column(columnDefinition = "varchar(20) not null ")//check(length >4)
    private String title;
    @NotEmpty(message = "the description cannot be empty ")
    @Column(columnDefinition = "varchar(255) not null ")
    private String description;
    @NotEmpty(message = "the location cannot be empty ")
    @Column(columnDefinition = "varchar (255) not null ")
    private String location;
    @NotNull(message = "the salary cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    private LocalDate postingDate;
}

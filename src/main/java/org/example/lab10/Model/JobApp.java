package org.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class JobApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "the user id cannot be empty ")
    @Column(columnDefinition = "int not null")
    private Integer userID;
    @NotNull(message = "the job Post id cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer jobPostID;


}

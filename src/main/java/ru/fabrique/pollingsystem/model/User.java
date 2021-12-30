package ru.fabrique.pollingsystem.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class User {

    @NotNull
    private final Long id;
    private String name;
    private String password;
    private List<Survey> surveys;
}

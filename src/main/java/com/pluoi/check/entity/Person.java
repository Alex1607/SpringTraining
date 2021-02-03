package com.pluoi.check.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Person {

    @Getter
    @Setter
    private String vorname;
    @Getter
    @Setter
    private String nachname;
    @Getter
    @Setter
    private List<String> skills;
    @Getter
    @Setter
    private UUID id;

    /*
    Wenn alle Properties mitgegeben werden, erstellt es ein Objekt **ohne** den Constructor?
    Wenn ich die Id Weglasse wird aber das hier aufgerufen???
     */
    public Person(@JsonProperty("vorname") String vorname,
                  @JsonProperty("nachname") String nachname,
                  @JsonProperty("skills") List<String> skills) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.skills = skills;
        this.id = UUID.randomUUID();
    }
}

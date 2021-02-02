package com.pluoi.check.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Person {

    @Getter private static final List<Person> personsList = new ArrayList<>();
    @Getter @Setter @NotBlank private String vorname;
    @Getter @Setter @NotBlank private String nachname;
    @Getter @Setter private List<String> skills;
    @Getter @Setter private UUID id;

    public Person(@JsonProperty("vorname") String vorname,
                  @JsonProperty("nachname") String nachname,
                  @JsonProperty("skills") List<String> skills,
                  @JsonProperty("id") UUID id) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.skills = skills;
        this.id = id;

        personsList.add(this);
    }

    public Person(@JsonProperty("vorname") String vorname,
                  @JsonProperty("nachname") String nachname,
                  @JsonProperty("skills") List<String> skills) {
        new Person(vorname, nachname, skills, UUID.randomUUID());
    }
}

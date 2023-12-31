package no.hvl.dat250.group.project;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
public class _User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    @OneToMany(mappedBy = "owner")
    @JsonIgnoreProperties({"owner","answers","devices"})
    private Set<Poll> polls = new HashSet<>();
    @Getter
    @Setter
    @OneToMany(mappedBy = "_user")
    @JsonIgnoreProperties({"_user","poll","device"})
    private Set<Answer> answers = new HashSet<>();


}

package noki.api.domain.project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noki.api.domain.profile.Profile;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "tb_projects") @Table(name = "tb_projects")
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String summary;

    private String github;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Project(String name, String summary, String github, Profile profile){
        this.name = name;
        this.summary = summary;
        this.github = github;
        this.profile = profile;
    }
}

package noki.api.domain.skill;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noki.api.domain.profile.Profile;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "tb_skills") @Table(name = "tb_skills")
public class Skill {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String resume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Skill(String name, String resume, Profile profile){
        this.name = name;
        this.resume = resume;
        this.profile = profile;
    }
}

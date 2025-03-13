package noki.api.domain.degree;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noki.api.domain.profile.Profile;

import java.util.GregorianCalendar;
import java.util.UUID;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "tb_degrees") @Table(name = "tb_degrees")
public class Degree {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String institution;

    @Enumerated(EnumType.STRING)
    private DegreeType type;

    private String course;

    private GregorianCalendar conclusion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Degree(String institution, String course, DegreeType type, GregorianCalendar conclusion){
        this.institution = institution;
        this.course = course;
        this.type = type;
        this.conclusion = conclusion;
    }
}

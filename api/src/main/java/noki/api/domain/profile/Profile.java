package noki.api.domain.profile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.GregorianCalendar;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "tb_profiles") @Table(name = "tb_profiles")
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String biography;

    private GregorianCalendar birth;

    public Profile(String name, String biography, GregorianCalendar birth){
        this.name = name;
        this.biography = biography;
        this.birth = birth;
    }
    
}

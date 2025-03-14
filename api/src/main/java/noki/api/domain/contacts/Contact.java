package noki.api.domain.contacts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noki.api.domain.profile.Profile;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity(name = "tb_contacts") @Table(name = "tb_contacts")
public class Contact {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String url;

    @Enumerated(value = EnumType.STRING)
    private ContactType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Contact(String name, String url, ContactType type, Profile profile){
        this.name = name;
        this.url = url;
        this.type = type;
        this.profile = profile;
    }
}

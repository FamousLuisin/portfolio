package noki.api.controller;

import noki.api.domain.profile.Profile;
import noki.api.domain.profile.dto.ProfileDTO;
import noki.api.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository repository;

    @GetMapping
    public ResponseEntity<ProfileDTO> getProfile(){

        Profile profile = repository.findAll().iterator().next();

        ProfileDTO response = new ProfileDTO(profile.getName(), profile.getBiography(), profile.getBirth());

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody ProfileDTO dto){

        Profile profile = repository.findAll().iterator().next();

        profile.setName(dto.name());
        profile.setBiography(dto.biography());
        profile.setBirth(dto.birth());

        repository.save(profile);

        return ResponseEntity.ok().build();
    }

}

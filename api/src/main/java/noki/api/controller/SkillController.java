package noki.api.controller;

import noki.api.domain.profile.Profile;
import noki.api.domain.skill.Skill;
import noki.api.domain.skill.dto.SkillDTO;
import noki.api.repository.ProfileRepository;
import noki.api.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping
    public ResponseEntity<?> postSkill(@RequestBody SkillDTO dto){

        Profile profile = profileRepository.findAll().iterator().next();

        Skill skill = new Skill(dto.name(), dto.resume(), profile);

        skillRepository.save(skill);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getSkills(){

        Profile profile = profileRepository.findAll().iterator().next();

        List<Skill> skills = skillRepository.findAllByProfile(profile);

        List<SkillDTO> skillsDTO = skills.stream().map(s -> new SkillDTO(s.getId(), s.getName(), s.getResume())).toList();

        return ResponseEntity.ok(skillsDTO);
    }

    @PutMapping
    public ResponseEntity<?> updateSkill(@RequestBody SkillDTO dto){

        Optional<Skill> skill = skillRepository.findById(dto.id());

        skill.ifPresentOrElse(s -> {
            s.setName(dto.name());
            s.setResume(dto.resume());
            skillRepository.save(s);
        }, () -> {});

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable UUID id){
        skillRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}

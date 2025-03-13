package noki.api.controller;

import noki.api.domain.degree.Degree;
import noki.api.domain.degree.dto.DegreeDTO;
import noki.api.domain.profile.Profile;
import noki.api.repository.DegreeRepository;
import noki.api.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/degrees")
public class DegreeController {

    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping
    public ResponseEntity<?> addDegree(@RequestBody DegreeDTO dto){

        Profile profile = profileRepository.findAll().iterator().next();

        Degree degree = new Degree(dto.institution(), dto.course(), dto.type(), dto.conclusion());

        degree.setProfile(profile);

        degreeRepository.save(degree);

        return ResponseEntity.ok(degree);
    }

    @GetMapping
    public ResponseEntity<List<DegreeDTO>> getDegrees(){

        Profile profile = profileRepository.findAll().iterator().next();

        List<Degree> degrees = degreeRepository.findAllByProfile(profile);

        List<DegreeDTO> degreeDTOS = degrees.stream().
                map(degree -> new  DegreeDTO(
                        degree.getId(),
                        degree.getInstitution(),
                        degree.getCourse(),
                        degree.getType(),
                        degree.getConclusion())).toList();

        return ResponseEntity.ok(degreeDTOS);
    }

    @PutMapping
    public ResponseEntity<?> updateDegrees(@RequestBody DegreeDTO dto){

        Optional<Degree> degree = degreeRepository.findById(dto.id());

        degree.ifPresentOrElse(d ->{
            d.setInstitution(dto.institution());
            d.setCourse(dto.course());
            d.setType(dto.type());
            degreeRepository.save(d);

        }, () -> System.out.println("Não encontrado"));

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteDegree(@PathVariable String id){
        degreeRepository.deleteById(UUID.fromString(id));

        return ResponseEntity.ok().build();
    }
}

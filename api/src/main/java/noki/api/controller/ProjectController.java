package noki.api.controller;

import noki.api.domain.profile.Profile;
import noki.api.domain.project.Project;
import noki.api.domain.project.dto.ProjectDTO;
import noki.api.repository.ProfileRepository;
import noki.api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/projects")
public class ProjectController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public ResponseEntity<?> getProjects(){

        Profile profile = profileRepository.findAll().iterator().next();

        List<Project> projects = projectRepository.findAllByProfile(profile);

        List<ProjectDTO> projectDTOS = projects.stream().map(p -> new ProjectDTO(p.getId(),
                p.getName(),
                p.getSummary(),
                p.getGithub())).toList();

        return ResponseEntity.ok(projectDTOS);
    }

    @PostMapping
    public ResponseEntity<?> postProject(@RequestBody ProjectDTO dto){

        Profile profile = profileRepository.findAll().iterator().next();

        Project project = new Project(dto.name(), dto.summary(), dto.github(), profile);

        projectRepository.save(project);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public  ResponseEntity<?> putProject(@RequestBody ProjectDTO dto){

        Optional<Project> project = projectRepository.findById(dto.id());

        project.ifPresentOrElse(p -> {
            p.setName(dto.name());
            p.setSummary(dto.summary());
            p.setGithub(dto.github());

            projectRepository.save(p);
        }, () -> {});

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<?> deleteProject(@PathVariable UUID id){

        projectRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}

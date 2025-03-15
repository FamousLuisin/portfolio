package noki.api.repository;

import noki.api.domain.profile.Profile;
import noki.api.domain.project.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends CrudRepository<Project, UUID> {

    List<Project> findAllByProfile(Profile profile);
}

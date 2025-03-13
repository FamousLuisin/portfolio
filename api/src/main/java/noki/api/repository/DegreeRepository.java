package noki.api.repository;

import noki.api.domain.degree.Degree;
import noki.api.domain.profile.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DegreeRepository extends CrudRepository<Degree, UUID> {

    List<Degree> findAllByProfile(Profile profile);
}

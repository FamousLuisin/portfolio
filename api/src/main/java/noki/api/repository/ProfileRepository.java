package noki.api.repository;

import noki.api.domain.profile.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, UUID> {
}

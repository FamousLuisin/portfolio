package noki.api.repository;

import noki.api.domain.profile.Profile;
import noki.api.domain.skill.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillRepository extends CrudRepository<Skill, UUID> {

    List<Skill> findAllByProfile(Profile profile);
}

package noki.api.repository;

import noki.api.domain.contacts.Contact;
import noki.api.domain.profile.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepository extends CrudRepository<Contact, UUID> {

    List<Contact> findAllByProfile(Profile profile);
}

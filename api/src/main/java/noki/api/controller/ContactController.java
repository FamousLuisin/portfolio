package noki.api.controller;

import noki.api.domain.contacts.Contact;
import noki.api.domain.contacts.dto.ContactDTO;
import noki.api.domain.profile.Profile;
import noki.api.repository.ContactRepository;
import noki.api.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public ResponseEntity<?> getContacts(){
        Profile profile = profileRepository.findAll().iterator().next();

        List<Contact> contacts = contactRepository.findAllByProfile(profile);

        List<ContactDTO> contactsDTO = contacts.stream().map(contact -> {
           return new ContactDTO(
                   contact.getId(),
                   contact.getName(),
                   contact.getUrl(),
                   contact.getType());
        }).toList();

        return ResponseEntity.ok(contactsDTO);
    }

    @PostMapping
    public ResponseEntity<?> postContact(@RequestBody ContactDTO dto){
        Profile profile = profileRepository.findAll().iterator().next();

        Contact contact = new Contact();
        contact.setName(dto.name());
        contact.setUrl(dto.url());
        contact.setType(dto.type());
        contact.setProfile(profile);

        contactRepository.save(contact);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> putContact(@RequestBody ContactDTO dto){
        Profile profile = profileRepository.findAll().iterator().next();

        Optional<Contact> contact = contactRepository.findById(dto.id());

        contact.ifPresentOrElse(c -> {
            c.setName(dto.name());
            c.setUrl(dto.url());
            c.setType(dto.type());

            contactRepository.save(c);
        }, () -> {});

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable UUID id){
        contactRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}

package noki.api.domain.contacts.dto;

import noki.api.domain.contacts.ContactType;

import java.util.UUID;

public record ContactDTO(UUID id, String name, String url, ContactType type) {
}

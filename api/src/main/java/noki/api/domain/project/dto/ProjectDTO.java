package noki.api.domain.project.dto;

import java.util.UUID;

public record ProjectDTO(UUID id, String name, String summary, String github) {
}

package noki.api.domain.degree.dto;

import noki.api.domain.degree.DegreeType;

import java.util.GregorianCalendar;
import java.util.UUID;

public record DegreeDTO(UUID id, String institution, String course, DegreeType type, GregorianCalendar conclusion) {
}

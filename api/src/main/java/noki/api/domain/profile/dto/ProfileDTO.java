package noki.api.domain.profile.dto;

import java.util.GregorianCalendar;

public record ProfileDTO(String name, String biography, GregorianCalendar birth) {

    public ProfileDTO(String name, String biography, GregorianCalendar birth){
        this.name = name;
        this.biography = biography;
        this.birth = birth;
    }
}

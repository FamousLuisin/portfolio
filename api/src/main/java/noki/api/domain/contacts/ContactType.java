package noki.api.domain.contacts;

public enum ContactType {

    TEL("telefone"),
    EMAIL("email"),
    LINK("link");

    private final String type;

    ContactType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}

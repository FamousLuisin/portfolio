CREATE TABLE tb_contacts(
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(50),
    url VARCHAR(100),
    type VARCHAR(15),
    profile_id BINARY(16),
    CONSTRAINT fk_contacts_profile_id FOREIGN KEY (profile_id) REFERENCES tb_profiles(id)
);
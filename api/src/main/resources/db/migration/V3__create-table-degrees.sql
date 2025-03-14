CREATE TABLE tb_degrees(
    id BINARY(16) PRIMARY KEY,
    institution VARCHAR(50),
    type VARCHAR(50),
    course VARCHAR(50),
    conclusion DATE,
    profile_id BINARY(16),
    CONSTRAINT fk_degrees_profile_id FOREIGN KEY (profile_id) REFERENCES tb_profiles(id)
);
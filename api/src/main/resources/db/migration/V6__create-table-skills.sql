CREATE TABLE tb_skills(
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(50),
    resume VARCHAR(255),
    profile_id BINARY(16),
    CONSTRAINT fk_skills_projects_id FOREIGN KEY (profile_id) REFERENCES tb_profiles(id)
);
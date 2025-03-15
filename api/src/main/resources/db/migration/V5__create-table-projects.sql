CREATE TABLE tb_projects(
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(50),
    summary VARCHAR(500),
    github VARCHAR(50),
    profile_id BINARY(16),
    CONSTRAINT fk_projects_profile_id FOREIGN KEY (profile_id) REFERENCES tb_profiles(id)
);
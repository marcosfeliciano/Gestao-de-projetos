CREATE TABLE users
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE projects
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    name         VARCHAR(255)          NULL,
    area_app     VARCHAR(250)          NULL,
    start        date                  NULL,
    end          date                  NULL,
    budget       DOUBLE                NULL,
    location     VARCHAR(255)          NULL
    user_id      BIGINT                NULL,
    observations VARCHAR(255)          NULL,
    created_at   datetime              NULL,
    updated_at   datetime              NULL,
    CONSTRAINT pk_projects PRIMARY KEY (id)
);

ALTER TABLE projects
    ADD CONSTRAINT FK_PROJECTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);



CREATE TABLE phases
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    project_id  BIGINT                NULL,
    name        VARCHAR(255)          NULL,
    user_id     BIGINT                NULL,
    `order`     TINYINT               NULL,
    observation VARCHAR(255)          NULL,
    CONSTRAINT pk_phases PRIMARY KEY (id)
);

ALTER TABLE phases
    ADD CONSTRAINT FK_PHASES_ON_PROJECT FOREIGN KEY (project_id) REFERENCES projects (id);

ALTER TABLE phases
    ADD CONSTRAINT FK_PHASES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);
CREATE TABLE activities
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    phase_id    BIGINT                NULL,
    name        VARCHAR(255)          NULL,
    start       date                  NULL,
    end         date                  NULL,
    user_id     BIGINT                NULL,
    observation VARCHAR(255)          NULL,
    percent     FLOAT                 NULL,
    cell        BIGINT                NULL,
    activity_id BIGINT                NULL,
    CONSTRAINT pk_activities PRIMARY KEY (id)
);

ALTER TABLE activities
    ADD CONSTRAINT FK_ACTIVITIES_ON_ACTIVITY FOREIGN KEY (activity_id) REFERENCES activities (id);

ALTER TABLE activities
    ADD CONSTRAINT FK_ACTIVITIES_ON_PHASE FOREIGN KEY (phase_id) REFERENCES phases (id);

ALTER TABLE activities
    ADD CONSTRAINT FK_ACTIVITIES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);
--liquibase formatted sql

--changeset shulika:1
create table app_user
(
    id            bigint not null primary key,
    tg_first_name varchar(55),
    full_name     varchar(55),
    state         varchar(55),
    department_id bigint,
    role          varchar(10),
    send_to       bigint,
    created_at    timestamp,
    updated_at    timestamp
);
--rollback DROP TABLE category;

--changeset shulika:2
create table department
(
    id       serial primary key,
    name     varchar(55),
    password varchar(55)
);
--rollback DROP TABLE category;

--changeset shulika:3
create table employee
(
    id            bigint not null primary key,
    tg_first_name varchar(55),
    full_name     varchar(55),
    department_id bigint references department(id),
    role          varchar(55),
    created_at    timestamp,
    updated_at    timestamp
);
--rollback DROP TABLE category;

--changeset shulika:4
create table post
(
    id                   bigserial primary key,
    to_department_id     bigint references department(id),
    from_employee_id     bigint references employee(id),
    text_msg             varchar(955),
    accepted_employee_id bigint references employee(id),
    created_at           timestamp,
    updated_at           timestamp,
    file_id              varchar(255)
);
--rollback DROP TABLE category;
create table employee
(
    id          int auto_increment
        primary key,
    second_name varchar(20)                                      not null,
    first_name  varchar(20)                                      not null,
    middle_name varchar(20)                                      null,
    position    varchar(255)                                     not null,
    login       varchar(20)                                      not null,
    password    varchar(50) default 'password'                   not null,
    deleted     int         default 0                            not null,
    role        enum ('ROLE_ADMIN', 'ROLE_DOCTOR', 'ROLE_NURSE') not null
);

create table manipulation
(
    id      tinyint auto_increment
        primary key,
    title   varchar(225)                     not null,
    type    enum ('PROCEDURE', 'MEDICAMENT') not null,
    deleted int default 0                    not null
);

create table patient
(
    id          int auto_increment
        primary key,
    insurance   varchar(20)             not null,
    first_name  varchar(20)             not null,
    middle_name varchar(20)             null,
    second_name varchar(20)             not null,
    birthdate   date                    not null,
    gender      enum ('MALE', 'FEMALE') not null
);

create table `case`
(
    id         bigint auto_increment
        primary key,
    patient_id int                                   not null,
    doctor_id  int                                   not null,
    diagnosis  varchar(255) default 'is not defined' null,
    open       tinyint(1)   default 1                not null,
    start_date date                                  not null,
    end_date   date                                  null,
    constraint case_employee_id_fk
        foreign key (doctor_id) references employee (id),
    constraint case_patient_id_fk
        foreign key (patient_id) references patient (id)
);

create table prescription
(
    id              bigint auto_increment
        primary key,
    patient_id      int               not null,
    manipulation_id tinyint           not null,
    duration        tinyint           not null,
    start_date      date              not null,
    dosage          varchar(255)      null,
    daily_chart     tinyint default 1 not null,
    drug            varchar(40)       null,
    deleted         int     default 0 not null,
    case_id         bigint            not null,
    constraint appointment_manipulation_id_fk
        foreign key (manipulation_id) references manipulation (id),
    constraint appointment_patient_fk
        foreign key (patient_id) references patient (id)
);

create table event
(
    id              bigint auto_increment
        primary key,
    patient_id      int                                                                   not null,
    date            date                                                                  not null,
    manipulation_id tinyint                                                               not null,
    status          enum ('PLANNED', 'COMPLETED', 'CANCELED', 'FAILED') default 'PLANNED' not null,
    comment         text                                                                  null,
    prescription_id bigint                                                                not null,
    time            time                                                                  not null,
    constraint event_prescription_id_fk
        foreign key (prescription_id) references prescription (id),
    constraint manipulation_fk
        foreign key (manipulation_id) references manipulation (id),
    constraint patient_fk
        foreign key (patient_id) references patient (id)
);

create table time_pattern
(
    id              bigint auto_increment
        primary key,
    prescription_id bigint                                                                             not null,
    weekday         set ('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY') not null,
    constraint time_pattern_prescription_id_fk
        foreign key (prescription_id) references prescription (id)
);
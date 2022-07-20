create sequence hibernate_sequence start 1 increment 1;

create table activity_history (
    id                      bigserial not null,
    history_record_type     varchar(255),
    record_create_date      varchar(255),
    study_activity_id       int8 not null,
    schoolchild_id          int8 not null,
    primary key (id)
    );


create table schedule (
    id bigserial not null,
    cabinet_number varchar(255),
    date_of_event varchar(255),
    end_time varchar(255),
    start_time varchar(255),
    study_activity_id int8,
    primary key (id)
    );


create table schoolchild (
    id bigserial not null,
    educational_class varchar(255),
    educational_organization varchar(255),
    email varchar(255),
    father_name varchar(255),
    name varchar(255),
    phone_number varchar(255),
    surname varchar(255),
    primary key (id)
    );


create table study_activity (
    id bigserial not null,
    activity_type varchar(255),
    description varchar(2048),
    end_date varchar(255),
    max_participants int4,
    name varchar(255),
    participation_point int4,
    start_date varchar(255),
    primary key (id)
    );


create table activity_trajectory (
    trajectory_id bigserial not null,
    study_activity_id int8 not null,
    primary key (trajectory_id, study_activity_id)
    );


create table trajectory (
    id bigserial not null,
    description varchar(255),
    name varchar(255),
    primary key (id)
   );


alter table if exists activity_trajectory
    add constraint activity_trajectory_activity_fk
    foreign key (study_activity_id) references study_activity;


alter table if exists activity_trajectory
    add constraint activity_trajectory_trajectory_fk
    foreign key (trajectory_id) references trajectory;


alter table if exists activity_history
    add constraint activity_history_study_activity_fk
    foreign key (study_activity_id) references study_activity;


alter table if exists activity_history
    add constraint activity_history_schoolchild_fk
    foreign key (schoolchild_id) references schoolchild;


alter table if exists schedule
    add constraint schedule_study_activity_fk
    foreign key (study_activity_id) references study_activity;
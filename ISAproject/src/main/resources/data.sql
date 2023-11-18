insert into authority(id,name) values (1,'ROLE_ADMIN');
insert into authority(id,name) values (2,'ROLE_REGISTERED_USER');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date) values (1,'Admin','truman', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Truman', 'Willis', 'isamarkomarkovic99@gmail.com', '305-555-0163',true,'1983-07-12 21:30:55.888');
insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date) values (2,'RegisteredUser','raymond', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Raymond', 'Weaving', 'isamarkomarkovic99@gmail.com', '305-555-0720',true,'1983-07-12 21:30:55.888');

insert into user (id, username, password, email, first_name, last_name, mobile, city, state, sex, profession, organization_information, enabled, role) values (3, 'mare99', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'mare99@gmail.com', 'Marko', 'Markovic', '520-661-7473', 'Beograd', 'Srbija', 'Male', 'Web Designer II', 'Vega', true, 'RegisteredUser');

insert into user (id, username, password, email, first_name, last_name, mobile, city, state, sex, profession, organization_information, enabled, role)
values (4, 'milos34', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'milos34@gmail.com', 'Milos', 'Milosevic', '602-479-9290', 'Nis', 'Srbija', 'Male', 'Senior Cost Accountant', 'Avamba', false, 'Admin');

insert into user (id, username, password, email, first_name, last_name, mobile, city, state, sex, profession, organization_information, enabled, role)
values (5, 'wmacmenamy2', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'wmacmenamy2@wisc.edu', 'Westbrook', 'MacMenamy', '520-946-8299', 'Tucson', 'Arizona', 'Male', 'Editor', 'Camimbo', true, true);

insert into user (id, username, password, email, first_name, last_name, mobile, city, state, sex, profession, organization_information, enabled, role)
values (6, 'rcubbon3', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'rcubbon3@google.com.hk', 'Riannon', 'Cubbon', '602-563-0674', 'Tempe', 'Arizona', 'Female', 'Chemical Engineer', 'Kwimbee', false, false);

insert into user (id, username, password, email, first_name, last_name, mobile, city, state, sex, profession, organization_information, enabled, role)
values (7, 'crigardeau4', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'crigardeau4@google.ca', 'Clark', 'Rigardeau', '520-352-6769', 'Tucson', 'Arizona', 'Male', 'Business Systems Development Analyst', 'Yamia', false, true);



insert into user_authority (user_id,authority_id) values (1,1);
insert into user_authority (user_id,authority_id) values (2,2);

insert into company(id, name, address, description, average_grade_company) values (1, 'MedLa', 'Sentandrejski put BB', 'Medicinska laboratorija',8);

insert into equipment(id, name, type, description) values (1, 'Gaza', 'Osnovna', 'Gaza za previjanje');
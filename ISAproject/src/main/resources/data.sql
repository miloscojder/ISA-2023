insert into authority(id,name) values (1,'ROLE_ADMIN');
insert into authority(id,name) values (2, 'ROLE_REGISTEREDUSER');

insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date) values (1,'Admin','truman', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Truman', 'Willis', 'isamarkomarkovic99@gmail.com', '305-555-0163',true,'1983-07-12 21:30:55.888');
insert into user (id,role, username, password, first_name, last_name, email, mobile,enabled,last_password_reset_date) values (2,'Owner','raymond', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Raymond', 'Weaving', 'isamarkomarkovic99@gmail.com', '305-555-0720',true,'1983-07-12 21:30:55.888');



insert into user_authority (user_id,authority_id) values (1,1);
insert into user_authority (user_id,authority_id) values (2,2);

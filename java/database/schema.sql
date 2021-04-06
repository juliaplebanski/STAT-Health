BEGIN TRANSACTION;

DROP TABLE IF EXISTS doctor_schedule;
DROP TABLE IF EXISTS visit;
DROP TABLE IF EXISTS visit_status;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE patient (
  patient_id serial NOT NULL,
  user_id integer NOT NULL,
  CONSTRAINT pk_patient_id PRIMARY KEY (patient_id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE doctor (
  doctor_id serial NOT NULL,
  user_id integer NOT NULL,
  first_name varchar (50) NOT NULL,
  last_name varchar (50) NOT NULL,
  CONSTRAINT pk_doctor_id PRIMARY KEY (doctor_id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE visit_status (
  status_id char(1) NOT NULL,
  status_desc varchar(50) NOT NULL,
  CONSTRAINT pk_status_id PRIMARY KEY (status_id)
);

CREATE TABLE visit (
  visit_id serial NOT NULL,
  patient_id integer NOT NULL,
  doctor_id integer NOT NULL,
  date_of_visit date NOT NULL,
  start_time time NOT NULL,
  end_time time NOT NULL,
  status_id char(1) NOT NULL,
  CONSTRAINT pk_visit_id PRIMARY KEY (visit_id),
  CONSTRAINT fk_patient_id FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
  CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
  CONSTRAINT fk_status_id FOREIGN KEY (status_id) REFERENCES visit_status(status_id)
);


CREATE TABLE doctor_schedule (
  doctor_id integer NOT NULL,
  doctor_schedule_id serial NOT NULL,
  appointment_start_time time NOT NULL,
  appointment_end_time time (50) NOT NULL,
  
  
  CONSTRAINT pk_doctor_schedule_id PRIMARY KEY (doctor_schedule_id),
  CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)
);


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO patient (user_id) VALUES (1);
INSERT INTO patient (user_id) VALUES (1);
INSERT INTO doctor (user_id,first_name,last_name) VALUES (2, 'Steve', 'Carmicheal');
INSERT INTO visit_status (status_id,status_desc) VALUES ('a', 'approved');
INSERT INTO visit_status (status_id, status_desc) VALUES ('p','pending');
INSERT INTO visit (patient_id,doctor_id, date_of_visit, start_time, end_time, status_id) VALUES (1,1, '5/5/2021', '8:00', '8:30', 'a');
INSERT INTO visit (patient_id,doctor_id, date_of_visit, start_time, end_time, status_id) VALUES (1,1, '5/9/2021', '9:00', '9:30', 'a');
INSERT INTO visit (patient_id,doctor_id, date_of_visit, start_time, end_time, status_id) VALUES (1,1, '5/12/2021', '9:00', '9:30', 'a');
INSERT INTO visit (patient_id,doctor_id, date_of_visit, start_time, end_time, status_id) VALUES (1,1, '5/16/2021', '8:00', '8:30', 'a');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time,appointment_end_time) VALUES (1, '8:00', '8:30');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time,appointment_end_time) VALUES (1, '8:30', '9:00');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time,appointment_end_time) VALUES (1, '9:00', '9:30');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time,appointment_end_time) VALUES (1, '10:00', '10:30');



COMMIT TRANSACTION;

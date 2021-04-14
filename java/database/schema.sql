BEGIN TRANSACTION;

DROP TABLE IF EXISTS prescription;
DROP TABLE IF EXISTS doctor_schedule;
DROP TABLE IF EXISTS visit;
DROP TABLE IF EXISTS visit_reason;
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
  doctor_id integer NOT NULL,
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

CREATE TABLE visit_reason (
	visit_reason_id SERIAL NOT NULL,
	reason varchar(50) UNIQUE,	
	CONSTRAINT PK_visit_reason_id PRIMARY KEY (visit_reason_id)
	
);


CREATE TABLE visit (
  visit_id serial NOT NULL,
  patient_id integer NOT NULL,
  doctor_id integer NOT NULL,
  date_of_visit date NOT NULL,
  start_time time NOT NULL,
  status_id char(1) NOT NULL,
  visit_reason varchar(50) NOT NULL,
  description varchar (2000),

  CONSTRAINT pk_visit_id PRIMARY KEY (visit_id),
  CONSTRAINT fk_patient_id FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
  CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
  CONSTRAINT fk_status_id FOREIGN KEY (status_id) REFERENCES visit_status(status_id)
  

);


CREATE TABLE doctor_schedule (
  doctor_id integer NOT NULL,
  doctor_schedule_id serial NOT NULL,
  appointment_start_time time NOT NULL,
  
  CONSTRAINT pk_doctor_schedule_id PRIMARY KEY (doctor_schedule_id),
  CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)
);

CREATE TABLE prescription (
  prescription_id serial,
  prescription_name varchar NOT NULL,
  dosage_amount varchar NOT NULL,
  patient_id integer NOT NULL,
  doctor_id integer NOT NULL,
  description varchar NOT NULL,
  instructions varchar NOT NULL,
  
  CONSTRAINT pk_prescription_id PRIMARY KEY (prescription_id),
  CONSTRAINT fk_patient_id FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
  CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)

);


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO patient (user_id, doctor_id) VALUES (1,1);
INSERT INTO patient (user_id, doctor_id) VALUES (1,1);
INSERT INTO doctor (user_id,first_name,last_name) VALUES (2, 'Steve', 'Carmichael');
INSERT INTO visit_status (status_id,status_desc) VALUES ('a', 'approved');
INSERT INTO visit_status (status_id, status_desc) VALUES ('p','pending');

INSERT INTO visit_reason (reason) VALUES ('Skin Disorders');
INSERT INTO visit_reason (reason) VALUES ('Joint Pain and Osteoarthritis');
INSERT INTO visit_reason (reason) VALUES ('Back Problems');
INSERT INTO visit_reason (reason) VALUES ('Cholesterol Problems');
INSERT INTO visit_reason (reason) VALUES ('Upper Respiratory Problems (not including asthma)');
INSERT INTO visit_reason (reason) VALUES ('Anxiety, Bipolar Disorder and Depression');
INSERT INTO visit_reason (reason) VALUES ('Chronic Neurology Disorders');
INSERT INTO visit_reason (reason) VALUES ('High Blood Pressure');
INSERT INTO visit_reason (reason) VALUES ('Migraines');
INSERT INTO visit_reason (reason) VALUES ('Diabetes');
INSERT INTO visit_reason (reason) VALUES ('Other');

INSERT INTO visit (patient_id,doctor_id, date_of_visit, start_time, visit_reason, status_id, description) VALUES (1,1, '6/12/2020', '8:00', 'Other', 'a', 'I have been having difficulty breathing/catching my breath and believe I might have asthma');
INSERT INTO visit (patient_id,doctor_id, date_of_visit, start_time, visit_reason, status_id, description) VALUES (1,1, '8/8/2020', '8:00', 'Other', 'a', 'Consultation on ADHD testing');
INSERT INTO visit (patient_id,doctor_id, date_of_visit, start_time, visit_reason, status_id, description) VALUES (1,1, '11/12/2020', '8:00', 'Migraine', 'a', 'For the past few weeks I have been having bad migraines.');
INSERT INTO visit (patient_id,doctor_id, date_of_visit, start_time, visit_reason, status_id, description) VALUES (1,1, '4/19/2021', '8:00', 'Skin Disorders', 'a', 'For the past ten years, I had bad acne and I am interested in taking accutane');
INSERT INTO visit (patient_id,doctor_id, date_of_visit, start_time, visit_reason, status_id, description) VALUES (1,1, '5/13/2021', '9:00', 'Other', 'a', 'Last year, I realized I had small appetite, and was not eating much, my doctor recommended me Aptemin, so today I am booking a follow up');

INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '8:00');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '8:30');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '9:00');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '9:30');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '10:00');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '10:30');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '11:00');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '11:30');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '1:00');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '1:30');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '2:00');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '3:00');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '3:30');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '4:00');
INSERT INTO doctor_schedule (doctor_id, appointment_start_time) VALUES (1, '4:30');

INSERT INTO prescription (prescription_name, dosage_amount, patient_id, doctor_id, description, instructions) VALUES ('Adderall', '20mg', '1', '1', 'Adderall is a combination prescription drug that contains amphetamine and dextroamphetamine, two stimulants that affect the bodys impulse control and hyperactivity, and treat attention deficit hyperactivity disorder (ADHD)','Take this medication by mouth with or without food as needed, usually 1 to 3 times a day.');
INSERT INTO prescription (prescription_name, dosage_amount,patient_id, doctor_id, description, instructions) VALUES ('Ibuprofen', '500mg', '1', '1', 'Ibuprofen is used to reduce fever and treat pain or inflammation caused by many conditions such as headache, toothache, back pain, arthritis, menstrual cramps, or minor injury.','Take ibuprofen tablets and capsules as needed with food or a drink of milk to reduce the chance of an upset stomach.');
INSERT INTO prescription (prescription_name, dosage_amount,patient_id, doctor_id,description, instructions) VALUES ('Albuterol', '90mcg', '1', '1', 'Albuterol is used to prevent and treat wheezing, difficulty breathing, chest tightness, and coughing caused by lung diseases such as asthma and chronic obstructive pulmonary disease.', 'Please take this medication 5 times daily');
INSERT INTO prescription (prescription_name, dosage_amount,patient_id, doctor_id, description, instructions) VALUES ('Glyburide', '20mg', '1', '1', 'Glyburide lowers blood sugar by causing the pancreas to produce insulin (a natural substance that is needed to break down sugar in the body, and reduces diabetes.) ', 'Please take this medication 5 times daily');



COMMIT TRANSACTION;
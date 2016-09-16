
	delete from c_user_area;
	delete from c_user_speciality;
	delete from c_speciality;
	delete from c_area;
	delete from c_user;
	

	select * from c_user;
	select * from c_user_speciality;
	select * from c_user_area;

	
create table c_user (user_id INTEGER PRIMARY KEY AUTO_INCREMENT, email_id varchar(50) NOT NULL,password varchar(20) NOT NULL, first_name varchar(250) NOT NULL,last_name varchar(250) NOT NULL,age int ,gender varchar(1) NOT NULL,mobile_number INTEGER NOT NULL,charge_month int, is_cook varchar(1) NOT NULL DEFAULT 'Y',created_by int NOT NULL,modified_by int NOT NULL,created_date date NOT NULL ,modified_date date NOT NULL );
	 
create table c_speciality (spec_code VARCHAR(50) PRIMARY KEY,spec_desc varchar(250) NOT NULL,spec_comment varchar(250), created_by int NOT NULL,modified_by int NOT NULL,created_date date NOT NULL ,modified_date date NOT NULL);
	 
create table c_area (area_code VARCHAR(50) PRIMARY KEY,area_desc varchar(250) NOT NULL,	area_Comment varchar(250),created_by int NOT NULL,modified_by int NOT NULL,created_date date NOT NULL ,modified_date date NOT NULL);
	 
create table c_user_speciality (user_id INTEGER NOT NULL,spec_code VARCHAR(50) NOT NULL,created_by int NOT NULL,modified_by int NOT NULL,created_date date NOT NULL ,modified_date date NOT NULL,PRIMARY KEY (user_id,spec_code),CONSTRAINT fk_user_spec FOREIGN KEY (user_id) REFERENCES c_user (user_id),CONSTRAINT fk_spec FOREIGN KEY (spec_code) REFERENCES c_speciality (spec_code) );
	 
create table c_user_area (user_id INTEGER NOT NULL,area_code VARCHAR(50) NOT NULL,created_by int NOT NULL,modified_by int NOT NULL,created_date date NOT NULL ,modified_date date NOT NULL,PRIMARY KEY (user_id,area_code),CONSTRAINT fk_user_area FOREIGN KEY (user_id) REFERENCES c_user (user_id),CONSTRAINT fk_area FOREIGN KEY (area_code) REFERENCES c_area (area_code));
	 
insert into c_speciality(spec_code,spec_Desc, spec_comment, created_by, created_date, modified_by, modified_date) values('north_indian','North Indian', 'North Indian food', 1, now(), 1, now());

insert into c_speciality(spec_code,spec_Desc, spec_comment, created_by, created_date, modified_by, modified_date) values('south_indian','South Indian', 'South Indian food', 1, now(), 1, now());

insert into c_speciality(spec_code,spec_Desc, spec_comment, created_by, created_date, modified_by, modified_date) values('eastern_up','Eastern Up', 'Eastern UP Indian food', 1, now(), 1, now());

insert into c_speciality(spec_code,spec_Desc, spec_comment, created_by, created_date, modified_by, modified_date) values('punjabi','Punjabi Food', 'Punjabi Indian food', 1, now(), 1, now());

insert into c_area(area_code,area_Desc, area_comment, created_by, created_date, modified_by, modified_date) values('e_city_phase_2','Electronic City Phase 2', 'E City Phase 2', 1, now(), 1, now());

insert into c_area(area_code,area_Desc, area_comment, created_by, created_date, modified_by, modified_date) values('e_city_phase_1','Electronic City Phase 1', 'E City Phase 1', 1, now(), 1, now());

insert into c_area(area_code,area_Desc, area_comment, created_by, created_date, modified_by, modified_date) values('BTM','BTM', 'BTM Area', 1, now(), 1, now());

insert into c_area(area_code,area_Desc, area_comment, created_by, created_date, modified_by, modified_date) values('Kormangala','Kormangala', 'Kormangala', 1, now(), 1, now());

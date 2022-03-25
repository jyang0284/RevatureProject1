------------------------------------------------------------------------------------ Creating Project 1 tables ------------------------------------------------------------------------------------

create table reimbursements(
reimb_id serial primary key,
reimb_amount int not null,
reimb_description varchar (100),
reimb_receipt bytea,
reimb_author_fk int references users(users_id) not null,  							--This is a foriegn key
reimb_resolver_fk int references users (users_id),  								--This is a foriegn key
reimb_status_id_fk int default 1 references reimbursement_status (reimb_status_id), --This is a foriegn key
reimb_type_id_fk int references reimbursement_type(reimb_type_id) not null,  		--This is a foriegn key
reimb_submitted timestamp default now());

select * from reimbursements;

------------------------------------------------------------------------------------- Adding reimbursements into table -----------------------------------------------------------------------------
insert into reimbursements(reimb_amount, reimb_author_fk, reimb_type_id_fk)
values (400, 1, 3);

insert into reimbursements(reimb_amount, reimb_author_fk, reimb_type_id_fk)
values (25, 4, 2);
------------------------------------------------------------------------------------- Displaying reimbursements in a specific list according to users_id -------------------------------------------
select * from reimbursements where reimb_I_fk = 1;


select * from reimbursements where reimb_Id = 8;

update reimbursements set reimb_status_id_fk = ? where reimb_id = ? ;
------------------------------------------------------------------------------------ Creating Users tables -----------------------------------------------------------------------------------------

create table users(
users_id serial primary key,
users_username varchar (100) unique not null,
users_password varchar (100) not null,
users_firstname varchar (100) not null,
users_lastname varchar (100) not null,
users_email varchar (100) unique,
users_role_id_fk int references users_role(users_role_id), --This is a foriegn key
date_created timestamp default now());

select * from users;

------------------------------------------------------------------------------------ Creating a user -------------------------------------------------------------------------------------------------
insert into users (users_username, users_password, users_firstname, users_lastname)
values ('jyang', 'pass123', 'James', 'Yang');

insert into users (users_username, users_password, users_firstname, users_lastname)
values ('Dsakiente', 'pass123', 'Dani', 'Sali');

insert into users (users_username, users_password, users_firstname, users_lastname)
values ('Phengxw', 'pass123', 'Pheng', 'Yang');

insert into users (users_username, users_password, users_firstname, users_lastname)
values ('user2', 'pass123', 'User', 'Two');

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table users_role(
users_role_id serial primary key,
users_role varchar (100) not null );

select * from users_role;

create table reimbursement_status(
reimb_status_id serial primary key,
reimb_status varchar (100) not null);

select * from reimbursement_status;

create table reimbursement_type(
reimb_type_id serial primary key,
reimb_type varchar (100) not null);

select * from reimbursement_type;

------------------------------------------------------------------------------------ Validating credentials ----------------------------------------------------------------------------------------------------------------

select * from users where users_username = 'jyang';

--The code above should only return one user

------------------------------------------------------------------------------------ Get user given username ----------------------------
select * from reimbursements where reimb_author_fk = 1;

------------------------------------------------------------------------------- Initializing Database values -------------------------------------------------------------------------------

----------------- User role codes  --------------------------
insert into users_role values (default, 'Employee');
insert into users_role values (default, 'Manager');

----------------- reimbursement status ID codes  ----------------
insert into reimbursement_status values (default, 'Pending');

insert into reimbursement_status values (default, 'Approved');

insert into reimbursement_status values (default, 'Denied');

----------------- reimbursement type ID codes -------------------
insert into reimbursement_type values(default, 'Lodging');

insert into reimbursement_type values(default, 'Food');

insert into reimbursement_type values(default, 'Travel');



------------------------------------------------------ Below is an example of setting the forign key to a default value using keyword alter -----------------------------------------------------------------


alter table reimbursements alter column reimb_status_id_fk set default 1;



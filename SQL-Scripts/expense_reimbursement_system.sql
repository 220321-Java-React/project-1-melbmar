-- This Script is create to hold the user users/users roles/reimbursement type and
-- reimbursement status to Expense Reimbursement System (ERS)  from P1 project
-- Data Definition Language (DDL): create, alter, truncate, drop.


-- Create ERS_User_role table will hold revelant information to the users
CREATE TABLE ers_user_roles (
ers_user_role_id serial PRIMARY KEY,
user_role VARCHAR (10) -- varchar2, which is a non-SQL-standard type. In PostgreSQL, use type varchar or text instead.

);

-- Create ERS_User table will hold revelant information to the users
CREATE TABLE ers_users (
ers_users_id serial PRIMARY KEY,
ers_username VARCHAR (50) UNIQUE, 
ers_password VARCHAR (50),
ers_first_name VARCHAR (100),
ers_second_name VARCHAR (100),
ers_email VARCHAR (150) UNIQUE, -- UNIQUE maintains the uniqueness of the data correctly
                                -- ensures that all values in a column are different.
user_role_id_fk int REFERENCES ers_user_roles (ers_user_role_id)

);

-- Create ERS_Reimbuserment_status table will hold revelant information to the users
CREATE TABLE ers_reimbursement_status (
reimb_status_id serial PRIMARY KEY,
reimb_status VARCHAR (10)

);

-- Create ERS_Reimbursement_type table will hold revelant information to the users
CREATE TABLE ers_reimbursement_type(
reimb_type_id serial PRIMARY KEY,
reimb_type VARCHAR (10)

);


-- Create ERS_Reimbursement table will hold revelant information to the users
-- this table have the type many to many relationships or one to many depends of the soluction
-- Both relationships will occurs when multiple records 
-- in one table are related to multiple records in another table. 
CREATE TABLE ers_reimbursement (
reimb_id serial PRIMARY KEY,
reimb_aumount NUMBER,
reimb_submitted TIMESTAMP, -- The timestamp datatype allows you to store both date and time.
reimb_author NUMBER,
reimb_resolver NUMBER,
reimb_status_id NUMBER,
reimb_type_id NUMBER

);


-- Drop table ers_user_roles need delete information
DROP TABLE ers_user_roles;
DROP TABLE ers_users;

-- INSERT infor in table reimbursement type (the employee can choose their reimbursement)
INSERT INTO ers_reimbursement_type (reimb_type) 
VALUES ('Lodging (Hotel)'),
       ('Traver'),
       ('Food'),
       ('Clothes'),
       ('Others');
SELECT * FROM ers_reimbursement_type;






       
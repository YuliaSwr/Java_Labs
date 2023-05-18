CREATE DATABASE IF NOT EXISTS student_data;
DROP TABLE IF EXISTS student;

CREATE TABLE student (
id int AUTO_INCREMENT NOT NULL,
first_name varchar(60) NOT NULL,
last_name varchar(60) NOT NULL,
middle_name varchar(60) NOT NULL,
birth_date date NOT NULL,
gradebook_number varchar(12) UNIQUE NOT NULL,
PRIMARY KEY(id));

INSERT INTO student VALUES (null, 'Yulia', 'Sida', 'Anatoliyivna', '2003-01-07', 'YS0123456789');
INSERT INTO student VALUES (null, 'Olena', 'Smerenko', 'Volodymyrivna', '2002-12-09', 'OS0123456789');
INSERT INTO student VALUES (null, 'Maxim', 'Topolya', 'Andriyovich', '2003-10-16', 'MT0123456789');
INSERT INTO student VALUES (null, 'Maria', 'Lenko', 'Olegivna', '2003-08-12', 'ML0123456789');
INSERT INTO student VALUES (null, 'Vasyl', 'Panko', 'Andriyovich', '2003-08-25', 'VP0123456789');

INSERT INTO student VALUES (null, 'Andriy', 'Shevchenko', 'Fedorovych', '2002-11-25', 'AS0123456789');
INSERT INTO student VALUES (null, 'Anna', 'Dinenko', 'Vitaliyivna', '2003-02-02', 'AD0123456789');
INSERT INTO student VALUES (null, 'Oleksiy', 'Kovalyov', 'Vitaliyovich', '2002-12-19', 'OK0123456789');
INSERT INTO student VALUES (null, 'Mykyta', 'Ranenko', 'Volodymyrovich', '2003-03-08', 'MR0123456789');
INSERT INTO student VALUES (null, 'Diana', 'Semenko', 'Vasylivna', '2003-05-18', 'DS0123456789');

INSERT INTO student VALUES (null, 'Denys', 'Vasko', 'Denysovich', '2003-08-09', 'DV0123456789');
INSERT INTO student VALUES (null, 'Anastasiya', 'Horenko', 'Volodymyrivna', '2003-07-19', 'AH0123456789');
INSERT INTO student VALUES (null, 'Sofia', 'Skorko', 'Andriyivna', '2002-11-16', 'SS0123456789');
INSERT INTO student VALUES (null, 'Artem', 'Tynenko', 'Olegovich', '2003-07-12', 'AT0123456789');
INSERT INTO student VALUES (null, 'Oleksandr', 'Dumko', 'Andriyovich', '2003-08-25', 'OD0123456789');

INSERT INTO student VALUES (null, 'Vlad', 'Vunenko', 'Fedorovych', '2003-05-10', 'VV0123456789');
INSERT INTO student VALUES (null, 'Olga', 'Latun', 'Vitaliyivna', '2003-02-02', 'OL0123456789');
INSERT INTO student VALUES (null, 'Valentyn', 'Konenko', 'Vitaliyovich', '2002-01-23', 'VK0123456789');
INSERT INTO student VALUES (null, 'Vadym', 'Masko', 'Volodymyrovich', '2003-02-08', 'VM0123456789');
INSERT INTO student VALUES (null, 'Eva', 'Yakovenko', 'Oleksandrivna', '2003-09-11', 'EY0123456789');

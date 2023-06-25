use Airline;
create table customer(cname varchar(20),eduation varchar(20),classtype varchar(10),pass varchar(20),takeoff varchar(20),landing varchar(20),id varchar(20));
create table CustomerPassport(countryname varchar(12),age int,FIR boolean,visaType varchar(14),religion varchar(12),id varchar(20) unique key,fname varchar(20),mname varchar(20),dob date);
create database Naiki;
use Naiki;

create table Donor (
	username varchar(30) primary key,
    pass varchar(30) NOT NULL,
    firstName varchar(30),
    lastName varchar(30),
    phoneNo varchar(30),
    totalSuccessfulRequests int default 0,
    totalCashDonated int default 0,
    address varchar(70),
    currentRide int
);

create table Rider (
	username varchar(30) primary key,
    pass varchar(30) NOT NULL,
    firstName varchar(30),
    lastName varchar(30),
    phoneNo varchar(30),
    totalSuccessfulRides int default 0,
    currentRide int
);

create table NaikiAdmin
(
	username varchar(30) primary key,
    pass varchar(30) NOT NULL,
    firstName varchar(30),
    lastName varchar(30)
);


create Table Ride(
	rideID int primary key,
    pickUp varchar(70),
    dropOff varchar(70),
    dateofRide date,
    rider varchar(30),
    donor varchar(30),
    statusOfRide varchar(30) check(
		statusOfRide = 'inProcess' OR 
        statusOfRide = 'pending' OR 
        statusOfRide = 'delivered' OR
        statusOfRide = 'cancelled' OR
        statusOfRide = 'rejected')
);

Insert into naikiadmin values ('zarmeenkaz', '112233', 'Zarmeen', 'Kazmi');

ALTER TABLE Donor ADD CONSTRAINT DonorRide_FK FOREIGN KEY (currentRide) REFERENCES Ride(RideID);
ALTER TABLE Rider ADD CONSTRAINT RiderRide_FK FOREIGN KEY (currentRide) REFERENCES Ride(RideID);
ALTER TABLE Ride ADD CONSTRAINT FK_RIDER_RIDE FOREIGN KEY (rider) REFERENCES Rider(username);
ALTER TABLE Ride ADD CONSTRAINT FK_DONOR_RIDE FOREIGN KEY (donor) REFERENCES Donor(username);

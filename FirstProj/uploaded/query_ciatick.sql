create database ciatickk;
create table PoliciesProceduresFiles(
ID int ,
FileName varchar(250),
FileURL varchar(250),
Date DATETIME,
DateStamp DATETIME,
primary key(ID)
);
alter table PoliciesProceduresFiles drop column FileURL;
alter table PoliciesProceduresFiles modify  ID binary(16);
drop table PoliciesProceduresNotes;
ALTER TABLE CorrectiveAction MODIFY ID varchar(100);


create table PoliciesProceduresNotes(
ID varchar(100),
Notes varchar(4000),
Date DATETIME,
Datestamp DATETIME,
primary key(ID)
);
----
create table ProgramAssignedTo (
ID varchar(100),
FirstName varchar(250) not null,
LastName varchar(250) not null,
Date DATETIME,
DateStamp datetime,
primary key(ID)
);
----
create table ProgramInitiations(
ID varchar(100),
ProgramAssignedToId varchar(100),
FrameWork varchar(250),
Status varchar(250),
Date DATETIME,
CriteriaOfTheAudit varchar(4000),
ScopeOfTheAudit varchar(4000),
DateStamp datetime,
primary key(ID),
foreign key(ProgramAssignedToId) references ProgramAssignedTo(ID)
);
drop table ProgramAssignedTo
----
create table ProgramInitiationFiles(
ID varchar(100),
FileName varchar(250) not null,
FileURL varchar(250) not null,
Date DATETIME,
Datestamp datetime,
primary key(ID) 
);

create table ProgramInititionNotes(
ID varchar(100),
FileName varchar(250) not null,
FileURL varchar(250) not null,
Date DATETIME,
primary key(ID)
);


-- create table MandatoryClausesPerform(
-- ID int not null AUTO_INCREMENT,
-- Requirement varchar(250),	
-- Clauses FLOAT,
-- TestingSteps nvarchar(4000),
-- Complaint BOOLEAN,
-- Evidence varchar(250),
-- Reference INT

-- )

create table MandatoryClausesFiles(
ID varchar(100),
FileName varchar(250),
FileURL varchar(250),
Date DATETIME,
Datestamp datetime,
primary key(ID)
);

create table MandatoryClausesNotes(
ID varchar(100),
FileName varchar(250),
FileURL varchar(250),
Date datetime,
Datestamp datetime,
primary key(ID)
);

create table SecurityControlsFiles(
ID varchar(100),
FileName varchar(250),
FileURL varchar(250) ,
Date datetime,
Datestamp datetime,
primary key(ID)
);

create table SecurityControlsNotes(
ID varchar(100),
FileName varchar(250),
FileURL varchar(250),
Date DateTime, 
Datestamp datetime,
primary key(ID)
);



create table AuditeeComplaintsAssignedTo(
ID varchar(100),
FirstName varchar(250),
LastName varchar(250),
Date DATETIME,
DateStamp datetime,
primary key(ID)
);

create table AuditeeComplaintsFiles(
ID varchar(100),
FileName varchar(250) not null,
FileURL varchar(250) not null,
Date DATETIME, 
Datestamp datetime,
primary key(ID)
);

create table AuditeeComplaintsNotes(
ID varchar(100),
FileName varchar(250),
FileURL varchar(250),
Date DATETIME,
Datestamp datetime,
primary key(ID)
);


create table AuditeeComplaints(
ID varchar(100),
AssignedtToID varchar(100),
Status varchar(250),
PersonReported varchar(250),
ComplaintDescription varchar(4000) ,
ActionFortreating varchar(4000) ,
Attachments varchar(250),
Date DATETIME, 
DateStamp datetime,
primary key(ID),
foreign key(AssignedtToID) references  AuditeeComplaintsAssignedTo(ID)
);

create table Nonconformities(
ID varchar(100),
Domain varchar(250),
ClauseNumber int,
Reference Float,
AuditCriteria varchar(4000),
Findings varchar(4000),
AcknowledgmentAuditee varchar(250),
IdentifyingDate DATETIME,
DateStamp datetime,
NonconformityClassification varchar(250),
primary key(ID)
);


create table NonconformitiesAttachments(
ID varchar(100),
NonconformitiesID varchar(100),
FileName varchar(250), 
FileURL varchar(250),
Date DATETIME,
Datestamp datetime,
primary key(ID),
foreign key(NonconformitiesID) references Nonconformities(ID)
);

create table NonconformitiesFiles(
ID varchar(100),
FileName varchar(250),
FileURL varchar(250),
Date DATETIME,
Datestamp datetime,
primary key(ID)
);


create table NonconformitiesNotes(
ID varchar(100),
FileName varchar(250) ,
FileURL varchar(250) ,
Date DATETIME,
Datestamp datetime,
primary key(ID)
);

create table CorrectiveReviewer (
ID varchar(100),
FirstName varchar(250),
LastName varchar(250),
Date DATETIME,
DateStamp datetime,
primary key(ID)
);

create table CorrectiveAssignedTo(
ID varchar(100),
FirstName varchar(250),
LastName varchar(250),
Date DATETIME, 
DateStamp datetime,
primary key(ID)
);
 create table CorrectiveActionFiles(
ID varchar(100),
FileName varchar(250),
FileURL varchar(250),
Date DATETIME,
Datestamp datetime,
primary key(ID)
 );
 
 create table CorrectiveActionNotes(
ID varchar(100),
FileName varchar(250),
FileURL varchar(250),
Date DATETIME,
Datestamp datetime,
primary key(ID)
 );
 
create table CorrectiveAction(
ID varchar(100),
AssignedToId varchar(100),
ReviewerId varchar(100),
Status varchar(250),
AssignedOnDate DATETIME,
RelatedNonconformities varchar(250),
CorrectiveAction varchar(250),
InformedImplementedAction varchar(250),
RelatedCustomerComplaints varchar(250),
ImplementationDeadlineDate DATETIME,
ReviewedOnDate DATETIME,
Datestamp datetime,
primary key(ID),
foreign key(AssignedToId) references CorrectiveAssignedTo(ID),
foreign key(ReviewerId) references CorrectiveReviewer(ID)
);

create table CorrectiveActionAttachments(
ID varchar(100),
CorrectiveActionID varchar(100),
FileName varchar(250) ,
FileURL varchar(250) ,
Date DATETIME,
Datestamp datetime,
primary key(ID),
foreign key(CorrectiveActionID) references CorrectiveAction(ID)
);

create table  MandatoryClausesPerform(
ID varchar(100),
Requirement varchar(250),	
Clauses FLOAT,
TestingSteps varchar(4000),
Complaint BOOLEAN,
Evidence varchar(250),
Reference int, 
primary key(ID)
);

insert into PoliciesProceduresFiles values('A.1','','','2038-01-19 03:14:07.999999','2038-01-19 03:14:07.999999');
insert into PoliciesProceduresFiles(ID, FileName, FileURL, Date, DateStamp) values (1, 'myfile','C:\Users\user.WSL125\Desktop\reeem','2020-2-1' , '2020-1-2');
insert into PoliciesProceduresFiles(ID, FileName, FileURL, Date, DateStamp) values (2, 'myfile2','C:\\Users\\user.WSL125\\Desktop\\reeem','2020-2-1' , '2020-1-2');

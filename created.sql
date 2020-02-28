use cs5200_ke_sun_hw3_store_procedures;
create table module(
	module varchar(64),
    primary key(module)
);

create table user(
	id int,
    approvedUser boolean,
    userAgreement boolean,
    fristName varchar(45),
    lastName varchar(45),
    primary key(id)
);

create table answer(
	id int,
    text varchar(1024),
    postedBy int,
    postedOn Date,
    correctAnswer boolean,
    upVote int,
    downVote int,
    qustion int,
    primary key(id),
    FOREIGN KEY (qustion) REFERENCES qustion(id),
    FOREIGN KEY (postedBy) REFERENCES user(id)
);

create table question(
	id int,
    askedBy int,
    text varchar(1024),
    postedOn date,
    length int,
    views int,
    endorsedByInstructor boolean,
    module varchar(64),
    primary key(id),
    FOREIGN KEY (askedBy) REFERENCES user(id),
    FOREIGN KEY (module) REFERENCES module(module)
);
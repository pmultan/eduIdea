
    create table Category (
        id integer not null auto_increment,
        name varchar(255),
        parentCategory_id integer,
        primary key (id)
    );

    create table Idea (
        id integer not null auto_increment,
        complexityLvl integer,
        dateCreated datetime,
        expectedVotes integer,
        text TEXT,
        title varchar(255),
        author_id bigint,
        category_id integer,
        primary key (id)
    );

    create table News (
        Id integer not null auto_increment,
        Text TEXT,
        Title varchar(255),
        UserCreated bigint,
        dateCreated datetime,
        primary key (Id)
    );

    create table Role (
        id bigint not null auto_increment,
        role_id integer,
        user_id bigint,
        primary key (id)
    );

    create table User (
        id bigint not null auto_increment,
        activationKey varchar(255),
        email varchar(255),
        firstName varchar(255),
        isActivated bit,
        lastName varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
    );

    alter table User 
        add constraint UK_e6gkqunxajvyxl5uctpl2vl2p  unique (email);

    alter table User 
        add constraint UK_jreodf78a7pl5qidfh43axdfb  unique (username);

    alter table Category 
        add constraint FK_3v34vcvwua46xp9jd0bj7rk78 
        foreign key (parentCategory_id) 
        references Category (id);

    alter table Idea 
        add constraint FK_7f7fm8e327n08ep3pdf9f0l7d 
        foreign key (author_id) 
        references User (id);

    alter table Idea 
        add constraint FK_amwov7lpdehilqw0a2jq3d30n 
        foreign key (category_id) 
        references Category (id);

    alter table Role 
        add constraint FK_1wtyy2cjpkrg90j7af2wxqw2 
        foreign key (user_id) 
        references User (id);

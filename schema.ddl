
    create table News (
        Id integer not null auto_increment,
        DateCreated date,
        Text TEXT,
        Title varchar(255),
        UserCreated bigint,
        primary key (Id)
    );

    create table Role (
        id bigint not null,
        role_id integer,
        user_id bigint,
        primary key (id)
    );

    create table User (
        id bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
    );

    alter table User 
        add constraint UK_jreodf78a7pl5qidfh43axdfb  unique (username);

    alter table Role 
        add constraint FK_1wtyy2cjpkrg90j7af2wxqw2 
        foreign key (user_id) 
        references User (id);

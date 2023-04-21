create schema QuizGame;

create table multiQuiz
(
    id_multiQuiz int auto_increment,
    question     varchar(2500) not null,
    answerA      varchar(1000) not null,
    answerB      varchar(1000) not null,
    answerC      varchar(1000) not null,
    answerD      varchar(1000) not null,
    solution     int           null,
    constraint multiQuiz_pk
        primary key (id_multiQuiz)
);

create table binaryQuiz
(
    id_multiQuiz int auto_increment,
    question     varchar(2500) not null,
    solution     int           not null,
    constraint binaryQuiz_pk
        primary key (id_multiQuiz)
);

create table highScore
(
    id_highScore int auto_increment,
    user         varchar(100) not null,
    score        int          not null,
    topic        varchar(100) not null,
    constraint highScore_pk
        primary key (id_highScore)
);


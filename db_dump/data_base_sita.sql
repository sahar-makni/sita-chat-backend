create sequence if not exists hibernate_sequence start with 2032 increment by 1;

create table if not exists room
(
    id   bigint       not null
        primary key,
    name varchar(255) null
);

create table if not exists user
(
    id             bigint       not null
        primary key,
    email          varchar(255) null,
    language       varchar(255) null,
    messages_count int          null,
    password       varchar(255) null,
    rooms_count    int          null,
    theme          varchar(255) null
);

create table if not exists message
(
    id        bigint       not null
        primary key,
    send_date datetime(6)  null,
    text      varchar(255) null,
    room_id   bigint       not null,
    sender_id bigint       not null,
    constraint FKcnj2qaf5yc36v2f90jw2ipl9b
        foreign key (sender_id) references user (id),
    constraint FKl1kg5a2471cv6pkew0gdgjrmo
        foreign key (room_id) references room (id)
);

create table if not exists room_users
(
    room_id bigint not null,
    user_id bigint not null,
    constraint FK6joy9hqfc79xqekja7ncepnvj
        foreign key (room_id) references room (id),
    constraint FKs4gtrm8ddoc2lekumsnnmsqfq
        foreign key (user_id) references user (id)
);

insert into hibernate_sequence (next_not_cached_value, minimum_value, maximum_value, start_value, increment, cache_size, cycle_option, cycle_count)
values  (3001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);


insert into room (id, name)
values  (1, 'room 1'),
        (2, 'room 2'),
        (3, 'room 3');

insert into user (id, email, language, messages_count, password, rooms_count, theme)
values  (1008, 'sahar@gmail.com', 'EN', 10, '$2a$10$Q9Wi8XFYld3Q.gISWuUGPuyY/7/nIruUxFW3zThlWJjYjD6ubynZ.', 2, 'ARYA_BLUE'),
        (2001, 'jules@gmail.com', 'EN', 0, '$2a$10$Hy2e6lLG3fHThPozRckL2.TMrYrG/tbXZnn0XO4S1piReMMyyfElG', 0, 'ARYA_BLUE'),
        (2002, 'marie@gmail.com', 'EN', 0, '$2a$10$SNd9SRP7bcs2ahv/eHZuo.ojZu6CokfIujz08ZWjpOLJh4xqZ9vTa', 0, 'ARYA_BLUE'),
        (2003, 'pierre@gmail.com', 'EN', 0, '$2a$10$jwExim7nIoZvgaDqh./7JeJ4XMSprFzKy2qd78xYkT3GyWcbf5yhG', 0, 'ARYA_BLUE');


insert into room_users (room_id, user_id)
values  (1, 1008),
        (1, 2001),
        (2, 1008),
        (2, 2002),
        (3, 2001),
        (3, 2003);

insert into message (id, send_date, text, room_id, sender_id)
values  (2020, '2022-12-10 13:30:53.482000', 'Bonjour !! ', 2, 2002),
        (2021, '2022-12-10 13:31:15.946000', 'Hey 😍', 2, 1008),
        (2022, '2022-12-10 13:31:45.578000', 'It has been a while. How have you been ? ', 2, 2002),
        (2023, '2022-12-10 13:32:16.795000', 'I''ve been busy making a chat plateform. How is it going with you ? ', 2, 1008),
        (2024, '2022-12-10 13:32:56.617000', 'Ah !! Cool  😎 ', 2, 2002),
        (2025, '2022-12-10 13:33:25.694000', 'I''ve been learning to cook lately. Wanna come this weekend for a little fun ? ', 2, 2002),
        (2026, '2022-12-10 13:33:48.172000', 'Would love to 😍', 2, 1008),
        (2027, '2022-12-10 13:34:12.173000', 'Will call you to arrage this ❤️👌', 2, 1008),
        (2028, '2022-12-10 13:34:21.000000', 'later', 2, 2002),
        (2029, '2022-12-10 13:34:22.869000', 'later', 2, 1008),
        (2030, '2022-12-10 13:37:08.349000', 'coucou !! ', 1, 1008),
        (2031, '2022-12-10 13:37:11.547000', 'Comment vas tu ? ', 1, 1008);
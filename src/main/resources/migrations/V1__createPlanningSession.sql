create table planning_session(
    id UUID primary key,
    title varchar(200) not null,
    deck_type varchar(200) not null,
    createdDate timeStamp default now(),
    updatedDate timeStamp default now()
)

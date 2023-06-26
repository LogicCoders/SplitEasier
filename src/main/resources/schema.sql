create table if not exists expense
(
     id uuid default random_uuid() primary key,
     description varchar(255),
     exp_Date varchar(255),
     cost varchar(255),
     doc_ID varchar(255)

);

create table document(
    id uuid default random_uuid() primary key,
    name varchar(255),
    path varchar(255),
    curr_Dt varchar(255)
);


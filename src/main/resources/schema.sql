create table if not exists expense
(
     id uuid default random_uuid() primary key,
     expense_name varchar(255),
     expense_date date,
     vendor_id varchar(255),
     amount double,
     expense_type varchar(255)

);

create table if not exists vendor
(
     id uuid default random_uuid() primary key,
     vendor_name varchar(255)
);

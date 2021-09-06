drop table if exists world_record
create table world_record (id bigint not null auto_increment, date date, description varchar(255), measure double precision, recorder bigint, unit varchar(255), primary key (id))

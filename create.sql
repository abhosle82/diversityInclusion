create table company_diversity_info (id bigint not null, city varchar(255), county varchar(255), duns_name varchar(255), duns_number varchar(255), phone varchar(255), state varchar(255), street_address varchar(255), zip_code varchar(255), primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table tbl_div_leader (id integer not null auto_increment, ethnicity varchar(255), gender varchar(255), disabled varchar(255), lgbt varchar(255), veteran varchar(255), name varchar(255), share_percent bigint, company_id bigint, primary key (id)) engine=InnoDB;
alter table tbl_div_leader add constraint FKitun66wsnw0nwuihlx7o3fdu8 foreign key (company_id) references company_diversity_info (id);

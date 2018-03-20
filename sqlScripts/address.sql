create table address_details
(
address_id bigint not null   AUTO_INCREMENT,
add_customer_profile_fk bigint not null,
address_type varchar(30),
country varchar(255) ,
state varchar(255),
city varchar(255),
streat varchar(255),
landmark varchar(255),
area nvarchar(100) ,
pincode varchar(100),
created_on datetime not null,
Last_Modified_on datetime not null,

CONSTRAINT pk_address_id PRIMARY KEY (address_id),

CONSTRAINT add_customer_profile_id_reff foreign key 
fk_custProfId(add_customer_profile_fk)
references customer_profile(customer_id)
ON UPDATE CASCADE
ON DELETE CASCADE
);

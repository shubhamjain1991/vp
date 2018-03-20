create table customer_profile
(
customer_id bigint not null   AUTO_INCREMENT,
customer_type varchar(30),
customer_email varchar(255) unique key,
customer_mobile double unique key,
customer_first_name varchar(255),
customer_last_name varchar(255),
customer_user_name varchar(255),
customer_password nvarchar(255),
customer_unique_id nvarchar(100) unique key,
customer_unique_id_type varchar(100),
isUid_validate ENUM('Yes','No') DEFAULT 'No',
isMobile_validate ENUM('Yes','No') DEFAULT 'No' ,
isEmail_validate ENUM('Yes','No') DEFAULT 'No',
isActive ENUM('Yes','No'),
Gender ENUM('Male','Female'),
created_on datetime not null,
Last_Modified_on datetime not null,

CONSTRAINT pk_customer_id PRIMARY KEY (customer_id),
CONSTRAINT ck_CustMob_CustEmail unique KEY (customer_email , customer_mobile )
);
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


ALTER TABLE `vp`.`customer_profile`   
  CHANGE `customer_mobile` `customer_mobile` VARCHAR(13) NULL,
  CHANGE `isUid_validate` `is_uid_validate` ENUM('Yes','No') CHARSET utf8 COLLATE utf8_general_ci DEFAULT 'No'  NULL,
  CHANGE `isMobile_validate` `is_mobile_validate` ENUM('Yes','No') CHARSET utf8 COLLATE utf8_general_ci DEFAULT 'No'  NULL,
  CHANGE `isEmail_validate` `is_email_validate` ENUM('Yes','No') CHARSET utf8 COLLATE utf8_general_ci DEFAULT 'No'  NULL,
  CHANGE `isActive` `is_active` ENUM('Yes','No') CHARSET utf8 COLLATE utf8_general_ci DEFAULT 'Yes'  NULL,
  CHANGE `Gender` `gender` ENUM('Male','Female') CHARSET utf8 COLLATE utf8_general_ci NULL,
  CHANGE `created_on` `created_on` TIMESTAMP NOT NULL,
  CHANGE `Last_Modified_on` `last_modified_on` TIMESTAMP NOT NULL, 
  DROP INDEX `ck_CustMob_CustEmail`;

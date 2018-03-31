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


  CREATE TABLE address_details
(
address_id BIGINT NOT NULL   AUTO_INCREMENT,
addr_customer_profile_fk BIGINT NOT NULL,
addr_type VARCHAR(30),
addr_country VARCHAR(255) ,
addr_state VARCHAR(255),
addr_city VARCHAR(255),
addr_streat VARCHAR(255),
addr_landmark VARCHAR(255),
addr_area NVARCHAR(100) ,
addr_pincode VARCHAR(100),
addr_created DATETIME NOT NULL,
addr_updated DATETIME NOT NULL,
CONSTRAINT pk_address_id PRIMARY KEY (address_id)
);

ALTER TABLE `vp`.`address_details`   
  CHANGE `addr_customer_profile_fk` `addr_customer_id` BIGINT(20) NOT NULL,
  CHANGE `addr_streat` `addr_streat` VARCHAR(255) CHARSET utf8 COLLATE utf8_general_ci NULL  AFTER `addr_type`,
  CHANGE `addr_landmark` `addr_landmark` VARCHAR(255) CHARSET utf8 COLLATE utf8_general_ci NULL  AFTER `addr_streat`,
  CHANGE `addr_city` `addr_city` VARCHAR(255) CHARSET utf8 COLLATE utf8_general_ci NULL  AFTER `addr_landmark`,
  CHANGE `addr_area` `addr_area` VARCHAR(100) CHARSET utf8 COLLATE utf8_general_ci NULL  AFTER `addr_city`,
  CHANGE `addr_pincode` `addr_pincode` VARCHAR(100) CHARSET utf8 COLLATE utf8_general_ci NULL  AFTER `addr_area`,
  CHANGE `addr_state` `addr_state` VARCHAR(255) CHARSET utf8 COLLATE utf8_general_ci NULL  AFTER `addr_pincode`,
  CHANGE `addr_created` `addr_created` TIMESTAMP NOT NULL,
  CHANGE `addr_updated` `addr_updated` TIMESTAMP NOT NULL,
  ADD CONSTRAINT `FK_ADDR_CUSTOMER_ID` FOREIGN KEY (`addr_customer_id`) REFERENCES `vp`.`customer_profile`(`customer_id`) ON UPDATE CASCADE ON DELETE CASCADE;  
  
CREATE TABLE `service_providers` (
  `sp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sp_customer_id` bigint(20) NOT NULL,
  `sp_addr_id` bigint(20) NOT NULL,
  `sp_profession` varchar(100) NOT NULL,
  `sp_sub_Profession` varchar(100) NOT NULL,
  `sp_highest_qualifiaction` varchar(512) DEFAULT NULL,
  `sp_collage_Name` varchar(512) DEFAULT NULL,
  `sp_year_of_pass_out` int(11) DEFAULT NULL,
  `sp_total_year_of_experience` int(11) DEFAULT NULL,
  `sp_profile_head_line` varchar(500) DEFAULT NULL,
  `sp_about_your_self` varchar(1000) DEFAULT NULL,
  `sp_certificate_serial_number` varchar(500) DEFAULT NULL,
  `sp_is_certificate_validate` enum('Yes','No') DEFAULT 'No',
  `sp_certificate_scan_url` varchar(1000) DEFAULT NULL,
  `sp_proflie_pic_url` varchar(1000) DEFAULT NULL,
  `sp_created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sp_updated_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`sp_id`)
);


ALTER TABLE `vp`.`service_providers`   
  CHANGE `sp_sub_Profession` `sp_sub_profession` VARCHAR(100) CHARSET utf8 COLLATE utf8_general_ci NOT NULL,
  CHANGE `sp_collage_Name` `sp_collage_name` VARCHAR(512) CHARSET utf8 COLLATE utf8_general_ci NULL,
  CHANGE `sp_updated_date` `sp_updated_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL,
  ADD CONSTRAINT `FK_SP_CUSTOMER_ID` FOREIGN KEY (`sp_customer_id`) REFERENCES `vp`.`customer_profile`(`customer_id`) ON UPDATE CASCADE ON DELETE CASCADE,
  ADD CONSTRAINT `FK_SP_ADDR_ID` FOREIGN KEY (`sp_addr_id`) REFERENCES `vp`.`address_details`(`address_id`) ON UPDATE CASCADE ON DELETE CASCADE;
  
  
  CREATE TABLE application_form (
  af_id BIGINT NOT NULL AUTO_INCREMENT,
  af_customer_id BIGINT NOT NULL,
  af_sp_id BIGINT NOT NULL,
  af_requester_name VARCHAR (250) NOT NULL,
  af_cause_of_meeting VARCHAR (1000) NOT NULL,
  af_special_notes VARCHAR (1000),
  af_time_duration_estimate INT,
  af_req_meeting_datetime BIGINT,
  af_created_date TIMESTAMP,
  af_last_modified_date TIMESTAMP,
  CONSTRAINT pk_application_Id PRIMARY KEY (af_id),
  CONSTRAINT afk_Cusomer_id FOREIGN KEY (af_customer_id) REFERENCES customer_profile (customer_id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_Service_Provider_id FOREIGN KEY (af_sp_id) REFERENCES service_providers (sp_id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT af_meeting_datetime UNIQUE KEY (
    af_req_meeting_datetime,
    af_customer_id
  )
);

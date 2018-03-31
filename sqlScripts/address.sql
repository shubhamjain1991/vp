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


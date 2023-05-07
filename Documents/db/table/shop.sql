-- happyanddaily.shop definition

CREATE TABLE `shop` (
                        `shop_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                        `shop_name` varchar(100) DEFAULT NULL,
                        `shop_tel` varchar(100) DEFAULT NULL,
                        `shop_address` varchar(100) DEFAULT NULL,
                        `shop_category` varchar(100) DEFAULT NULL,
                        `shop_thumb_path` varchar(200) DEFAULT NULL,
                        `shop_business_number` varchar(100) DEFAULT NULL,
                        PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
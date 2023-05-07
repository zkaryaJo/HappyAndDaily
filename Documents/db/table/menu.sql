-- happyanddaily.menu definition

CREATE TABLE `menu` (
                        `menu_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                        `category_main` varchar(100) DEFAULT NULL,
                        `category_sub` varchar(100) DEFAULT NULL,
                        `menu_name` varchar(100) DEFAULT NULL,
                        `menu_price` decimal(10,0) DEFAULT NULL,
                        `menu_description` text DEFAULT NULL,
                        PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
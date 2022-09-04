CREATE TABLE `member_basic` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(30) not null,
  `nickname` varchar(15) not null,
  `gender` char(1) not null,
  `birth` char(8),
  `access_time` char(4),
  `about_me` varchar(100),
  `discord_url` varchar(255),
  `phone_number` char(11),
  `last_login` datetime
);

CREATE TABLE `member_auth` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int not null,
  `auth_id` varchar(20) not null,
  `auth_value` varchar(255) not null,
  `auth_role` varchar(10),
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `game_character` (
  `id` int PRIMARY KEY,
  `game` varchar(10) not null,
  `character_name` varchar(30) not null,
  `character_image_path` varchar(255)
);

CREATE TABLE `mate_wish` (
  `id` int PRIMARY KEY,
  `user_id` int not null,
  `gender` char(1),
  `age_group` char(4),
  `access_time` char(4),
  `game_type` varchar(255)
);

CREATE TABLE `matching_info` (
  `id` int PRIMARY KEY,
  `requester` int not null,
  `requestee` int not null,
  `stat` char(4) not null,
  `message` char,
  `created_at` datetime,
  `updated_at` datetime
);

ALTER TABLE `member_auth` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);

ALTER TABLE `mate_wish` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);

ALTER TABLE `matching_info` ADD FOREIGN KEY (`requester`) REFERENCES `member_basic` (`id`);

ALTER TABLE `matching_info` ADD FOREIGN KEY (`requestee`) REFERENCES `member_basic` (`id`);


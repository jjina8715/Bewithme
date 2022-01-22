CREATE TABLE `member_basic` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(30),
  `nickname` varchar(15),
  `gender` char(1),
  `birth` char(8),
  `access_time` char(4),
  `about_me` varchar(100),
  `discord_url` varchar(255),
  `phone_number` char(11),
  `last_login` datetime
);

CREATE TABLE `member_auth` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int,
  `auth_id` varchar(20),
  `auth_value` varchar(255),
  `auth_role` varchar(10),
  `created_at` datetime,
  `updated_at` datetime
);

CREATE TABLE `game` (
  `game_code` int PRIMARY KEY,
  `game_name` varchar(255),
  `game_image_path` varchar(255)
);

CREATE TABLE `character` (
  `id` int PRIMARY KEY,
  `game_code` int,
  `character_name` varchar(30),
  `character_image_path` varchar(255)
);

CREATE TABLE `wish` (
  `id` int PRIMARY KEY,
  `user_id` int,
  `gender` char(1),
  `age_group` char(4),
  `access_time` char(4),
  `game_type` varchar(255)
);

CREATE TABLE `user_game_info_lol` (
  `user_id` int,
  `summoner_id` varchar(30) UNIQUE,
  `role` char(4),
  `position` char(4),
  `level` int,
  `character_id` int,
  `tier` char(4),
  `game_type` char(4)
);

CREATE TABLE `user_game_info_bag` (
  `user_id` int,
  `nickname` char UNIQUE,
  `tier` char(4),
  `rp` int,
  `server` char(4),
  `game_type` char(4)
);

CREATE TABLE `matchginInfo` (
  `id` int PRIMARY KEY,
  `requester` int,
  `requestee` int,
  `stat` char(4),
  `message` char,
  `created_at` datetime,
  `updated_at` datetime
);

ALTER TABLE `member_auth` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);

ALTER TABLE `character` ADD FOREIGN KEY (`game_code`) REFERENCES `game` (`game_code`);

ALTER TABLE `wish` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);

ALTER TABLE `user_game_info_lol` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);

ALTER TABLE `user_game_info_lol` ADD FOREIGN KEY (`character_id`) REFERENCES `character` (`id`);

ALTER TABLE `user_game_info_bag` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);

ALTER TABLE `matchginInfo` ADD FOREIGN KEY (`requester`) REFERENCES `member_basic` (`id`);

ALTER TABLE `matchginInfo` ADD FOREIGN KEY (`requestee`) REFERENCES `member_basic` (`id`);

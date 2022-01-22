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

CREATE TABLE `game` (
  `id` int PRIMARY KEY,
  `game_name` varchar(255) not null,
  `game_image_path` varchar(255)
);

CREATE TABLE `game_character` (
  `id` int PRIMARY KEY,
  `game_id` int not null,
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

CREATE TABLE `user_game_info_lol` (
  `user_id` int not null,
  `summoner_id` varchar(30) UNIQUE not null,
  `role` char(4),
  `position` char(4),
  `level` int,
  `character_id` int,
  `tier` char(4),
  `game_type` char(4)
);

CREATE TABLE `user_game_info_bag` (
  `user_id` int not null,
  `nickname` char UNIQUE not null,
  `tier` char(4),
  `rp` int,
  `server` char(4),
  `game_type` char(4)
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

ALTER TABLE `game_character` ADD FOREIGN KEY (`game_id`) REFERENCES `game` (`id`);

ALTER TABLE `mate_wish` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);

ALTER TABLE `user_game_info_lol` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);

ALTER TABLE `user_game_info_lol` ADD FOREIGN KEY (`character_id`) REFERENCES `game_character` (`id`);

ALTER TABLE `user_game_info_bag` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);

ALTER TABLE `matching_info` ADD FOREIGN KEY (`requester`) REFERENCES `member_basic` (`id`);

ALTER TABLE `matching_info` ADD FOREIGN KEY (`requestee`) REFERENCES `member_basic` (`id`);

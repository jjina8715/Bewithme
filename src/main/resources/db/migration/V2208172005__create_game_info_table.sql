CREATE TABLE `game_info` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `user_id` int not null,
  `game` varchar(10) not null,
  `comment` varchar(255) not null
);
ALTER TABLE `game_info` ADD FOREIGN KEY (`user_id`) REFERENCES `member_basic` (`id`);
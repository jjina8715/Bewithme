ALTER TABLE `matching_info` MODIFY COLUMN `id` INT NOT NULL AUTO_INCREMENT;
ALTER TABLE `mate_wish` MODIFY COLUMN `id` INT NOT NULL AUTO_INCREMENT;
ALTER TABLE `game_character` MODIFY COLUMN `id` INT NOT NULL AUTO_INCREMENT;
ALTER TABLE `member_basic` ADD COLUMN `character_id` INT;
ALTER TABLE `member_basic` ADD FOREIGN KEY (`character_id`) REFERENCES `game_character` (`id`); 

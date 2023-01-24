package com.bewithme.app.user.model;

import com.bewithme.data.entity.GameInfoEntity;
import com.bewithme.data.entity.MateWishEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.type.Game;
import com.bewithme.data.type.Gender;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class UserDetailDto {
	private Long id;
	private String nickname;
	private String gender;
	private String birth;
	private String aboutMe;
	private String discordUrl;
	private GameInfo game;
	private WishInfo wish;

	@Data
	@AllArgsConstructor
	public class GameInfo {
		private String gameName;
		private String comment;
	}

	@Data
	@AllArgsConstructor
	public class WishInfo {
		private String ageGroup;
		private String gender;
		private String accessTime;
		private String gameType;
	}

	public UserDetailDto(MemberBasicEntity memberBasic) throws Exception{
		this.id = memberBasic.getId();
		this.nickname = memberBasic.getNickname();
		this.gender = Gender.of(memberBasic.getGender()).getDesc();
		this.birth = memberBasic.getBirth();
		this.aboutMe = memberBasic.getAboutMe();
		this.discordUrl = memberBasic.getDiscordUrl();
	}

	public void setGameInfo(GameInfoEntity gameInfo) {
		var gameName = Game.of(gameInfo.getGame()).getKorName();
		var comment = gameInfo.getComment();
		this.game = new GameInfo(gameName, comment);
	}

	public void setWishInfo(MateWishEntity wishInfo) {
		this.wish = new WishInfo(wishInfo.getAgeGroup(), wishInfo.getGender(),
				wishInfo.getAccessTime(), wishInfo.getGameType());
	}
}

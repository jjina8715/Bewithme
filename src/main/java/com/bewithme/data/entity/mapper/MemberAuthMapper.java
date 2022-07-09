package com.bewithme.data.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.common.mapper.EntityMapper;
import com.bewithme.data.entity.MemberAuthEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MemberAuthMapper extends EntityMapper<MemberInfoDto, MemberAuthEntity>{

    @Mappings({
        @Mapping(source = "memberBasic.name"         	, target = "name"         	),
        @Mapping(source = "memberBasic.nickname"     	, target = "nickname"		),
        @Mapping(source = "memberBasic.gender"       	, target = "gender"      	),
        @Mapping(source = "memberBasic.birth"     		, target = "birth"     		),
        @Mapping(source = "memberBasic.accessTime"     	, target = "accessTime"     ),
        @Mapping(source = "memberBasic.aboutMe"      	, target = "aboutMe"      	),
        @Mapping(source = "memberBasic.discordUrl" 		, target = "discordUrl" 	),
        @Mapping(source = "memberBasic.phoneNumber"		, target = "phoneNumber"	),
        @Mapping(source = "memberBasic.lastLogin" 		, target = "lastLogin" 		, dateFormat = "yyyy-MM-dd")
	})
    MemberAuthEntity map(MemberInfoDto source);
    
    
}

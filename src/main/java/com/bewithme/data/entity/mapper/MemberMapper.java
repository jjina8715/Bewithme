package com.bewithme.data.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.common.mapper.EntityMapper;
import com.bewithme.data.entity.MemberAuthEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MemberMapper extends EntityMapper<MemberInfoDto, MemberAuthEntity>{
	
}

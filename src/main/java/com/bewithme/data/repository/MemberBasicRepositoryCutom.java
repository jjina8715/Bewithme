package com.bewithme.data.repository;

import java.util.List;

import com.bewithme.app.member.model.MateInfoDto;
import com.bewithme.app.member.model.MemberCondition;

public interface MemberBasicRepositoryCutom {

	List<MateInfoDto> readItems(MemberCondition memberCondition);
}

package com.bewithme.data.repository;

import java.util.List;

import com.bewithme.app.member.model.MemberCondition;
import com.bewithme.app.member.model.MemberInfoDto;

public interface MemberAuthRepositoryCutom {

	List<MemberInfoDto> readItems(MemberCondition memberCondition);
}

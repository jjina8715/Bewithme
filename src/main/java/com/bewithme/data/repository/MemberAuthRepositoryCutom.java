package com.bewithme.data.repository;

import java.util.List;

import com.bewithme.app.info.model.MemberCondition;
import com.bewithme.app.info.model.MemberInfoDto;

public interface MemberAuthRepositoryCutom {

	List<MemberInfoDto> readItems(MemberCondition memberCondition);
}

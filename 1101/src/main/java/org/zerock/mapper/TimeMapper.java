package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("select sysdate from dual")
	public String getTime();
	
	@Select("select name from G_CLASS where name = '�ֿ��Ҷ�'")
	public String getMem();
}

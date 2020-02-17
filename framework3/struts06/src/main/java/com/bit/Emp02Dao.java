package com.bit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Emp02Dao {
	SqlMapClient sqlMapClient;
	
	public Emp02Dao() {
		try {
			Reader reader = Resources.getResourceAsReader("/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Emp02Vo> selectAll() throws SQLException {
		return sqlMapClient.queryForList("selectAll");
		// Query.xml에서 사용한 id 호출
	}
}

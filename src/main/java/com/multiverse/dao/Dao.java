package com.multiverse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.multiverse.model.Family;
import com.multiverse.model.FamilyDetails;


@Component
public class Dao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<FamilyDetails> getAllFamilies() {
		String query = "select family_id,universe_id,power from family order by family_id asc ,universe_id asc";

		List<FamilyDetails> details = jdbcTemplate.query(query, new RowMapper<FamilyDetails>() {
			public FamilyDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

				FamilyDetails familyDetails=new FamilyDetails();
				familyDetails.setFamilyId(rs.getInt(1));
				familyDetails.setUniverseId(rs.getInt(2));
				familyDetails.setFamilypower(rs.getInt(3));
				
				return familyDetails;
			}
		});
		return details;
	}
	public List<Integer> getFamiliesbyID(int id) {
		String query = "select family_id from family where universe_id = " + id;

		List<Integer> actors = jdbcTemplate.query(query, new RowMapper<Integer>() {
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {

				return (int) rs.getLong(1);
			}
		});
		return actors;
	}

	public List<Family> checkbalance() {
		String query = "select family_id , count(distinct power) from family group by family_id";

		List<Family> actors = jdbcTemplate.query(query, new RowMapper<Family>() {
			public Family mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Family(rs.getLong(1), rs.getLong(2) == 1 ? true : false);
			}
		});
		return actors;

	}

	public void balancepower() {
		String query = "select family_id as id ,max(power) as power from family group by family_id";

		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		for (Map row : rows) {
			hm.put(Integer.parseInt((String) row.get("id")), (Integer) row.get("power"));

		}

		Map<Integer, Integer> hm2 = new HashMap<Integer, Integer>();

		String query2 = "select id,family_id,power from family ";
		List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(query2);
		for (Map<String, Object> row : rows2) {

			Integer a = (Integer) row.get("id");
			Integer b = (Integer) row.get("power");
			Integer c = Integer.parseInt((String) row.get("family_id"));
			hm2.put(a, hm.get(c) - b );
		}

		
		String query3 = "update person set power = ? + power where family_id= ? limit 1 ";
		int[] types = { Types.INTEGER, Types.INTEGER };
		for (Map.Entry<Integer, Integer> m : hm2.entrySet()) {
			Object[] params = { m.getValue(), m.getKey() };
			jdbcTemplate.update(query3, params, types);
		}
		String  query4="update family set power = ? where family_id =?";
		for (Map.Entry<Integer, Integer> m : hm.entrySet())
		{
			Object[] params = { m.getValue(), m.getKey() };
			jdbcTemplate.update(query4, params, types);
		}
		

	}

}

package com.multiverse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.multiverse.model.Person;

@Component
public class PersonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Person p) {
		Integer id = 0;
		String query = "";
		try {
			query = "select id from family where family_id=" + p.getFamilyId() + " and universe_id = "
					+ p.getUniverseId();

			id = jdbcTemplate.queryForObject(query, Integer.class);

		} catch (EmptyResultDataAccessException e) {
			String q = "insert into family(family_id,universe_id,power,name) values(" + p.getFamilyId() + ","
					+ p.getUniverseId() + ",0,'default')";
			jdbcTemplate.update(q);
			jdbcTemplate.update("insert into universe (name) values('a')");
			id = jdbcTemplate.queryForObject(query, Integer.class);
		} finally {

			jdbcTemplate.update("update family set power = power + " + p.getPower() + " where id = " + id);
			String query2 = "insert into person(name,family_id,power) values(?,?,?)";
			System.out.println(id);
			jdbcTemplate.update(query2, new Object[] { p.getName(), id, p.getPower() });
		}

	}

	public List<Person> getAllpersons() {
		String sql = "SELECT p.id as id ,p.name as name,f.family_id as fid,f.universe_id as uid ,p.power as power FROM person p join family f on p.family_id = f.id order by fid asc , uid asc";

		List<Person> persons = new ArrayList<Person>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Person person = new Person();
			person.setName(row.get("name"));
			person.setFamilyId(Integer.parseInt((String)row.get("fid")));
			person.setUniverseId((Integer) row.get("uid"));
			person.setPower((Integer) row.get("power"));
			persons.add(person);
		}

		return persons;

	}
}

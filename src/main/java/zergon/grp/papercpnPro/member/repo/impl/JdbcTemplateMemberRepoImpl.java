package zergon.grp.papercpnPro.member.repo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import zergon.grp.papercpnPro.member.repo.MemberRepo;
import zergon.grp.papercpnPro.member.repo.MemberVO;

public class JdbcTemplateMemberRepoImpl implements MemberRepo {

	private final JdbcTemplate jdbcTemplate;

	public JdbcTemplateMemberRepoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public MemberVO save(MemberVO member) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", member.getName());
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		member.setId(key.longValue());

		return member;
	}

	@Override
	public Optional<MemberVO> findById(Long id) {
		List<MemberVO> result = jdbcTemplate.query("select * from member where id= ?", memberRowMapper(), id);
		return result.stream().findAny();
	}

	@Override
	public Optional<MemberVO> findByName(String name) {
		List<MemberVO> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
		return result.stream().findAny();
	}

	@Override
	public List<MemberVO> findAll() {
		return jdbcTemplate.query("select * from member", memberRowMapper());
	}

	private RowMapper<MemberVO> memberRowMapper() {
		return (rs, rowNum) -> {
			MemberVO member = new MemberVO();
			member.setId(rs.getLong("id"));
			member.setName(rs.getString("name"));
			return member;
		};
	}
}

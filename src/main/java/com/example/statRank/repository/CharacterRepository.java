package com.example.statRank.repository;

import com.example.statRank.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

@Repository
public class CharacterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<CharacterDTO> rowMapper = (rs, rowNum) -> {
        CharacterDTO character = new CharacterDTO();
        character.setId(rs.getLong("id"));
        character.setName(rs.getString("name"));
        character.setImage(rs.getString("image"));
        character.setContent(rs.getString("content"));
        character.setStat1(rs.getInt("stat1"));
        character.setStat2(rs.getInt("stat2"));
        character.setStat3(rs.getInt("stat3"));
        character.setStat4(rs.getInt("stat4"));
        character.setStat5(rs.getInt("stat5"));
        return character;
    };

    public CharacterDTO save(CharacterDTO character) {
        jdbcTemplate.update("INSERT INTO characters (name, image, content, stat1, stat2, stat3, stat4, stat5) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                character.getName(), character.getImage(), character.getContent(), character.getStat1(), character.getStat2(), character.getStat3(), character.getStat4(), character.getStat5());
        return character;
    }

    public List<CharacterDTO> findAll() {
        return jdbcTemplate.query("SELECT * FROM characters", rowMapper);
    }

    public CharacterDTO findById(Long id) {
        List<CharacterDTO> results = jdbcTemplate.query("SELECT * FROM characters WHERE id = ?", new Object[]{id}, rowMapper);
        if (results.isEmpty()) {
            throw new EmptyResultDataAccessException("No character found with id " + id, 1);
        }
        return results.get(0);
    }

    public void update(CharacterDTO character) {
        jdbcTemplate.update("UPDATE characters SET name = ?, image = ?, content = ?, stat1 = ?, stat2 = ?, stat3 = ?, stat4 = ?, stat5 = ? WHERE id = ?",
                character.getName(), character.getImage(), character.getContent(), character.getStat1(), character.getStat2(), character.getStat3(), character.getStat4(), character.getStat5(), character.getId());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM characters WHERE id = ?", id);
    }
}
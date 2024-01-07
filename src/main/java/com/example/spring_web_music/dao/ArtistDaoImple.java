package com.example.spring_web_music.dao;

import com.example.spring_web_music.model.Artist;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ArtistDaoImple implements ArtistDao {

    NamedParameterJdbcTemplate template;

    public void setTemplate(NamedParameterJdbcTemplate template) throws DataAccessException {
        this.template = template;
    }

    @Override
    public void addArtist(Artist artist) {
        String sql ="INSERT INTO artists(name,image) VALUES (:name,:image)";
        template.update(sql, getSqlParamsbyModel(artist));

    }

    @Override
    public void updateArtist(Artist artist) {
        String sql ="UPDATE artists SET name=:name, image=:image";
        template.update(sql, getSqlParamsbyModel(artist));
    }

    @Override
    public void deleteArtist(String name) {
        String sql ="DELETE FROM artists WHERE name=:name";
        template.update(sql, getSqlParamsbyModel(new Artist()));

    }

    @Override
    public List<Artist> getAllArtist() {
        String sql = "SELECT * FROM artists";
        List<Artist> artistList = template.query(sql, getSqlParamsbyModel(null), new ArtistMapper());

        return artistList;
    }

    @Override
    public Artist findArtist(String name) {
//        String sql ="SELECT * FROM artists WHERE name=:name";
//        return (Artist) template.query(sql,getSqlParamsbyModel(new Artist(name)),new ArtistMapper());
        return null;
    }

    private SqlParameterSource getSqlParamsbyModel(Artist artist){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        if(artist != null){
            parameterSource.addValue("id",artist.getId());
            parameterSource.addValue("name", artist.getName());
            parameterSource.addValue("image",artist.getImage());
        }
        return parameterSource;
    }

    private static final class ArtistMapper implements RowMapper {

        @Override
        public Artist mapRow(ResultSet rs, int rowNum) throws SQLException {
            Artist artist = new Artist();
            artist.setId(rs.getInt("id"));
            artist.setName(rs.getString("name"));
            artist.setImage(rs.getString("image"));
            return artist;
        }
    }
}

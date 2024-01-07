package com.example.spring_web_music.dao;

import com.example.spring_web_music.model.Artist;

import java.util.List;

public interface ArtistDao {

    public void addArtist(Artist artist);
    public void updateArtist(Artist artist);
    public void deleteArtist(String name);
    public List<Artist> getAllArtist();
    public Artist findArtist(String name );
}

package org.allga.model;

/**
 * Created by Olga on 29.03.2016.
 */
public class MovieData {
    private String imdbSearch;
    private String number;
    private String title;
    private String knownAs;
    private String year;
    private String duration;
    private String rating;
    private String format;
    private boolean ownMovie;
    private boolean alreadySeen;
    private boolean loanedOut;
    private String trailerUrl;
    private String personalNotes;
    private String taglines;
    private String plotOutline;
    private String plots;
    private String languages;
    private String subtitles;
    private String audio;
    private String video;
    private String country;
    private String genres;
    private String director;
    private String writer;
    private String producer;
    private String music;
    private String cast;

    public String getImdbSearch() {
        return imdbSearch;
    }

    public MovieData setImdbSearch(String imdbSearch) {
        this.imdbSearch = imdbSearch;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public MovieData setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MovieData setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public MovieData setKnownAs(String knownAs) {
        this.knownAs = knownAs;
        return this;
    }

    public String getYear() {
        return year;
    }

    public MovieData setYear(String year) {
        this.year = year;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public MovieData setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public MovieData setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public MovieData setFormat(String format) {
        this.format = format;
        return this;
    }

    public boolean isOwnMovie() {
        return ownMovie;
    }

    public MovieData setOwnMovie(boolean ownMovie) {
        this.ownMovie = ownMovie;
        return this;
    }

    public boolean isAlreadySeen() {
        return alreadySeen;
    }

    public MovieData setAlreadySeen(boolean alreadySeen) {
        this.alreadySeen = alreadySeen;
        return this;
    }

    public boolean isLoanedOut() {
        return loanedOut;
    }

    public MovieData setLoanedOut(boolean loanedOut) {
        this.loanedOut = loanedOut;
        return this;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public MovieData setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
        return this;
    }

    public String getPersonalNotes() {
        return personalNotes;
    }

    public MovieData setPersonalNotes(String personalNotes) {
        this.personalNotes = personalNotes;
        return this;
    }

    public String getTaglines() {
        return taglines;
    }

    public MovieData setTaglines(String taglines) {
        this.taglines = taglines;
        return this;
    }

    public String getPlotOutline() {
        return plotOutline;
    }

    public MovieData setPlotOutline(String plotOutline) {
        this.plotOutline = plotOutline;
        return this;
    }

    public String getPlots() {
        return plots;
    }

    public MovieData setPlots(String plots) {
        this.plots = plots;
        return this;
    }

    public String getLanguages() {
        return languages;
    }

    public MovieData setLanguages(String languages) {
        this.languages = languages;
        return this;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public MovieData setSubtitles(String subtitles) {
        this.subtitles = subtitles;
        return this;
    }

    public String getAudio() {
        return audio;
    }

    public MovieData setAudio(String audio) {
        this.audio = audio;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public MovieData setVideo(String video) {
        this.video = video;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public MovieData setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getGenres() {
        return genres;
    }

    public MovieData setGenres(String genres) {
        this.genres = genres;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public MovieData setDirector(String director) {
        this.director = director;
        return this;
    }

    public String getWriter() {
        return writer;
    }

    public MovieData setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public MovieData setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getMusic() {
        return music;
    }

    public MovieData setMusic(String music) {
        this.music = music;
        return this;
    }

    public String getCast() {
        return cast;
    }

    public MovieData setCast(String cast) {
        this.cast = cast;
        return this;
    }

    @Override
    public String toString() {
        return "MovieData{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", number='" + number + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}

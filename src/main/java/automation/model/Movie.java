package automation.model;

public class Movie {
	
	private String title;
	private String year;
	private String plot;
	private String producer;
	
	public String getTitle() {
		return title;
	}
	
	public Movie setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getYear() {
		return year;
	}
	
	public Movie setYear(String year) {
		this.year = year;
		return this;
	}
	
	public String getPlot() {
		return plot;
	}
	
	public Movie setPlot(String plot) {
		this.plot = plot;
		return this;
	}
	
	public String getProducer() {
		return producer;
	}
	
	public Movie setProducer(String producer) {
		this.producer = producer;
		return this;
	}

}

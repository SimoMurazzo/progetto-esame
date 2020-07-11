package com.esame.model;

/**
 * Modello per le statistiche sulle immagini che contiene attributo del tweet, dimesioni
 * e statistica minima, media e massima
 * @author Sergio Galletto
 * @author Simone Murazzo
 */
public class ImageStatsMod {

	private String tweetattribute;
	private String imageDim;
	private double med;
	private long min;
	private long max;
	
	public ImageStatsMod() {}
	
	public ImageStatsMod(String tweetattribute, String imageDim, double med, long min, long max) {
		this.tweetattribute = tweetattribute;
		this.imageDim = imageDim;
		this.med = med;
		this.min = min;
		this.max = max;
	}

	public String getTweetattribute() {
		return tweetattribute;
	}

	public String getImageDim() {
		return imageDim;
	}

	public double getMed() {
		return med;
	}

	public long getMin() {
		return min;
	}

	public long getMax() {
		return max;
	}

	public void setTweetattribute(String tweetattribute) {
		this.tweetattribute = tweetattribute;
	}

	public void setImageDim(String imageDim) {
		this.imageDim = imageDim;
	}

	public void setMed(double med) {
		this.med = med;
	}

	public void setMin(long min) {
		this.min = min;
	}

	public void setMax(long max) {
		this.max = max;
	}
	
	
}

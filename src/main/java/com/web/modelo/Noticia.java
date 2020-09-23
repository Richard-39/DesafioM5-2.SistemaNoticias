package com.web.modelo;

public class Noticia {

	private String titulo;
	private String bajada;
	private String imgUrl;
	
	public Noticia() {
		super();
	}

	public Noticia(String titulo, String bajada, String imgUrl) {
		super();
		this.titulo = titulo;
		this.bajada = bajada;
		this.imgUrl = imgUrl;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getBajada() {
		return bajada;
	}

	public void setBajada(String bajada) {
		this.bajada = bajada;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Noticia [titulo=" + titulo + ", bajada=" + bajada + ", imgUrl=" + imgUrl + "]";
	}
	
	
	
}

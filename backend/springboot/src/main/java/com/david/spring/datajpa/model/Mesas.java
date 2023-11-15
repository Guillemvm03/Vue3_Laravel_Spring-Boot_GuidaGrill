package com.david.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "num_Mesa")
	private Integer num_Mesa;

	@Column(name = "capacidad")
	private Integer capacidad;
    
    @Column(name = "categoria")
	private String categoria;

	@Column(name = "reserva")
	private boolean reserva;

    public Mesas() {
		
	}

	public Mesas(Integer num_Mesa, Integer capacidad, String categoria, boolean reserva) {

        this.num_Mesa = num_Mesa;
        this.capacidad = capacidad;
        this.categoria = categoria;
        this.reserva = reserva;
	}

	

	public long getId() {
		return id;
	}

	public Integer getnum_Mesa() {
		return num_Mesa;
	}

	public void setnumMesa(Integer num_Mesa) {
		this.num_Mesa = num_Mesa;
	}

	public Integer getcapacidad() {
		return capacidad;
	}

	public void setcapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

    public String getcategoria() {
		return categoria;
	}

	public void setcategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isreserva() {
		return reserva;
	}

	public void setreserva(boolean isreserva) {
		this.reserva = isreserva;
	}

	@Override
	public String toString() {
		return "Mesas [id=" + id + ", numMesa=" + num_Mesa + ", capacidad=" + capacidad + ", categoria=" + categoria + ", reserva=" + reserva + "]";
	}

}

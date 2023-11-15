package com.david.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tables")
public class Tables {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "table_number")
	private Integer table_number;

	@Column(name = "capacity")
	private Integer capacity;
    
    @Column(name = "category")
	private String category;

	@Column(name = "available")
	private boolean available;

    @Column(name = "status")
	private String status;

    public Tables() {
		
	}

	public Tables(Integer table_number, Integer capacity, String category, boolean available, String status) {

        this.table_number = table_number;
        this.capacity = capacity;
        this.category = category;
        this.available = available;
        this.status = status;
	}

	

	public long getId() {
		return id;
	}

	public Integer gettable_number() {
		return table_number;
	}

	public void setnumMesa(Integer table_number) {
		this.table_number = table_number;
	}

	public Integer getcapacity() {
		return capacity;
	}

	public void setcapacity(Integer capacity) {
		this.capacity = capacity;
	}

    public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}

	public boolean isavailable() {
		return available;
	}

	public void setavailable(boolean isavailable) {
		this.available = isavailable;
	}

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Tables [id=" + id + ", table_number=" + table_number + ", capacity=" + capacity + ", category=" + category + ", available=" + available + ", status=" + status + "]";
	}

}

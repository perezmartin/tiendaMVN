package es.rf.tienda.dominio;

import java.util.Date;

public class Producto {

	private int id_producto;
	private String pro_descripcion;
	private String pro_desLarga;
	private double pro_precio;
	private int pro_stock;
	private Date pro_fecRepos;
	private Date pro_fecActi;
	private Date pro_fecDesacti;
	private String pro_uniVenta;
	private int pro_cantXUniVenta;
	private String pro_uniUltNivel;
	private int id_pais;
	private String pro_usoRecomendado;
	private int id_categoria;
	private int pro_stkReservado;
	private boolean pro_nStkAlto;
	private boolean pro_nStkBajo;
	private boolean pro_stat;

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getPro_descripcion() {
		return pro_descripcion;
	}

	public void setPro_descripcion(String pro_descripcion) {
		this.pro_descripcion = pro_descripcion;
	}

	public String getPro_desLarga() {
		return pro_desLarga;
	}

	public void setPro_desLarga(String pro_desLarga) {
		this.pro_desLarga = pro_desLarga;
	}

	public double getPro_precio() {
		return pro_precio;
	}

	public void setPro_precio(double pro_precio) {
		this.pro_precio = pro_precio;
	}

	public int getPro_stock() {
		return pro_stock;
	}

	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	public Date getPro_fecRepos() {
		return pro_fecRepos;
	}

	public void setPro_fecRepos(Date pro_fecRepos) {
		this.pro_fecRepos = pro_fecRepos;
	}

	public Date getPro_fecActi() {
		return pro_fecActi;
	}

	public void setPro_fecActi(Date pro_fecActi) {
		this.pro_fecActi = pro_fecActi;
	}

	public Date getPro_fecDesacti() {
		return pro_fecDesacti;
	}

	public void setPro_fecDesacti(Date pro_fecDesacti) {
		this.pro_fecDesacti = pro_fecDesacti;
	}

	public String getPro_uniVenta() {
		return pro_uniVenta;
	}

	public void setPro_uniVenta(String pro_uniVenta) {
		this.pro_uniVenta = pro_uniVenta;
	}

	public int getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}

	public void setPro_cantXUniVenta(int pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}

	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}

	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}

	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}

	public void setPro_usoRecomendado(String pro_usoRecomendado) {
		this.pro_usoRecomendado = pro_usoRecomendado;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getPro_stkReservado() {
		return pro_stkReservado;
	}

	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}

	public boolean isPro_nStkAlto() {
		return pro_nStkAlto;
	}

	public void setPro_nStkAlto(boolean pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}

	public boolean isPro_nStkBajo() {
		return pro_nStkBajo;
	}

	public void setPro_nStkBajo(boolean pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}

	public boolean isPro_stat() {
		return pro_stat;
	}

	public void setPro_stat(boolean pro_stat) {
		this.pro_stat = pro_stat;
	}

}

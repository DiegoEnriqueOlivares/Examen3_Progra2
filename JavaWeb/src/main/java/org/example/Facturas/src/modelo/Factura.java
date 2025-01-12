package org.example.Facturas.src.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
	private int folio;
	private String descripcion;
	private Date fecha;
	private Cliente cliente;
	private ItemFactura[] items;
	private int indiceItems;
	public static final int MAX_ITEMS=12;
	private static int ultimoFolio;
	
	public Factura(String descripcion, Cliente cliente) {
		this.descripcion=descripcion;
		this.cliente= cliente;
		this.items=new ItemFactura[MAX_ITEMS];
		this.folio= ++ultimoFolio;
		this.fecha=new Date();
	}
	public void addItemFactura(ItemFactura item) {
		if(indiceItems<MAX_ITEMS) {
			this.items[indiceItems++]=item;
		}
	}
	
	public float calcularTotal() {
		float total=0.0f;
		for(ItemFactura item:this.items) {
			if(item==null) {
				continue;
			}
			total+=item.calcularImporte();
		}
		return total;
	}
	
	public String generarDetalle() {
		StringBuilder sb = new StringBuilder("Factura N : ");
		sb.append(folio)
			.append("\nCliente: ")
			.append(this.cliente.getNombre())
			.append("\t NRC: ")
			.append(cliente.getNrc())
			.append("\n Descripcion ")
			.append(this.descripcion)
			.append("\n");
		SimpleDateFormat df =new SimpleDateFormat("dd 'de' MMMM, yyyy");
		sb.append("Fecha Emision: ")
		.append(df.format(this.fecha))
		.append("\n")
		.append("\n#\tNombre\t$\tCant.\tTotal\n");
		for(ItemFactura item:this.items) {
			if(item==null) {
				continue;
			}
			sb.append(item.getProducto().getCodigo())
				.append("\t")
				.append(item.getProducto().getNombre())
				.append("\t")
				.append(item.getProducto().getPrecio())
				.append("\t")
				.append(item.getCantidad())
				.append("\t")
				.append(item.calcularImporte())
				.append("\n");
			
		}
		sb.append("\n Total:" )
				.append(calcularTotal());
		return sb.toString();
	}
	
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ItemFactura[] getItems() {
		return items;
	}
	public void setItems(ItemFactura[] items) {
		this.items = items;
	}
	public int getIndiceItems() {
		return indiceItems;
	}
	public void setIndiceItems(int indiceItems) {
		this.indiceItems = indiceItems;
	}
	public static int getUltimoFolio() {
		return ultimoFolio;
	}
	public static void setUltimoFolio(int ultimoFolio) {
		Factura.ultimoFolio = ultimoFolio;
	}
	public static int getMaxItems() {
		return MAX_ITEMS;
	}
	
}

package org.example.Facturas.src.Presentacion;

import java.util.Scanner;
import org.example.Facturas.src.modelo.Cliente;
import org.example.Facturas.src.modelo.Factura;
import org.example.Facturas.src.modelo.ItemFactura;
import org.example.Facturas.src.modelo.Producto;

public class Facturacion {

	public static void main(String[] args) {
		Cliente cliente =new Cliente();
		cliente.setNrc("118557-5");
		cliente.setNombre("Diego");
		Scanner s= new Scanner(System.in);
		System.out.println("Ingrese una descripcion de la Factura: ");
		String desc = s.nextLine();
		Factura factura = new Factura(desc, cliente);
		Producto producto;
		String nombre;
		float precio;
		int cantidad;
		System.out.println();
		for(int i=0;i<5;i++) {
			producto=new Producto();
			System.out.println("Ingrese el producto: "+producto.getCodigo()+": ");
			nombre=s.nextLine();
			producto.setNombre(nombre);
			System.out.println("Ingrese el precio: ");
			precio=Float.parseFloat(s.nextLine());
			producto.setPrecio(precio);
			System.out.println("Ingrese la cantidad: ");
			cantidad=Integer.parseInt(s.nextLine());
			ItemFactura item = new ItemFactura(cantidad, producto);
			factura.addItemFactura(item);
			System.out.println();
			s.nextLine();
			
		}
		System.out.println(factura.generarDetalle());
	}

}

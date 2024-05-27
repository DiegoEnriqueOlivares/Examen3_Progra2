package org.example.Facturas.src.Presentacion;

import jakarta.servlet.ServletException;
import org.example.Facturas.src.modelo.Cliente;
import org.example.Facturas.src.modelo.Factura;
import org.example.Facturas.src.modelo.ItemFactura;
import org.example.Facturas.src.modelo.Producto;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FacturacionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = new Cliente();
        cliente.setNrc(request.getParameter("nrc"));
        cliente.setNombre(request.getParameter("nombre"));

        String descripcion = request.getParameter("descripcion");
        Factura factura = new Factura(descripcion, cliente);

        for (int i = 1; i <= 5; i++) {
            Producto producto = new Producto();
            producto.setNombre(request.getParameter("producto" + i));
            try {
                producto.setPrecio(Float.parseFloat(request.getParameter("precio" + i)));
            } catch (NumberFormatException e) {
                producto.setPrecio(0);
            }

            int cantidad;
            try {
                cantidad = Integer.parseInt(request.getParameter("cantidad" + i));
            } catch (NumberFormatException e) {
                cantidad = 0;
            }

            ItemFactura item = new ItemFactura(cantidad, producto);
            factura.addItemFactura(item);
        }

        request.getSession().setAttribute("factura", factura);
        request.getRequestDispatcher("/WEB-INF/factura.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}



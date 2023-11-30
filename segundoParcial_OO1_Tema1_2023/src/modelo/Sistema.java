package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Articulo> articulos;
	private List<Compra> compras;

	public Sistema() {
		super();
		this.articulos = new ArrayList<>();
		this.compras = new ArrayList<>();
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Sistema [articulos=" + articulos + ", compras=" + compras + "]\n";
	}

	public Articulo traerArticulo(String detalle) {
		Articulo found = null;
		int i = 0;
		while (found == null && i < getArticulos().size()) {
			if (getArticulos().get(i).getDetalle().equalsIgnoreCase(detalle))
				found = getArticulos().get(i);
			i++;
		}
		return found;
	}

	public boolean agregarArticulo(String detalle, double precio, Descuento descuento) throws Exception {
		if (traerArticulo(detalle) != null)
			throw new Exception("existe articulo " + detalle);

		return getArticulos().add(new Articulo(proxIdArt(), detalle, precio, descuento));
	}

	private int proxIdArt() {
		int p = 1;
		if (!getArticulos().isEmpty())
			p = getArticulos().get(getArticulos().size() - 1).getId() + 1;
		return p;
	}

	public boolean agregarCompra(int cantidad, Articulo articulo, LocalDateTime fechaHora) throws Exception {
		return getCompras().add(new Compra(cantidad, articulo, fechaHora));
	}

	public List<Compra> traerCompras(LocalDateTime desde, LocalDateTime hasta) {
		List<Compra> encont = new ArrayList<>();

		for (Compra compra : getCompras()) {
			if ((compra.getFechaHora().isEqual(desde) || compra.getFechaHora().isAfter(desde))
					&& (compra.getFechaHora().isEqual(hasta) || compra.getFechaHora().isBefore(hasta)))
				encont.add(compra);
		}
		return encont;
	}

	public List<Compra> traerComprasdescuentoPorcantidad(LocalDateTime desde, LocalDateTime hasta) {
		List<Compra> encont = new ArrayList<>();

		for (Compra compra : getCompras()) {
			if ((compra.getFechaHora().isEqual(desde) || compra.getFechaHora().isAfter(desde))
					&& (compra.getFechaHora().isEqual(hasta) || compra.getFechaHora().isBefore(hasta))
					&& compra.getArticulo().getDescuento() instanceof descuentoPorCantidad)
				encont.add(compra);
		}
		return encont;
	}

	public List<Articulo> traerArticuosconDescuento(boolean activo) {
		List<Articulo> encont = new ArrayList<>();

		for (Articulo articulo : getArticulos()) {
			if (articulo.getDescuento().isActivo() == activo)
				encont.add(articulo);
		}
		return encont;
	}
}

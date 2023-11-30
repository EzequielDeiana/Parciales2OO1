package modelo;

public abstract class Tarjeta {
	
	protected String codigo;
	protected int id;
	protected boolean descuentoActivo;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDescuentoActivo() {
		return descuentoActivo;
	}
	public void setDescuentoActivo(boolean descuentoActivo) {
		this.descuentoActivo = descuentoActivo;
	}
	
	public Tarjeta(String codigo, int id, boolean descuentoActivo) {
		super();
		this.codigo = codigo;
		this.id = id;
		this.descuentoActivo = descuentoActivo;
	}
	
	public abstract double calcularDescuento(double precio);
	
	public double devolverDescuentoCalculadoSegunEstado(double precio) {
		double descuento = 0;
		if(descuentoActivo) {
			descuento = calcularDescuento(precio);
		} 
		return descuento;
	}
	
}

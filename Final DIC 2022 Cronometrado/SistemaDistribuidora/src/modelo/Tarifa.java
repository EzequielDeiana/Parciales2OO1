package modelo;

public class Tarifa {
	private int id;
	private int consumoDesde;
	private int consumoHasta;
	private float cargoFijo;
	private float cargoVariable;
	
	
	
	public Tarifa(int id, int consumoDesde, int consumoHasta, float cargoFijo, float cargoVariable) {
		super();
		this.id = id;
		this.consumoDesde = consumoDesde;
		this.consumoHasta = consumoHasta;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getConsumoDesde() {
		return consumoDesde;
	}
	public void setConsumoDesde(int consumoDesde) {
		this.consumoDesde = consumoDesde;
	}
	public int getConsumoHasta() {
		return consumoHasta;
	}
	public void setConsumoHasta(int consumoHasta) {
		this.consumoHasta = consumoHasta;
	}
	public float getCargoFijo() {
		return cargoFijo;
	}
	public void setCargoFijo(float cargoFijo) {
		this.cargoFijo = cargoFijo;
	}
	public float getCargoVariable() {
		return cargoVariable;
	}
	public void setCargoVariable(float cargoVariable) {
		this.cargoVariable = cargoVariable;
	}


	@Override
	public String toString() {
		return "Tarifa [id=" + id + ", consumoDesde=" + consumoDesde + ", consumoHasta=" + consumoHasta + ", cargoFijo="
				+ cargoFijo + ", cargoVariable=" + cargoVariable + "]";
	}
	
	
	
}

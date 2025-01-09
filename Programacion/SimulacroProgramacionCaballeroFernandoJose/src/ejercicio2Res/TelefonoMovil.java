package ejercicio2Res;

public class TelefonoMovil extends Producto {

		public TelefonoMovil(String modelo, String marca, double precio, double descuento) {
				super(modelo, marca, precio, descuento);

		}
		
		@Override
		public String toString() {
			return "TelefonoMovil [modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", descuento=" + descuento
					+ "]";
		}
		
		
		@Override
		public double calcularPrecio() {
			double precioTotal=0;
			precioTotal= precio-descuento;
			return precioTotal;
		}

}

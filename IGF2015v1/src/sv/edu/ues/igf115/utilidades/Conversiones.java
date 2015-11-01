package sv.edu.ues.igf115.utilidades;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversiones {

	
	public Date stringToDate(String strFecha){
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = formatoDelTexto.parse(strFecha);
			return fecha;
		} catch (Exception e){
			System.err.println("(Fechas) Ocurrio un error "+e.getMessage());
			return null;
		}
	}
	
	public BigDecimal stringToBigDecimal(String strBigDecimal){
		strBigDecimal = strBigDecimal.replaceAll(",","");
		return new BigDecimal(strBigDecimal);
	}
}

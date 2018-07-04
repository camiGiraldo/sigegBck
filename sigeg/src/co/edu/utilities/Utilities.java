package co.edu.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Utilities {

	public static final String ERRORGET = "No se encontraron registros.";
	public static final String ERRORSAVE = "Error al guardar la entidad.";
	public static final String IDAPORTEINVESTIGACION = "idAporteInvestigacion";
	public static final String IDEGRESADO = "idEgresado";
	public static final String IDEVENTO = "idEvento";
	public static final String IDFACULTAD = "idFacultad";
	public static final String IDPROGRAMA = "idPrograma";
	public static final String IDRECONOCIMIENTO = "idReconocimiento";
	public static final String IDPARTICIPACIONDEMOCRATICA = "idParticipacionDemocratica";
	public static final String IDINFORMACIONACADEMICA = "idInformacionAcademica";
	public static final String IDCATEGORIAEVENTO = "idCategoriaEvento";
	public static final String IDEGRESADOAPORTE = "idEgresadoAporte";
	public static final String IDINFORMACIONCONTROL = "idInformacionControl";
	public static final String IDASISTENCIAEVENTO = "idAsistenciaEvento";
	public static final String IDFORMAPARTICIPACION = "idFormaParticipacion";
	public static final String IDPARTICIPACIONEGRESADO = "idFormaParticipacion";
	public static final String IDEGRESADORECONICIMIENTO = "idEgresadoReconocimiento";
	public static final String IDTIPOAPORTE = "idTipoAporte";
	public static final String IDTIPOEVENTO = "idTipoEvento";
	public static final String IDTIPORECONOCIMIENTO = "idTipoReconocimiento";
	public static final String SOPORTE = "soporte";
	public static final String IDEGRESADONOTEMPTY = "Id Egresado no puede estar vacio y debe ser un numero con menos de 10 caracteres";
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	private Utilities() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean isNumeric(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("^\\d+$");
		Matcher mat = pat.matcher(word);
		if (mat.find()) {
			ret = true;
		}
		return ret;
	}

	/**
	 * 
	 * @param word
	 * @return Expresion regular "(\\d){1,10}\\.(\\d){1,10}" (\\d)digito {1,10}de 1
	 *         a 10 caracteres \\. punto
	 * 
	 */
	public static boolean isDecimal(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("(\\d){1,8}\\.(\\d){0,2}");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
	}

	public static boolean checkWordAndCheckWithlength(String word,
			Integer length) {
		boolean ret = false;
		if (word.length() <= length) {
			ret = true;
		}
		return ret;
	}

	public static boolean isOnlyLetters(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("[^A-Za-z0-9',.\\s]");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
	}

	public static String formatDateWithoutTimeInAStringForBetweenWhere(
			Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = sdf.format(fecha);
		return "TO_DATE('" + strDate + "','dd/MM/yyyy')";
	}

	public static boolean validateEmailAddress(String sEmail) {
		InternetAddress internetAddress;
		try {
			internetAddress = new InternetAddress(sEmail);
			internetAddress.validate();
			return true;
		} catch (AddressException e) {
			return false;
		}
	}

	public static boolean checkEmpty(String field) {
		return field.isEmpty() ? false : true;
	}

	public static boolean checkEmptyAndLength(String field, int length) {
		return !field.isEmpty() && field.length() <= length ? true : false;
	}

	public static boolean checkNotEmptyAndLength(String field, int length) {
		return !field.isEmpty() && field.length() > length ? true : false;
	}

	public static boolean checkEmptyLengthAndNumber(String field, int length) {
		return !field.isEmpty() && field.length() <= length && isNumeric(field) ? true : false;
	}

	public static boolean checkEmptyLengthAndEmail(String field, int length) {
		return !field.isEmpty() && field.length() <= length && validateEmailAddress(field) ? true : false;
	}

	public static boolean checkNotEmptyLengthAndEmail(String field, int length) {
		return !field.isEmpty() && (field.length() > length || validateEmailAddress(field)) ? true : false;
	}

	public static Validator getValidator() {
		return factory.getValidator();
	}

}

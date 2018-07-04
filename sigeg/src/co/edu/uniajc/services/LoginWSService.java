package co.edu.uniajc.services;

import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.dataaccess.dao.CFMenu;
import co.edu.dataaccess.dao.Usuario;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;

@CrossOrigin
@RestController
public class LoginWSService {
	private static final Logger log = LoggerFactory.getLogger(LoginWSService.class);
	private static String secretKey = "Un14jc2018!!.";

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseService login(@RequestParam String usr, @RequestParam String pas) {

		ResponseService responseService = new ResponseService();
		BusinessDelegatorView businessDelegatorView = new BusinessDelegatorView();
		Map<String, Object> data = new HashMap<>();
		try {

		//String userDecrypt = decrypt(usr);
			//List<Object> usua = businessDelegatorView
					//.getFindCriteriaGeneric(Usuario.class, "username = ? and password = ? ", new Object[] { userDecrypt, pas });

			if (1==2) {

				responseService.setData(data);
				responseService.setStatus(Status.FAILURE);
				responseService.setMessage("Usuario/Contraseña incorrecto");
			} else {
				/*Usuario user = ((Usuario) usua.get(0));
				Long id = user.getId();
				String name = user.getName();
				String username = user.getUsername();
				Long rol = user.getIdRol();*/

				data.put("nombre", "Luis alejandro");
				data.put("id", "1");
				data.put("username", "admin");
				data.put("token", "token-admin");

				//if (rol == 1) {
					//List<Object> listMenu = businessDelegatorView.getAllEntities(CFMenu.class);
					//data.put("menu", listMenu);
				//}
				responseService.setData(data);
				responseService.setStatus(Status.OK);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(e.getMessage());
		}

		return responseService;
	}

	public String decrypt(String value) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, DigestException {

		byte[] cipherData = Base64.getDecoder().decode(value);
		byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);

		MessageDigest md5 = MessageDigest.getInstance("MD5");
		final byte[][] keyAndIV = generateKeyAndIV(32, 16, 1, saltData, secretKey.getBytes(StandardCharsets.UTF_8), md5);
		SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
		IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);

		byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
		Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
		aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] decryptedData = aesCBC.doFinal(encrypted);
		return new String(decryptedData, StandardCharsets.UTF_8);
	}

	public static byte[][] generateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md) throws DigestException {

		int digestLength = md.getDigestLength();
		int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
		byte[] generatedData = new byte[requiredLength];
		int generatedLength = 0;

		try {
			md.reset();

			// Repeat process until sufficient data has been generated
			while (generatedLength < keyLength + ivLength) {

				// Digest data (last digest if available, password data, salt if available)
				if (generatedLength > 0)
					md.update(generatedData, generatedLength - digestLength, digestLength);
				md.update(password);
				if (salt != null)
					md.update(salt, 0, 8);
				md.digest(generatedData, generatedLength, digestLength);

				// additional rounds
				for (int i = 1; i < iterations; i++) {
					md.update(generatedData, generatedLength, digestLength);
					md.digest(generatedData, generatedLength, digestLength);
				}

				generatedLength += digestLength;
			}

			// Copy key and IV into separate byte arrays
			byte[][] result = new byte[2][];
			result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
			if (ivLength > 0)
				result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);

			return result;

		} finally {
			// Clean out temporary data
			Arrays.fill(generatedData, (byte) 0);
		}
	}

}

package dao;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.sql.DataSource;

public class UserDAO {
	public DataSource ds;
	public boolean loggedIn = false;
	public String username = null;
	
	public UserDAO(DataSource ds) {
		this.ds = ds;
	}

	public void registerUser(String username, String password, String fname, String lname, String phonenumber, String email,
			String street, String country, String zip) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
		//register address
		String query = "Select COUNT(*) From Address";
		Statement st = ds.getConnection().createStatement();
		ResultSet rs = st.executeQuery(query);
		int addressId = rs.getInt(1)+1;
		String query1 = "INSERT INTO Address (id, street, country, zip, phone) VALUES (?,?,?,?,?)";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query1);
		p.setInt(1, addressId);
		p.setString(2, street);
		p.setString(3, country);
		p.setString(4, zip);
		p.setString(5, phonenumber);
		p.executeQuery();
		
		String query3 = "INSERT INTO User (username, password, fname, lname, address, email) VALUES (?,?,?,?,?,?)";
		PreparedStatement p2 = con.prepareStatement(query3);
		p2.setString(1, username);
		String generatedSecuredPasswordHash = generateStorngPasswordHash(password);
		p2.setString(2, generatedSecuredPasswordHash);
		p2.setString(3, fname);
		p2.setString(4, lname);
		p2.setInt(5 ,addressId);
		p2.setString(6, email);
		p2.executeQuery();
		
	}
	
	public Boolean passwordMatch(String username, String password) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
		String query = "SELECT password FROM User where username = '"+username+"'";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		if(!rs.next()) return false;
		String storedPassword = rs.getString(1);
		if(validatePassword(password, storedPassword)){
			this.loggedIn=true;
			this.username=username;
			return true;
		}
		return false;
	}
	//the code below is for security hashing passwords 
	//source: https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
		private String generateStorngPasswordHash(String password) 
		    throws NoSuchAlgorithmException, InvalidKeySpecException {
		    int iterations = 1000;
		    char[] chars = password.toCharArray();
		    byte[] salt = getSalt();

		    PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
		    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

		    byte[] hash = skf.generateSecret(spec).getEncoded();
		    return iterations + ":" + toHex(salt) + ":" + toHex(hash);
		}

		private byte[] getSalt() throws NoSuchAlgorithmException
		{
		    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		    byte[] salt = new byte[16];
		    sr.nextBytes(salt);
		    return salt;
		}

		private String toHex(byte[] array) throws NoSuchAlgorithmException
		{
		    BigInteger bi = new BigInteger(1, array);
		    String hex = bi.toString(16);
		    
		    int paddingLength = (array.length * 2) - hex.length();
		    if(paddingLength > 0)
		    {
		        return String.format("%0"  +paddingLength + "d", 0) + hex;
		    }else{
		        return hex;
		    }
		}
		
		private boolean validatePassword(String originalPassword, String storedPassword) 
			    throws NoSuchAlgorithmException, InvalidKeySpecException
			{
			    String[] parts = storedPassword.split(":");
			    int iterations = Integer.parseInt(parts[0]);

			    byte[] salt = fromHex(parts[1]);
			    byte[] hash = fromHex(parts[2]);

			    PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), 
			        salt, iterations, hash.length * 8);
			    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			    byte[] testHash = skf.generateSecret(spec).getEncoded();

			    int diff = hash.length ^ testHash.length;
			    for(int i = 0; i < hash.length && i < testHash.length; i++)
			    {
			        diff |= hash[i] ^ testHash[i];
			    }
			    return diff == 0;
			}
			private byte[] fromHex(String hex) throws NoSuchAlgorithmException{
			    byte[] bytes = new byte[hex.length() / 2];
			    for(int i = 0; i < bytes.length ;i++)
			    {
			        bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
			    }
			    return bytes;
			}
}

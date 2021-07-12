import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class Cep{

// Consumindo API pública externa
			
			URL url = new URL("https://viacep.com.br/ws/"+usuario.getCep()+"/json/");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			String cep = "";
			StringBuilder jsonCEP = new StringBuilder();
			
			while((cep = br.readLine()) != null) {
				jsonCEP.append(cep);
			}
			
			System.out.println(jsonCEP.toString());
		
			Usuario userAux = new Gson().fromJson(jsonCEP.toString(), Usuario.class);
			
			usuario.setCep(userAux.getCep());
			usuario.setLogradouro(userAux.getLogradouro());
			usuario.setComplemento(userAux.getComplemento());
			usuario.setBairro(userAux.getBairro());
			usuario.setLocalidade(userAux.getLocalidade());
			usuario.setUf(userAux.getUf());
		
    // Fim da API externa
	}

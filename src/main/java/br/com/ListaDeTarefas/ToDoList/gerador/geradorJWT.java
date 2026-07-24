package br.com.ListaDeTarefas.ToDoList.gerador;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.beans.Encoder;

public class geradorJWT {

    public static void main(String[] args) {

        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String base64 = Encoders.BASE64.encode(key.getEncoded());

        System.out.println(base64);

    }
}

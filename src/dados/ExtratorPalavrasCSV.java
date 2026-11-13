package dados; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import modelo.Nivel;
import modelo.Palavra;

public class ExtratorPalavrasCSV {

    public static ArrayList<Palavra> extrairPalavras(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists() || !arquivo.isFile()) {
            return null;
        }

        ArrayList<Palavra> palavras = new ArrayList<Palavra>();

        try (BufferedReader leitor = new BufferedReader(
                new InputStreamReader(new FileInputStream(arquivo), StandardCharsets.UTF_8))) {

            String linha;
            boolean primeira = true;
            while ((linha = leitor.readLine()) != null) {
                if (primeira) {
                    linha = linha.replace("\uFEFF", ""); // Remove BOM
                    primeira = false;
                }
                if (linha.trim().isEmpty()) {
                    continue;
                }

                
                String[] partes = linha.split(",", 4);
                if (partes.length != 4) {
                    continue; 
                }

                
                String palavra = partes[1].trim();
                String dica = partes[3].trim();
                
                if (palavra.isEmpty() || dica.isEmpty()) {
                    continue;
                }

                Nivel nivel;
                try {
                    nivel = converterNivel(Integer.parseInt(partes[2].trim()));
                } catch (NumberFormatException e) {
                    continue;
                }
                
                if (nivel == null) {
                    continue;
                }

                
                palavras.add(new Palavra(palavra, nivel, dica));
            }
        } catch (IOException e) {
            return null;
        }

        return palavras;
    }

    private static Nivel converterNivel(int codigo) {
        switch (codigo) {
        case 0:
            return Nivel.FACIL;
        case 1:
            return Nivel.NORMAL; 
        case 2:
            return Nivel.DIFICIL;
        default:
            return null;
        }
    }
}
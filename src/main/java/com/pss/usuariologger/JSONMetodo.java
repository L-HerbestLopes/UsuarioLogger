package com.pss.usuariologger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class JSONMetodo implements ILoggerMetodo {

    @Override
    public void registrar(String mensagem) {
        Logger logger = Logger.getInstancia();
        Path caminhoPath = Paths.get(logger.getCaminhoArquivo() + "log.json");
        
        if(!Files.exists(caminhoPath)) criarArquivo();
        
        String mensagemFormatada = "{\"mensagem\": \"" + mensagem + "\"}";
        
        try {
            Files.writeString(caminhoPath, mensagemFormatada);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void criarArquivo() {
        Logger logger = Logger.getInstancia();
        Path caminhoPath = Paths.get(logger.getCaminhoArquivo() + "log.json");
        
        if (!Files.exists(caminhoPath)) {
            try {
                Files.createFile(caminhoPath);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}

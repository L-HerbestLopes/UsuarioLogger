package com.pss.usuariologger;


public class UsuarioLogger {

    public static void main(String[] args) {
        Logger log = Logger.getInstancia();
        log.configurar(new CSVMetodo(';'));
        
        log.registrar("Mensagem aqui");
    }
}

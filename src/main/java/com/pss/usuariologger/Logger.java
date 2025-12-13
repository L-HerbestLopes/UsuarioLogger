package com.pss.usuariologger;


public class Logger {
    private static Logger instancia;
    private ILoggerMetodo metodo;
    
    private Logger(ILoggerMetodo metodo) {
        this.metodo = metodo;
    }
    
    public static Logger getInstancia() {
        if(instancia == null) {
            instancia = new Logger(new JSONMetodo());
        }
        
        return instancia;
    }
    
    public void configurar(ILoggerMetodo metodo) {
        this.metodo = metodo;
    }
    
    public void registrar(String mensagem) {
        metodo.registrar(mensagem);
    }
}

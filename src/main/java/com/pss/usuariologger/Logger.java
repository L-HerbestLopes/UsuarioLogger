package com.pss.usuariologger;


public class Logger {
    private static Logger instancia;
    private ILoggerMetodo metodo;
    private String caminhoArquivo;
    
    private Logger(ILoggerMetodo metodo) {
        this.metodo = metodo;
        
        String diretorio = System.getProperty("user.dir");
        System.out.println(diretorio);
    }
    
    public static Logger getInstancia() {
        if(instancia == null) {
            instancia = new Logger(new JSONMetodo());
        }
        
        return instancia;
    }
    
    public void setCaminhoArquivo(String caminho) {
        caminhoArquivo = caminho;
    }
    
    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
    
    public void registrar(String mensagem) {
        metodo.registrar(mensagem);
    }
}

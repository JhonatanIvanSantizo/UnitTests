package unitTest;

public class NotificadorEmail {
    private EmailCliente emailCliente;
    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }
    public void notificar(String direccion, String mensaje) {
        if (direccion == null || direccion.isEmpty() || mensaje == null || mensaje.isEmpty()) {
            return; // Do not call enviarCorreo if the input is invalid
        }
        emailCliente.enviarCorreo(direccion, mensaje);
    }
}

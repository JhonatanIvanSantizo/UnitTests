package unitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {
    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar(){
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com","Hola mundo");

        verify(emailClienteMock).enviarCorreo("ejemplo@test.com","Hola mundo");
    }

    @Test
    public void testNotificarConDireccionVacia(){
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("","Hola mundo");

        verify(emailClienteMock, times(0)).enviarCorreo(anyString(),anyString());
    }

    @Test
    public void testNotificarConMensajeNulo(){
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com",null);

        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), isNull());
    }

    @Test
    public void testNotificarConDireccionNula() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar(null, "Mensaje");

        verify(emailClienteMock, times(0)).enviarCorreo(isNull(), anyString());
    }

    @Test
    public void testNotificarConMensajeVacio() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "");

        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), eq(""));
    }

}
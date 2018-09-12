/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import org.apache.log4j.Logger;
/**
 *
 * @author fernando
 */
public class ConexionServidor  {
    
    //private Logger log = Logger.getLogger(ConexionServidor.class);
    private Socket socket; 
    private JTextField tfMensaje;
    private String usuario;
    private DataOutputStream salidaDatos;
    
    public ConexionServidor(Socket socket, JTextField tfMensaje, String usuario) {
        this.socket = socket;
        this.tfMensaje = tfMensaje;
        this.usuario = usuario;
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Salida de datos::::.");
            salidaDatos.writeUTF(usuario + ": " + tfMensaje.getText() );
            
        } catch (IOException ex) {
            System.out.println("Error al crear el stream de salida : " + ex.getMessage());
//log.error("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("El socket no se creo correctamente. ");
//log.error("El socket no se creo correctamente. ");
        }
    }

    
    public void actionPerformed(ActionEvent e) {
        try {
            
            tfMensaje.setText("");
            System.out.println("Entro aqui:::::");
        } catch (IOException ex) {
            System.out.println("Error al intentar enviar un mensaje: " + ex.getMessage());
            //log.error("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }
    
    /**
     * Recibe los mensajes del chat reenviados por el servidor
     */
    public void recibirMensajesServidor(JTextArea mensajesChat){
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("\"Error al crear el stream de entrada: \" + ex.getMessage()");
//log.error("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("El socket no se creo correctamente. ");
//log.error("El socket no se creo correctamente. ");
        }
        
        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();
                mensajesChat.append(mensaje + System.lineSeparator());
            } catch (IOException ex) {
                    System.out.println("Error al leer del stream de entrada: " + ex.getMessage());
//log.error("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                System.out.println("El socket no se creo correctamente. ");
//log.error("El socket no se creo correctamente. ");
                conectado = false;
            }
        }
    }
}

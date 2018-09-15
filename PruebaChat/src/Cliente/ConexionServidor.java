/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import Codificacion.Base;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
//import org.apache.log4j.Logger;
/**
 *
 * @author fernando
 */
public class ConexionServidor implements ActionListener  {
    
    //private Logger log = Logger.getLogger(ConexionServidor.class);
    private Socket socket; 
    private JTextField tfMensaje;
    private String usuario;
    private DataOutputStream salidaDatos;

    private JTextField baseFin;
    private Base objBase = new Base();
    private JTextField destino;
    
    
    public ConexionServidor(Socket socket, JTextField tfMensaje, String usuario, JTextField base1, JTextField des) {
        this.socket = socket;
        this.tfMensaje = tfMensaje;
        this.usuario = usuario;
        this.baseFin = base1;
        this.destino = des;
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
            
        } catch (IOException ex) {
            System.out.println("Error al crear el stream de salida : " + ex.getMessage());
//log.error("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("El socket no se creo correctamente. ");
//log.error("El socket no se creo correctamente. ");
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Aqui iria la codificacion
           // System.out.println("El mensaje:..."+tfMensaje.getText()+"::... la base:...."+baseFin.getText());
            String msg = objBase.obtenerBaseFinal(tfMensaje.getText(), baseFin.getText());
           
            salidaDatos.writeUTF(usuario + ":" + msg +": "+destino.getText());
            
            //tfMensaje.setText("");
        } catch (IOException ex) {
            System.out.println("Error al intentar enviar un mensaje: " + ex.getMessage());
            //log.error("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }
}

package br.com.sd.app.service;

import br.com.sd.app.bean.ChatMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteService {

    private Socket socket;
    private ObjectOutputStream output;

    public Socket connect() {
        try {
            this.socket = new Socket("localhost", 8500);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (UnknownHostException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        return socket;
    }

    public void send(ChatMessage message) {
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}

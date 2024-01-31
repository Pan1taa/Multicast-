import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServidorMulticast {
    public static void main(String[] args) {
        try {
            MulticastSocket socketMulticast = new MulticastSocket();
            InetAddress direccionGrupo = InetAddress.getByName("224.0.0.1");

            String[] palabras = {
                    "Sol", "Luna", "Estrella", "Bosque", "Montaña", "Río", "Mar", "Lago", "Playa", "Cascada",
                    "Flor", "Árbol", "Hoja", "Cielo", "Nube", "Viento", "Rocas", "Desierto", "Pradera",
                    "Animales", "Pájaro", "Mariposa", "Abeja", "Elefante", "León", "Oso", "Tigre", "Zorro",
                    "Ciervo", "Mariscos", "Pez", "Ballena", "Delfín", "Coral", "Ola", "Amanecer", "Atardecer",
                    "Aurora boreal", "Arco iris", "Rayo", "Trueno", "Lluvia", "Nieve", "Hielo", "Aire fresco",
                    "Hierba", "Sombra", "Aroma", "Silencio", "Paz"
            };

            while (true) {
                // Escoge una palabra aleatoria de la lista
                String palabraAleatoria = palabras[new Random().nextInt(palabras.length)];

                // Envía la palabra al grupo multicast
                byte[] datosEnvio = palabraAleatoria.getBytes();
                DatagramPacket paqueteEnvio = new DatagramPacket(datosEnvio, datosEnvio.length, direccionGrupo, 9876);
                socketMulticast.send(paqueteEnvio);

                // Duerme para simular intervalos entre palabras
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

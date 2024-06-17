import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.Random;

public class MqttPublisher {

    public static void main(String[] args) {
        String broker = "tcp://broker.emqx.io:1883";
        String clientId = "JavaMatrixPublisher";
        String topic = "TarakanovVladislav/matrix";
        int qos = 2;

        try {
            MqttClient client = new MqttClient(broker, clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            client.connect(connOpts);
            Gson gson = new Gson();
            Random random = new Random();

            while (true) {
                int[][] matrix = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrix[i][j] = random.nextInt(21);
                    }
                }

                String matrixJson = gson.toJson(matrix);
                MqttMessage message = new MqttMessage(matrixJson.getBytes());
                message.setQos(qos);
                client.publish(topic, message);

                System.out.println("Published matrix: ");
                for (int[] row : matrix) {
                    for (int element : row) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }

                Thread.sleep(4000);
            }

        } catch (MqttException | InterruptedException me) {
            me.printStackTrace();
        }
    }
}

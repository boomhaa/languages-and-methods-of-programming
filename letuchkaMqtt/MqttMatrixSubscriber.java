import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttMatrixSubscriber {

    public static void main(String[] args) {
        String broker = "tcp://broker.emqx.io:1883";
        String clientId = "JavaMatrixSubscriber";
        String topic = "TarakanovVladislav/matrix";
        int qos = 2;

        try {
            MqttClient client = new MqttClient(broker, clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    Gson gson = new Gson();
                    double[][] matrix = gson.fromJson(new String(message.getPayload()), double[][].class);

                    if (isOrthogonal(matrix)) {
                        System.out.println("The matrix is orthogonal.");
                    } else {
                        System.out.println("The matrix is not orthogonal.");
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // No implementation required
                }
            });

            client.connect(connOpts);
            client.subscribe(topic, qos);
        } catch (MqttException me) {
            me.printStackTrace();
        }
    }

    private static boolean isOrthogonal(double[][] matrix) {
        int n = matrix.length;
        double[][] transpose = new double[n][n];

        // Calculate transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }

        // Check if matrix * transpose is identity
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += matrix[i][k] * transpose[k][j];
                }
                if (i == j && Math.abs(sum - 1) > 1e-6) {
                    return false;
                } else if (i != j && Math.abs(sum) > 1e-6) {
                    return false;
                }
            }
        }

        return true;
    }
}

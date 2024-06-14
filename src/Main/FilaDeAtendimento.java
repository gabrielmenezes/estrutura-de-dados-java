package Main;

import dataStructure.Queue;

import java.util.Random;

public class FilaDeAtendimento {

    public static void main(String[] args) {
        int n = 5;
        var random = new Random();
        int client = random.nextInt(101);
        Queue myQueue = new Queue(client);
        System.out.println("Chegou o cliente: " + client);

        for(int i = 2; i < n; i++){
            client = random.nextInt(101);
            System.out.println("Chegou o cliente: " + client);
            myQueue.enqueue(client);
        }

        var node = myQueue.dequeue();
        while (node != null){
            System.out.println("Atendido o cliente: " + node.getValue());
            node = myQueue.dequeue();
        }

    }
}

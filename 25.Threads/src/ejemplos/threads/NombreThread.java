package ejemplos.threads;

public class NombreThread extends Thread {
    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() { // Comienza el hilo
        System.out.println("Se inicia el metodo run del hilo " + getName());

        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName());
        }

        System.out.println("Finaliza el hilo " + this.getName());
    }
}

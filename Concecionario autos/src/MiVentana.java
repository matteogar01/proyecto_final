import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MiVentana extends JFrame {

    public MiVentana() {

        setTitle("Concecionario de vehiculos");
        setSize(364, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        // Panel para botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 2)); // 5 filas y 2 columnas para 10 botones



        // Crear botones y agregar acciones
        JButton button1 = new JButton("Ver placas motos");
        buttonPanel.add(button1);


        JButton button2 = new JButton("buscar placa");
        JLabel mensaje = new JLabel("el mensaje que quieras escribir");
        buttonPanel.add(button2);


        JButton button3 = new JButton("Agregar vehiculo");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "el carro mas  barato es " + "spark", "Carro mas  barato", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(button3);

        JButton button4 = new JButton("ordenar vehiculo");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "el carro mas  barato es " + "spark", "Carro mas  barato", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        buttonPanel.add(button4);

        JButton button5 = new JButton("buscar por modelo y año");
        buttonPanel.add(button5);

        JButton button6 = new JButton("Comprar moto");
        buttonPanel.add(button6);

        JButton button7 = new JButton("Promocion");
        buttonPanel.add(button7);

        JButton button8 = new JButton("Mas antiguo");
        buttonPanel.add(button8);

        JButton button9 = new JButton("Mas barato");
        buttonPanel.add(button9);

        JButton button10 = new JButton("Mas CC");
        buttonPanel.add(button10);
        // Continúa creando y agregando botones individualmente

        panel.add(buttonPanel, BorderLayout.WEST);
        getContentPane().add(panel);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MiVentana miInterfaz = new MiVentana();
                miInterfaz.setVisible(true);
            }
        });
    }
}

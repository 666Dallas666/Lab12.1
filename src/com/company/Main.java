package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
enum Planet {
    Меркурий(3.3e+23, 2.42e+6),
    Венера(4.9e+24, 6.1e+6),
    Земля(6e+24, 6.4e+6),
    Марс(6.4e+23, 3.4e+6),
    Юпитер(1.9e+27, 7.1e+6),
    Сатурн(5.7e+26, 6e+6),
    Уран(8.7e+25, 2.6e+6),
    Нептун(1e+26, 2.5e+6);
    private double weight, radius;
    private double ConstGrav = 6.7e-11;
    Planet(double weight, double radius){
        this.weight = weight;
        this.radius = radius;
    }
    public double getGravity(){
        return (ConstGrav * weight / Math.pow(radius, 2));
    }
}
class PlanetGUI {
    JFrame frame;
    JPanel jpanel;
    JLabel label, label1;
    JComboBox selector;
    PlanetGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        jpanel = new JPanel();
        label = new JLabel("Выберите планету:");
        selector = new JComboBox(Planet.values());
        label1 = new JLabel();
        jpanel.setLayout(new GridLayout(3,0));
        jpanel.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
        frame.add(jpanel);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        jpanel.add(label);
        selector.setSize(100,20);
        jpanel.add(selector);
        jpanel.add(label1);
        selector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Planet test = (Planet)selector.getSelectedItem();
                label1.setText(test.name() + ": Гравитация равна " + test.getGravity());
            }
        });
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new PlanetGUI();
    }
}
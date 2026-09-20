package br.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;


public class Display {

    private JFrame jframe;
    private Canvas canvas;

    
    public Display(String title, int width, int height) {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        
        // Garante que o Canvas aceita o foco de entrada
        canvas.setFocusable(true);
        
        jframe = new JFrame(title);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        
        jframe.setFocusable(true); // PARA NÃO ROUBAR A CARACTERÍSTICA DE PRESSIONAMENTO DA TECLA DO KEYLISTENER
        jframe.add(canvas);
        jframe.pack();

        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

        // Solicita o foco de entrada imediatamente após exibir a janela
        canvas.requestFocus();
        jframe.requestFocus();

        // Diagnóstico: ao clicar na janela, força o foco e imprime o estado no terminal
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                canvas.requestFocusInWindow();
                jframe.requestFocusInWindow();
                System.out.println("Janela clicada - Tem foco? (Canvas: " + canvas.hasFocus() + " | JFrame: " + jframe.hasFocus() + ")");
            }
        });
    }
    
    public BufferStrategy getBufferStrategy() {
        return canvas.getBufferStrategy();
    }
    
    public void createBufferStrategy() {
        canvas.createBufferStrategy(3);
    }
    
    // CONTROLE DE TECLADO
    public void setKeyListener(KeyListener k1) {
        jframe.addKeyListener(k1); // JFRAME RECEBE OS EVENTOS DE CLIQUE
        canvas.addKeyListener(k1); // ADICIONADO TAMBÉM AO CANVAS (evita perda de eventos se o Canvas capturar o foco)
    }
}
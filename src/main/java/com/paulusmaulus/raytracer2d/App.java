package com.paulusmaulus.raytracer2d;

import javax.swing.JFrame;

public final class App extends JFrame implements Runnable {

    public App() {
        super();
    }

    public static void main(String[] args) {
        App app = new App();

        app.setSize(720, 720);
        app.setTitle("2D Ray-Tracing game engine");
        app.setVisible(true);
        app.run();
    }

    @Override
    public void repaint() {
        // TODO Rendering logic?
        super.repaint();
    }

    @Override
    public void run() {
        while (true) {
            repaint();
        }
    }
}

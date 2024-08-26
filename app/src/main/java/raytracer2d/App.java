package raytracer2d;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.List;

import raytracer2d.assets.gameObjects.Player;
import raytracer2d.core.Game;
import raytracer2d.core.Renderer;
import raytracer2d.utils.core.Renderable;
import raytracer2d.utils.core.Scene;
import raytracer2d.utils.interfaces.Modification;
import raytracer2d.utils.interfaces.Rule;
import raytracer2d.utils.math.Vector;
import raytracer2d.utils.rendering.Color;
import raytracer2d.utils.res.Audio;

public class App {
    public static void main(String[] args) {

        Game game = new Game();
        game.setSize(720, 720);
        game.setTitle("2D Ray-Tracing game engine");
        game.setVisible(true);

        game.setRenderer(new Renderer() {

            // Create a BufferedImage for double buffering
            private BufferedImage buffer = new BufferedImage(game.getWidth(), game.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);

            @Override
            public void render(Graphics gfx, Scene scene) {
                Graphics2D bufferGfx = buffer.createGraphics();
                bufferGfx.clearRect(0, 0, game.getWidth(), game.getHeight());

                for (Renderable renderable : scene.getRenderables()) {
                    renderable.draw(bufferGfx);
                }

                gfx.drawImage(buffer, 0, 0, null);
                bufferGfx.dispose();
            }

        });

        Player player = new Player(new Vector(360, 360), game);
        Vector playerDelta = new Vector(0, 0);

        /*
         * game.addKeyListener(new KeyListener() {
         * 
         * @Override
         * public void keyPressed(KeyEvent e) {
         * switch (e.getKeyCode()) {
         * case KeyEvent.VK_W -> playerDelta.setY(-1);
         * case KeyEvent.VK_A -> playerDelta.setX(-1);
         * case KeyEvent.VK_D -> playerDelta.setX(1);
         * case KeyEvent.VK_S -> playerDelta.setY(1);
         * }
         * }
         * 
         * @Override
         * public void keyReleased(KeyEvent e) {
         * switch (e.getKeyCode()) {
         * case KeyEvent.VK_W -> playerDelta.setY(0);
         * case KeyEvent.VK_A -> playerDelta.setX(0);
         * case KeyEvent.VK_D -> playerDelta.setX(0);
         * case KeyEvent.VK_S -> playerDelta.setY(0);
         * }
         * }
         * 
         * @Override
         * public void keyTyped(KeyEvent e) {
         * }
         * 
         * });
         */

        game.getPhysicsEngine().add(new Rule() {

            @Override
            public boolean applies() {
                return (player.getPos().add(playerDelta).x - 25 > 0
                        && player.getPos().add(playerDelta).y - 25 > 0)
                        && (player.getPos().add(playerDelta).x + 25 < game.getWidth()
                                && player.getPos().add(playerDelta).y + 25 < game.getHeight());
            }

            @Override
            public List<Modification> getModifications() {
                return List.of(() -> {
                    player.setPos(player.getPos().add(new Vector(0, .981)));
                });
            }

        });

        game.getPhysicsEngine().add(new Rule() {

            @Override
            public boolean applies() {
                return true;
            }

            @Override
            public List<Modification> getModifications() {
                return List.of(() -> {
                    player.setColor(
                            new Color((int) ((player.getPos().x / game.getWidth()) * 255),
                                    (int) ((player.getPos().y / game.getHeight()) * 255), 0));
                });
            }

        });

        Scene scene = new Scene("Test");
        scene.add(player);
        game.getSceneManager().setCurrentScene(scene);

        game.getResourceManager().addAudio(
                new Audio("src\\main\\java\\com\\paulusmaulus\\raytracer2d\\assets\\sounds\\example.wav", "Example"));

        game.getMainLoop().add(() -> game.getPhysicsEngine().run());
        game.getMainLoop().add(() -> game.repaint());

        game.run();
    }

}

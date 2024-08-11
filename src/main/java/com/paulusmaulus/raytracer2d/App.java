package com.paulusmaulus.raytracer2d;

import com.paulusmaulus.raytracer2d.assets.gameObjects.Player;
import com.paulusmaulus.raytracer2d.core.Game;
import com.paulusmaulus.raytracer2d.utils.core.Scene;
import com.paulusmaulus.raytracer2d.utils.math.Vector;

public class App {
    public static void main(String[] args) {

        Game game = new Game();
        game.setSize(720, 720);
        game.setTitle("2D Ray-Tracing game engine");
        game.setVisible(true);

        Player player = new Player(new Vector(0, 0), game);

        Scene scene = new Scene("Test");
        scene.add(player);
        game.getSceneManager().setCurrentScene(scene);

        game.getMainLoop().add(() -> {
            game.getAudioPlayer().play("Example");
        });

        game.run();
    }

}

# Basic concept

## Description

2D Game engine written in Java. Ray-Tracing for lighting/LOS determination/Rendering. (WIP)

## Component functionality

### AudioPlayer

Allows loading/playing of **Audio**s in 2D space

```Java
class AudioPlayer {
    static void play(Audio audio, int x, int y, double loudness)
}
```

### GameLoop

Defines the order of operations (**Action**s)

```Java
class GameLoop {
    List<Action> actions

    void add(Action action)
    void run() {
        foreach(action : actions)
            action.run()
    }
}
```

### InputHandler

Basically a buch of Key- and MouseListeners strapped together, which run **Modification**s

```Java
class InputHandler {
    Set<Integer> pressedKeys
    Set<Integer> pressedMouseButtons
    HashMap<Integer, Modification> keyModifications
    HashMap<Integer, Modification> buttonModifications
    int mouseX
    int mouseY

    boolean isKeyPressed(int key)
    boolean isMouseButtonPressed(int button)
    void addKeyModification(int key, Modification mod)
    void addButtonModification(int key, Modification mod)
    boolean hasMouseMoved(int origX, int origY, int deadzone)
    int getMouseX()
    int getMouseY()

    void run() {
        foreach(key : pressedKeys)
            if (keyModifications.has(e.keyCode))
                keyModifications.get(e.keyCode).run()
        foreach(button : pressedMouseButton)
            if (buttonModifications.has(e.button))
                buttonModifications.get(e.button).run()
    }

    // KeyListener methods
    ...

    // MouseListener methods
    ...

    // MouseMoveListener methods
    ...

}
```

### PhysicsEngine

Checks if **Rule**s are met and runs **Modification**s accordingly

```Java
class PhysiscsEngine {
    List<Rule> rules

    void addRule(Rule rule)
    void run() {
        foreach(rule : rules)
            if (rule.applies())
                rule.runMods()
    }
}
```

### Renderer

Renders the image

Note: Renderer NEEDS to be written for each game and does not rely on components like the rest (too complicated)

```Java
abstract class Renderer {
    static void render()
}
```

### ResourceManager

Place for loading and storing the resources (audios, sprites/textures, tilemaps, ...)

```Java
class ResourceManager {
    List<Resource> resources

    void load(File... files)
    Resource get(String resName)
}
```

### SceneManager

For storing, selecting and switching scenes

```Java
class SceneManager {
    List<Scene> scenes
    int currentScene

    void add(Scene... scene)
    Scene get(int id)
    Scene get(String sceneName)
    void next() {
        currentScene++
    }
}
```

### UISystem

For creating, managing and showing UIElements

```Java
class UISystem {
    List<UIElement> elements
    List<UI> uis

    void add(UI... uis)
    void add(UIElement... elements)
    UI get(int id)
    UI get(String sceneName)
}
```

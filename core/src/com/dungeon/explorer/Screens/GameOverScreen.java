package com.dungeon.explorer.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dungeon.explorer.DungeonExplorer;
import com.dungeon.explorer.Scenes.Hud;
import com.dungeon.explorer.Sprites.Player;

public class GameOverScreen implements Screen {
    private Viewport viewport;
    private Stage stage;

    private Game game;

    public GameOverScreen(Game game) {
        this.game = game;
        viewport = new FitViewport(DungeonExplorer.V_WIDTH, DungeonExplorer.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, ((DungeonExplorer) game).batch);

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        Label gameOverLabel = new Label("GAME OVER", font);
//        Label playAgainLabel = new Label("Click to Play Again", font);

        table.add(gameOverLabel).expandX();
//        table.row();
//        table.add(playAgainLabel).expandX().padTop(10);


        stage.addActor(table);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            Player.setPlayerIsDead(false);
            // TODO Détruire les instances de Ninja et de Men
            dispose();
            game.setScreen(new PlayScreen((DungeonExplorer) game));
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}

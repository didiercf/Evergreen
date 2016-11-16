package com.evergreen.titz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

/**
 * Created by 1458214 on 2016-11-15.
 */
public class MainMenu implements Screen {

    final CharacterCustomization game;

    private Stage stage;
    private Skin skin;
    private Table table;
    private Button button;

    public MainMenu(final CharacterCustomization game) {
        this.game = game;

        stage = new Stage();
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        table = new Table(skin);
        table.setFillParent(true);
    }

    @Override
    public void show() {
        TextButton button1 = new TextButton("click me", skin);

        table.add(button1);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
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

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

    public MainMenu(final CharacterCustomization game) {
        this.game = game;

        stage = new Stage();
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        table = new Table(skin);


    }

    @Override
    public void show() {
        Label nameLabel = new Label("Name:", skin);
        TextField nameText = new TextField("", skin);
        Label addressLabel = new Label("Address:", skin);
        TextField addressText = new TextField("", skin);

        table.add(nameLabel).expandX();
        table.add(nameText).width(100);
        table.row();
        table.add(addressLabel);
        table.add(addressText).width(100);

        table.setPosition(200, 200);
        table.setDebug(true);

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

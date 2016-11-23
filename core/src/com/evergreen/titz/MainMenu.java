package com.evergreen.titz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class MainMenu implements Screen {

    final String[] chestWears = { "Chainmail", "Leather Jacket", "Winter Coat", "Naked" };

    int indexChestWear = 0;

    final CharacterCustomization game;

    private Stage stage;
    private Skin skin;
    private Table table;

    public MainMenu(final CharacterCustomization game) {
        this.game = game;

        stage = new Stage();
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        table = new Table(skin);

        table.setFillParent(true);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Label placeholder = new Label("", skin);

        Label headLabel = new Label("Head : ", skin);
        Label chestLabel = new Label("Chest : ", skin);
        Label legsLabel = new Label("Legs : ", skin);
        Label feetLabel = new Label("Feet : ", skin);

        final TextField currentHeadPiece = new TextField("Hat", skin);
        final TextField currentChestPiece = new TextField(chestWears[indexChestWear], skin);
        final TextField currentLegPiece = new TextField("Jeans", skin);
        final TextField currentFeetPiece = new TextField("Crocs", skin);

        currentHeadPiece.setDisabled(true);
        currentChestPiece.setDisabled(true);
        currentLegPiece.setDisabled(true);
        currentFeetPiece.setDisabled(true);

        TextButton btnHeadLeft = new TextButton("<", skin);
        TextButton btnHeadRight = new TextButton(">", skin);
        TextButton btnChestLeft = new TextButton("<", skin);
        TextButton btnChestRight = new TextButton(">", skin);
        TextButton btnLegLeft = new TextButton("<", skin);
        TextButton btnLegRight = new TextButton(">", skin);
        TextButton btnFeetLeft = new TextButton("<", skin);
        TextButton btnFeetRight = new TextButton(">", skin);

        btnChestRight.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (indexChestWear < chestWears.length - 1)
                    indexChestWear++;
                else
                    indexChestWear = 0;

                currentChestPiece.setText(chestWears[indexChestWear]);
            }
        });

        //Head
        table.add(placeholder);
        table.add(headLabel);
        table.add(placeholder);
        table.row();
        table.add(btnHeadLeft);
        table.add(currentHeadPiece);
        table.add(btnHeadRight);
        table.row();

        //Chest
        table.add(placeholder);
        table.add(chestLabel);
        table.add(placeholder);
        table.row();
        table.add(btnChestLeft);
        table.add(currentChestPiece);
        table.add(btnChestRight);
        table.row();

        //Legs
        table.add(placeholder);
        table.add(legsLabel);
        table.add(placeholder);
        table.row();
        table.add(btnLegLeft);
        table.add(currentLegPiece);
        table.add(btnLegRight);
        table.row();

        //Feet
        table.add(placeholder);
        table.add(feetLabel);
        table.add(placeholder);
        table.row();
        table.add(btnFeetLeft);
        table.add(currentFeetPiece);
        table.add(btnFeetRight);

        table.left();
        table.pad(0, Gdx.graphics.getWidth() / 4 - (table.getMinWidth() / 2),  0, 0);
        //table.setDebug(true);

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

package com.evergreen.titz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;


public class MainMenu extends ScreenAdapter {

    final CharacterCustomization game;

    private Stage stage;
    private Skin skin;
    private Table table;
    private ExtendViewport stageViewPort;
    private CharacterDisplay characterDisplay;

    TextButton btnHeadLeft;
    TextButton btnHeadRight;
    TextButton btnChestLeft;
    TextButton btnChestRight;
    TextButton btnLegLeft;
    TextButton btnLegRight;
    TextButton btnFeetLeft;
    TextButton btnFeetRight;

    final TextField currentHeadPiece;
    final TextField currentChestPiece;
    final TextField currentLegPiece;
    final TextField currentFeetPiece;

    public MainMenu(final CharacterCustomization game) {
        this.game = game;

        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();


        characterDisplay = new CharacterDisplay(new Character(Clothes.EnumHeadWear.METAL_HELM, Clothes.EnumChestWear.LEATHER_JACKET, Clothes.EnumLegWear.METAL_PANTS, Clothes.EnumFootWear.METAL_BOOTS, Genders.MALE));
        stageViewPort = new ExtendViewport(width, height);
        stage = new Stage(stageViewPort);
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        currentHeadPiece = new TextField(Clothes.EnumHeadWear.values()[characterDisplay.indexHeadWear].name, skin);
        currentChestPiece = new TextField(Clothes.EnumChestWear.values()[characterDisplay.indexChestWear].name, skin);
        currentLegPiece = new TextField("Jeans", skin);
        currentFeetPiece = new TextField("Crocs", skin);

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

        btnHeadLeft = new TextButton("<", skin);
        btnHeadRight = new TextButton(">", skin);
        btnChestLeft = new TextButton("<", skin);
        btnChestRight = new TextButton(">", skin);
        btnLegLeft = new TextButton("<", skin);
        btnLegRight = new TextButton(">", skin);
        btnFeetLeft = new TextButton("<", skin);
        btnFeetRight = new TextButton(">", skin);

        currentHeadPiece.setDisabled(true);
        currentChestPiece.setDisabled(true);
        currentLegPiece.setDisabled(true);
        currentFeetPiece.setDisabled(true);

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
        characterDisplay.chooseDisplay(SpritesheetValues.FRONT);

        stage.addActor(table);
        stage.addActor(characterDisplay);

        btnHeadRight.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.nextHead();
                currentHeadPiece.setText(Clothes.EnumHeadWear.values()[characterDisplay.indexHeadWear].name);
            }
        });

        btnHeadLeft.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.previousHead();
                currentHeadPiece.setText(Clothes.EnumHeadWear.values()[characterDisplay.indexHeadWear].name);
            }
        });

        btnChestRight.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.nextChest();
                currentChestPiece.setText(Clothes.EnumChestWear.values()[characterDisplay.indexChestWear].name);		
            }
        });

        btnChestLeft.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.previousChest();
                currentChestPiece.setText(Clothes.EnumChestWear.values()[characterDisplay.indexChestWear].name);
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, false);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}

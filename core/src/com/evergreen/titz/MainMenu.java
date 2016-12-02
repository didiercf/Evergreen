package com.evergreen.titz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
import com.badlogic.gdx.utils.viewport.StretchViewport;


public class MainMenu extends ScreenAdapter {

    final CharacterCustomization game;

    private Stage stage;
    private Skin skin;
    private Table table;
    private StretchViewport stageViewPort;
    private CharacterDisplay characterDisplay;

    private final TextField currentSkinPiece;
    private final TextField currentHeadPiece;
    private final TextField currentChestPiece;
    private final TextField currentLegPiece;
    private final TextField currentFeetPiece;

    public MainMenu(final CharacterCustomization game) {
        this.game = game;

        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();


        characterDisplay = new CharacterDisplay(new Character(Traits.EnumHeadWear.METAL_HELM, Traits.EnumChestWear.LEATHER_JACKET, Traits.EnumLegWear.METAL_PANTS, Traits.EnumFootWear.METAL_BOOTS));
        stageViewPort = new StretchViewport(width, height);
        stage = new Stage(stageViewPort);
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        currentSkinPiece = new TextField(Traits.EnumSkins.values()[characterDisplay.indexSkinType].name, skin);
        currentHeadPiece = new TextField(Traits.EnumHeadWear.values()[characterDisplay.indexHeadWear].name, skin);
        currentChestPiece = new TextField(Traits.EnumChestWear.values()[characterDisplay.indexChestWear].name, skin);
        currentLegPiece = new TextField(Traits.EnumLegWear.values()[characterDisplay.indexLegWear].name, skin);
        currentFeetPiece = new TextField(Traits.EnumFootWear.values()[characterDisplay.indexFeetWear].name, skin);

        table = new Table(skin);

        table.setFillParent(true);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Label placeholder = new Label("", skin);

        Label skinLabel = new Label("Skin : ", skin);
        Label headLabel = new Label("Head : ", skin);
        Label chestLabel = new Label("Chest : ", skin);
        Label legsLabel = new Label("Legs : ", skin);
        Label feetLabel = new Label("Feet : ", skin);

        TextButton btnSkinLeft = new TextButton("<", skin);
        TextButton btnSkinRight = new TextButton(">", skin);
        TextButton btnHeadLeft = new TextButton("<", skin);
        TextButton btnHeadRight = new TextButton(">", skin);
        TextButton btnChestLeft = new TextButton("<", skin);
        TextButton btnChestRight = new TextButton(">", skin);
        TextButton btnLegLeft = new TextButton("<", skin);
        TextButton btnLegRight = new TextButton(">", skin);
        TextButton btnFeetLeft = new TextButton("<", skin);
        TextButton btnFeetRight = new TextButton(">", skin);

        currentSkinPiece.setDisabled(true);
        currentHeadPiece.setDisabled(true);
        currentChestPiece.setDisabled(true);
        currentLegPiece.setDisabled(true);
        currentFeetPiece.setDisabled(true);

        //Skin
        table.add(placeholder);
        table.add(skinLabel);
        table.add(placeholder);
        table.row();
        table.add(btnSkinLeft);
        table.add(currentSkinPiece);
        table.add(btnSkinRight);
        table.row();

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


        //=============Button Listeners=============
        btnSkinRight.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.nextSkin();
                currentSkinPiece.setText(Traits.EnumSkins.values()[characterDisplay.indexSkinType].name);
            }
        });

        btnSkinLeft.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.previousSkin();
                currentSkinPiece.setText(Traits.EnumSkins.values()[characterDisplay.indexSkinType].name);
            }
        });

        btnHeadRight.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.nextHead();
                currentHeadPiece.setText(Traits.EnumHeadWear.values()[characterDisplay.indexHeadWear].name);
            }
        });

        btnHeadLeft.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.previousHead();
                currentHeadPiece.setText(Traits.EnumHeadWear.values()[characterDisplay.indexHeadWear].name);
            }
        });

        btnChestRight.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.nextChest();
                currentChestPiece.setText(Traits.EnumChestWear.values()[characterDisplay.indexChestWear].name);
            }
        });

        btnChestLeft.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.previousChest();
                currentChestPiece.setText(Traits.EnumChestWear.values()[characterDisplay.indexChestWear].name);
            }
        });

        btnLegRight.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.nextLeg();
                currentLegPiece.setText(Traits.EnumLegWear.values()[characterDisplay.indexLegWear].name);
            }
        });

        btnLegLeft.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.previousLeg();
                currentLegPiece.setText(Traits.EnumLegWear.values()[characterDisplay.indexLegWear].name);
            }
        });

        btnFeetRight.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.nextFeet();
                currentFeetPiece.setText(Traits.EnumFootWear.values()[characterDisplay.indexFeetWear].name);
            }
        });

        btnFeetLeft.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                characterDisplay.previousFeet();
                currentFeetPiece.setText(Traits.EnumFootWear.values()[characterDisplay.indexFeetWear].name);
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, false);
    }

    @Override
    public void dispose() {
        stage.dispose();
        characterDisplay.dispose();
    }
}

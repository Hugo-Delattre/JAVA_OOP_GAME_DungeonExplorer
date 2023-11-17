package com.dungeon.explorer.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.dungeon.explorer.DungeonExplorer;
import com.dungeon.explorer.Screens.PlayScreen;

public class Stone extends InteractiveTileObject {

    private PlayScreen screen;

    public Stone(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(DungeonExplorer.WALL_BIT);
        this.screen = screen;
    }

    @Override
    public void onPlayerContact() {
        Gdx.app.log("Stone", "Collision");
        //TODO sound effect stone destroyed
        if (Enemy.enemyCounter <= 0) {
            PlayScreen.currentLevel++;
            Gdx.app.log("Stone", "Reached");
            setCategoryFilter(DungeonExplorer.DESTROYED_BIT);
            screen.setShouldMoveCamera(true);
        }
    }

    public void breakStone() {
        if (Enemy.enemyCounter == 0) {
            Gdx.app.log("STONE", "BREAK");

            if (body != null) {
                world.destroyBody(body);
            }

            TiledMapTileLayer layerToRemove = (TiledMapTileLayer) map.getLayers().get(2); // Remplacer l'index 5 par celui de votre calque de pierres

            if (layerToRemove != null) {
                map.getLayers().remove(layerToRemove);
            }

        }
    }
}


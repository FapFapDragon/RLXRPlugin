package rlxr.util;

import net.runelite.api.Client;
import net.runelite.api.Player;
import rlxr.RLXRConfig;

import java.awt.event.*;
import java.io.Console;

import net.runelite.client.input.KeyManager;


public class CameraControl {

    private  KeyManager key_manager;

    KeyListener key_listener;
    private Client client;

    private Player player;

    private RLXRConfig config;

    private float free_x,free_y,free_z;

    private float pitch_modified, yaw_modified;

    public CameraControl(Client _client, RLXRConfig _config)
    {
        this.client = _client;
        this.config = _config;
    }

    public int getCameraX2()
    {

        if (config.cameraMode() == RLXRConfig.cameraMode.first_person)
        {

            try
            {
                player = client.getLocalPlayer();
                return  player.getLocalLocation().getX();
            }
            catch (NullPointerException e)
            {
                return  client.getCameraX2();
            }
        }
        else
        {
            return client.getCameraX2();
        }
    }

    public int getCameraY2()
    {
        if (config.cameraMode() == RLXRConfig.cameraMode.first_person)
        {

            try
            {
                player = client.getLocalPlayer();
                return  player.getLocalLocation().getY();
            }
            catch (NullPointerException e)
            {
                return  client.getCameraY2();
            }
        }
        else
        {
            return client.getCameraY2();
        }
    }

    public int getCameraZ2()
    {
        if (config.cameraMode() == RLXRConfig.cameraMode.first_person)
        {

            try
            {
                player = client.getLocalPlayer();
                return player.getLogicalHeight();
            }
            catch (NullPointerException e)
            {
                return  client.getCameraZ2();
            }
        }
        else
        {
            return client.getCameraZ2();
        }
    }

    public int getCameraYaw()
    {

        return client.getCameraYaw();
    }

    public int getCameraPitch()
    {
        return client.getCameraPitch();
    }
// Instead of this add a KeyEvent class that will listen for keyboard inputs, add a callback from this function
}

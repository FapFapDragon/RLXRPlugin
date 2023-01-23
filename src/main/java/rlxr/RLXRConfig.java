/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package rlxr;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;
import static rlxr.RLXRPlugin.MAX_DISTANCE;
import static rlxr.RLXRPlugin.MAX_FOG_DEPTH;
import rlxr.config.AntiAliasingMode;
import rlxr.config.ColorBlindMode;
import rlxr.config.UIScalingMode;

@ConfigGroup(RLXRConfig.GROUP)
public interface RLXRConfig extends Config
{
	String GROUP = "RLXR";

	@Range(
			max = MAX_DISTANCE
	)
	@ConfigItem(
			keyName = "drawDistance",
			name = "Draw Distance",
			description = "Draw distance",
			position = 1
	)
	default int drawDistance()
	{
		return 25;
	}

	enum cameraMode
	{
		normal,
		free,
		first_person
	}
	@ConfigItem(
			keyName = "cameraMode",
			name = "Camera mode",
			description = "Changes various Camera Modes",
			position = 12
	)
	default cameraMode cameraMode() {return cameraMode.normal;}

	@ConfigItem(
			keyName = "smoothBanding",
			name = "Remove Color Banding",
			description = "Smooths out the color banding that is present in the CPU renderer",
			position = 2
	)
	default boolean smoothBanding()
	{
		return false;
	}

	@ConfigItem(
			keyName = "antiAliasingMode",
			name = "Anti Aliasing",
			description = "Configures the anti-aliasing mode",
			position = 3
	)
	default AntiAliasingMode antiAliasingMode()
	{
		return AntiAliasingMode.DISABLED;
	}

	@ConfigItem(
			keyName = "uiScalingMode",
			name = "UI scaling mode",
			description = "Sampling function to use for the UI in stretched mode",
			position = 4
	)
	default UIScalingMode uiScalingMode()
	{
		return UIScalingMode.LINEAR;
	}

	@Range(
			max = MAX_FOG_DEPTH
	)
	@ConfigItem(
			keyName = "fogDepth",
			name = "Fog depth",
			description = "Distance from the scene edge the fog starts",
			position = 5
	)
	default int fogDepth()
	{
		return 0;
	}

	@ConfigItem(
			keyName = "useComputeShaders",
			name = "Compute Shaders",
			description = "Offloads face sorting to GPU, enabling extended draw distance. Requires plugin restart.",
			warning = "This feature requires OpenGL 4.3 to use. Please check that your GPU supports this.\nRestart the plugin for changes to take effect.",
			position = 6
	)
	default boolean useComputeShaders()
	{
		return true;
	}


	@Range(
			min = 0,
			max = 16
	)
	@ConfigItem(
			keyName = "anisotropicFilteringLevel",
			name = "Anisotropic Filtering",
			description = "Configures the anisotropic filtering level.",
			position = 7
	)
	default int anisotropicFilteringLevel()
	{
		return 0;
	}

	@Range(
			min = Integer.MIN_VALUE,
			max = Integer.MAX_VALUE
	)
	@ConfigItem(
			keyName = "CameraXOffset",
			name = "X Offset",
			description = "Sets The X Offset.",
			position = 13
	)
	default int CameraXOffset() {return 0;}

	@Range(
			min = Integer.MIN_VALUE,
			max = Integer.MAX_VALUE
	)
	@ConfigItem(
			keyName = "CameraYOffset",
			name = "Y Offset",
			description = "Sets The Y Offset.",
			position = 14
	)
	default int CameraYOffset() {return 0;}

	@Range(
			min = Integer.MIN_VALUE,
			max = Integer.MAX_VALUE
	)
	@ConfigItem(
			keyName = "CameraZOffset",
			name = "Z Offset",
			description = "Sets The Z Offset.",
			position = 15
	)
	default int CameraZOffset() {return 0;}

	@Range(
			min = -150,
			max = Integer.MAX_VALUE
	)
	@ConfigItem(
			keyName = "XRLenseOffset",
			name = "XR Offset",
			description = "Sets The XR Offset.",
			position = 16
	)
	default int XRLenseOffset() {return 0;}

	@Range(
			min = 100,
			max = Integer.MAX_VALUE
	)
	@ConfigItem(
			keyName = "XRFOVScale",
			name = "XR FOV Scale",
			description = "Sets The XR FOV Scale.",
			position = 17
	)
	default int XrFOVScale() {return 100;}

	@ConfigItem(
			keyName = "colorBlindMode",
			name = "Colorblindness Correction",
			description = "Adjusts colors to account for colorblindness",
			position = 8
	)
	default ColorBlindMode colorBlindMode()
	{
		return ColorBlindMode.NONE;
	}

	@ConfigItem(
			keyName = "brightTextures",
			name = "Bright Textures",
			description = "Use old texture lighting method which results in brighter game textures",
			position = 9
	)
	default boolean brightTextures()
	{
		return false;
	}

	@ConfigItem(
			keyName = "unlockFps",
			name = "Unlock FPS",
			description = "Removes the 50 FPS cap for camera movement",
			position = 10
	)
	default boolean unlockFps()
	{
		return false;
	}

	enum SyncMode
	{
		OFF,
		ON,
		ADAPTIVE
	}

	@ConfigItem(
			keyName = "vsyncMode",
			name = "Vsync Mode",
			description = "Method to synchronize frame rate with refresh rate",
			position = 11
	)
	default SyncMode syncMode()
	{
		return SyncMode.ADAPTIVE;
	}

	@ConfigItem(
			keyName = "fpsTarget",
			name = "FPS Target",
			description = "Target FPS when unlock FPS is enabled and Vsync mode is OFF",
			position = 12
	)
	@Range(
			min = 1,
			max = 999
	)
	default int fpsTarget()
	{
		return 60;
	}
}

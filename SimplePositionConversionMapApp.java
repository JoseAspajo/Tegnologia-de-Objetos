package de.fhpotsdam.unfolding.examples;

import processing.core.PApplet;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.examples.marker.SimpleMarkerManagerApp;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.utils.ScreenPosition;

/**
 * Simple map app showing how to convert screen position to geo-location, and vice versa.
 * 
 * For automatic conversion from geo-location to screen, take a look at Unfolding's marker mechanism.
 * Start at {@link SimpleMarkeApp} and {@link SimpleMarkerManagerApp}.
 */
public class SimplePositionConversionMapApp extends PApplet {

	UnfoldingMap map;

	public void setup() {
		size(800, 600, OPENGL);

		map = new UnfoldingMap(this,  new Microsoft.HybridProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
	}

	public void draw() {
		map.draw();

		fill(215, 0, 0, 100);
		// Shows latitude,longitude at mouse position
		Location location = map.getLocation(mouseX, mouseY);
		text("geo:" + location.toString(), mouseX, mouseY);

		// Shows marker at Berlin location
		Location loc = new Location(-16.392140147207392, -71.56738489866257);
		ScreenPosition pos = map.getScreenPosition(loc);
		ellipse(pos.x, pos.y, 20, 20);

		String MicasaDescription = "Mi home xD (" + (int) pos.x + "," + (int) pos.y + ")";
		text(MicasaDescription, pos.x, pos.y);
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { "de.fhpotsdam.unfolding.examples.SimplePositionConversionMapApp" });
	}
}

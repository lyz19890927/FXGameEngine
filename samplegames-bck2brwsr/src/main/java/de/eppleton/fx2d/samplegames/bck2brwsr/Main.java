/**
 * This file is part of FXGameEngine A Game Engine written in JavaFX Copyright
 * (C) 2012 Anton Epple <info@eppleton.de>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. Look for COPYING file in the top folder. If not, see
 * http://opensource.org/licenses/GPL-2.0.
 *
 * For alternative licensing or use in closed source projects contact Anton
 * Epple
 * <info@eppleton.de>
 */
package de.eppleton.fx2d.samplegames.bck2brwsr;

import de.eppleton.fx2d.Level;
import de.eppleton.fx2d.event.KeyCode;
import de.eppleton.fx2d.event.KeyEvent;
import de.eppleton.fx2d.samples.pong.Pong;
import de.eppleton.fx2d.samples.spaceinvaders.SpaceInvaders;
import net.java.html.boot.BrowserBuilder;
import net.java.html.canvas.GraphicsContext;
import org.apidesign.bck2brwsr.core.JavaScriptBody;
import org.apidesign.bck2brwsr.htmlpage.api.On;
import org.apidesign.bck2brwsr.htmlpage.api.OnEvent;
import org.apidesign.bck2brwsr.htmlpage.api.Page;

/**
 * This is the controller class for associated index.html page. The
 * <code>Index</code> is autogenerated by parsing the index.html page. It fields
 * represent individual elements annotated by "id" in the page.
 */
@Page(xhtml = "index.html", className = "Index")
public final class Main {

    private org.apidesign.bck2brwsr.htmlpage.Knockout ko;

   
    /**
     * Launches the browser
     */
    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
                loadPage("de/eppleton/fx2d/samplegames/bck2brwsr/index.html").
                loadClass(Main.class).
                invoke("onPageLoad", args).
                showAndWait();
        System.exit(0);
    }

    public static void onPageLoad(String... args) throws Exception {

//        Logger.getLogger("test").log(Level.SEVERE, "So'n Quatsch");
        Index model = new Index();
//        createImage("TORSO_leather_armor_torso.png");
//         DefaultTileMapSerializationEnvironment ts = new DefaultTileMapSerializationEnvironment();
//        try {
//            ts.readMap("/de/eppleton/tileengine/sample/resources/maps/sample.json");
//        } catch (TileMapException ex) {
//            java.util.logging.Logger.getLogger(DefaultTileMapSerializationEnvironment.class.getName()).log(Level.SEVERE, null, ex);
//        }
        GraphicsContext gc = model.canvas.getContext();
    
        game = new Pong(gc, 800, 600, 800, 600);
        game.start();

    }

    @JavaScriptBody(args = {"src"}, body = "var image = new Image(); image.src = src; return image;")
    private static native Object createImage(String src);

    private static Level game;

    @On(event = OnEvent.KEY_DOWN, id = "canvas")
    static void keyPress(final Index m, int keyCode) {
        KeyCode keyCode1 = KeyCode.getKeyCode(keyCode);
        game.dispatchEvent(new KeyEvent(game, KeyEvent.KEY_PRESSED, keyCode1));
    }

    @On(event = OnEvent.KEY_UP, id = "canvas")
    static void keyRealeased(final Index m, int keyCode) {
        KeyCode keyCode1 = KeyCode.getKeyCode(keyCode);
        game.dispatchEvent(new KeyEvent(game, KeyEvent.KEY_RELEASED, keyCode1));
    }

}

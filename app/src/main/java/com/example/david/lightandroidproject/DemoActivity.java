package com.example.david.lightandroidproject;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.dmacan.lightandroid.type.LightIconDrawable;
import com.dmacan.lightandroid.ui.drawer.DrawerData;
import com.dmacan.lightandroid.ui.drawer.DrawerItem;
import com.dmacan.lightandroid.ui.drawer.DrawerItemHeading;
import com.dmacan.lightandroid.ui.drawer.LightDrawerActivity;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 17.9.2014..
 */
public class DemoActivity extends LightDrawerActivity {

    /**
     * U ovu metodu dodaješ Drawer Iteme koje želiš prikazati u draweru (od gornje prema donjoj)
     * Ako želiš jedan header item i 3 obična, onda radiš ovako:
     * <p/>
     * NAPOMENA: Nikada ne stavljati isti label na dva elementa, jer će biti sranja (taj dio moram srediti kad nađem vremena)
     *
     * @return
     */
    @Override
    public List<DrawerItem> provideDrawerItems() {
        List<DrawerItem> drawerItems = new ArrayList<DrawerItem>();
        // Ako želš font ikonu pretvorit u drawable, radiš ovako:
        Drawable myDrawable = new LightIconDrawable(getBaseContext(), getResources().getString(R.string.fa_spyglass)); // drugi parametar je hex vrijednost ikone
        int myColor = Color.parseColor("#ff0000"); // naravno, možeš koristiti i putem R.color, al mi se ne da :D
        DrawerData.context = getBaseContext(); // Šuti, znam da trebam ovo mijenjati :D
        drawerItems.add(new DrawerItemHeading("Moj heading", myColor, myDrawable)); // Ovdje ide heading
        drawerItems.add(DrawerData.newItem("Item 1", "&#xf083;")); // kreira se DrawerItemSimple, odnosno običan element drawera koji ima ikonu i label
        drawerItems.add(DrawerData.newItem(R.string.app_name, R.string.fa_camera, false)); // može se i s resource id-evima raditi (preporučano). Treći parametar (false) označava treba li taj element na klik otvoriti fragment (po defaultu je true)
        // ...
        return drawerItems;
    }

    @Override
    protected int getDragMode() {
        return MenuDrawer.MENU_DRAG_WINDOW; // ovo koristim po defaultu
    }

    @Override
    protected Position getDrawerPosition() {
        return Position.LEFT; // isto po defaultu
    }

    @Override
    public void main(Bundle savedInstanceState, boolean drawerActivity) {
        // ovdje ide logika (iako u pravilu drawer activity ne bi trebao imati nikakvu logiku osim prikaza itema)
    }

    /**
     * Ovisi o tome na koji element si kliknuo, određena akcija se izvodi. Ovu metodu ću s vremenom refaktorirati, al sad nek bude ovako kako je
     *
     * @param tag Tag je u pravilu label elementa na koji si kliknuo. To znači, ako si kliknuo na drawer item koji se zove "Home", tag će biti "Home"
     * @return Fragment koji želiš otvoriti odabirom elementa ili null ako ne želiš fragment otvoriti
     */
    @Override
    public Fragment provideFragment(String tag) {
        if (tag.equals("Item 1"))
            return new TestFragment();
        else if (tag.equals(getResources().getString(R.string.app_name)))
            getLightMessenger().showSuccess("Bravo, skužio si!"); // Poziva se onaj Crouton toast. Ja imam 3 tipa: success, error, loading. S vremenom ću još dodati i "message", al sad to nije bitno
        return null;
    }

    // Ako se radi o LightDrawerActivity-u, onda možeš dati bilo koji layout resource. Ja u pravilu napravim običan linearlayout i nazovem ga activity_drawer
    @Override
    public int provideLayoutRes() {
        return R.layout.activity_drawer;
    }
}

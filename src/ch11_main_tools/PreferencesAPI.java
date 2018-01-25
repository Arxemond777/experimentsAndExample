package ch11_main_tools;

import java.util.Date;
import java.util.prefs.BackingStoreException;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

public class PreferencesAPI
{
    public static void main(String[] args) throws BackingStoreException {
        Preferences preferences = Preferences.userRoot().node("oreilly/learningjava");//аналог
        preferences.put("author", "Nimier");
        preferences.flush();
        preferences.putInt("edition", 4);
        String author = preferences.get("author", "undefined");
        int edition = preferences.getInt("edition", -1);
        int edition1 = preferences.getInt("edition1", -1);
        Preferences pref = Preferences.userRoot().node("oreilly").node("learningjava");//аналог
        Preferences pref1 = Preferences.userRoot().node("oreilly").node("learningjava1");
        System.out.println(pref.getInt("edition", -1));
        System.out.println(pref1);
        System.out.println(author);
        System.out.println(edition);
        System.out.println(edition1);

        PreferencesAPI pAPI = new PreferencesAPI();
        pAPI.abc();
        pAPI.a(pref);
        pref.putInt("1", 111);//Observer
    }

    void abc() {
        Preferences preferences = Preferences.systemNodeForPackage(Date.class);
        PreferencesAPI pAPI = new PreferencesAPI();
        Preferences preferences1 = Preferences.systemNodeForPackage(pAPI.getClass());
        System.out.println(preferences);
        System.out.println(preferences1);
    }

    void a(Preferences p) {
        p.addPreferenceChangeListener(new PreferenceChangeListener()
        {
            @Override
            public void preferenceChange(PreferenceChangeEvent evt) {
                System.out.println(evt.getKey() + " change " + evt.getNewValue());
            }
        });
    }
}

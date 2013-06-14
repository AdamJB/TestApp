package com.ajb.testapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;

import org.holoeverywhere.addon.AddonSlider;
import org.holoeverywhere.addon.AddonSlider.AddonSliderA;
import org.holoeverywhere.app.Activity;
import org.holoeverywhere.app.Activity.Addons;

import org.holoeverywhere.slider.SliderMenu;

import com.actionbarsherlock.view.MenuItem;

import com.ajb.testapp.fragments.MainFragment;
import com.ajb.testapp.fragments.ProfileFragment;
import com.ajb.testapp.fragments.SettingsFragment;

@Addons(Activity.ADDON_SLIDER)
public class MainActivity extends Activity implements OnBackStackChangedListener {
    public AddonSliderA addonSlider() {
        return addon(AddonSlider.class);
    }
    
	@Override
	public void onBackStackChanged() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(addonSlider().isAddonEnabled() ? true :
            getSupportFragmentManager().getBackStackEntryCount() > 0);
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final AddonSliderA slider = addonSlider();
        slider.setDrawerLayout(R.layout.main);
        slider.setOverlayActionBar(true);
        
        final SliderMenu sliderMenu = slider.obtainSliderMenu();
        
        sliderMenu.add(R.string.menu_home, MainFragment.class, SliderMenu.BLUE);
        sliderMenu.add(R.string.menu_profile, ProfileFragment.class, SliderMenu.GREEN);
        sliderMenu.add(R.string.action_settings, SettingsFragment.class, SliderMenu.PURPLE);
        
        sliderMenu.makeDefaultMenu(getSupportActionBarContext());
        
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        onBackStackChanged();
        
        getSupportActionBar().setTitle(R.string.app_name);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
        	if (addonSlider().isAddonEnabled()
        			&& getSupportFragmentManager().getBackStackEntryCount() == 0) {
        		addonSlider().toggle();        	
        	} else {
        		onBackPressed();
        	}
        }
        return super.onOptionsItemSelected(item);          
    }
}

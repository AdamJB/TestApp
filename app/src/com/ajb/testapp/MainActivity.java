package com.ajb.testapp;

import org.holoeverywhere.app.Activity;
import org.holoeverywhere.app.Fragment;
import org.holoeverywhere.widget.ArrayAdapter;
import org.holoeverywhere.widget.DrawerLayout;
import org.holoeverywhere.widget.ListView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;

import com.actionbarsherlock.view.MenuItem;
import com.ajb.testapp.fragments.MainFragment;
import com.ajb.testapp.fragments.ProfileFragment;
import com.ajb.testapp.fragments.SettingsFragment;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private String[] mMenuItems;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mMenuItems = getResources().getStringArray(R.array.menuItems);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_menu);

		// Set adapter for list view
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.menu_list_item, mMenuItems));
		// Set the list's click listener
		mDrawerList.setOnItemClickListener(new MenuItemClickListener());

		// Create a listener for the drawer to open and close via the Action Bar
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close);
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// Enable the ActionBar app icon to behave as action to toggle nav
		// Drawer
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		if (savedInstanceState == null) {
			selectItem(0);
		}
		getSupportActionBar().setTitle(R.string.app_name);
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			if (mDrawerLayout.isDrawerVisible(Gravity.START)) {
				mDrawerLayout.closeDrawer(Gravity.START);
			} else {
				mDrawerLayout.openDrawer(Gravity.START);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/** Helper method to swap fragments in the main content view */
	private void selectItem(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		// Update main content by replacing fragments
		Fragment fragment;
		switch (position) {
		case 0:
			fragment = new MainFragment();
			break;
		case 1:
			fragment = new ProfileFragment();
			break;
		case 2:
			fragment = new SettingsFragment();
			break;
		default:
			fragment = new MainFragment();
			break;
		}

		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		// Update selected Item and Title, then close the drawer
		mDrawerList.setItemChecked(position, true);
		setTitle(mMenuItems[position]);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	private class MenuItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}
}
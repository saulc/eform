package sanitation.la.project.myapplication;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import sanitation.la.project.myapplication.dummy.DummyContent;

public class DrawerMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    private boolean mTwoPane;
    private final String TAG = getClass().getSimpleName();

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        if (findViewById(R.id.list_container) != null) {
            FormListFragment fragment = new FormListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_container, fragment)
                    .commit();
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, DrawerMain.class));
            return true;
        } else  if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_new) {
            ItemFragment fragment = new ItemFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_container, fragment)
                    .commit();
            Log.d(TAG, "Adding Grid fragment");
        } else if (id == R.id.nav_open) {
            Uidemofragment fragment = new Uidemofragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_container, fragment)
                    .commit();
            Log.d(TAG, "Adding demo fragment");

        } else if (id == R.id.nav_previous) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_map) {
            Log.d(TAG, "Show map clicked.");
            if (findViewById(R.id.list_container) != null) {
                SupportMapFragment mapFragment = new SupportMapFragment();
                mapFragment.getMapAsync(this);


                //MapsFragment fragment = new MapsFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.list_container, mapFragment)
                        .commit();
                Log.d(TAG, "Adding map");
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng lopezCanyon = new LatLng(34.286911, -118.400914);
        LatLng schollCanyon = new LatLng( 34.152666, -118.194597);
        LatLng bishopsCanyon = new LatLng( 34.286869, -118.400481);
        LatLng sheldonArleta = new LatLng( 34.227111, -118.406669);
        LatLng toyonCanyon = new LatLng( 34.146090, -118.304545);
        LatLng gaffeyStreet = new LatLng(33.759605, -118.291736 );

        ArrayList<LatLng> locations = new ArrayList<LatLng>();
        locations.add(lopezCanyon);
        locations.add(schollCanyon);
        locations.add(bishopsCanyon);
        locations.add(sheldonArleta);
        locations.add(toyonCanyon);
        locations.add(gaffeyStreet);



//        Bishops Canyon Landfill - land restoration complete
//        Gaffey Street Landfill - land restoration complete
//        Lopez Canyon Landfill - closure work complete
//        Sheldon-Arleta Landfill - closure work complete and land redevelopment in progress
//        Toyon Canyon Landfill -
        int i = 1;
        for(LatLng l: locations)
            mMap.addMarker(new MarkerOptions().position(l).title("Landfill " + i++));

        //    mMap.addMarker(new MarkerOptions().position(lopezCanyon).title("Lopez Canyon Landfill"));

     //   mMap.moveCamera(CameraUpdateFactory.newLatLng(lopezCanyon));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lopezCanyon, .9f));
    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DummyContent.DummyItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(FormDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        FormDetailFragment fragment = new FormDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.form_detail_container, fragment)
                                .commit();
                    } else {

//                        Context context = v.getContext();
//                        Intent intent = new Intent(context, FormDetailActivity.class);
//                        intent.putExtra(FormDetailFragment.ARG_ITEM_ID, holder.mItem.id);
//
//                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public DummyContent.DummyItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}

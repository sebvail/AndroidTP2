package com.example.snowt.tp2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.ArrayList;
import java.util.List;

import static com.example.snowt.tp2.R.id.fragment_scan;
import static com.example.snowt.tp2.R.id.scan_from_fragment;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    Bitmap bmp;
    ImageView iv2;
    private static SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    ArrayList<Information> listeEnvoi;
    public void ajouterListe(String info){
        listeEnvoi.add(new Information(info));
        updateAdapterListeEnvoi();
    }
    public void retirerListe(String info){
        listeEnvoi.remove(new Information(info));
        updateAdapterListeEnvoi();
    }
    public void updateAdapterListeEnvoi(){
        setContentView(R.layout.activity_main);
        ListView lv = ((ListView) findViewById(R.id.lv_envoi));
        CustomAdapterInfoEnvoi adapter = new CustomAdapterInfoEnvoi(MainActivity.this, R.layout.envoi_layout, listeEnvoi);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeEnvoi = new ArrayList<Information>();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        listeEnvoi.add(new Information("info1"));
        listeEnvoi.add(new Information("info2"));
        listeEnvoi.add(new Information("info3"));
        listeEnvoi.add(new Information("info4"));
        listeEnvoi.add(new Information("info5"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";




        View  rootView;

        View views;
        @Override
        public View onCreateView( LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState)
        {
            Bitmap bmp;
            ImageView iv2;
            final ArrayList<Information> listeEnvoi = new ArrayList<>();
            listeEnvoi.add(new Information("info1"));
            listeEnvoi.add(new Information("info2"));
            listeEnvoi.add(new Information("info3"));
            listeEnvoi.add(new Information("info4"));
            listeEnvoi.add(new Information("info5"));
            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1: {

                    Fragment fragment =  mSectionsPagerAdapter.getItem(0);
                    //Fragment fragment = getFragmentManager().findFragmentByTag("android:switcher:2131558525:0");
                    /*if(rootView != null) {
                        List<Fragment> frg = new ArrayList<Fragment>();
                        frg = getFragmentManager().getFragments();
                        getFragmentManager().beginTransaction().remove(fragment).commit();
                        rootView = inflater.inflate(R.layout.activity_scan, container, false);
                    }
                    else {
                        rootView = inflater.inflate(R.layout.activity_scan, container, false);
                        iv2 = (ImageView) rootView.findViewById(R.id.imageView);
                        bmp = QREncoder.encodeAsBitmap("yo");
                        iv2.setImageBitmap(bmp);
                    }*/
                    break;
                }
                case 2: {
                    Fragment fragment =  mSectionsPagerAdapter.getItem(1);
                    /*rootView = inflater.inflate(R.layout.envoi_layout,container, false);
                    views = inflater.inflate(R.layout.activity_scan, container, false);
                    (rootView.findViewById(R.id.btnEnvoyerInfo)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            EditText txt = (EditText)rootView.findViewById(R.id.editAjouterEnvoi);
                            String text = txt.getText().toString();
                            Bitmap bmp = QREncoder.encodeAsBitmap(text);
                            ImageView iv2 = (ImageView)views.findViewById(R.id.imageView);
                            iv2.setImageBitmap(bmp);
                            //0x7f0d007d
                            Fragment lo = getFragmentManager().findFragmentByTag("android:switcher:2131558525:0");

                            final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();

                            ft.detach(lo);
                            ft.attach(lo);
                            ft.commit();

                        }
                    });
                    (rootView.findViewById(R.id.btnAjouterEnvoi)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            EditText txt = (EditText)rootView.findViewById(R.id.editAjouterEnvoi);
                            String text = txt.getText().toString();
                            listeEnvoi.add(new Information(text));
                            ListView lv = (ListView)rootView.findViewById(R.id.lv_envoi);
                            CustomAdapterInfoEnvoi adapter = new CustomAdapterInfoEnvoi(getActivity().getBaseContext(),R.layout.envoi_layout,listeEnvoi);
                            lv.setAdapter(adapter);

                        }
                    });
                    (rootView.findViewById(R.id.btnSupprimerInfo)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ((MainActivity)getActivity()).retirerListe(rootView.findViewById(R.id.txtEnvoiInfo).toString());

                        }
                    });*/
                    break;
                }
                case 3: {
                    Fragment fragment =  mSectionsPagerAdapter.getItem(2);
                    /*rootView = inflater.inflate(R.layout.recu_layout,container,false);*/
                    break;
                }
            }


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment f=null;

            if (position ==0){
                f = new FragmentHome();
            }
            else if (position==1){
                f= new FragmentEnvoi();

            }
            else if (position ==2){
                f = new FragmentRecu();
            }

            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).


            return f;        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "scan";
                case 1:
                    return "À envoyer";
                case 2:
                    return "Recu";
            }
            return null;
        }
    }

    public static class ScanFragment extends Fragment {
        private String toast;

        public ScanFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            displayToast();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_scan, container, false);
            Button scan = (Button) view.findViewById(R.id.scan_from_fragment);
            scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scanFromFragment();
                }
            });
            return view;
        }

        public void scanFromFragment() {
            IntentIntegrator.forSupportFragment(this).initiateScan();
        }

        private void displayToast() {
            if(getActivity() != null && toast != null) {
                Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
                toast = null;
            }
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(result != null) {
                if(result.getContents() == null) {
                    toast = "Scan cancellé";
                } else {
                    toast = "Résultat du Scan " + result.getContents();
                }

                // At this point we may or may not have a reference to the activity
                displayToast();
            }
        }
    }
}

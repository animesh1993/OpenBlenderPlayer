package com.example.openblender;

import java.io.File;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    public void OpenBlender(View view)
    {
//    	Intent intent= new Intent();
//    	intent.setAction(Intent.ACTION_VIEW);

    	File storage = Environment.getExternalStorageDirectory() ;
    	File directory = new File(storage.getAbsolutePath() + "/BlenderPlayer");
    	File file = new File(directory,"/test.blend") ;
    	if(file.canRead())
    	{
            if(file.exists())
            {
                  Uri path=Uri.fromFile(file);
                  Intent intent=new Intent(Intent.ACTION_VIEW);
                  intent.setDataAndType(path, "application/readername");

                  try
                  {

                        startActivity(intent);
                  }
                  catch(ActivityNotFoundException e)
                  {
                        Toast.makeText(MainActivity.this, "No software found", Toast.LENGTH_SHORT).show();
                  }
            }
            
//    		MimeTypeMap mime = MimeTypeMap.getSingleton();
//    		String ext = file.getName().substring(file.getName().indexOf(".")+1);
//    		String type = mime.getMimeTypeFromExtension(ext);
//
//    		intent.setDataAndType(Uri.fromFile(file), type);
//    	
//    		startActivity(intent) ;	
    	
//    		Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("org.blender.play");
//    		LaunchIntent.
//    		startActivity(LaunchIntent);
    	
    	}
    	else
    	{
    		Toast.makeText(getApplicationContext(), "Not able to open",Toast.LENGTH_SHORT).show();
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    
}



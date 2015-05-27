package bigdogconsultants.co.uk.arrayclick;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    // array example - this can contain anything
    public String [] mAlphaArray = {"A", "B", "C", "D", "E", "F", "G", "H"};
    // a counter to track the position - might not be required
    public int mIfCounter = 0;
    // the label to show the array element
    public TextView mViewLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init the label
        mViewLabel = (TextView) findViewById(R.id.ifTestLabel);
        // connect up the button
        Button setIfTestButton = (Button) findViewById(R.id.btnIfTest);
        // listen for a click ... shhhhh!
        setIfTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** In here we test to see if we've hit the last
                 *  element in the array and reset if we have,
                 *  else just carry on to the next
                 */
                if (mIfCounter < mAlphaArray.length - 1){
                    mIfCounter++;
                } else {
                    mIfCounter = 0;
                }
                // our very own function to update the label text
                changeIfLabel();
            }
        });
    }

    public void changeIfLabel(){
        mViewLabel.setText(mAlphaArray[mIfCounter]);
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
}

package rafsan.abdullah.convertee;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.SharedPreferences;

public class ASCIItable extends AppCompatActivity {
	SharedPreferences sf;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asciitable);
		Toolbar toolbar = findViewById(R.id.toolbar2);
		setSupportActionBar(toolbar);
		sf = getSharedPreferences("bitConfig",MODE_PRIVATE);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.ascii_menu,menu);
		return true;
	}
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.actionAbout:
				new AboutDialog().show(getFragmentManager(),"");
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}

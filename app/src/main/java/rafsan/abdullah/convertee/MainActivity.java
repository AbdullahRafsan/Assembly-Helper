package rafsan.abdullah.convertee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sf;
	int bit;
	MenuItem bitIndicator;
	TextView displayOctal,displayDecimal,displayDecimalUnsigned,displayHexadecimal,displayCharacter,displayBinary;
	Button buttonA,buttonB,buttonC,buttonD,buttonE,buttonF,button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonMinus,buttonDelete;
	Button[] hexButtons,nonBinaryButtons,allButtons;
	OnClickListener handleKey;
	OnTouchListener handleDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		sf = getSharedPreferences("bitConfig",MODE_PRIVATE);
		bit = sf.getInt("bit",8);
		
		
		displayDecimal = findViewById(R.id.mainEditTextDec);
		displayOctal = findViewById(R.id.mainEditTextOct);
		displayDecimalUnsigned = findViewById(R.id.mainEditTextDecU);
		displayHexadecimal = findViewById(R.id.mainEditTextHex);
		displayCharacter = findViewById(R.id.mainEditTextChr);
		displayBinary = findViewById(R.id.mainEditTextBin);

		
		buttonA = findViewById(R.id.a);
		buttonB = findViewById(R.id.b);
		buttonC = findViewById(R.id.c);
		buttonD = findViewById(R.id.d);
		buttonE = findViewById(R.id.e);
		buttonF = findViewById(R.id.f);
		button1 = findViewById(R.id.b1);
		button2 = findViewById(R.id.b2);
		button3 = findViewById(R.id.b3);
		button4 = findViewById(R.id.b4);
		button5 = findViewById(R.id.b5);
		button6 = findViewById(R.id.b6);
		button7 = findViewById(R.id.b7);
		button8 = findViewById(R.id.b8);
		button9 = findViewById(R.id.b9);
		button0 = findViewById(R.id.b0);
		buttonMinus = findViewById(R.id.bm);
		buttonDelete = findViewById(R.id.de);

		hexButtons = new Button[]{buttonA,buttonB,buttonC,buttonD,buttonE,buttonF};
		nonBinaryButtons = new Button[]{button2,button3,button4,button5,button6,button7,button8,button9};
    }
	
	@Override
	protected void onResume() {
		super.onResume();

		
		handleDisplay = new OnTouchListener(){
			@Override
			public boolean onTouch(View p1, MotionEvent p2) {
				TextView v = (TextView) p1;
				

				switch (p1.getId()) {

						
					case R.id.mainEditTextBin:
						focusBinary(v);
						break;

					
					case R.id.mainEditTextDec:
						focusDecimalSigned(v);
						break;

						
					case R.id.mainEditTextDecU:
						focusDecimalUnSigned(v);
						break;

					case R.id.mainEditTextOct:
						focusOctal(v);
						break;
						
					case R.id.mainEditTextHex:
						focusHexadecimal(v);
						break;
					case R.id.mainEditTextChr:
						break;
				}
				return true;
			}

			
		};

		
		handleKey = new OnClickListener(){

			@Override
			public void onClick(View p1) {
				TextView display = (TextView) getWindow().getCurrentFocus();
				String textFromDisplay = display.getText().toString();
				int number =0;
				switch (p1.getId()) {
					case R.id.a:
						if (textFromDisplay.charAt(0) == '0') display.setText("A");
						else display.setText(textFromDisplay + "A");
						break;
					case R.id.b:
						if (textFromDisplay.charAt(0) == '0') display.setText("B");
						else display.setText(textFromDisplay + "B");
						break;
					case R.id.c:
						if (textFromDisplay.charAt(0) == '0') display.setText("C");
						else display.setText(textFromDisplay + "C");
						break;
					case R.id.d:
						if (textFromDisplay.charAt(0) == '0') display.setText("D");
						else display.setText(textFromDisplay + "D");
						break;
					case R.id.e:
						if (textFromDisplay.charAt(0) == '0') display.setText("E");
						else display.setText(textFromDisplay + "E");
						break;
					case R.id.f:
						if (textFromDisplay.charAt(0) == '0') display.setText("F");
						else display.setText(textFromDisplay + "F");
						break;
					case R.id.b0:
						if (textFromDisplay.charAt(0) == '-' && textFromDisplay.length() == 1) break;
						if (textFromDisplay.charAt(0) == '0') display.setText("0");
						else display.setText(textFromDisplay + "0");
						break;
					case R.id.b1:
						if (textFromDisplay.charAt(0) == '0') display.setText("1");
						else display.setText(textFromDisplay + "1");
						break;
					case R.id.b2:
						if (textFromDisplay.charAt(0) == '0') display.setText("2");
						else display.setText(textFromDisplay + "2");
						break;
					case R.id.b3:
						if (textFromDisplay.charAt(0) == '0') display.setText("3");
						else display.setText(textFromDisplay + "3");
						break;
					case R.id.b4:
						if (textFromDisplay.charAt(0) == '0') display.setText("4");
						else display.setText(textFromDisplay + "4");
						break;
					case R.id.b5:
						if (textFromDisplay.charAt(0) == '0') display.setText("5");
						else display.setText(textFromDisplay + "5");
						break;
					case R.id.b6:
						if (textFromDisplay.charAt(0) == '0') display.setText("6");
						else display.setText(textFromDisplay + "6");
						break;
					case R.id.b7:
						if (textFromDisplay.charAt(0) == '0') display.setText("7");
						else display.setText(textFromDisplay + "7");
						break;
					case R.id.b8:
						if (textFromDisplay.charAt(0) == '0') display.setText("8");
						else display.setText(textFromDisplay + "8");
						break;
					case R.id.b9:
						if (textFromDisplay.charAt(0) == '0') display.setText("9");
						else display.setText(textFromDisplay + "9");
						break;
					case R.id.bm:
						
						if (textFromDisplay.charAt(0) == '0'){ 
							display.setText("-");
							return;
						}
						else if (textFromDisplay.charAt(0) != '-') display.setText("-" + textFromDisplay);
						else {
							display.setText(textFromDisplay.subSequence(1, textFromDisplay.length()));
						}
						if(textFromDisplay.length() == 1 && textFromDisplay.charAt(0) == '-') return;
						break;
					case R.id.de:
						display.setText(delete(textFromDisplay));
						break;

				}
				textFromDisplay = display.getText().toString();
				
				

				switch (display.getId()) {
					case R.id.mainEditTextDec:
						number = Integer.parseInt(textFromDisplay.toString());
						if(bit == 8){
							if (!(number >= -128 && number <= 127)) {
								showMessage("Must be between -128 and 127");
								display.setText(delete(textFromDisplay));
								
							}}
						else if(bit == 16){
							if (!(number >= -32768 && number <= 32767)) {
								showMessage("Must be between -32768 and 32767");
								display.setText(delete(textFromDisplay));
								return;
							}
						}

						break;
					case R.id.mainEditTextDecU:
						number = Integer.parseInt(textFromDisplay.toString());
						if(bit == 8){
							if (!(number >= 0 && number <= 255)) {
								showMessage("Must be between 0 and 255");
								display.setText(delete(textFromDisplay));
								return;
							}}
						else if(bit == 16){
							if (!(number >= 0 && number <= 65535)) {
								showMessage("Must be between 0 and 65535");
								display.setText(delete(textFromDisplay));
								return;
							}
						}
						break;
					case R.id.mainEditTextBin:
						if (textFromDisplay.length() > bit) {
							showMessage("Must be a "+bit+" bit binary integer !");
							display.setText(delete(textFromDisplay));
							return;
						}
						break;
					case R.id.mainEditTextHex:
						if (textFromDisplay.length() > (bit/4)) {
							showMessage("Must be a "+(bit/4)+" digit hex integer !");
							display.setText(delete(textFromDisplay));
							return;
						}
						break;
				}
				
				calculate(display,textFromDisplay);
			}
		};

		
		buttonDelete.setOnLongClickListener(new OnLongClickListener(){

				@Override
				public boolean onLongClick(View p1) {
					reset();
					return true;
				}
			});
		
		for(Button button:hexButtons) button.setOnClickListener(handleKey);
		for(Button button:nonBinaryButtons) button.setOnClickListener(handleKey);
		button0.setOnClickListener(handleKey);
		button1.setOnClickListener(handleKey);
		buttonMinus.setOnClickListener(handleKey);
		buttonDelete.setOnClickListener(handleKey);

		displayOctal.setOnTouchListener(handleDisplay);
		displayBinary.setOnTouchListener(handleDisplay);
		displayDecimal.setOnTouchListener(handleDisplay);
		displayHexadecimal.setOnTouchListener(handleDisplay);
		displayDecimalUnsigned.setOnTouchListener(handleDisplay);

		
		focusDecimalSigned(displayDecimal);
	}

	
	protected void calculate(TextView display,String textFromDisplay){

		if (display == null) {
			showMessage("Nothing Focused");
			return;
		}

		
		int num = 0;

		//textFromDisplay = display.getText().toString();

		switch (display.getId()) {
			case R.id.mainEditTextDec:
				if (textFromDisplay.length() == 1 && textFromDisplay.charAt(0) == '-') break;

				num = Integer.parseInt(textFromDisplay);
				toBinary(num);
				toAsciiChar(num);
				toHexadecimal(num);
				toDecimalU(num);
				toOctal(num);

				break;
			case R.id.mainEditTextDecU:
				num = Integer.parseInt(textFromDisplay);
				toBinary(num);
				toAsciiChar(num);
				toHexadecimal(num);
				toDecimalS(num);
				toOctal(num);
				break;
			case R.id.mainEditTextBin:


				num = Integer.parseInt(textFromDisplay, 2);
				toDecimalS(num);
				toHexadecimal(num);
				toDecimalU(num);
				toAsciiChar(num);
				toOctal(num);
				break;
			case R.id.mainEditTextHex:

				num = Integer.parseInt(textFromDisplay, 16);
				toDecimalS(num);
				toAsciiChar(num);
				toBinary(num);
				toDecimalU(num);
				toOctal(num);
				break;
			case R.id.mainEditTextOct:

				num = Integer.parseInt(textFromDisplay, 8);
				toDecimalS(num);
				toAsciiChar(num);
				toBinary(num);
				toDecimalU(num);
				toHexadecimal(num);
				break;

		}
	}

	protected void focusOctal(TextView view){
		if (view.requestFocus()) {
			disableHex();    
			enableSign();   
			enableNonBinary();
			enableOctal();


			view.setTextColor(getColor(R.color.activeText));


			displayHexadecimal.setTextColor(getColor(R.color.white));
			displayDecimalUnsigned.setTextColor(getColor(R.color.white));
			displayBinary.setTextColor(getColor(R.color.white));
		}
	}
	
	protected void focusDecimalSigned(TextView view){
		if (view.requestFocus()) {
			disableHex();    
			enableSign();   
			enableNonBinary();

			
			view.setTextColor(getColor(R.color.activeText));

			
			displayHexadecimal.setTextColor(getColor(R.color.white));
			displayDecimalUnsigned.setTextColor(getColor(R.color.white));
			displayBinary.setTextColor(getColor(R.color.white));
		}
	}


	protected void focusDecimalUnSigned(TextView view){
		if (view.requestFocus()) {
			disableHex();  
			disableSign();    
			enableNonBinary(); 

			view.setTextColor(getColor(R.color.activeText));

			
			displayHexadecimal.setTextColor(getColor(R.color.white));
			displayDecimal.setTextColor(getColor(R.color.white));
			displayBinary.setTextColor(getColor(R.color.white));
		}
	}

	
	protected void focusHexadecimal(TextView view){
		if (view.requestFocus()) {
			enableNonBinary(); 
			enableHex();     
			disableSign();   

			
			view.setTextColor(getColor(R.color.activeText));

			
			displayBinary.setTextColor(getColor(android.R.color.primary_text_light));
			displayDecimalUnsigned.setTextColor(getColor(R.color.white));
			displayDecimal.setTextColor(getColor(R.color.white));
		}
	}

	
	protected void focusBinary(TextView view){
		if (view.requestFocus()) {
			disableHex();  
			disableSign(); 
			disableNonBinary(); 

			view.setTextColor(getColor(R.color.activeText));

			displayHexadecimal.setTextColor(getColor(R.color.white));
			displayDecimalUnsigned.setTextColor(getColor(R.color.white));
			displayDecimal.setTextColor(getColor(R.color.white));
		}
	}

	protected void showMessage(String msg) {
		Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
	}

	protected String delete(String textFromDisplay){
		if (textFromDisplay.length() <= 1) {
			return "0";
		}
		else return (String) textFromDisplay.subSequence(0,textFromDisplay.length() - 1);
	}

	protected void enableNonBinary() {
		float x = 1.0f;
		boolean y = true;
		for(Button btn:nonBinaryButtons){
			btn.setAlpha(x);
			btn.setEnabled(y);
		}
	}
	
	protected void enableOctal(){
		button8.setAlpha(0.7f);
		button8.setEnabled(false);
		button9.setAlpha(0.7f);
		button9.setEnabled(false);
	}

	protected void disableNonBinary() {
		float x = 0.7f;
		boolean y = false;
		for(Button btn:nonBinaryButtons){
			btn.setAlpha(x);
			btn.setEnabled(y);
		}
	}

	protected void enableHex() {
		float x = 1.0f;
		boolean y = true;
		for(Button btn:hexButtons){
			btn.setAlpha(x);
			btn.setEnabled(y);
		}

	}

	protected void disableHex() {
		boolean y = false;
		float x= 0.7f;
		for(Button btn:hexButtons){
			btn.setAlpha(x);
			btn.setEnabled(y);
		}
	}

	protected void disableSign() {
		buttonMinus.setAlpha(0.7f);
		buttonMinus.setEnabled(false);
	}

	protected void enableSign() {
		buttonMinus.setAlpha(1.0f);
		buttonMinus.setEnabled(true);
	}

	protected void toBinary(long number) {
		number = getDecimalU(number);
		String x = "";
		if(number == 0) x += "0";
		while (number != 0) {
			x += ((number % 2));
			number /= 2;
		}
		String h = x;
		x = "";
		for(int j = h.length()-1; j >= 0; j--){
			x += h.charAt(j);
		}
		displayBinary.setText(x);
	}

	protected void toOctal(long number){
		number = getDecimalU(number);
		String x = "";
		if(number == 0) x += "0";
		while (number != 0) {
			x += ((number % 8));
			number /= 8;
		}
		String h = x;
		x = "";
		for(int j = h.length()-1; j >= 0; j--){
			x += h.charAt(j);
		}
		displayOctal.setText(x);
	}
	
	protected void toHexadecimal(long number) {
		number = getDecimalU(number);
		String x = "";
		long y = 0;

		if(number == 0) x +="0";
		while (number != 0) {
			y = (number % 16);
			switch((int )y){
				case 10:
					x+="A";
					break;
				case 11:
					x+="B";
					break;
				case 12:
					x+="C";
					break;
				case 13:
					x+="D";
					break;
				case 14:
					x+="E";
					break;
				case 15:
					x+="F";
					break;
				default:
					x +=y;
			}

			number /= 16;
		}
		String h = x;
		x = "";
		for(int k = h.length()-1 ; k >= 0;k--){
			x+=h.charAt(k);
		}
		displayHexadecimal.setText(x);
	}

	protected void toDecimalS(long number) {
		long c = 128;
		if(bit == 8) c = 128;
		else if(bit == 16) c = 32768;
		if(number >= c) displayDecimal.setText(""+((-1*c) + ((-1*c) + number)));
		else displayDecimal.setText(""+number);
	}

	protected void toDecimalU(long number) {
		displayDecimalUnsigned.setText(getDecimalU(number)+"");
	}

	protected long getDecimalU(long number) {
		long c = 128;
		if(bit == 8) c = 128;
		else if(bit == 16) c = 32768;
		long num = 0;
		if (number < 0) num = c + (c + number);
		else num = number;
		return num;
	}

	protected void toAsciiChar(long number) {
		number = getDecimalU(number);
		switch ((int) number) {
			case 0:
				displayCharacter.setText("Null");
				break;
			case 7:
				displayCharacter.setText("Bell");
				break;
			case 10:
				displayCharacter.setText("Line Feed");
				break;
//			case 9 tab
//			case 32 space 
			case 13:
				displayCharacter.setText("Carriage Return");
				break;
			case 8:
				displayCharacter.setText("Backspace");
				break;
			default:
				displayCharacter.setText("" + (char) number);
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu,menu);
		
		return true;
	}
	
	protected void reset(){
		displayBinary.setText("0");
		displayHexadecimal.setText("0");
		displayDecimal.setText("0");
		displayDecimalUnsigned.setText("0");
		displayCharacter.setText("Null");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.actionAbout:
				new AboutDialog().show(getFragmentManager(),"");
				return true;
			case R.id.action8BitMode:
				sf.edit().putInt("bit",8).apply();
				bit = sf.getInt("bit",8);
				int x = displayBinary.getText().length();
//				reset();
				if(x > 8){
					displayBinary.setText(displayBinary.getText().subSequence(0,8));
				}
				calculate(displayBinary,displayBinary.getText().toString());
				showMessage("Switching to 8 bit mode");
				return true;
			case R.id.actionASCIITable:
				startActivity(new Intent(MainActivity.this,ASCIItable.class));
				return true;
			case R.id.action16BitMode:
				sf.edit().putInt("bit",16).apply();
				bit = sf.getInt("bit",8);
//				reset();
				calculate(displayBinary,displayBinary.getText().toString());
				showMessage("Switching to 16 bit mode");
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}

package com.example.inclass02;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public EditText ed;
	public TextView tx;
	public String readText;

	public static boolean isNumber(String string) {
		if (string == null || string.isEmpty()) {
			return false;
		}
		int i = 0;
		if (string.charAt(0) == '-') {
			return false;
		}
		int count = 0;
		for (; i < string.length(); i++) {
			if (!Character.isDigit(string.charAt(i)) && !(string.charAt(i) == '.')) {
				return false;
			}
			if(string.charAt(i) == '.')
				count++;
		}
		
		if(count > 1)
			return false;
		else
			return true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ed = (EditText) findViewById(R.id.editText1);
		tx = (TextView) findViewById(R.id.textView1);
	}

	public void eurButton(View v) {
		readText = ed.getText().toString();
		if (isNumber(readText)) {
			String inp = new DecimalFormat("#.##").format(Double.parseDouble(readText));
			double result = Double.parseDouble(inp) * 0.849282;
			tx.setText(inp + " USD = " + new DecimalFormat("#.##").format(result) + " EUR");
		} else {
			Toast.makeText(getBaseContext(), "Wrong input", Toast.LENGTH_LONG).show();
		}
	}

	public void cadButton(View v) {
		readText = ed.getText().toString();
		if (isNumber(readText)) {
			String inp = new DecimalFormat("#.##").format(Double.parseDouble(readText));
			double result = Double.parseDouble(inp) * 1.19;
			tx.setText(inp + " USD = " + new DecimalFormat("#.##").format(result) + " CAD");
		} else {
			Toast.makeText(getBaseContext(), "Wrong input", Toast.LENGTH_LONG).show();
		}
	}

	public void gbpButton(View v) {
		readText = ed.getText().toString();
		if (isNumber(readText)) {
			String inp = new DecimalFormat("#.##").format(Double.parseDouble(readText));
			double result = Double.parseDouble(inp) * 0.65;
			tx.setText(inp + " USD = " + new DecimalFormat("#.##").format(result) + " GBP");
		} else {
			Toast.makeText(getBaseContext(), "Wrong input", Toast.LENGTH_LONG).show();
		}
	}

	public void jpyButton(View v) {
		readText = ed.getText().toString();
		if (isNumber(readText)) {
			String inp = new DecimalFormat("#.##").format(Double.parseDouble(readText));
			double result = Double.parseDouble(inp) * 117.62;
			tx.setText(inp + " USD = " + new DecimalFormat("#.##").format(result) + " JPY");
		} else {
			Toast.makeText(getBaseContext(), "Wrong input", Toast.LENGTH_LONG).show();
		}
	}

	public void clearButton(View v) {
		ed.setText("");
		tx.setText("");
	}
}

package edu.auburn.eng.csse.comp3710.shanajp.midterm.piglatintranslator;

/*
 * Midterm Project - Joseph Shanhan
 * COMP3710 - Dr. Umphress
 * Pig Latin Converter
 * Description: A simple app that takes a word and converts it to Pig Latin 
 * and displays the converted word to user. It also demonstrates how to
 * rotate an image
 */

import java.util.Locale;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	public int myint = 5;
	private int myint2 = 6;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private int myMethod()
	{
	 return 1;
	}
	
	/*
	 * The translate method is called when the translate button is clicked.
	 * It translates the inputed word into pig latin
	 */
	@SuppressLint("NewApi")
	public void translate(View view) {
		/*
		 * The next four lines take care of instantiating views
		 */
		EditText edit = (EditText) findViewById(R.id.editText1);
		TextView textView = (TextView) findViewById(R.id.translatedMessageView);
		TextView textView2 = (TextView) findViewById(R.id.historyView);
		ImageView imageView = (ImageView) findViewById(R.id.au_imageView);
		
		imageView.setRotation(imageView.getRotation()+15); // this rotates the AU image
		
		if(edit.getText().toString().equals("")) //check to make sure there is indeed input
		{
			textView2.setText(textView2.getText() + "\n" + "Error - No Input" );
			textView.setText("Error - No Input");
		}
		else // otherwise translate the word into pig latin and update accordingly
		{
		
		String inputText = edit.getText().toString();
		String translatedText = convertToPigLatin(inputText);
		
		textView.setText(translatedText);
		textView2.setText(textView2.getText() + "\n" + inputText + "  -  " + translatedText );
		}
		}
	
	
	/*
	 * The convertToPigLatin(String s) takes in a string and converts it to pig latin
	 * It returns the converted word as a String. 
	 */
	public String convertToPigLatin(String s){
		String firstLetter = s.substring(0, 1);
		
		//the follow "or" chain checks to see if it is a vowel
		if(firstLetter.toLowerCase(Locale.US).equals("a")
				|| firstLetter.toLowerCase(Locale.US).equals("e")
					|| firstLetter.toLowerCase(Locale.US).equals("i")
						|| firstLetter.toLowerCase(Locale.US).equals("o")
							|| firstLetter.toLowerCase(Locale.US).equals("u"))
			s = s + "ay";
		else //if it is not a vowel, convert accordingly
			s = s.substring(1, s.length()) + firstLetter + "ay";
		return s;
	}
	
	
} 

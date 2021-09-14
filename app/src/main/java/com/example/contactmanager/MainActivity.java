package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.contactmanager.data.DatabaseHandler;
import com.example.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler database = new DatabaseHandler(MainActivity.this);

        Contact person1 = new Contact();
        person1.setName("David");
        person1.setPhoneNumber("654565555631");
        database.addContact(person1);
        Log.d("addContact", "onCreate: " + "contact added");

        List<Contact> contactList = database.getAllContacts();

        for (Contact item : contactList) {
            Log.d("addContact", "onCreate: " + item);
        }
    }
}
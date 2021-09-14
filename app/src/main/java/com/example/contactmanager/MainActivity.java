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

        Contact contact = database.getContact(2);
        Log.d("getContact", "onCreate: " + contact);


        Contact contact1 = database.getContact(1);
        contact1.setName("Eva");
        contact1.setPhoneNumber("56465465654");

        int updatedRow = database.updateContact(contact);
        Log.d("update", "onCreate: " + updatedRow);

        List<Contact> contactList = database.getAllContacts();

        for (Contact item : contactList) {
            Log.d("listContacts", "onCreate: " + item);
        }
    }
}
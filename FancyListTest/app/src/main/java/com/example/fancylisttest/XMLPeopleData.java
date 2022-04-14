package com.example.fancylisttest;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLPeopleData {

    private Context context;
    private Person people [];

    public XMLPeopleData(Context context) {
        this.context = context;

        //get the data from people.xml and parse it
        InputStream stream = this.context.getResources().openRawResource(R.raw.people);

        //create a document builder and make the xml tree document
        DocumentBuilder builder = null;
        Document xmlTree = null;

        try{
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlTree = builder.parse(stream);

        }catch(Exception e){
        }

        //slice xmlTree into NodeLists
        NodeList nameList = xmlTree.getElementsByTagName("name");
        NodeList phoneList = xmlTree.getElementsByTagName("phone");
        NodeList addressList = xmlTree.getElementsByTagName("address");
        NodeList imageList = xmlTree.getElementsByTagName("image");
        NodeList urlList = xmlTree.getElementsByTagName("url");   //in loc de email

        //traverse the NodeLists and make people
        people = new Person [nameList.getLength()];
        for(int i = 0; i < people.length; i++) {
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String phone = phoneList.item(i).getFirstChild().getNodeValue();
            String address = addressList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String email = urlList.item(i).getFirstChild().getNodeValue();

            people[i] = new Person(name, phone, address, email, image);
        }
    }

    public Person [] getPeople(){return people;}
    public Person getPerson(int position) {return people[position];}

}

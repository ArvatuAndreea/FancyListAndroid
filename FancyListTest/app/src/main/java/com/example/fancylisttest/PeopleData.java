package com.example.fancylisttest;

public class PeopleData {

    private Person [] people = {
                new Person("Arvatu Andreea", "0123456789", "Unitbv, Brasov", "arvatuandreea@yahoo.com", "peisaj.jpg"),
                new Person("Arvatu Alina", "2222222222", "Unitbv, Brasov", "arvatuandreea@yahoo.com", "peisaj.jpg"),
                new Person("Arvatu Alexandru", "333333333", "Unitbv, Brasov", "arvatuandreea@yahoo.com", "peisaj.jpg"),
                new Person("Arvatu Maria", "44444444", "Unitbv, Brasov", "arvatuandreea@yahoo.com", "peisaj.jpg"),
    };

    public Person [] getPeople() {return people;}
    public Person getPerson(int position) {return people[position];}


}

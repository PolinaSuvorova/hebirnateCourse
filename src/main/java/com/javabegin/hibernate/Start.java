package com.javabegin.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Start {
    public static void main(String[] args) {
      Session session =  HibernateUtil.getSessionFactory().openSession();
    }
}

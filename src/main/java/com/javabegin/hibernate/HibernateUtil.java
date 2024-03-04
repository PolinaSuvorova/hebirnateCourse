package com.javabegin.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// Класс из документации Hebirnate
// Для считывания настроек и инициализации SessionFactory
// При загрузке класса автоматически всё инициализируеся
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        // Полуение реестра сервисов ( что такое Service - http://docs.jboss.org/hibernate/orm/5.1/integrationGuide/html_single/
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() //настройка из hibernate.cfg.xml
                .build();
        try {
            //MetadataSources - для работы с метаданными иеппинга объектов
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // Реестр должен быть уничтожен
            StandardServiceRegistryBuilder.destroy(registry);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

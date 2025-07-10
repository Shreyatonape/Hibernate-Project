package com.example.dao;

import com.example.model.Country;
import com.example.model.Region;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CountryDAO {

    
    public void addCountry(String countryId, String countryName, int regionId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Region region = session.get(Region.class, regionId);
            if (region != null) {
                Country country = new Country();
                country.setCountryId(countryId);
                country.setCountryName(countryName);
                country.setRegion(region);

                session.save(country);
                tx.commit();
                System.out.println("✅ Country added successfully.");
            } else {
                System.out.println("❌ Region not found.");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    
    public List<Country> getAllCountries() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Country", Country.class).list();
        }
    }

    
    public Country getCountryById(String countryId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Country.class, countryId);
        }
    }

  
    public void updateCountry(String countryId, String newName) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Country country = session.get(Country.class, countryId);
            if (country != null) {
                country.setCountryName(newName);
                session.update(country);
                tx.commit();
                System.out.println("✏️ Country updated successfully.");
            } else {
                System.out.println("❌ Country not found.");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    
    public void deleteCountry(String countryId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Country country = session.get(Country.class, countryId);
            if (country != null) {
                session.delete(country);
                tx.commit();
                System.out.println("🗑 Country deleted.");
            } else {
                System.out.println("❌ Country not found.");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}

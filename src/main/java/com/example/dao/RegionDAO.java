package com.example.dao;

import com.example.model.Region;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegionDAO {

  
    public void addRegion(String regionName) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Region region = new Region();
            region.setRegionName(regionName);
            session.save(region);
            tx.commit();
            System.out.println("✅ Region added successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    
    public List<Region> getAllRegions() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Region", Region.class).list();
        }
    }

    
    public Region getRegionById(int regionId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Region.class, regionId);
        }
    }

   
    public void updateRegion(int regionId, String newRegionName) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Region region = session.get(Region.class, regionId);
            if (region != null) {
                region.setRegionName(newRegionName);
                session.update(region);
                tx.commit();
                System.out.println("✏️ Region updated successfully.");
            } else {
                System.out.println("❌ Region not found.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

 
    public void deleteRegion(int regionId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Region region = session.get(Region.class, regionId);
            if (region != null) {
                session.delete(region);
                tx.commit();
                System.out.println("🗑 Region deleted.");
            } else {
                System.out.println("❌ Region not found.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}

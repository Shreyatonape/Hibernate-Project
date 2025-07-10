package com.example.main;

import com.example.dao.CountryDAO;
import com.example.dao.RegionDAO;
import com.example.model.Country;
import com.example.model.Region;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegionDAO regionDAO = new RegionDAO();
        CountryDAO countryDAO = new CountryDAO();

        while (true) {
            System.out.println("\n===== Hibernate Country & Region CRUD =====");
            System.out.println("1. Add Region");
            System.out.println("2. View Regions");
            System.out.println("3. Update Region");
            System.out.println("4. Delete Region");
            System.out.println("5. Add Country");
            System.out.println("6. View Countries");
            System.out.println("7. Update Country");
            System.out.println("8. Delete Country");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter region name: ");
                    sc.nextLine();
                    String rname = sc.nextLine();
                    regionDAO.addRegion(rname);
                    break;

                case 2:
                    List<Region> regions = regionDAO.getAllRegions();
                    for (Region r : regions) {
                        System.out.println("ID: " + r.getRegionId() + ", Name: " + r.getRegionName());
                    }
                    break;

                case 3:
                    System.out.print("Enter region ID to update: ");
                    int rid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newRname = sc.nextLine();
                    regionDAO.updateRegion(rid, newRname);
                    break;

                case 4:
                    System.out.print("Enter region ID to delete: ");
                    int delRid = sc.nextInt();
                    regionDAO.deleteRegion(delRid);
                    break;

                case 5:
                    System.out.print("Enter country ID (2 letters): ");
                    sc.nextLine();
                    String cid = sc.nextLine();
                    System.out.print("Enter country name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter region ID: ");
                    int crid = sc.nextInt();
                    countryDAO.addCountry(cid, cname, crid);
                    break;

                case 6:
                    List<Country> countries = countryDAO.getAllCountries();
                    for (Country c : countries) {
                        System.out.println("ID: " + c.getCountryId() + ", Name: " + c.getCountryName() + ", Region: " + c.getRegion().getRegionName());
                    }
                    break;

                case 7:
                    System.out.print("Enter country ID to update: ");
                    sc.nextLine();
                    String ucid = sc.nextLine();
                    System.out.print("Enter new name: ");
                    String ucname = sc.nextLine();
                    countryDAO.updateCountry(ucid, ucname);
                    break;

                case 8:
                    System.out.print("Enter country ID to delete: ");
                    sc.nextLine();
                    String dcid = sc.nextLine();
                    countryDAO.deleteCountry(dcid);
                    break;

                case 9:
                    System.out.println("👋 Exiting...");
                    System.exit(0);

                default:
                    System.out.println("❗ Invalid choice!");
            }
        }
    }
}

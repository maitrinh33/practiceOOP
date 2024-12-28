/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Labs_OOP.Câu4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dopha
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Them");
            System.out.println("2. Sua");
            System.out.println("3. Xoa");
            System.out.println("4. Tim kiem theo ten");
            System.out.println("5. Tim kiem theo so dien thoai");
            System.out.println("6. Thoat");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhap ten: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhap so dien thoai: ");
                    String phoneNumber = scanner.nextLine();
                    contacts.add(new Contact(name, phoneNumber));
                }

                case 2 -> {
                    System.out.print("Nhap ten can sua: ");
                    String editName = scanner.nextLine();
                    for (Contact contact : contacts) {
                        if (contact.getName().equalsIgnoreCase(editName)) {
                            System.out.print("Nhap so dien thoai moi: ");
                            String newPhone = scanner.nextLine();
                            contact.setPhoneNumber(newPhone);
                            break;
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Nhap ten can xoa: ");
                    String deleteName = scanner.nextLine();
                    contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(deleteName));
                }

                case 4 -> {
                    System.out.print("Nhap ten can tim: ");
                    String searchName = scanner.nextLine();
                    for (Contact contact : contacts) {
                        if (contact.getName().equalsIgnoreCase(searchName)) {
                            System.out.println(contact);
                        }
                    }
                }

                case 5 -> {
                    System.out.print("Nhap so dien thoai can tim: ");
                    String searchPhone = scanner.nextLine();
                    for (Contact contact : contacts) {
                        if (contact.getPhoneNumber().equals(searchPhone)) {
                            System.out.println(contact);
                        }
                    }
                }

                case 6 -> System.out.println("Thoat chuong trinh.");

                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 6);
    }
}
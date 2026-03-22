package btvn.session11.baitap05.presentation;

import java.util.*;

import btvn.session11.baitap05.business.DoctorService;
import btvn.session11.baitap05.model.Doctor;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final DoctorService doctorService = new DoctorService();

    public void processAddDoctor() {
        System.out.print("Nhập tên bác sĩ: ");
        String name = sc.nextLine();
        System.out.print("Nhập chuyên khoa: ");
        String specialty = sc.nextLine();
        if (doctorService.add(name, specialty)) {
            System.out.println("Thêm thành công");
        } else {
            System.out.println("Thêm thất bại");
        }
    }

    public void displayListDoctor() {
        List<Doctor> doctors = doctorService.findAll();
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public void showMenu() {
        int choice = -1;
        do {
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ mới");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Nhâp chức năng: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ");
            }
            switch (choice) {
                case 1:
                    displayListDoctor();
                    break;
                case 2:
                    processAddDoctor();
                    break;
                case 3: {
                    Map<String, Integer> map = doctorService.countBySpecialty();
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                }
                break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (choice != 4);
    }
}

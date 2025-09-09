/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pbo.volunteer;

import java.util.ArrayList;
import java.util.Scanner;

class Kegiatan {
    String nama;
    String tanggal;

    public Kegiatan(String nama, String tanggal) {
        this.nama = nama;
        this.tanggal = tanggal;
    }
}
/**
 *
 * @author hp
 */
public class PBOVolunteer {

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        ArrayList<Kegiatan> kegiatanList = new ArrayList<>();
        int pilih = 0;

        while (pilih != 6) {
            System.out.println("\n=== Sistem Manajemen Kegiatan Sosial ===");
            System.out.println("1. Tambah Kegiatan");
            System.out.println("2. Lihat Kegiatan");
            System.out.println("3. Update Kegiatan");
            System.out.println("4. Hapus Kegiatan");
            System.out.println("5. Cari Kegiatan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilih = in.nextInt();
            in.nextLine();

            if (pilih == 1) {
                System.out.print("Masukkan nama kegiatan: ");
                String nama = in.nextLine();
                System.out.print("Masukkan tanggal kegiatan: ");
                String tanggal = in.nextLine();
                kegiatanList.add(new Kegiatan(nama, tanggal));
                System.out.println("✅ Kegiatan berhasil ditambahkan!");
            } 
            else if (pilih == 2) {
                if (kegiatanList.isEmpty()) {
                    System.out.println("⚠️ Belum ada kegiatan.");
                } else {
                    System.out.println("--- Daftar Kegiatan ---");
                    for (int i = 0; i < kegiatanList.size(); i++) {
                        Kegiatan k = kegiatanList.get(i);
                        System.out.println((i+1) + ". " + k.nama + " (Tanggal: " + k.tanggal + ")");
                    }
                }
            } 
            else if (pilih == 3) {
                if (kegiatanList.isEmpty()) {
                    System.out.println("⚠️ Tidak ada kegiatan untuk diupdate.");
                } else {
                    System.out.println("--- Pilih Kegiatan yang Ingin Diupdate ---");
                    for (int i = 0; i < kegiatanList.size(); i++) {
                        Kegiatan k = kegiatanList.get(i);
                        System.out.println((i+1) + ". " + k.nama + " (Tanggal: " + k.tanggal + ")");
                    }
                    System.out.print("Nomor kegiatan yang diupdate: ");
                    int u = in.nextInt();
                    in.nextLine();
                    if (u > 0 && u <= kegiatanList.size()) {
                        System.out.print("Masukkan nama kegiatan baru: ");
                        String namaBaru = in.nextLine();
                        System.out.print("Masukkan tanggal kegiatan baru: ");
                        String tanggalBaru = in.nextLine();
                        kegiatanList.set(u-1, new Kegiatan(namaBaru, tanggalBaru));
                        System.out.println("✅ Kegiatan berhasil diupdate!");
                    } else {
                        System.out.println("❌ Nomor tidak valid.");
                    }
                }
            } 
            else if (pilih == 4) {
                if (kegiatanList.isEmpty()) {
                    System.out.println("⚠️ Tidak ada kegiatan untuk dihapus.");
                } else {
                    System.out.println("--- Pilih Kegiatan yang Ingin Dihapus ---");
                    for (int i = 0; i < kegiatanList.size(); i++) {
                        Kegiatan k = kegiatanList.get(i);
                        System.out.println((i+1) + ". " + k.nama + " (Tanggal: " + k.tanggal + ")");
                    }
                    System.out.print("Nomor kegiatan yang dihapus: ");
                    int h = in.nextInt();
                    in.nextLine();
                    if (h > 0 && h <= kegiatanList.size()) {
                        System.out.println("🗑️ Menghapus: " + kegiatanList.get(h-1).nama);
                        kegiatanList.remove(h-1);
                    } else {
                        System.out.println("❌ Nomor tidak valid.");
                    }
                }
            } 
            else if (pilih == 5) {
                if (kegiatanList.isEmpty()) {
                    System.out.println("⚠️ Belum ada kegiatan.");
                } else {
                    System.out.print("Masukkan kata kunci pencarian: ");
                    String keyword = in.nextLine().toLowerCase();
                    boolean ditemukan = false;

                    System.out.println("--- Hasil Pencarian ---");
                    for (int i = 0; i < kegiatanList.size(); i++) {
                        Kegiatan k = kegiatanList.get(i);
                        if (k.nama.toLowerCase().contains(keyword) || k.tanggal.toLowerCase().contains(keyword)) {
                            System.out.println((i+1) + ". " + k.nama + " (Tanggal: " + k.tanggal + ")");
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("❌ Tidak ada kegiatan yang cocok dengan \"" + keyword + "\"");
                    }
                }
            } 
            else if (pilih == 6) {
                System.out.println("🙏 Terima kasih, program selesai.");
            } 
            else {
                System.out.println("❌ Menu tidak valid, coba lagi.");
            }
        }
    }
}